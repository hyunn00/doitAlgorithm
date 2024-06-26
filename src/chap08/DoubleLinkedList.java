package chap08;

import java.util.Comparator;

public class DoubleLinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList() {
        head = crnt = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while(ptr != head) {
            if(c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void printCurrentNode() {
        if(isEmpty())
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    public void dump() {
        Node<E> ptr = head.next;

        while(ptr != head) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while(ptr != head) {
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        }
        System.out.println();
    }

    public boolean next() {
        if(isEmpty() || crnt.next == head)
            return false;
        crnt = crnt.next;
        return true;
    }

    public boolean prev() {
        if(isEmpty() || crnt.prev == head)
            return false;
        crnt = crnt.prev;
        return true;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    public void removeCurrentNode() {
        if(!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if(crnt == head) crnt = head.next;
        }
    }

    public void remove(Node<E> p) {
        Node<E> ptr = head.next;

        while(ptr != head) {
            if(ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    public void clear() {
        while(!isEmpty())
            removeFirst();
    }

    // Ex9 연결 리스트 클래스 LinkedList<E>에 대하여 연습문제 Q1에서 수행한 과제와 동일한 방법으로 원형 이중 연결 리스트 클래스 DoubleLinkedList<E>를 작성하세요
    public void purge(Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while(ptr.next != head) {
            int count = 0;
            Node<E> ptr2 = ptr;
            Node<E> pre = ptr;

            while(pre.next != head) {
                ptr2 = pre.next;
                if(c.compare(ptr.data, ptr2.data) == 0) {
                    pre.next = ptr2.next;
                    count++;
                } else
                    pre = ptr2;
            }

            if(count == 0)
                ptr = ptr.next;
            else {
                Node<E> temp = ptr;
                remove(ptr);
                ptr = temp.next;
            }
        }
        crnt = head;
    }

    // Ex10 연결 리스트 클래스 LinkedList<E>에 대하여 연습문제 Q2에서 수행한 과제와 동일한 방법으로 원형 이중 연결 리스트 클래스 DoubleLinkedList<E>를 작성하세요
    public E retrieve(int n) {
        Node<E> ptr = head.next;


        while(n >= 0 && ptr.next.next != head) {
            if(n-- == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }
}
