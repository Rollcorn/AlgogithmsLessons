package AlgorithmsLessons.Lesson3;
// package Algorithms.DynArray;

import java.lang.reflect.Array;

public class DynArray<T>
{
  // Для тестов вернуть public а то хз
  public T [] array;            // Буфер памяти
  public int count;             // Количество элементов в массиве
  public int capacity;          // Размер буфера
  public int minCapacity = 16;  // Минимальный размер буфера
  Class clazz;                  // Тип хранимых элементов

  /*****************************************************************
   * Конструктор
   * new DynArray<Integer>(Integer.class);
   * @param a_clz
   */
  public DynArray(Class a_clz)
  {
    clazz = a_clz; // нужен для безопасного приведения типов
    count = 0;
    capacity = minCapacity;
    makeArray(capacity);
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
    if (count == 0){
      array = ( T[] ) Array.newInstance( this.clazz, a_newCapacity );
    } else {
      T [] newArray = ( T[] ) Array.newInstance( this.clazz, a_newCapacity );
      this.copy(newArray);
      array = newArray;
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
    if( !( (a_index >= 0) && (a_index < count) ) ){ 
      throw new ArrayIndexOutOfBoundsException(); 
    }

    assert( a_index <= count && a_index >= 0);
    return array[a_index];
  }
  /************************************************************************
   * Добавление нового элемента в конец массива
   * 
   * @param itm
   */
  public void append(T itm)
  {
    if ( 0 == (capacity - count) ) {
      capacity *= 2;
      makeArray(capacity);
    } 
    array[count] = itm;
    count += 1;
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
    if( !( (a_index >= 0) && (a_index <= count) ) ){ 
      throw new ArrayIndexOutOfBoundsException(); 
    }

    T insetItem = a_itm;
    T tmpItem;
    
    // Проверка объема буфера
    if ( (capacity - count) == 0) {
      capacity *= 2;
      makeArray(capacity);
    }
    
    for ( int i = a_index;  i <= count; i++){
      // Смещение элементов
      tmpItem = array[i];
      array[i] = insetItem;
      insetItem = tmpItem;
    } 
    
    // Увеличение счетчика
    count += 1;
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
    if( !( (a_index >= 0) && (a_index < count) ) ){ 
      throw new ArrayIndexOutOfBoundsException(); 
    }
    
    // Сдвиг элементов (удаление)
    for(int i = a_index; i < count; i++ ){
      array[i] = array[i + 1];
    }
    // Уменьшение счетчика элементов
    count -= 1;

    // Поддержание заполненности буфера более 50%
    if(count <= 0.5*capacity) {
      if (capacity / 1.5 <= minCapacity) {
        capacity = minCapacity;
      } else {
        // Уменьшить размер буфера в 1,5 раза
        capacity /= 1.5;
        makeArray(capacity);
      }
    }
  }

  /**********************************************************
   * Количество элементов в массиве
   * @return
   */
  public int count(){
    return count;
  }

  /**********************************************************
   * Объем буфера массива 
   */
  public int capacity(){
    return capacity;
  }

  /******************************************************************
   * Копирование элементов масива
   * 
   * @param a_array - массив в который происходит копирование
   */
  private void copy(T[] a_array){
    for(int i = 0; i != count(); i++){
      a_array[i] = array[i];
    }
  }


}
