package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex16 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static int pow2(int n) {
        int k=1;

        while(n-- > 0)
            k*=2;

        return k;
    }

    static void dispSpace(int n) {
        for(int i=0; i<n; i++) {
            System.out.print(' ');
        }
    }

    static void dispHeap(int a[], int n) {
        int i = n;
        int height = 1;
        while((i >>= 1) > 0)
            height++;
        i=0;
        int w=1;
        Loop : {
            for(int level = 0; level < height; level++) {
                dispSpace(pow2(height - level) - 2);
                for(int k=0; k<w; k++) {
                    System.out.printf("%02d", a[i++]);
                    if(i >= n) break Loop;
                    if(k < w-1)
                        dispSpace(pow2(height-level+1)-2);
                }
                System.out.println();

                dispSpace(pow2(height-level) - 3);
                for(int k=0; k<w; k++) {
                    if(2 * k + i < n) System.out.print("/");
                    if(2 * k + i + 1 < n) System.out.print("\\");
                    if(k < w-1)
                        dispSpace(pow2(height-level+1)-4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }

    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];
        int child;
        int parent;

        for(parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if(temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for(int i=(n-1)/2; i>= 0; i--) {
            dispHeap(a, n);
            downHeap(a, i, n - 1);
        }

        for(int i=(n-1); i> 0; i--) {
            swap(a, 0, i);
            dispHeap(a, n);
            downHeap(a, 0, i - 1);
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("downHeap 메서드가 호출될 때마다 오른쪽 그림처럼 배열 값을 트리 형식으로 출력하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        heapSort(x, nx);
    }
}
