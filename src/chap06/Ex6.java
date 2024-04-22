package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {
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
            }

            for(int k=0; k<n; k++) {
                if(k==i) System.out.print(" *");
                else if(k==min) System.out.print(" +");
                else System.out.print("  ");
            }
            System.out.println();

            for(int k=0; k<n; k++)
                System.out.printf("%2d", a[k]);
            System.out.println();

            swap(a, i, min); // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환

        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("요소의 교환 과정을 자세하게 출력하도록 단순 선택 정렬 프로그램을 수정하세요." +
                "오른쪽 그림처럼 정렬하지 않은 부분의 맨 앞 요소위에는 '*'를, 정렬하지 않은 부분에서 가장 작은 값의 요소 위에는 '+'를 출력하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
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
