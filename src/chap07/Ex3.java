package chap07;

import java.util.Scanner;

public class Ex3 {
    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length()+1];
        int count = 0;
        int k= -1;
        int idx = 1;
        skip[pt] = 0;
        System.out.println("건너뛰기 표 작성");
        while(pt != pat.length()) {
            System.out.printf("%s %s\n", k==pt-pp ? " " : String.valueOf(pt-pp), txt);
            System.out.print(" ".repeat((pt)+2));
            k = pt-pp;

            System.out.println(txt.charAt(pt) == pat.charAt(pp) ? "+" : "|");
            System.out.print(" ".repeat((pt-pp)+2));
            System.out.println(pat);

            if(pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            }
            else if(pp == 0) {
                skip[++pt] = pp;
            }
            else {
                pp = skip[pp];
            }
            idx++;
            count++;
        }

        pt = pp = 0;
        idx = 0;
        boolean isStart=true;
        System.out.println("검색");
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
            } else if(pp == 0) {
                pt++;
                idx++;
                System.out.println("|");
                System.out.print(" ".repeat(idx+1));
                System.out.println(pat);
                isStart = true;
            }
            else {
                pp = skip[pp];
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
            return pt - pp;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Q1과 마찬가지로 KMP법을 사용하는 검색 과정을 자세히 출력하는 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scanner.next();

        System.out.print("패 턴 : ");
        String s2 = scanner.next();

        int idx = kmpMatch(s1, s2);

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
