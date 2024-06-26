package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex9 {
    static void insertionSort(int[] a, int n) {
        for (int i=1; i<n; i++) {
            int key = a[i];
            int pl = 0; // 검색 범위 맨 앞의 인덱스
            int pr = i - 1; // 검색 범위 맨 끝의 인덱스
            int pc; // 검색 범위 중앙의 인덱스
            int pd; // 삽입하는 위치의 인덱스

            do {
                pc = (pl + pr) / 2;
                if(a[pc] == key)
                    break;
                else if(a[pc] < key)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while(pl <= pr);
            pd = (pl <= pr) ? pc + 1 : pr + 1;

            for(int j=i; j>pd; j--) {
                a[j] = a[j-1];
            }
            a[pd] = key;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("단순 삽입 정렬은 배열의 요솟수가 많아지면 많아질수록 요소 삽입에 필요한 비교, 대입 비용이 무시할 수 없을 정도로 커집니다." +
                "이때 배열에서 이미 정해진 부분은 이진 검색을 사용할 수 있기 때문에 삽입할 위치를 더 빨리 찾을 수 있습니다." +
                "이진 검색을 사용하여 프로그램을 수정하세요.");
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
