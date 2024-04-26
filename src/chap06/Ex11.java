package chap06;

import chap04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

public class Ex11 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        System.out.printf("x[%d]~x[%d]을 나누는 문제를 스택에 푸시합니다.\n", left, right);
        System.out.print("Lstack : "); lstack.dump();
        System.out.print("Rstack : "); rstack.dump();

        while(!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right)/2];

            System.out.printf("스택에서 나누는 문제를 꺼냈습니다. x[%d]~x[%d]을 나눕니다.\n", left, right);

            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;

                if(pl <= pr)
                    swap(a, pl++, pr--);

            } while(pl <= pr);

            if(left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("x[%d]~x[%d]을 나누는 문제를 스택에 푸시합니다.\n", left, pr);
                System.out.print("Lstack : "); lstack.dump();
                System.out.print("Rstack : "); rstack.dump();
            }
            if(pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("x[%d]~x[%d]을 나누는 문제를 스택에 푸시합니다.\n", pl, right);
                System.out.print("Lstack : "); lstack.dump();
                System.out.print("Rstack : "); rstack.dump();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("실습 6-10을 수정하여 푸시, 팝, 나누는 과정을 출력하는 프로그램을 작성하세요.");
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
