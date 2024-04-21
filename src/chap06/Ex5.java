package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        int sk=0;
        int ek=n-1;
        int last = ek;

        while(sk < ek) {
            for (int j = ek; j > sk; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            sk = last;

            for (int j = sk; j < ek ; j++)
                if (a[j] < a[j+1]) {
                    swap(a, j, j+1);
                    last= j;
                }
            ek = last;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        System.out.println("다음 데이터의 배열을 정렬한다고 가정하겠습니다." +
                "{9, 1, 3, 4, 6, 7, 8}" +
                "이 배열은 두 번째 요소부터 정렬되어 있지만 버전 3의 버블 정렬 알고리즘을 사용해도 빠른 시간 안에 정렬 작업을 마칠 수는 없습니다." +
                "왜냐하면 맨 앞에 있는 요솟값(9)은 1회의 패스로 한 칸씩만 뒤로 옮겨지기 때문입니다." +
                "그래서 홀수 번째 패스는 가장 작은 요소를 맨 앞으로 옮기고 짝수 번째 패스는 가장 큰 요소를 맨 뒤로 옮기는 방식을 사용하면 (패스의 스탠 방향을 교대로 바꾸면) 이런 정렬을 더 적은 횟수로 비교할 수 있습니다." +
                "실습 6-3의 버블 정렬(버전 3)을 개선하여 양방향 버블 정렬을 수행하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        bubbleSort(x, nx);
    }
}
