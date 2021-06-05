package lesson2;

public class MyLinkedList<T> {

    private int size = 0;

    private Node<T> firstNode;
    private Node<T> lastNode;

    public MyLinkedList() {
        firstNode = null;
        lastNode = null;
    }

    public void add(final T item){
        final Node<T> newNode = new Node<>(item);
        final Node<T> last = lastNode;
        lastNode = newNode;
        if(size == 0){
            firstNode = newNode;
        } else {
            last.nextNode = newNode;
            lastNode.previouseNode = last;
        }
        size++;
    }

    public T get(final int index){
        if (index > size - 1 || index < 0){
            throw new IndexOutOfBoundsException("");
        }
        return node(index).item;
    }

    public void remove(final int index){
        if (index > size-1 || index < 0){
            throw new IndexOutOfBoundsException("");
        } else if (index == size -1){
            node(index - 1).nextNode = null;
            lastNode = node(index - 1);
        } else if (index == 0){
            node(index + 1).previouseNode = null;
            firstNode = node(index + 1);
        } else {
            node(index -1).nextNode = node(index + 1);
            node(index + 1).previouseNode = node(index - 1);
        }
        size--;
    }

    public void inverse(){
        Node<T> temp = null;
        for (Node<T> x = firstNode; x != null; x = temp.nextNode) {
            try {
                temp = x.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            x.previouseNode = temp != null ? temp.nextNode : null;
            x.nextNode = temp != null ? temp.previouseNode : null;
        }
        Node<T> tempNode = null;
        try {
            tempNode = firstNode != null ? firstNode.clone() : null;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        firstNode = lastNode;
        lastNode = tempNode;
    }

    Node<T> node(final int index){
        if(size == 0 || index < 0 || index > size - 1){
            return null;
        }
        Node<T> node = null;
        if (index > size/2){
            node = lastNode;
            for (int i = size - 1; i > index; i--) {
                node = node.previouseNode;
            }
        } else {
            node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
        }
        return node;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (size < 1){
            return "MyLinkedList is empty";
        }
        final StringBuilder sb = new StringBuilder("MyLinkedList{");
        for (int i = 0; i < size; i++) {
            sb.append(i).append("el.=").append(node(i).item).append(", ");
        }
        sb.replace(sb.length()-2, sb.length(), "");
        return sb.append("}").toString();
    }

    private static class Node<T> implements Cloneable{
        private final T item;
        private Node<T> previouseNode;
        private Node<T> nextNode;

        Node(final T item) {
            this.item = item;
        }

        Node(final T item, final Node<T> previouseNode, final Node<T> nextNode) {
            this.item = item;
            this.previouseNode = previouseNode;
            this.nextNode = nextNode;
        }

        @Override
        public Node<T> clone() throws CloneNotSupportedException {
            return (Node<T>) super.clone();
        }
    }

}
