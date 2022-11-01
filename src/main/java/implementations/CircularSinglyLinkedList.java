package implementations;

public class CircularSinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;
    }

    public Node createCircularSinglyLinkedList(E value) {
        head = new Node<>();
        Node node = new Node();
        node.value = value;
        node.next = node;
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    public void insertInCircularSinglyLinkedList(E nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createCircularSinglyLinkedList(nodeValue);
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tempNode = head;
            int index = 0;

            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            node.next = tempNode.next;
            tempNode.next = node;
        }

        size++;
    }

    public void traverseCircularSinglyLinkedList() {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);

                if (i != size - 1) {
                    System.out.print(" -> ");
                }

                tempNode = tempNode.next;
            }

            System.out.println();
        } else {
            System.out.println("The Circular Singly Linked List does not exist!");
        }
    }

    public boolean searchNode(E nodeValue) {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node found at location: " + i);
                    return true;
                }

                tempNode = tempNode.next;
            }
        }

        System.out.println("Node not found!");
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The Circular Singly Linked List does not exist!");
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;

            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tempNode = head;

            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }

            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }

            tempNode.next = head;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;

            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteCircularSinglyLinkedList() {
        if (head == null) {
            System.out.println("The Circular Singly Linked List does not exist!");
        } else {
            head = null;
            tail.next = null;
            tail = null;

            System.out.println("The Circular Singly Linked has been deleted!");
        }
    }
}
