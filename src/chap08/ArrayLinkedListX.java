package chap08;

import java.util.Comparator;

public class ArrayLinkedListX<E> {
    class Node<E> {
        private E data; // 데이터
        private int next; // 리스트의 뒤쪽 포인터
        private int dnext; // 프리 리스트의 뒤쪽 포인터


        // 생성자
        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n; // 리스트 본체
    private int size; // 리스트의 용량(가장 큰 데이터 수)
    private int max; // 사용 중인 꼬리 record
    private int head; // 머리 노드
    private int tail; // 꼬리 노드
    private int crnt; // 선택 노드
    private int deleted; // 프리 리스트의 머리 노드
    private static final int NULL = -1; // 다음 노드 없음 / 리스트가 가득 참


    public ArrayLinkedListX(int capacity) {
        head = tail = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for(int i=0; i<capacity; i++)
                n[i] = new Node<E>();
            size = capacity;
        } catch (OutOfMemoryError e) {
            size = 0;
        }
    }

    private int getInsertIndex(){
        if(deleted == NULL)
            if(max < size)
                return ++max;
            else
                return NULL;
        else {
            int rec = deleted;
            deleted = n[rec].dnext;
            return rec;
        }
    }

    private void deleteIndex(int idx) {
        if(deleted == NULL) {
            deleted = idx;
            n[idx].dnext = NULL;
        } else {
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;

        while(ptr != NULL) {
            if(c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }
        return null;
    }

    public void addFirst(E obj) {
        boolean empty = (tail == NULL);
        int ptr = head;
        int rec = getInsertIndex();
        if(rec != NULL) {
            head = crnt = rec;
            n[head].set(obj, ptr);
            if(empty) tail = crnt;
        }
    }

    public void addLast(E obj) {
        if (head == NULL)
            addFirst(obj);
        else{
            int rec = getInsertIndex();
            if (rec != NULL) {
                n[tail].next = crnt = rec;
                n[rec].set(obj, NULL);
                tail = rec;
            }
        }
    }

    public void removeFirst() {
        if(head != NULL) {
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
            if(head == NULL) tail = NULL;
        }
    }

    public void removeLast() {
        if(head != NULL) {
            if(n[head].next == NULL)
                removeFirst();
            else {
                int ptr = head;
                int pre = head;

                while(n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;
                deleteIndex(ptr);
                tail = crnt = pre;
            }
        }
    }

    public void remove(int p) {
        if(head != NULL) {
            if(p == head)
                removeFirst();
            else if(p == tail)
                removeLast();
            else {
                int ptr = head;

                while(n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if(ptr == NULL) return;
                }
                n[ptr].next = n[p].next;
                deleteIndex(p);
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while(head != NULL)
            removeFirst();
        crnt = NULL;
    }

    public boolean next() {
        if(crnt == NULL || n[crnt].next == NULL)
            return false;
        crnt = n[crnt].next;
        return true;
    }

    public void printCurrentNode() {
        if(crnt == NULL)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);
    }

    public void dump() {
        int ptr = head;
        while(ptr != NULL) {
            System.out.print(n[ptr].data + " ");
            ptr = n[ptr].next;
        }
        System.out.println();
    }

    // Ex4 연결 리스트 클래스 LinkedList<E> 에 대하여 연습문제 Q1에서 수행한 과제와 동일한 방법으로 배열 커서 버전의 연결 리스트를 작성하세요.
    public void purge(Comparator<? super E> c) {
        int ptr = head;

        while(ptr != NULL) {
            int count = 0;
            int ptr2 = ptr;
            int pre = ptr;

            while(n[pre].next != NULL) {
                ptr2 = n[pre].next;
                if(c.compare(n[ptr].data, n[ptr2].data) == 0) {
                    remove(ptr2);
                    count++;
                } else
                    pre = ptr2;
            }

            if(count == 0)
                ptr = n[ptr].next;
            else {
                int temp = ptr;
                remove(ptr);
                ptr = n[temp].next;
            }
        }
        crnt = head;
    }

    // Ex5 연결 리스트 클래스 LinkedList<E> 에 대하여 연습문제 Q2에서 수행한 과제와 동일한 방법으로 배열 커서 버전의 연결 리스트를 작성하세요.
    // n이 음수이거나 노드 개수보다 크거나 같으면 null을 반환합니다.
    public E retrieve(int num) {
        int ptr = head;


        while(num >= 0 && ptr != NULL) {
            if(num-- == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }

        return null;
    }
}
