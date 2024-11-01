package Application;

import java.util.HashSet;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addAtPosition(int value, int position) {
        Node newNode = new Node(value);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Posição fora do intervalo.");
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    // Complexidade: O(n), onde n é a posição em que o elemento é inserido.

    public void removeElement(int value) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.value == value) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Remoção falhou: valor não encontrado.");
    }
    // Complexidade: O(n), onde n é o número de elementos na lista.

    public void reverseList() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
    }
    // Complexidade: O(n), onde n é o número de elementos na lista.

    public Node getMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Complexidade: O(n), onde n é o número de elementos na lista.

    public void removeDuplicates() {
        Node current = head;
        Node previous = null;
        HashSet<Integer> seen = new HashSet<>();
        while (current != null) {
            if (seen.contains(current.value)) {
                previous.next = current.next;
            } else {
                seen.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
    // Complexidade: O(n), onde n é o número de elementos na lista.

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}