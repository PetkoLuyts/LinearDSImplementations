package implementations;

public class CircularDoublyLinkedList<E> {
    public Node<E> head;
    public Node<E> tail;
    public int size;

    public static class Node<E> {
        public E value;
        public Node<E> next;
        public Node<E> prev;
    }

    public Node<E> createCircularDoublyLinkedList(E value) {
        head = new Node<>();
        Node newNode = new Node();
        newNode.value = value;
        head = tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;

        return head;
    }

    public void insertNode(E nodeValue, int location) {
        Node newNode = new Node();
        newNode.value = nodeValue;

        if (head == null) {
            createCircularDoublyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            int index = 0;

            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }

        size++;
    }

    public void traverseCircularDoublyLinkedList() {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);

                if (i != size - 1) {
                    System.out.print(" -> ");
                }

                tempNode = tempNode.next;
            }
        } else {
            System.out.println("The Circular Doubly Linked List does not exist.");
        }

        System.out.println();
    }

    public void reverseTraversalCircularDoublyLinkedList() {
        if (head != null) {
            Node tempNode = tail;

            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);

                if (i != size - 1) {
                    System.out.print(" <- ");
                }

                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("The Circular Doubly Linked List does not exist.");
        }

        System.out.println();
    }
}
