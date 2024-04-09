package chap03;

import java.util.Scanner;

public class Ex3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for(int i=0; i<n; i++){
            if(a[i] == key) {
                idx[count++] = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고, 일치하는 요솟수를 반환하는 메서드를 작성하세요." +
                "예를 들어 요솟수가 8인 배열 a의 요소가 {1, 9, 2, 9, 4, 6, 7}이고 key가 9일 때 배열 idx에 {1, 3, 7}을 저장하고 3을 반환합니다.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];
        int[] y = new int[num]; // 배열 x의 크기 만큼 y도 지정

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();


        int count = searchIdx(x, num, ky, y);

        System.out.println("검색한 값 "+ky+"는 " +count+"개 있습니다.");
    }
}
