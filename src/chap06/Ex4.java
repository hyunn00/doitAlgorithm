package chap06;

import java.util.Scanner;

public class Ex4 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        int compare = 0;
        int change = 0;

        int k=0;
        int idx=1;
        while(k < n-1) {
            System.out.printf("패스 %d :\n", idx);
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                compare++;
                for (int i = 0; i < j-1; i++)
                    System.out.printf("%2d", a[i]);

                System.out.printf("%2d", a[j-1]);
                if (a[j - 1] > a[j]) {
                    change++;
                    System.out.printf("+%d", a[j]);
                    swap(a, j - 1, j);
                    last = j;
                }else
                    System.out.printf("-%d", a[j]);

                for(int i=j+1; i<n; i++)
                    System.out.printf("%2d", a[i]);
                System.out.println();
            }
            for(int i = 0; i<n; i++)
                System.out.printf("%2d", a[i]);
            System.out.println();
            k = last;
            idx++;
        }

        System.out.printf("비교를 %d회 했습니다.\n", compare);
        System.out.printf("교환을 %d회 했습니다.\n", change);
    }

    public static void main(String[] args) {
        System.out.println("실습 6-3의 버블 정렬(버전 3)을 연습문제 Q2와 마찬가지로 비교, 교환하는 과정을 자세히 출력하는 프로그램으로 수정하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        bubbleSort(x, nx);
    }
}
