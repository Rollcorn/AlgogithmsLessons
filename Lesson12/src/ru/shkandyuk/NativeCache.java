// package ru.shkandyuk;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    Class clazz;

    public NativeCache(int sz, Class clz) {
        clazz = clz;
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(this.clazz, this.size);

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
    public int put(String aKey, T aValue) {
        int hashKey = hashFun(aKey);
        // count attempts
        int count;
        //check slot and key is equals
        boolean isEqualKey = false;

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
            // we already have received key in collection
            if (isEqualKey) {
                values[hashKey] = aValue;

                // we can't find in collection empty slot
            } else if (slots[hashKey] == null) {
                slots[hashKey] = aKey;
                values[hashKey] = aValue;
                hits[hashKey] = 0;

                // In all other cases empty some slot and put received key-value
            } else {
                remove(minHits());
                put(aKey, aValue);
            }

        }

        return hashKey;
    }

    /*************************************************
     * Return value from collection by key
     */
    public T get(String aKey) {
        if (!isKey(aKey)) {
            return null;
        }

        int hashKey = hashFun(aKey);
        while (!slots[hashKey].equals(aKey)) {
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
        hits[hashKey] = 0;

        // Fix sequence following for the removed key
        hashKey = (hashKey + 3) % size;
        while (slots[hashKey] != null) {
            String keyToRedo = slots[hashKey];
            T valToRedo = values[hashKey];
            int hitsRedo = hits[hashKey];

            slots[hashKey] = null;
            values[hashKey] = null;
            hits[hashKey] = 0;
            hits[ put(keyToRedo, valToRedo) ] = hitsRedo;
            hashKey = (hashKey + 3) % size;
        }
        return true;

    }

    /***********************************************************************
     * Looking for element with smalest using frequency and return its key
     */
    public String minHits() {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i != size; i++) {
            if (i == 0) {
                min = hits[i];
            } else {
                if (hits[i] < min) {
                    min = hits[i];
                    minIndex = i;
                }
            }
        }
        return slots[minIndex];
    }

}
