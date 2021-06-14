package lesson2;

public class MyArrayList<T> {
    private int size = 0;
    private T[] array;
    private int capacity = 10;

    public MyArrayList() {
        this.array = (T[]) new Object[capacity];
    }

    public void add(final T item){
        if(size == capacity){
            capacity *= 2;
            final T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = item;
        size++;
    }

    public void remove(final int index){
        if (index > size - 1){
            return;
        }
        if (size - (index + 1) >= 0){
            System.arraycopy(array, index + 1, array, index, size - (index + 1));
        }
        size--;
    }

    public Object get(final int index){
        if (index > size - 1){
            return "no such index";
        }
        return array[index];
    }

    @Override
    public String toString() {
        final StringBuilder sb= new StringBuilder("MyArrayList{");
        for (int i = 0; i < size; i++) {
            sb.append("i").append(i).append("=").append(array[i]).append(", ");
        }
        sb.replace(sb.length()-2, sb.length(), "");
        return sb.append("}").toString();
    }
}
