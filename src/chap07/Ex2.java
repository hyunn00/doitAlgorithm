package chap07;

import java.util.Scanner;

public class Ex2 {
    static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - pat.length();
        int pp = 0;

        while(pt != 0 && pp != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp - 1;
                pp = 0;
            }
        }

        if(pp == pat.length())
            return pt-pp;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("bfMatch 메서드는 텍스트에 패턴이 여러 개 있으면 가장 앞쪽의 인덱스를 반환합니다." +
                "이를 수정하여 가장 뒤쪽의 인덱스를 반환하는 bfMatchLast 메서드를 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = scanner.next();

        System.out.print("패 턴 : ");
        String s2 = scanner.next();

        int idx = bfMatchLast(s1, s2);

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
