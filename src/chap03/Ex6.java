package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("실습 BinarySearchTester를 수정하여 검색에 실패할 때 삽입 포인트의 값을 출력하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = scanner.nextInt();

        for(int i=1; i<num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = scanner.nextInt();
            } while(x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();

        int idx = Arrays.binarySearch(x, ky);

        if(idx < 0) {
            System.out.println("그 값의 요소는 존재하지 않습니다.");
            System.out.printf("삽입 포인트는 %d입니다.\n", -idx -1);
            System.out.printf("x[%d]의 바로 앞에 %d를 삽입하면 배열의 정렬 상태가 유지됩니다.\n", -idx -1, ky);
        }
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
