//package AlgorithmsLessons.Lesson9;
import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
      size = sz;
      slots = new String[size];
      values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String a_key)
    {
        int hash = 0;
        for(int i = 0; i != a_key.length(); i++){
          hash =( hash * 31 + a_key.charAt(i) ) % size;
        }
        return hash;
    }

    public boolean isKey(String a_key)
    {
        int hashKey = hashFun(a_key);
        boolean equals = false;

        for ( int count = 0 ; (count < size) && (slots[hashKey] != null); count++, hashKey = (hashKey + 3) % size ){

            if( slots[hashKey].length() != a_key.length() ){
                continue;
            }

            for( int i = 0 ; i != a_key.length(); i++){
                if( slots[hashKey].charAt(i) != a_key.charAt(i)){
                    equals = false;
                    break;
                } else {
                    equals = true;
                }
            }
            if ( equals ) {
                return true;
            }
        }

        return false;
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
    
/*
    public void printTable(){
    
        for(int i = 0; i != size; i++){
          System.out.println("The slot = [" + i + "] : key[" + slots[i] + "] : values [" + values[i] + "]" );
        } 
    }
*/

}
