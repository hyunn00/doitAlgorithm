package chap01;

import java.util.Scanner;

public class SumVerbose {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        do {
            System.out.println("n의 값 : ");
            n=stdIn.nextInt();
        } while(n <= 0);

        int sum=0;

        for(int i =1; i < n ; i++) {
            System.out.print(i + "+");
            sum += i;
        }
        System.out.println(n + "=" + (sum+=n));
    }
}
