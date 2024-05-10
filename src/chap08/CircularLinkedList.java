package chap08;

import java.util.Comparator;

public class CircularLinkedList<E> {
    class Node<E> {
        E data; // 데이터
        Node<E> next; // 뒤쪽 포인터(다음 노드 참조)

        // 생성자
        Node(E data) {
            this.data = data;
            this.next = this;
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // 머리 노드 참조
    private Node<E> tail; // 꼬리 노드 참조
    private Node<E> crnt; // 선택 포인터(선택 노드 참조)

    public CircularLinkedList() {
        head = tail = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        if(head != null) {
            Node<E> ptr = head;

            do {
                if (c.compare(obj, ptr.data) == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;
            } while(ptr != head);
        }
        return null;
    }

    public void addFirst(E obj) {
        if(head == null)
            head = tail = crnt = new Node<E>(obj);
        else{
            Node<E> ptr = head;
            head = crnt = new Node<E>(obj, ptr);
            tail.next = head;
        }
    }

    public void addLast(E obj) {
        if(head == null)
            addFirst(obj);
        else {
            Node<E> ptr= tail;
            ptr.next = tail = crnt = new Node<E>(obj, head);

        }
    }

    public void removeFirst() {
        if(head != null) {
            if(head == tail)
                head = tail = crnt = null;
            else {
                Node<E> ptr = head.next;
                head = crnt = ptr;
                tail.next = head;
            }
        }
    }

    public void removeLast() {
        if(head != null) {
            if(head == tail)
                removeFirst();
            else {
                Node<E> ptr = head;
                Node<E> pre = head;

                while(ptr.next != head) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = head;
                tail = crnt = pre;
            }
        }
    }

    public void remove(Node<E> p) {
        if(head != null) {
            if(p == head)
                removeFirst();
            else if (p == tail)
                removeLast();
            else {
                Node<E> ptr = head;

                while(ptr.next != p) {
                    ptr = ptr.next;
                    if(ptr == head) return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while(head != null)
            removeFirst();
        crnt = null;
    }

    public boolean next() {
        if(crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if(crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data.toString());
    }

    public void dump() {
        if(head != null) {
            Node<E> ptr = head;

            do {
                System.out.print(ptr.data.toString() + " ");
                ptr = ptr.next;
            } while(ptr != head);
            System.out.println();
        }
    }

    // Ex1 comparator c로 서로 같은 노드를 찾아 가장 앞쪽의 노드만 남기고 모두 삭제하는 다음 메서드를 작성하세요.
    public void purge(Comparator<? super E> c) {
        if(head == null) return;
        Node<E> ptr = head;

        do {
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
        } while(ptr != head);
        crnt = head;
    }

    // Ex2 머리부터 n개 뒤의 노드에 대한 참조
    // (n이 0이면 머리 노드에 대한 참조, n이 1이면 두 번째 노드에 대한 참조, ...)
    // 를 반환하는 다음 메서드를 작성하세요.
    // n이 음수이거나 노드 개수보다 크거나 같으면 null을 반환합니다.
    public E retrieve(int n) {
        if(head != null) {
            Node<E> ptr = head;


            while (n >= 0) {
                if (n-- == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;
                if(ptr == head) break;
            }
        }
        return null;
    }
}
