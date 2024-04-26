package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex14 {
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

    static void qsort(int[] x, int n) {
        quickSort(x, 0, n-1);
    }

    public static void main(String[] args) {
        System.out.println("quickSort 메서드는 3개의 인수를 전달받는다는 점에서 이 장의 다른 정렬 메서드와 다릅니다." +
                "연습문제 Q13에서 작성한 프로그램을 수정하여 다음 형식으로 퀵 정렬을 수행하는 메서드를 작성하세요." +
                "(첫번째 인수 x는 정렬할 배열이고 두 번째 인수 n은 요솟수입니다.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];


        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        qsort(x, nx);
        System.out.println(Arrays.toString(x));
    }
}
