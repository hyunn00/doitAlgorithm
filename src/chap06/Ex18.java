package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex18 {
    static void countingSort(int[] a, int n, int max, int min) {
        int[] f = new int[max-min+2];
        int[] b = new int[n];

        for(int i=0; i<n; i++) f[a[i]-min]++;
        for(int i=1; i<=max-min+1;i++) f[i] += f[i-1];
        for(int i=n-1; i>=0; i--) b[--f[a[i]-min]] = a[i];
        for(int i=0; i<n; i++) a[i] = b[i];

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("요솟값의 범위가 min 이상 max 이하이고 요솟수가 n개인 배열 a를 도수 정렬하는 메서드를 작성하세요.");
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

        int min = x[0];
        for(int i=1; i<nx; i++)
            if(x[i] < min) min = x[i];

        countingSort(x, nx, max, min);
    }
}
