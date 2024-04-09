package chap03;

import java.util.Scanner;

public class Ex5 {
    static int binSearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        do {
            int pc = (pl + pr) / 2;
            if(a[pc] == key) {
                for(;pc > pl; pc--) {
                    if(a[pc-1] < key)
                        break;
                }
                return pc;
            } else if(a[pc] > key) {
                pr = pc - 1;
            } else {
                pl = pr + 1;
            }
        } while(pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("우리가 살펴본 이진 검색 알고리즘 프로그램은 검색할 키값과 같은 값을 갖는 요소가 하나 이상일 경우 그 요소 중에서 맨 앞의 요소를 찾지 못합니다." +
                "예를 들어 다음 그림의 배옇에서 7을 검색하면 중앙에 위치하는 a[5]를 검색합니다." +
                "이를 개선하여 키 값과 일치하는 맨 앞의 요소를 찾는 binSearchX 메서드를 작성하세요.");

        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = scanner.nextInt();

        for(int i = 1; i<num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = scanner.nextInt();
            } while(x[i] < x[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();

        int idx = binSearchX(x, num, ky);

        if(idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
