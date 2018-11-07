// TIPS GAINED FROM MY PEERS ABOUT FIXING MY CODE:
//  1. try indicating "this" versus "other" to make sure you understand things better
//  2. read over directions over and over again in order to make sure you know what's going on
//  3. add throws; you didn't have any...
//  4. use JLDriver!!!
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
    if (size < 0){
      throw new IllegalArgumentException("How are we going to negative starting capacity...?");
    }
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
      if (data[i] != null){
        count = count + 1;
      }
    }
    this.size = count;
    return this.size;
  }
  public boolean isEmpty(){
    return this.size() == 0;
  }

  // 3 SANITY CHECK DONE
  public boolean add(String input){
    if (this.size() < this.data.length){
      this.data[this.size()] = input;
      size ++;
    }
    else{
      this.resize();
      this.data[this.size()] = input;
      size ++;
    }
    return true;
  }

  // 4
  public String toString(){
    // we cannot just say return "" + data or it will return the address
    if (this.size() == 0){
      return "[]";
    }
    String theRegularArray = "["; // the beginning of the array we need to print
    for (int i = 0; i < this.size() - 1; i++){ // WE USE SIZE HERE
      theRegularArray = theRegularArray + data[i] + ", "; // need to add the comma to separate the strings
    }
    if (size() > 0){
      theRegularArray = theRegularArray + data[this.size() - 1];
    }
    theRegularArray = theRegularArray + "]"; // close the array!
    return theRegularArray;
  }
  public String toStringDebug(){
    // we cannot just say return "" + data or it will return the address
    if (this.data.length == 0){
      return "[]";
    }
    String theAmazingArray = "["; // the beginning of the array we need to print
    for (int i = 0; i < this.data.length - 1; i++){ // WE USE BUILT-IN METHOD TO GET THE NULLS
      theAmazingArray = theAmazingArray + data[i] + ", "; // need to add the comma to separate the strings
    }
    theAmazingArray = theAmazingArray + data[this.data.length - 1] + "]"; // close the array!
    return theAmazingArray;
  }

  // 5
  public String get(int index){
    if (index < 0 || index >= this.size()){
      throw new IndexOutOfBoundsException("Check the index! Is this valid?");
    }
    return "" + this.data[index];
  }

  // 6
  public String set(int index, String desiredValue){ // replaces the string so don't worry about shifting
    if (index < 0 || index >= this.size()){
      throw new IndexOutOfBoundsException("Check the index! Is this valid?");
    }
    String old = "" + this.data[index];
    this.data[index] = desiredValue;
    return old;
  }

// PHASE TWO
  // 7 SANITY CHECK DONE
  private void resize(){
    String[] resizedData;
    // have to add case about the original size being only 0; had this problem when trying to run driver
    if (this.size() == 0){
      resizedData = new String[10];
    }
    else{
      resizedData = new String[this.data.length * 2]; // changed to include size instead
    }
    for (int i = 0; i < this.size(); i++){ // loop through and add original values
      resizedData[i] = data[i];
    }
    this.data = resizedData; // THIS SEEMS SUS but works ???
  }

// PHASE THREE
  // 8
  public boolean contains(String target){
    boolean marker = false;
    for (int i = 0; i < this.size() - 1; i++){
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
    for (int i = 0; i < this.size() - 1; i++){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    for (int i = this.size() - 1; i > 0; i--){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }

  // 10 SANITY CHECK DONE
  public void add(int index, String element){
    if (index < 0 || index > this.size()){
      throw new IndexOutOfBoundsException("Check the index!!!");
    }
    if (this.data.length == this.size()){
        this.resize();
    }
    for (int i = size(); i > -1; i--){
      if (i == index){
        data[i] = element;
      }
      if (i > index){
        data[i] = data[i - 1];
      }
    }
    size++;
    // GOING TO TRY METHOD WITHOUT A NEW ARRAY
    /*
    String addedData[];
    addedData = new String[this.data.length + 1];
    size ++;
    for (int x = 0; x < index; x++){
      addedData[x] = data[x];
    }
    addedData[index] = element;
    for (int i = index + 1; i < this.size(); i++){
      addedData[i] = data[i-1];
    }
    data = addedData;
    */
  }

  // 11 SANITY CHECK DONE
  public String remove(int index){
    if (index < 0 || index > this.size()){
      throw new IndexOutOfBoundsException("Check the index!!!");
    }
    String whatIsRemoved = this.data[index];
    for (int i = index; i < this.size(); i++){
      data[i] = data[i+1];
    }
    size--;
    return whatIsRemoved;
    // INSPIRED BY THE WORKING CODE FOR ADD METHOD NOW, ATTEMPT TO MAKE THE SAME CHANGES TO THIS
    /*
    else{
      String removedData[];
      removedData = new String[this.data.length - 1];
      for (int x = 0; x < index; x++){
        removedData[x] = data[x];
      }
      String whatIsRemoved = this.data[index];
      for (int i = index; i < this.size(); i++){
        removedData[i] = data[i+1];
      }
      data = removedData;
      size --;
      return whatIsRemoved;
    }
    */
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
