package AlgorithmsLessons.Lesson10;

public class PowerSet
{
    public int m_capacity = 20000;
    public int m_size;
    public String [] m_slots; 

    public PowerSet()
    {
    m_slots = new String[m_capacity];
    m_size = 0;

    for(int i = 0; i < m_capacity; i++) 
        m_slots[i] = null;   
    }

   public int size()
   {
        return m_size;
   }

   private int hashFun(String value)
   {    
       int hash = 0;
       for(int i = 0; i != value.length(); i++){
         hash = ( hash * 31 + value.charAt(i) ) % m_capacity;
       }
       return hash;
   }

   private boolean isKey(String a_key)
   {
        int hashKey = hashFun(a_key);
        boolean equals = false;

        for ( int count = 0 ; count <= m_capacity ; count++, hashKey = (hashKey + 3) % m_capacity ){
            if ( m_slots[hashKey] == null ) { break; }

            if( ( hashFun(m_slots[hashKey]) != hashFun(a_key) ) && m_slots[hashKey].length() != a_key.length() ){
                continue;
            }

            for( int i = 0 ; i != a_key.length(); i++){
                if( m_slots[hashKey].charAt(i) != a_key.charAt(i)){
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

    public void put(String a_value)
    {
        int hashKey = hashFun(a_value);
        boolean checkKey = isKey(a_value);  //Check this value in the set

        for ( int count = 0 ; (m_slots[hashKey] != null) && (count <= m_capacity) ; count++ ){
            //if set already has this value dont put it again
            if( checkKey == true ) break;
            hashKey = (hashKey + 3) % m_capacity;
        }

        if ( m_slots[hashKey] == null ){
            m_slots[hashKey] = a_value;
            m_size += 1;
        }

    }

    public boolean get(String a_value)
    {
        return isKey(a_value);
    }

    public boolean remove(String a_value)
    {
        int hashKey = hashFun(a_value);
        boolean checkKey = isKey(a_value);

        if ( checkKey == false ) { return false; }

        // Looking for slot which has key = a_value 
        while ( ! m_slots[hashKey].equals(a_value) ){
            hashKey = (hashKey + 3) % m_capacity;
        }

        // Remove this key
        m_slots[hashKey] = null;
        m_size--;
        hashKey = (hashKey + 3) % m_capacity;

        // Fix sequence following for the removed key
        while( m_slots[hashKey] != null ) {
            String keyToRedo = m_slots[hashKey];
            m_slots[hashKey] = null;
            m_size--;
            put(keyToRedo);
            hashKey = (hashKey + 3) % m_capacity;
        }
        return true;

    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet intersectSet = new PowerSet();

        for ( int i = 0; i < this.m_capacity ; i++ ){
            if ( this.m_slots[i] != null && set2.isKey( this.m_slots[i] ) ){
                intersectSet.put(this.m_slots[i]);
            } 
        }

        return intersectSet;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet unionSet = new PowerSet();

        for (int i = 0; (i < this.m_capacity) || (i < set2.m_capacity) ; i++){
            if ( this.m_slots[i] != null && i < this.m_capacity ){
                unionSet.put(this.m_slots[i]);
            } 
            if ( set2.m_slots[i] != null && i < set2.m_capacity ){
                unionSet.put(set2.m_slots[i]);
            } 
        }

        return unionSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet diffSet = new PowerSet();

        for ( int i = 0; i < this.m_capacity ; i++ ){
            if ( this.m_slots[i] != null && !set2.isKey(m_slots[i]) ){
                diffSet.put(m_slots[i]);
            } 
        }

        return diffSet;  
    }

    public boolean isSubset(PowerSet set2)
    {
        boolean equalCheck = false;

        if ( set2.size() > this.size() ){
            return equalCheck;
        }

        for ( int i = 0; i < set2.m_capacity ; i++ ){
            String checkSlot = set2.m_slots[i];

            if ( checkSlot == null ){
                continue;
            } else if ( this.isKey(checkSlot) ){
                equalCheck = true;
            } else {
                equalCheck = false;
                break;
            }
        }
        return equalCheck;

    }

    public void printTable(){
        for(int i = 0; i < m_capacity ; i++){
            if ( m_slots[i] != null ){
                System.out.println("The slot = [" + i + "] : value[" + m_slots[i] + "]" );
            }
        } 
        System.out.println();
    }

}
