package chap01;

import java.util.Scanner;

public class PrintStars {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n, w;

        do {
            System.out.println("n의 값 : ");
            n = stdIn.nextInt();
        } while(n<=0);

        do {
            System.out.println("w의 값 : ");
            w = stdIn.nextInt();
        } while(w<=0);


        for(int i=0; i<n/w; i++) {
            System.out.println("*".repeat(w));
        }

        int rest = n%w;
        if(rest != 0) System.out.println("*".repeat(rest));
    }
}
