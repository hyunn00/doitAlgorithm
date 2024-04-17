package chap04;

public class IntArrayQueue {
    private int[] que; // 큐용 배열
    private int capacity; // 큐 용량
    private int num; // 현재 데이터 개수

    public IntArrayQueue(int maxlen) {
        num = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }


    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public int enqueue(int x) throws OverflowIntQueueException {
        if(num >= capacity)
            throw new OverflowIntQueueException();
        return que[num++] = x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = que[0];
        for(int q =1; q<num+1; q++) {
            que[q-1] = que[q];
        }
        num--;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[num-1];
    }

    public void clear() {
        num = 0;
    }

    public int indexOf(int x) {
        for(int i=0; i<num; i++) {
            if(x == que[i]) return i;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for(int i=0; i<num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
