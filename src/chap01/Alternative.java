package chap01;

import java.util.Scanner;

public class Alternative {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        do {
            System.out.println("n의 값 : ");
            n = stdIn.nextInt();
        } while(n<=0);

        for(int i=1; i<=n/2; i++) {
            System.out.print("+-");
        }

        if(n%2 != 0) System.out.print("+");
    }
}
