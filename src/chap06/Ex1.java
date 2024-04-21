package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        for(int i=n-1; i>0; i--)
            for(int j=0; j<i; j++)
                if(a[j] > a[j+1])
                    swap(a, j, j+1);
    }

    public static void main(String[] args) {
        System.out.println("버블 정렬의 각 패스에서 비교, 교환은 배열의 앞쪽, 즉 처음부터 수행해도 됨(각 패스에서 가장 큰 값의 요소가 맨 끝으로 옮겨집니다.)" +
                "그렇게 수정한 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        bubbleSort(x, nx);
        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i< nx; i++) {
            System.out.println("x["+i+"] = "+x[i]);
        }
    }
}
