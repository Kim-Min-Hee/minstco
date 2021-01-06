package app;

import service.Registration;
import vo.Member;

import java.util.Scanner;

public class Minstco {

    public static void main(String[] args){
        Registration registration = new Registration();
        boolean check = true;

        System.out.println("choose number "+"\n"+"1. registration 2. login 3. logout");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch(choose){
            case 1 :
                System.out.println("Would you like to become a member?"+"\t"+"1. Yes 2. No");
                scanner.nextLine();
                int extra = scanner.nextInt();
                if(extra==1){
                    registration.insertMember();
                }else{
                    return;
                }
                break;

            case 2 :
                registration.loginMember();

        }

    }
}
