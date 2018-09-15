class ArrayList<T>{
  // declare an array
  // when array reaches max length
  //    -> make another array of 2x length
  //    -> insert all elements of this array into new array
  //    -> return new array
  // TODO: avoid / fix unchecked casting errors  

  private T[] array;
  private int index;
  public int length;
  public ArrayList(){
    this.array = (T[])new Object[1];
    this.index = -1;
    this.length = this.array.length;
  }

  void add(T element){
    int oldLength = this.array.length;
    // If array is full
    if(this.index == oldLength - 1){
      T[] newArray = (T[])new Object[2*oldLength];

      //copy elements into new array
      for(int i = 0; i < oldLength; i++){
        newArray[i] = this.array[i];
      }

      this.array = newArray;
    }

    // Insert element into the array
    this.index++;
    this.array[this.index] = element;
    this.length = this.index + 1;
    return;
  }

  T charAt(int index){
    return this.array[index];
  }
}

public class ArrayListImplementation{

    public static void main(String[] args){
      ArrayList<Integer> intList = new ArrayList<Integer>();
      intList.add(1);
      intList.add(2);
      intList.add(3);
      intList.add(4);
      intList.add(5);
      displayArrayList(intList);
      ArrayList<String> stringList = new ArrayList<String>();
      stringList.add("this");
      stringList.add("array");
      stringList.add("is");
      stringList.add("increasing");
      stringList.add("dynamically!");
      displayArrayList(stringList);
    }

    static void displayArrayList(ArrayList list){
      for(int i = 0; i < list.length; i++){
        System.out.println(list.charAt(i));
      }
    }
}
