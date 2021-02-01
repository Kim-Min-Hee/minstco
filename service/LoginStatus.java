package service;
import app.Minstco;
import vo.BuyProduct;
import vo.Member;
import vo.User;

import java.util.Scanner;

public class LoginStatus {
    private static final char[] LoginStatus= null;
    public static final String User =null;
    User consumer = null;
    Scanner scanner = new Scanner(System.in);
    public  User loginInformation(){
         return consumer;
    }

    public void login (User consumer){
        if(consumer.getGrade()=='D'){
            System.out.println("a member who has withdrawn");
            return;
        }
        System.out.println("login Ok");
        System.out.println("welcome "+"\t"+consumer.getId());
        this.consumer = consumer;
    }

    public boolean isLogin(){
        boolean check = false;
        if(this.consumer !=null){
            check = true;
        }else{
            check = false;
        }
        return check;
    }

    public void logout(){
        this.consumer=null;
    }

//    public void informationDetails(){
//            System.out.println(consumer.UserInfo());
//    }
//
//    public void editInformation(){
//        Registration registration = new Registration();
//        System.out.println("write your password");
//        String password = scanner.nextLine();
//
//        if(consumer.getPassword().equals(password)){
//            System.out.println("You can edit your information / Select the information you want to edit"+"\n"
//                    +"1. name 2. email 3. phoneNumber ");
//            int select = scanner.nextInt();
//            scanner.nextLine();
//            String name =null;
//            String email = null;
//            String phone = null;
//            switch(select){
//                case 1 :
//                    System.out.println("Please write the name to change");
//                    name = scanner.nextLine();
//                    break;
//
//                case 2 :
//
//                    int count  =0;
//                    while(count<3){
//                        System.out.println("Please write the email to change");
//                        email = scanner.nextLine();
//                        int check = 0;
//                        boolean verify = email.contains("@") && email.contains(".");
//                        if(verify){
//                            for(Member m : registration.profile){
//                                if(m.getEmail().equals(email)){
//                                    System.out.println("the email can not use");
//                                    email=null;
//                                    break;
//                                }else{
//                                    check++;
//                                }
//                                if(check == registration.profile.size()){
//                                    count=3;
//                                    System.out.println("Email address that can be used");
//                                    break;
//                                }
//                            }
//
//                        }else{
//                            System.out.println("Email format is incorrect");
//                        }
//                        count++;
//                    }
//
//                    break;
//                case 3 :
//                    System.out.println("Please write the phoneNumber to change");
//                    scanner.nextLine();
//                    String phoneNumber = scanner.nextLine();
//                    if(phoneNumber.length()<12 && phoneNumber.length()>9){
//                        phone = phoneNumber;
//                    }else{
//                        System.out.println("Cell phone number format is incorrect");
//
//                    }
//                    break;
//            }
//            for(int i=0 ; i<registration.profile.size();i++){
//                Member member = registration.profile.get(i);
//                if(consumer.getId().equals(member.getId())){
//
//                    if(name != null){
//                        Member member1 = new Member(member.getId(),member.getPassword(),name,member.getEmail(),member.getPhoneNumber(),
//                                member.getGender(),member.getGrade(),member.getDiscountRate(),member.getTotal(),member.getDiscount());
//                        registration.profile.add(member1);
//                        registration.profile.remove(member);
//                            break;
//                    }else if(email != null){
//                        Member member1 = new Member(member.getId(),member.getPassword(),member.getName(),email,member.getPhoneNumber(),
//                                member.getGender(),member.getGrade(),member.getDiscountRate(),member.getTotal(),member.getDiscount());
//                        registration.profile.add(member1);
//                        registration.profile.remove(member);
//                        break;
//                    }else if(phone != null){
//                        Member member1 = new Member(member.getId(),member.getPassword(),member.getName(),member.getEmail(),phone,
//                                member.getGender(),member.getGrade(),member.getDiscountRate(),member.getTotal(),member.getDiscount());
//                        registration.profile.add(member1);
//                        registration.profile.remove(member);
//                        break;
//                    }
//
//                }
//            }
//        }else {
//            System.out.println("Passwords do not match");
//        }
//
//
//
//    }
//    public void MembershipWithdrawal(){
//        System.out.println("write your ID");
//        String id = scanner.nextLine();
//        System.out.println("write your PASSWORD");
//        String password = scanner.nextLine();
//        if(id.equals(consumer.getId()) && password.equals(consumer.getPassword())){
//            String userid = consumer.getId();
//            String userPassword = consumer.getPassword();
//            String userName = consumer.getName();
//            String userEmail = consumer.getEmail();
//            String userPhoneNumber = consumer.getPhoneNumber();
//            String userGender = consumer.getGender();
//            char userGrade = 'D';
//            double userDiscountRate=0;
//            int  userTotal = consumer.getTotal();
//            int userDiscount = consumer.getDiscount();
//            Member withdrawal = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userDiscountRate,
//                    userTotal,userDiscount);
//
//            System.out.println(consumer.getId()+" Thank you for using it so far");
//            logout();
//
//        }
//    }



}
