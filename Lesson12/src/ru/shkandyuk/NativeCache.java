package ru.shkandyuk;

import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public void NativeCache(int sz, Class clazz){
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    // Calculate hash number of the a_key
    public int hashFun(String a_key)
    {
        int hash = 0;
        for(int i = 0; a_key != null && i != a_key.length(); i++){
            hash =( hash * 31 + a_key.charAt(i) ) % size;
        }
        return hash;
    }


    public boolean isKey(String a_key)
    {
        int hashKey = hashFun(a_key);
        boolean equals = false;

        for ( int count = 0 ; a_key != null && (count < size) && (slots[hashKey] != null) && !equals;
              count++, hashKey = (hashKey + 3) % size ){

            equals = slots[hashKey].equals(a_key);
        }

        return equals;
    }

    public void put(String a_key, T a_value)
    {
        int hashKey = hashFun(a_key);

        for ( int count = 0 ; slots[hashKey] != null && count < size ; count++ ){
            if( slots[hashKey].equals(a_key) ){
                break;
            } else {
                hashKey = (hashKey + 3) % size;
            }
        }

        if(slots[hashKey] == null){
            slots[hashKey] = a_key;
        }
        values[hashKey] = a_value;
    }

    public T get(String a_key)
    {
        if( !isKey(a_key) ){
            return null;
        }

        int hashKey = hashFun(a_key);
        while ( !slots[hashKey].equals(a_key) ){
            hashKey = (hashKey + 3) % size;
        }
        return values[hashKey];

    }

    public boolean remove(String aValue,  T a_value) {
        if (aValue == null) {
            return false;
        }

        boolean checkKey = isKey(aValue);

        if (!checkKey) {
            return false;
        }

        int hashKey = hashFun(aValue);
        // Looking for slot which has key = a_value
        while (!slots[hashKey].equals(aValue)) {
            hashKey = (hashKey + 3) % size;
        }

        // Remove this key
        slots[hashKey] = null;
        hashKey = (hashKey + 3) % size;

        // Fix sequence following for the removed key
        while (slots[hashKey] != null) {
            String keyToRedo = slots[hashKey];
            T valueToRedo = values[hashKey];
            slots[hashKey] = null;
            values[hashKey] = null;
            put(keyToRedo, valueToRedo);
            hashKey = (hashKey + 3) % size;
        }
        return true;

    }

}
