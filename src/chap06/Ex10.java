package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10 {
    static void shellSort(int[] a, int n) {
        int count = 0;
        for(int h=n/2; h>0; h/=2) {
            for(int i=h; i<n; i++) {
                int j;
                int tmp = a[i];
                for(j=i-h; j>=0 && a[j] >tmp;j-=h) {
                    count++;
                    a[j+h] = a[j];
                }
                a[j+h] = tmp;
                count++;
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println("shellSort : "+count+"회");
    }
    static void shellSort2(int[] a, int n) {
        int count = 0;
        int h;
        for(h=1; h<n; h = h*3+1)
            ;

        for(; h>0; h/=3) {
            for(int i=h; i<n; i++) {
                int j;
                int tmp = a[i];
                for(j=i-h; j>=0 && a[j] >tmp;j-=h) {
                    a[j+h] = a[j];
                    count++;
                }
                a[j+h] = tmp;
                count++;
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println("shellSort2 : " +count+"회");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("셸 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("a[" + i + "] = ");
            x[i] = scanner.nextInt();
        }

        shellSort(x, nx);
        shellSort2(x, nx);
    }
}
