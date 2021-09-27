package AlgorithmsLessons.Lesson10;

public class PowerSet
{
    private int m_capacity = 20;
    private int m_size;
    private String [] m_slots; 

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
         hash =( hash * 31 + value.charAt(i) ) % m_capacity;
       }
       return hash;
   }

   private boolean isKey(String a_key)
   {
       int hashKey = hashFun(a_key);
       boolean equals = false;

       for ( int count = 0 ; (count < m_capacity) && (m_slots[hashKey] != null); count++, hashKey = (hashKey + 3) % m_capacity ){

           if( m_slots[hashKey].length() != a_key.length() ){
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

        for ( int count = 0 ; (m_slots[hashKey] != null) && (count < m_capacity) ; count++ ){
            if( isKey(a_value) ) break;
            hashKey = (hashKey + 3) % m_capacity;
        }

        if (m_slots[hashKey] == null){
            m_slots[hashKey] = a_value;
        }
        m_size++;

    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }

    public void printTable(){
        for(int i = 0; (i < m_capacity) ; i++){
          System.out.println("The slot = [" + i + "] : value[" + m_slots[i] + "]" );
        } 
    }

}
