package chap02;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    static void swap(int[] a, int idx1, int idx2) {
        System.out.println("a[" + idx1 + "]과 a[" + idx2 + "]을 교환합니다.");
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a) {
        for(int i=0; i<a.length/2; i++) {
            swap(a, i, a.length-1-i);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        System.out.println("오른쪽처럼 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();

        int[] a = new int[num];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] :");
            a[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(a));
        reverse(a);
        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
