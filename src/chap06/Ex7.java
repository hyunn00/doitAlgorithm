package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7 {
    static void insertionSort(int[] a, int n) {
        for (int i=1; i<n; i++) {
            for(int k=0; k<n;k++) {
                System.out.printf("%2d", a[k]);
            }
            System.out.println();

            int j;
            int tmp = a[i];
            for(j=i; j>0 && a[j-1]>tmp; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;

            for(int k=0; k<=i; k++) {
                if(k==j) {
                    if(i == j) System.out.print(" +");
                    else System.out.print(" ^");
                }
                else if(k==i) System.out.print("-+");
                else if(k > j) System.out.print("--");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        insertionSort(x, nx);
    }
}
