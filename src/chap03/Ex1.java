package chap03;

import java.util.Scanner;

public class Ex1 {
    static int seqSearch(int[] a, int n, int key) {
        int i;

        a[n] = key;

        for(i=0; a[i] != key;i++)
            ;

        return i==n ? -1 : i;
    }

    public static void main(String[] args) {
        System.out.println("실습 3-3의 seqSearchSen 메서드를 while문 대신 for문을 사용하여 수정한 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num+1];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();

        int idx = seqSearch(x, num, ky);

        if(idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
