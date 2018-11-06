public class SecondDriver {
  public static void main(String[]args) {
    SuperArray ary = new SuperArray(10);
    System.out.println("New SuperArray ary: " + ary);
    System.out.println("Length of ary: " + ary.size());
    System.out.println("ary is empty?: " + ary.isEmpty());

    ary.add("hello");
    System.out.println("\nAdded item to ary: " + ary);
    System.out.println("Size of ary: " + ary.size());
    System.out.println("ary is empty?: " + ary.isEmpty());

    ary.add("yo");
    ary.add("welcome");
    ary.add("hi");
    ary.add("hola");
    ary.add("sup");
    ary.add("greetings");
    ary.add("nihao");
    ary.add("konichiwa");
    ary.add("aloha");
    System.out.println("\nFilled ary: " + ary);
    System.out.println("Length of ary: " + ary.size());
    System.out.println("\nItem at index 6: " + ary.get(6));
    System.out.println("Item at index -1: " + ary.get(11));

    ary.set(3,"bye");
    System.out.println("Item at index 3 set to 'bye': " + ary);
    ary.set(-1,"adios");
    System.out.println("Item at index -1 set to 'adios': " + ary);

    for (int i = 0; i < 50; i++) {
      ary.add("" + i);
    }
    System.out.println("\nMass adding initiated.");
    System.out.println(ary);
    System.out.println("Size of ary: " + ary.size());

    System.out.println("\n'aloha' in ary?: " + ary.contains("aloha"));
    System.out.println("'70' in ary?: " + ary.contains("70"));
    System.out.println("Index of '22'?: " + ary.indexOf("22"));
    System.out.println("Index of 'bye'?: "+ ary.indexOf("bye"));
    System.out.println("Index of 'yeehaw'? "+ ary.indexOf("yeehaw"));

    ary.add("hello");
    System.out.println("\n'hello' added to ary.");
    System.out.println("Size of ary: " + ary.size());
    System.out.println("Index of 'hello'?: "+ ary.indexOf("hello"));
    System.out.println("Last index of 'hello'?: " + ary.lastIndexOf("hello"));

    ary.add(0,"insert0");
    System.out.println("\n'insert0' inserted at index 0");
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());
    ary.add(10,"insert10");
    System.out.println("'insert10' inserted at index 10");
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());
    ary.add(ary.size(),"insertend");
    System.out.println("'insertend' inserted at index " + ary.size());
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());
    ary.add(99,"error?");
    System.out.println("'error?' inserted at index 99 ( should return ERROR ^)");
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());

    System.out.println("\nMass removal operation initiating!");
    System.out.println("Extra indexes to test errors");
    for (int i = 0; i < 50; i++) {
      try {
        ary.remove(i);
      }
      catch(IndexOutOfBoundsException e) {
        System.out.println("ERROR!");
      }
    }
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());

    System.out.println("\nRemoving 'hello': " + ary.remove("hello"));
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());

    System.out.println("\nRemoving 'andrew': " + ary.remove("andrew"));
    System.out.println(ary);
    System.out.println("Length of ary: " + ary.size());

    System.out.println("Testing exception on add method:");
    try {
      ary.add(99,"this should be an error!");
    }
    catch(IndexOutOfBoundsException e) {
      System.out.println("ERROR!");
    }
    System.out.println("Testing exception on remove method:");
    try {
      ary.remove(99);
    }
    catch(IndexOutOfBoundsException e) {
      System.out.println("ERROR!");
    }

  }
}
