package chap06;

import chap04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort1(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pr + pl)/2];

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;

            if(pl <= pr)
                swap(a, pl++, pr--);
        } while(pl <= pr);

        if((pr-left) < (right-pl)) {
            int temp;
            temp = left; left = pl; pl = temp;
            temp = right; right = pr; pr = temp;
        }
        if(left < pr) quickSort1(a, left, pr);
        if(pl < right) quickSort1(a, pl, right);

    }

    static void quickSort2(int[] a, int left, int right) {
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

            if((pr-left) < (right-pl)) {
                int temp;
                temp = left; left = pl; pl = temp;
                temp = right; right = pr; pr = temp;
            }

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
        System.out.println("실습 6-9, 실습 6-10의 quickSort 메서드를 요솟수가 적은 그룹을 먼저 나누도록 메서드를 수정하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];
        int[] y = x;


        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        quickSort1(x, 0, nx-1);
        quickSort2(y, 0, nx-1);
        System.out.println("x : " + Arrays.toString(x));
        System.out.println("y : " + Arrays.toString(y));
    }
}
