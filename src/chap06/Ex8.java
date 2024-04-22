package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex8 {
    static void insertionSort(int[] a, int n) {
        for (int i=2; i<n; i++) {
            int tmp = a[0] = a[i];
            int j = i;
            for(; a[j-1]>tmp; j--) {
                a[j] = a[j-1];
            }
            if(j > 0) a[j] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("단순 삽입 정렬에서 배열의 맨 앞 요소인 a[0]을 사용하지 않고 데이터를 a[1]부터 저장하면 a[0]를 보초로 하여 삽입을 마치는 조건을 줄일 수 있습니다." +
                "이 아이디어를 바탕으로 단순 삽입 정렬을 수행하는 메서드를 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx+1];

        for(int i=1; i<nx+1; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        insertionSort(x, nx+1);
    }
}
