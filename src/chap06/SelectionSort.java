package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n) {
        for (int i=0; i<n-1; i++) {
            int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 요소인 인덱스를 저장
            for(int j = i+1; j<n; j++) {
                if(a[j] < a[min])
                    min = j;
                swap(a, i, min); // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        selectionSort(x, nx);
    }
}
