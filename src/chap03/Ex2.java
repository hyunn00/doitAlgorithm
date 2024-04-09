package chap03;

import java.util.Scanner;

public class Ex2 {
    static int seqSearchFor(int[] a, int n, int key) {
        System.out.print("    |");
        for(int i=0;i<n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("----+");
        for(int i=0;i<3*n; i++) {
            System.out.print("-");
        }
        System.out.println();

        for(int i=0;i<n; i++) {
            for(int j=-1;j<=i; j++) {
                if(j==-1) System.out.print("    |");
                else if (j == i) System.out.printf("%3c\n", '*');
                else System.out.print("   ");
            }
            for(int j=-1;j<n; j++) {
                if(j==-1) System.out.printf("%3d |", i);
                else System.out.printf("%3d", a[j]);
            }
            System.out.println();

            if(a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("오른쪽처럼 선형 검색의 스캐닝 과정을 자세히 출력하는 프로그램을 작성하세요." +
                "이때 각 행의 맨 왼쪽에 현재 선택한 요소의 인덱스를 출력하고, 현재 선택한 요소 위에 기호 *를 출력하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();

        int idx = seqSearchFor(x, num, ky);

        if(idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
