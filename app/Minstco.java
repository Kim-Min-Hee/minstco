package app;

import service.LoginStatus;
import service.Registration;
import vo.Member;
import vo.User;
import vo.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Minstco {
    public static void main(String[] args) {
        Registration registration = new Registration();
        LoginStatus loginUser = new LoginStatus();
        while (true) {
            System.out.println("111");
            if(!loginUser.isLogin()){
                System.out.println("choose number " + "\n" + "1. registration 2. login ");
                Scanner scanner = new Scanner(System.in);
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("Would you like to become a member?" + "\t" + "1. Yes 2. No");
                        int extra = scanner.nextInt();
                        if (extra == 1) {
                            registration.insertMember();
                        } else {
                            return;
                        }
                        break;

                    case 2:
                    registration.tryLogin();


                }

            }else {
                Scanner scanner = new Scanner(System.in);
                    System.out.println("choose 1. My information management 2. Product Inquiry 3. Purchase of products 4. logout");
                    int choose = scanner.nextInt();

                    switch (choose) {
                        case 1:
                            System.out.println("choose 1. View my information details 2. Edit my information 3. Membership withdrawal 4. logout");
                            int number = scanner.nextInt();

                            if (number == 1) {
                                loginUser.informationDetails();
                            } else if (number == 2) {

                            } else if (number == 3) {

                            } else {
                                System.out.println("you are wrong");
                            }
                            break;
                        case 2 :


                        case 3 :

                        case 4 :
                            System.out.println("You are logged out");
                            //loginStatus.logout();
                            break;

                    }

            }




        }

    }

}
