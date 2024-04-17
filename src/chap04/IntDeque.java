package chap04;

public class IntDeque {
    private int[] que; // 큐용 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤에 요소 커서
    private int num; // 현재 데이터 개수

    // 실행 시 예외 : 큐가 비어 있음
    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {}
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {}
    }

    // 생성자
    public IntDeque(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;

        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 덱의 맨앞에 데이터를 인큐
    public int enqueFront(int x) throws OverflowIntDequeException {
        if(num >= capacity)
            throw new OverflowIntDequeException();
        num++;

        if(--front < 0)
           front = capacity - 1;
        que[front] = x;

        return x;
    }

    // 덱의 맨끝에 데이터를 인큐
    public int enqueRear(int x) throws OverflowIntDequeException {
        if(num >= capacity)
            throw new OverflowIntDequeException();
        que[rear++] = x;
        num++;

        if(rear == capacity)
            rear = 0;

        return x;
    }

    // 덱의 맨앞 데이터를 디큐
    public int dequeFront() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();

        int x = que[front++];
        num--;

        if(front == capacity)
            front = 0;

        return x;
    }

    // 덱의 맨끝 데이터를 디큐
    public int dequeRear() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();

        num--;

        if(--rear < 0)
            rear = capacity - 1;
        return que[rear];
    }

    // 덱의 맨앞 데이터를 피크(맨앞 데이터를 들여다봄)
    public int peekFront() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();
        return que[front];
    }

    // 덱의 맨끝 데이터를 피크(맨끝 데이터를 들여다봄)
    public int peekRear() throws EmptyIntDequeException {
        if(num <= 0)
            throw new EmptyIntDequeException();
        return que[rear == 0 ? capacity - 1 : rear - 1];
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for(int i = 0; i<num; i++) {
            int idx = (1+front) % capacity;
            if(que[idx] == x) return idx;
        }
        return -1;
    }
    public int search(int x) {
        for(int i=0; i<num; i++) {
            if(que[(i+front)%capacity] == x) return i+1;
        }
        return -1;
    }

    // 큐의 용량을 반환
    public int getCapacity() {
        return capacity;
    }

    // 큐에 쌓여 있는 데이터 개수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있나요?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼나요?
    public boolean isFull() {
        return num >= capacity;
    }

    // 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for(int i=0; i<num; i++)
                System.out.print(que[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
}
