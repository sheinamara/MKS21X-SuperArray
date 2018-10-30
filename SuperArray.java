public class SuperArray{
// PHASE ONE
  // private fields so we don't have random things accessing it!
  private String[] data;
  private int size;

  // constructor
  public SuperArray(){
    data = new String[10];
  }
  public SuperArray(int size){ // needed to add a second constructor to debug clear
    data = new String[size];
  }

  // 1
  public void clear(){
    this.size = 0;
    this.data = new String[this.data.length];
  }

  // 2
  public int size(){
    int count = 0;
    for (int i = 0; i < this.data.length; i++){ // needed actual code lol
      if (this.data[i] != null){
        count = count + 1;
      }
    }
    this.size = count;
    return this.size;
  }
  public boolean isEmpty(){
    return size == 0;
  }

  // 3 SANITY CHECK DONE
  public boolean add(String input){
    if (size == data.length){
      resize(); // added a later private resizing method from phase 2
      // return false;
    }
    // else{
    this.size ++; // i think this switch will debug it ???
    data[this.size] = input;
    return true;
    // }
  }

  // 4
  public String toString(){
    // we cannot just say return "" + data or it will return the address
    String theRegularArray = "["; // the beginning of the array we need to print
    for (int i = 0; i < size() - 1; i++){ // WE USE SIZE HERE
      theRegularArray = theRegularArray + data[i] + ", "; // need to add the comma to separate the strings
    }
    if (size() > 0){
      theRegularArray = theRegularArray + data[size() - 1];
    }
    theRegularArray = theRegularArray + "]"; // close the array!
    return theRegularArray;
  }
  public String toStringDebug(){
    // we cannot just say return "" + data or it will return the address
    String theAmazingArray = "["; // the beginning of the array we need to print
    for (int i = 0; i < data.length - 1; i++){ // WE USE BUILT-IN METHOD TO GET THE NULLS
      theAmazingArray = theAmazingArray + data[i] + ", "; // need to add the comma to separate the strings
    }
    theAmazingArray = theAmazingArray + data[data.length - 1] + "]"; // close the array!
    return theAmazingArray;
  }

  // 5
  public String get(int index){
    if (index < 0 || index >= size()){
      return null;
    }
    return "" + data[index];
  }

  // 6
  public String set(int index, String desiredValue){ // replaces the string so don't worry about shifting
    if (index < 0 || index >= size()){
      return null;
    }
    String old = "" + data[index];
    data[index] = desiredValue;
    return old;
  }

// PHASE TWO
  // 7 SANITY CHECK DONE
  private void resize(){
    String[] resizedData;
    resizedData = new String[data.length * 2 + 1];
    for (int i = 0; i < data.length - 1; i++){ // loop through and add original values
      resizedData[i] = data[i];
    }
    this.data = resizedData; // THIS SEEMS SUS but works ???
  }

// PHASE THREE
  // 8
  public boolean contains(String target){
    boolean marker = false;
    for (int i = 0; i < size() - 1; i++){
      if (data[i] == target){
        marker = true;
        return marker;
      }
      i = i + 1;
    }
    return marker;
  }

  // 9
  public int indexOf(String target){
    for (int i = 0; i < size() - 1; i++){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    for (int i = size() - 1; i > 0; i--){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }

  // 10 SANITY CHECK DONE
  public void add(int index, String element){
    if (size() == data.length){
      resize();
    }
    if (index < 0 || index >= size()){
      System.out.println("Error");
    }
    String addedData[];
    addedData = new String[data.length];
    size ++;
    for (int x = 0; x < index; x++){
      addedData[x] = data[x];
    }
    addedData[index] = element;
    for (int i = index + 1; i < size(); i++){
      addedData[i] = data[i-1];
    }
    data = addedData;
  }

  // 11 SANITY CHECK DONE
  public String remove(int index){
    if (index < 0 || index >= size()){
      return null;
    }
    String removedData[];
    removedData = new String[data.length - 1];
    size --;
    for (int x = 0; x < index; x++){
      removedData[x] = data[x];
    }
    String whatIsRemoved = data[index];
    for (int i = index; i < size(); i++){
      removedData[i] = data[i+1];
    }
    data = removedData;
    return whatIsRemoved;
  }


  // 12 SANITY CHECK DONE
  public boolean remove(String element){
    if (indexOf(element) == -1){
      return false;
    }
    else{
      remove(indexOf(element));
    }
    return true;
  }
}
