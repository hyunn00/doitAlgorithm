package chap05;

import java.util.Scanner;

public class Ex7 {
    // no : 옮겨야 할 원반의 개수
    // x : 시작 기둥의 번호
    // y : 목표 기둥의 번호
    static String[] names = {"A 기둥", "B 기둥", "C 기둥"};
    static void move(int no, int x, int y) {
        if(no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.printf("원반[%d]을(를) %s에서 %s으로 옮김\n", no, names[x-1], names[y-1]);

        if(no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        System.out.println("실습 5-7을 숫자가 아닌 문자열로 기둥 이름을 출력하도록 수정한 프로그램을 작성하세요." +
                "예를 들어 'A 기둥', 'B 기둥', 'C 기둥'과 같이 출력하면 됩니다.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수 : ");
        int n = scanner.nextInt();

        move(n, 1, 3);
    }
}
