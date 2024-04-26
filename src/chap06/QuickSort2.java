package chap06;

import chap04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort2 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        lstack.push(right);

        while(!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right)/2];

            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;

                if(pl <= pr)
                    swap(a, pl++, pr--);
            } while(pl <= pr);

            if(left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if(pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];


        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        quickSort(x, 0, nx-1);
        System.out.println(Arrays.toString(x));
    }
}
