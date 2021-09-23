package AlgorithmsLessons.Lesson9;
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

    public boolean isKey(String key)
    {
      // ���������� true ���� ���� �������,
      // ����� false
      return false;
    }

    public void put(String key, T value)
    {
      // �������������� ���������� 
      // �������� value �� ����� key
    }

    public T get(String key)
    {
      // ���������� value ��� key, 
      // ��� null ���� ���� �� ������
      return null;
    }
}
