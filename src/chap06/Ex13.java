package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex13 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static int sort3elem(int[] x, int a, int b, int c) {
        if(x[b] < x[a]) swap(x, b, a);
        if(x[c] < x[b]) swap(x, c, b);
        if(x[b] < x[a]) swap(x, b, a);
        return b;
    }

    static void insertionSort(int[] a, int left, int right) {
        for (int i=left+1; i<=right; i++) {
            int tmp = a[i];
            int j;
            for(j=i; j>left && a[j-1]>tmp; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    static void quickSort(int[] a, int left, int right) {

        if(right - left < 9) {
            insertionSort(a, left, right);
        } else {
            int pl = left;
            int pr = right;
            int m = sort3elem(a, pl, (pl + pr) / 2, pr);
            int x = a[m];

            swap(a, m, right - 1);
            pl++;
            pr -= 2;

            do {
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;

                if(pl <= pr)
                    swap(a, pl++, pr--);
            } while(pl <= pr);

            if(left < pr) quickSort(a, left, pr);
            if(pl < right) quickSort(a, pl, right);
        }
    }

    public static void main(String[] args) {
        System.out.println("퀵 정렬은 요솟수가 적은 배열을 처리할 때는 그다지 빠르지 않다고 알려져 있습니다." +
                "실습 6-11의 quickSort 메서드를 나눈 그룹의 9개 이하이면 단순 삽입 정렬로 동적하도록 메서드를 수정하세요.");

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
