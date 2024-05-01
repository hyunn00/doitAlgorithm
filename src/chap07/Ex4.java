package chap07;

import java.util.Scanner;

public class Ex4 {
    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtlen = txt.length();
        int patlen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for(pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patlen;
        for(pt = 0; pt < patlen - 1; pt++)
            skip[pat.charAt(pt)] = patlen - pt - 1;

        int idx = -1;
        System.out.println("검색");
        while(pt < txtlen) {
            pp = patlen - 1;
            System.out.printf("%s %s\n", pt-pp != idx ? String.valueOf(pt-pp) : " ", txt);
            idx = pt-pp;
            System.out.print(" ".repeat(pt+2));
            System.out.println(txt.charAt(pt) == pat.charAt(pp) ? "+" : "|");
            System.out.print(" ".repeat((pt-pp)+2));
            System.out.println(pat);

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if(pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
                System.out.printf("%s %s\n", pt-pp != idx ? String.valueOf(pt-pp) : " ", txt);
                idx = pt-pp;
                System.out.print(" ".repeat(pt+2));
                System.out.println(txt.charAt(pt) == pat.charAt(pp) ? "+" : "|");
                System.out.print(" ".repeat((pt-pp)+2));
                System.out.println(pat);
            }
            pt += (skip[txt.charAt(pt)] > patlen - pp) ? skip[txt.charAt(pt)] : patlen - pp;


        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Q1과 같이 보이어.무어법을 사용하는 검색 과정을 자세히 출력하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scanner.next();

        System.out.print("패  턴 : ");
        String s2 = scanner.next();

        int idx = bmMatch(s1, s2);

        if(idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for(int i=0; i<idx; i++)
                len += s1.substring(i, i+1).getBytes().length;
            len += s2.length();


            System.out.println((idx+1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패  턴 : %%%ds\n", len), s2);
        }
    }
}
