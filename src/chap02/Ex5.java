package chap02;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    static void rcopy(int[] a, int[] b) {
        int num = a.length < b.length ? a.length : b.length;
        for(int i=0; i<num; i++) {
            a[i] = b[b.length-i-1];
        }
    }

    public static void main(String[] args) {
        System.out.println("배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 rcopy를 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("x의 요솟수 : ");
        int numx = scanner.nextInt();

        int[] x = new int[numx];

        for(int i=0; i<numx; i++) {
            System.out.print("x[" + i + "] :");
            x[i] = scanner.nextInt();
        }

        System.out.print("y의 요솟수 : ");
        int numy = scanner.nextInt();

        int[] y = new int[numy];

        for(int i=0; i<numy; i++) {
            System.out.print("y[" + i + "] :");
            y[i] = scanner.nextInt();
        }

        rcopy(x, y);
        System.out.println("x="+ Arrays.toString(x));
        System.out.println("y="+ Arrays.toString(y));
    }
}
