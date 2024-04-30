package chap07;

import java.util.Scanner;

public class Ex1 {
    static int bfMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;

        int idx = 0;
        boolean isStart=true;
        int count = 0;
        while(pt != txt.length() && pp != pat.length()) {
            System.out.printf("%s %s\n", isStart ? String.valueOf(idx) : " ", txt);
            System.out.print(" ".repeat(pt+2));
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
                System.out.println("+");
                System.out.print(" ".repeat(idx+2));
                System.out.println(pat);
                isStart = false;
            } else {
                pt = pt - pp + 1;
                pp = 0;
                idx++;
                System.out.println("|");
                System.out.print(" ".repeat(idx+1));
                System.out.println(pat);
                isStart = true;
            }
            count++;
        }
        System.out.printf("비교를 %d회 했습니다.\n", count);

        if(pp == pat.length())
            return pt-pp;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("오른쪽처럼 브루트-포스법의 검색 과정을 자세히 출력하는 프로그램을 작성하세요." +
                "패턴을 옮길 때마다 검사하는 텍스트의 첫 번째 문자 인덱스를 출력하고, 검사 과정에서 비교하는 두 문자가 일치하면 +를, 다르면 |를 출력하세요." +
                "마지막에 비교한 횟수를 출력하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scanner.next();

        System.out.print("패 턴 : ");
        String s2 = scanner.next();

        int idx = bfMatch(s1, s2);

        if(idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for(int i=0; i<idx; i++)
                len += s1.substring(i, i+1).getBytes().length;
            len += s2.length();


            System.out.println((idx+1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패 턴 : %%%ds\n", len), s2);
        }
    }
}
