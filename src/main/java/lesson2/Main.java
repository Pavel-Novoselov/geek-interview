package lesson2;

public class Main  {
    public static void main(final String[] args) {
        final MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(51);
        myLinkedList.add(59);
        System.out.println(myLinkedList);
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));

        myLinkedList.add(88);
        myLinkedList.add(125);
        System.out.println(myLinkedList);
        myLinkedList.inverse();
        System.out.println("inverted: " + myLinkedList);

        final MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(15);
        myArrayList.add(25);
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(0));
        myArrayList.remove(2);
        System.out.println(myArrayList);

    }

}
