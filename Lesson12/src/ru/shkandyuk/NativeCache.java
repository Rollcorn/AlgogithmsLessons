package ru.shkandyuk;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public void NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);

        for (int i = 0; i != size; i++) {
            slots[i] = null;
            hits[i] = 0;
        }

    }

    /*************************************************
     * Calculate hash number of the a_key
     */
    public int hashFun(String a_key) {
        int hash = 0;
        for (int i = 0; a_key != null && i != a_key.length(); i++) {
            hash = (hash * 31 + a_key.charAt(i)) % size;
        }
        return hash;
    }

    /*************************************************
     * Check if the collection already has this key
     */
    public boolean isKey(String aKey) {
        int hashKey = hashFun(aKey);
        boolean equals = false;

        for (int count = 0; aKey != null && (count < size) && (slots[hashKey] != null) && !equals;
             count++, hashKey = (hashKey + 3) % size) {

            equals = slots[hashKey].equals(aKey);
        }
        return equals;
    }

    /*************************************************
     * Insert element IN collection by key and value
     */
    public void put(String aKey, T aValue) {
        int hashKey = hashFun(aKey);
        int count; // count attempts
        boolean isEqualKey = false; //check slot and key is equals

        // Looking for a slot
        // cycle is end only when find in collection empty slot, slot with received key, or it cannot
        for (count = 0; (aKey != null) && (slots[hashKey] != null) && (count < size);
             count++) {
            isEqualKey = slots[hashKey].equals(aKey);
            if (isEqualKey) {
                break;
            } else {
                hashKey = (hashKey + 3) % size;
            }
        }

        // Adding element in collection
        if (aKey != null) {
            // we cant find in collection empty slot or received key
            if (!isEqualKey && slots[hashKey] != null) { // we don't have
                remove(minHits());
                put(aKey, aValue);
            } else { // we already have this key in collection or find empty slot
                slots[hashKey] = aKey;
                values[hashKey] = aValue;
            }
        }
    }

    /*************************************************
     * Return value from collection by key
     */
    public T get(String a_key) {
        if (!isKey(a_key)) {
            return null;
        }

        int hashKey = hashFun(a_key);
        while (!slots[hashKey].equals(a_key)) {
            hashKey = (hashKey + 3) % size;
        }
        hits[hashKey]++;
        return values[hashKey];

    }

    /*************************************************
     * Remove element from collection by key
     */
    public boolean remove(String aKey) {
        boolean isNullKey = (aKey == null);
        boolean checkKey = isKey(aKey);

        if (!checkKey || isNullKey) {
            return false;
        }

        int hashKey = hashFun(aKey);
        // Looking for slot which has key = aKey
        while (!slots[hashKey].equals(aKey)) {
            hashKey = (hashKey + 3) % size;
        }

        // Remove this slot and its value
        slots[hashKey] = null;
        values[hashKey] = null;

        // Fix sequence following for the removed key
        hashKey = (hashKey + 3) % size;
        while (slots[hashKey] != null) {
            String keyToRedo = slots[hashKey];
            T valToRedo = values[hashKey];
            slots[hashKey] = null;
            values[hashKey] = null;
            put(keyToRedo, valToRedo);
            hashKey = (hashKey + 3) % size;
        }
        return true;

    }

    public String minHits() {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i != size; i++) {
            if (hits[i] < min) minIndex = i;
        }
        return slots[minIndex];
    }

}
