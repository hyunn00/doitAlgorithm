package chap01;

public class Ex4_5 {
    static int med3 (int a, int b, int c) {
        if (a >= b)
            if(b >= c) return b;
            else if(a <= c) return a;
            else return c;
        else if(a > c)
            return a;
        else if (b > c) return c;
        else return b;
    }

    static int med3_other (int a, int b, int c) {
        if((b >= a && c <= a) || (b <= a && c >= a))
            return a;
        else if ((a > b && c < b) || (a < b && c > b))
            return b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println("세 값의 대소 관계 13 종류의 모든 조합에 대해 중앙값을 구하여 출력하는 프로그램을 작성하세요.");
        System.out.println(med3(3, 2, 1));
        System.out.println(med3(3, 2, 2));
        System.out.println(med3(3, 1, 2));
        System.out.println(med3(3, 2, 3));
        System.out.println(med3(2, 1, 3));
        System.out.println(med3(3, 3, 2));
        System.out.println(med3(3, 3, 3));
        System.out.println(med3(2, 2, 3));
        System.out.println(med3(2, 3, 1));
        System.out.println(med3(2, 3, 2));
        System.out.println(med3(1, 3, 2));
        System.out.println(med3(2, 3, 3));
        System.out.println(med3(1, 2, 3));

        System.out.println("중앙값을 구하는 메서드는 다음과 같이 작성할 수도 있다." +
                "그러나 med3 메서드에 비해 효율이 떨어지는데, 그 이유를 설명하세요.");
        System.out.println("처음 if문의 판단 if((b >= a && c <= a) || (b <= a && c >= a))에 주목" +
                "여기서 b>=a 및 b<=a의 판단을 뒤집은 판단(실직적으로 동일한 판단)이," +
                "계속하여 else 이후에서else if ((a > b && c < b) || (a < b && c > b))ㄹ 수행" +
                "즉, 처음 if가 성립하지 않은 경우 2번째 if에서도 (실질적으로) 같은 판단을 수행하므로, 효율이 나빠짐");

    }
}
