package Algorithms.DynArray;

import java.lang.reflect.Array;

public class DynArray<T>
{
  // Для тестов вернуть public а то хз
  private T [] m_array;
  private int m_count;
  private int m_capacity;
  private int m_minCapacity;
  Class m_clazz;

  /**
   * Конструктор
   * new DynArray<Integer>(Integer.class);
   * @param a_clz
   */
  public DynArray(Class a_clz)
  {
    m_clazz = a_clz; // нужен для безопасного приведения типов
    m_count = 0;
    makeArray(m_minCapacity);
  }

  /****************************************************************
   * Метод меняет размер массива array, копируя при необходимости текущие 
   * объекты вышеописанным способом.
   * увеличение буфера происходит в два раза, а уменьшение в полтора 
   * раза (текущее значение размера буфера делится на 1.5, и результат 
   * приводится к целому типу)
   */
  public void makeArray(int a_newCapacity)
  {
    if (m_count == 0){
      m_array = ( T[] ) Array.newInstance( this.m_clazz, a_newCapacity );
    } else {
      T [] newArray = ( T[] ) Array.newInstance( this.m_clazz, a_newCapacity );
      this.copy(newArray);
      m_array = newArray;
    } 
      // ваш код
  }

  /************************************************************
   * Получение объекта по его индексу
   * Встроить проверку корректности индекса в рамках границ, и 
   * генерацию соответствующего исключения, если обращение некорректно;
   */
  public T getItem(int a_index)
  {
    assert( a_index <= m_count && a_index >= 0);
    return m_array[a_index];
  }
  /*****************************************************************
   * добавление нового элемента в конец массива
   * 
   * @param itm
   */
  public void append(T itm)
  {
    
    if ( (m_count + 1) == m_capacity ) {
      m_capacity *= 2;
      makeArray(m_capacity);
    } 
    m_array[m_count] = itm;
    m_count++;
  }

  /*****************************************************************
   * Вставляет в i-ю позицию объект item, сдвигая вперёд все последующие 
   * элементы. ! Новая длина массива может превысить размер буфера.
   * 
   * @param a_itm
   * @param a_index
   */
  public void insert(T a_itm, int a_index)
  {
    // ваш код
  }
  
  /**
   * удаляет объект из i-й позиции, при необходимости выполняя сжатие буфера.
   * @param a_index
   */
  public void remove(int a_index)
  {
    // ваш код
  }

  /**
   * Количество элементов в массиве
   * @return
   */
  public int count(){
    return m_count;
  }

  /**
   * Объем буфера массива 
   */
  public int capacity(){
    return m_capacity;
  }

  /**
   * Копирование элементов масива
   */
  public void copy(T[] a_array){
    for(int i = 0; i != count(); i++){
      a_array[i] = m_array[i];
    }
  }
}
