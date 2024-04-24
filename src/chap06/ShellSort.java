package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    static void shellSort(int[] a, int n) {
        for(int h=n/2; h>0; h/=2) {
            for(int i=h; i<n; i++) {
                int j;
                int tmp = a[i];
                for(j=i-h; j>=0 && a[j] >tmp;j-=h) {
                    a[j+h] = a[j];
                }
                a[j+h] = tmp;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("셸 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("a[" + i + "] = ");
            x[i] = scanner.nextInt();
        }

        shellSort(x, nx);
    }
}
