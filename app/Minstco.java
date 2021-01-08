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
        LoginStatus login = new LoginStatus();

        while (true) {
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
                    System.out.println("This is the login screen");
                    System.out.println("write your ID");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    System.out.println("write your password");
                    String password = scanner.nextLine();
                    int result = 0;
                    int result1 = 0;
                    for (Member m : registration.profile) {
                        if (m.getId().equals(id)) {
                            if (m.getPassword().equals(password)) {
                                System.out.println("login OK");
                                String userid = m.getId();
                                String userPassword = m.getPassword();
                                String userName = m.getName();
                                String userEmail = m.getEmail();
                                String userPhoneNumber = m.getPhoneNumber();
                                String userGender = m.getGender();
                                char userGrade = m.getGrade();
                                int userTotal = m.getTotal();
                                User user = new User(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal);
                                login.loginInsert(user);
                                return;
                            } else {
                                result++;
                            }
                        } else {
                            result1++;
                        }
                    }
                    if (result < registration.profile.size()) {
                        registration.reLogin(1, id);
                    } else if (result1 < registration.profile.size()) {
                        registration.reLogin(2, id);
                    }
                            break;
            }
        }

    }
    public void login(String id){
        //LoginStatus loginStatus = new LoginStatus();
        Scanner scanner = new Scanner(System.in);
        if(id.equals("admin")){
            System.out.println("admin !!!!!!");
        }else {
            System.out.println("choose 1. My information management 2. Product Inquiry 3. Purchase of products 4. logout");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("choose 1. View my information details 2. Edit my information 3. Membership withdrawal 4. logout");
                    int number = scanner.nextInt();
                    if (number == 1) {
                        //loginStatus.informationDetails();
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
