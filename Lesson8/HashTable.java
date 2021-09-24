package AlgorithmsLessons.Lesson8;

public class HashTable
{
  public int size;
  public int step;
  public String [] slots; 

  public HashTable(int sz, int stp)
  {
    size = sz;
    step = stp;
    slots = new String[size];
    for(int i=0; i < size; i++) slots[i] = null;
  }

  public int hashFun(String value)
  {    
      int hash = 0;
      for(int i = 0; i != value.length(); i++){
        hash =( hash * 31 + value.charAt(i) ) % size;
      }
      return hash;
  }

  public int seekSlot(String a_value)
  {
    int slotNum = hashFun(a_value);
    for ( int count = 0; !(count > size); count++ ){
      
      if(slots[slotNum] == null){
        return slotNum;
      }

      if(slotNum + step > size - 1){
        slotNum = slotNum + step - size;
      } else {
        slotNum += step;
      }
    }
    return -1;
  }
  
  public int put(String a_value)
  {
    int slotNum = seekSlot(a_value);
    if( slotNum == -1){
      return -1;
    } else {
      slots[slotNum] = a_value;
      return slotNum;
    }
  }
  
  public int find(String a_value)
  {
    int slotNum = hashFun(a_value);

    for(int count = 0; count <= size; count++){
      
      if(slots[slotNum] == a_value){
        return slotNum;
      }

      if(slotNum + step > size - 1){
        slotNum = slotNum + step - size;
      } else {
        slotNum += step;
      }
    }
    return -1;
  }

  public void printTable(){
    
    for(int i = 0; i != size; i++){
      System.out.println("The slot = " + i + " : " + slots[i]);
    }
  }

}
