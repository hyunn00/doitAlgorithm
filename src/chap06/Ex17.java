package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex17 {
    static void countingSort(int[] a, int n, int max) {
        int[] f = new int[max+1];
        int[] b = new int[n];

        System.out.println("Step 1 : 도수분포표 작성");
        for(int i=0; i<n; i++) {
            for(int k=0; k<=max; k++)
                System.out.printf("%4d", f[k]);
            System.out.println();
            f[a[i]]++;
        }
        for(int k=0; k<=max; k++)
            System.out.printf("%4d", f[k]);
        System.out.println();

        System.out.println("Step 2 : 누적도수분포표 작성");
        for(int i=1; i<=max;i++) {
            for(int k=0; k<=max; k++)
                System.out.printf("%4d", f[k]);
            System.out.println();
            f[i] += f[i - 1];
        }
        for(int k=0; k<=max; k++)
            System.out.printf("%4d", f[k]);
        System.out.println();

        System.out.println("Step 3 : 목표 배열 만들기");
        for(int i=n-1; i>=0; i--) {
            for(int k=0; k<n; k++)
                System.out.printf("%4d", b[k]);
            System.out.println();
            b[--f[a[i]]] = a[i];
        }
        for(int k=0; k<n; k++)
            System.out.printf("%4d", b[k]);
        System.out.println();

        System.out.println("Step 4 : 배열 복사하기");
        for(int i=0; i<n; i++) {
            a[i] = b[i];
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("도수 정렬의 각 단계(for 문)에서 배열 a, b, f의 요솟값이 변화하는 모습을 출력하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            do{
                System.out.print("x["+i+"] : ");
                x[i] = scanner.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for(int i=1; i<nx; i++)
            if(x[i] > max) max = x[i];

        countingSort(x, nx, max);
    }
}
