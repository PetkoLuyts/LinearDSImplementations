package implementations;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();

        circularDoublyLinkedList.createCircularDoublyLinkedList(1);
        circularDoublyLinkedList.insertNode(2, 0);
        circularDoublyLinkedList.insertNode(3, 2);
        circularDoublyLinkedList.insertNode(4, 5);

        System.out.println(circularDoublyLinkedList.head.next.value);

        circularDoublyLinkedList.traverseCircularDoublyLinkedList();
        circularDoublyLinkedList.reverseTraversalCircularDoublyLinkedList();
    }
}
