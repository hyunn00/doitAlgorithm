package chap01;

public class Ex12 {
    public static void main(String[] args) {
        System.out.println("곱셈이 아니라 덧셈을 출력하는 프로그램을 작성하세요.");
        for(int i=-1; i<=9; i++) {
            for(int j=0; j<=9; j++) {
                if(i == -1) {
                    if(j == 0) {
                        System.out.print("   |");
                    } else {
                        System.out.printf("%3d", j);
                    }
                }
                else if(i == 0) {
                    if(j == 0) {
                        System.out.print("---+");
                    } else {
                        System.out.print("---");
                    }
                } else {
                    if(j == 0) {
                        System.out.printf("%2d |", i);
                    } else
                        System.out.printf("%3d", i + j);
                }
            }
            System.out.println();
        }
    }
}
