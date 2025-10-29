class Node {
    int data;
    Node next;
    Node prives;
    Node(int data) {
        this.data = data;
    }
}

class MyLinkedList {
    Node head = null, tail = null;

    public int get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count++ == index) return current.data;
            current = current.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prives = newNode;
            head = newNode;
        }
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prives = tail;
            tail = newNode;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        Node newNode = new Node(val);
        newNode.next = current.next;
        newNode.prives = current;

        if (current.next != null)
            current.next.prives = newNode;
        else
            tail = newNode;

        current.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (head == null) return;

        Node current = head;
        int count = 0;

        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        if (current.prives != null)
            current.prives.next = current.next;
        else
            head = current.next;

        if (current.next != null)
            current.next.prives = current.prives;
        else
            tail = current.prives;
    }
}
