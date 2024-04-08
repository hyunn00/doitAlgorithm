package chap02;

import java.util.Scanner;

public class Ex8 {
    static class YMD {
        int y;
        int m;
        int d;

        //각 월의 일수
        static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };

        // year 년은 윤년인가?(윤년 : 1 / 평년 : 0)
        static int isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
        }

        YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        YMD after (int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if(n < 0) {
                return before(-n);
            }

            temp.d += n;

            while(temp.d>mdays[isLeap(temp.y)][temp.m-1]) {
                temp.d -= mdays[isLeap(temp.y)][temp.m-1];
                if(++temp.m > 12) {
                    temp.y++;
                    temp.m = 1;
                }
            }
            return temp;
        }

        YMD before(int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if(n < 0) {
                return after(-n);
            }

            temp.d -= n;

            while(temp.d<1) {
                if(--temp.m < 1) {
                    temp.y--;
                    temp.m = 12;
                }
                temp.d += mdays[isLeap(temp.y)][temp.m -1];
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("오른쪽처럼 년원일을 필드로 갖는 클래스를 만드세요." +
                "다음과 같이 생성자(constructor)와 생성자를 정의해야 함");

        Scanner scanner = new Scanner(System.in);

        System.out.print("년을 입력 : ");
        int y = scanner.nextInt();
        System.out.print("월을 입력 : ");
        int m = scanner.nextInt();
        System.out.print("일을 입력 : ");
        int d = scanner.nextInt();

        YMD x = new YMD(y, m, d);

        System.out.print("며칠 전/후의 날짜? : ");
        int n = scanner.nextInt();

        YMD beforeX = x.before(n);
        System.out.printf("n일 전 : %d-%d-%d\n", beforeX.y, beforeX.m, beforeX.d);
        YMD afterX = x.after(n);
        System.out.printf("n일 후 : %d-%d-%d\n", afterX.y, afterX.m, afterX.d);
    }
}
