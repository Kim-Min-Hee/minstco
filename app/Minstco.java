package app;

import service.LoginStatus;
import service.Registration;
import vo.Member;
import vo.LoginUser;
import vo.Product;

import java.util.Scanner;

public class Minstco {
    public static void main(String[] args){
        Registration registration = new Registration();
        LoginStatus loginStatus = new LoginStatus();


        while(true){
            System.out.println("choose number "+"\n"+"1. registration 2. login 3. memberList 4. logout");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            switch(choose){
                case 1 :
                    System.out.println("Would you like to become a member?"+"\t"+"1. Yes 2. No");
                    int extra = scanner.nextInt();
                    if(extra==1){
                        registration.insertMember();
                    }else{
                        return;
                    }
                    break;

                case 2 :
                    System.out.println("This is the login screen");
                    System.out.println("write your ID");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    System.out.println("write your password");
                    String password = scanner.nextLine();
                    int result=0;
                    int result1=0;
                    for(Member m : registration.profile){
                        if(m.getId().equals(id)){
                            if(m.getPassword().equals(password)){
                                System.out.println("login OK");
                                //LoginStatus loginStatus = new LoginStatus();
                                loginStatus.loginInsert(m.getId(),m.getPassword(),m.getName(),m.getEmail(),m.getPhoneNumber(),m.getGender(),m.getGrade(),m.getTotal());
                                return ;
                            }else {
                                result++;
                            }
                        }else {
                            result1++;
                        }
                    }
                    if(result<registration.profile.size()){
                        registration.reLogin(1,id);
                    }else if(result1<registration.profile.size()){
                        registration.reLogin(2,id);
                    }
                    break;
                case 3 :
                    registration.selectAllMember();

            }


        }

        }

    public static void login(String id, String password, String name, String email, String phoneNumber, String gender, char grade, int total) {
//        LoginStatus loginStatus = new LoginStatus();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("welcome!!"+"\n"+id);
//        if(id.equals("admin")){
//            System.out.println("");
//        }
//        System.out.println("choose 1. My information management 2. Product Inquiry 3. Purchase of products");
//        int choose = scanner.nextInt();
//        switch (choose){
//            case 1 :
//                System.out.println("choose 1. View my information details 2. Edit my information 3. Membership withdrawal");
//                int number =scanner.nextInt();
//                if(number==1){
//                    loginStatus.informationDetails();
//                }else if(number==2){
//
//                }else if(number==3){
//
//                }else{
//                    System.out.println("you are wrong");
//                }
//
//        }
   }

}
