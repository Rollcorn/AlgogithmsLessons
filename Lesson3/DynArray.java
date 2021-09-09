// package AlgorithmsLessons.Lesson3;
// package Algorithms.DynArray;

import java.lang.reflect.Array;

public class DynArray<T>
{
  // Для тестов вернуть public а то хз
  private T [] m_array;           // Буфер памяти
  private int m_count;            // Количество элементов в массиве
  private int m_capacity;         // Размер буфера
  private int m_minCapacity = 16; // Минимальный размер буфера
  Class m_clazz;                  // Тип хранимых элементов

  /*****************************************************************
   * Конструктор
   * new DynArray<Integer>(Integer.class);
   * @param a_clz
   */
  public DynArray(Class a_clz)
  {
    m_clazz = a_clz; // нужен для безопасного приведения типов
    m_count = 0;
    m_capacity = m_minCapacity;
    makeArray(m_capacity);
  }

  /******************************************************************************
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

  }

  /***************************************************************************
   * Получение объекта по его индексу
   * Встроить проверку корректности индекса в рамках границ, и 
   * генерацию соответствующего исключения, если обращение некорректно;
   */
  public T getItem(int a_index) throws ArrayIndexOutOfBoundsException
  {
    // Проверка индекса массива
    if( !( (a_index >= 0) && (a_index < m_count) ) ){ throw new ArrayIndexOutOfBoundsException(); }

    assert( a_index <= m_count && a_index >= 0);
    return m_array[a_index];
  }
  /************************************************************************
   * Добавление нового элемента в конец массива
   * 
   * @param itm
   */
  public void append(T itm)
  {
    if ( 0 == (m_capacity - m_count) ) {
      m_capacity *= 2;
      makeArray(m_capacity);
    } 
    m_array[m_count] = itm;
    m_count += 1;
  }

  /**********************************************************************
   * Вставляет в i-ю позицию объект item, сдвигая вперёд все последующие 
   * элементы. ! Новая длина массива может превысить размер буфера.
   * Увеличение буфера выполняем, когда он весь полностью заполнен, и 
   * выполняется попытка добавления.
   * 
   * @param a_itm - вставляемый объект.
   * @param a_index - индекс вставки.
   */
  public void insert(T a_itm, int a_index) throws ArrayIndexOutOfBoundsException
  {
    // Проверка индекса массива
    if( !( (a_index >= 0) && (a_index <= m_count) ) ){ throw new ArrayIndexOutOfBoundsException(); }

    T insetItem = a_itm;
    T tmpItem;
    
    // Проверка объема буфера
    if ( (m_capacity - m_count) == 0) {
      m_capacity *= 2;
      makeArray(m_capacity);
    }
    
    for ( int i = a_index;  i <= m_count; i++){
      // Смещение элементов
      tmpItem = m_array[i];
      m_array[i] = insetItem;
      insetItem = tmpItem;
    } 
    
    // Увеличение счетчика
    m_count += 1;
  }
  
  /**************************************************************************************
   * Удаляет объект из позиции a_index, при необходимости выполняя сжатие буфера
   * в 1.5 раза. Если после деления размера буфера на 1.5 остается меньше 16 элементов,
   * то принимаем новый размер буфера m_minCapacity. Сокращение 
   * буфера выполняем, когда его заполненность после операции удаления станет
   *  строго меньше, чем заданный процент заполнения = 50%. 
   * 
   * @param a_index - индекс элемента для удаления
   */
  public void remove(int a_index) throws ArrayIndexOutOfBoundsException
  {
    if( !( (a_index >= 0) && (a_index < m_count) ) ){ throw new ArrayIndexOutOfBoundsException(); }
    
    // Сдвиг элементов (удаление)
    for(int i = a_index; i < m_count; i++ ){
      m_array[i] = m_array[i + 1];
    }
    // Уменьшение счетчика элементов
    m_count -= 1;

    // Поддержание заполненности буфера более 50%
    if(m_count <= 0.5*m_capacity) {
      if (m_capacity / 1.5 <= m_minCapacity) {
        m_capacity = m_minCapacity;
      } else {
        // Уменьшить размер буфера в 1,5 раза
        m_capacity /= 1.5;
        makeArray(m_capacity);
      }
    }
  }

  /**********************************************************
   * Количество элементов в массиве
   * @return
   */
  public int count(){
    return m_count;
  }

  /**********************************************************
   * Объем буфера массива 
   */
  public int capacity(){
    return m_capacity;
  }

  /******************************************************************
   * Копирование элементов масива
   * 
   * @param a_array - массив в который происходит копирование
   */
  private void copy(T[] a_array){
    for(int i = 0; i != count(); i++){
      a_array[i] = m_array[i];
    }
  }


}
