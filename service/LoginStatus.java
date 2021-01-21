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

    public void productPurchaseRecord(int total, double discountedAmount, int pay){
        String id= loginInformation().getId();
        String password = loginInformation().getPassword();
        String name = loginInformation().getName();
        String email = loginInformation().getEmail();
        String phone =loginInformation().getPhoneNumber();
        String gender = loginInformation().getGender();
        char grade = loginInformation().getGrade();
        int sum = loginInformation().getTotal()+total;
        double discount = loginInformation().getDiscount()+discountedAmount;
        consumer.setTotal(sum);
        consumer.setDiscount(discount);

    }

    public void logout(){
        consumer=null;
        System.out.println(consumer);
    }

    public void ProductCalculation(){
        double purchase=0;
        if(consumer.getGrade()=='A'){
            purchase = 0.1;
        }else if(consumer.getGrade()=='B'){
            purchase = 0.05;
        }else {
            purchase = 0.03;
        }
        System.out.println("discount : "+purchase);

    }


    public void informationDetails(){
            System.out.println(consumer.UserInfo());

    }

    public void editInformation(){

        System.out.println("write your password");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        Registration registration = new Registration();
        if(consumer.getPassword().equals(password)){
            System.out.println("You can edit your information / Select the information you want to edit"+"\n"
                    +"1. name 2. email 3. phoneNumber ");
            int select = scanner.nextInt();
            switch(select){
                case 1 :
                    System.out.println("Please write the name to change");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    consumer.setName(name);
                    String userid = consumer.getId();
                    String userPassword = consumer.getPassword();
                    String userName = name;
                    String userEmail = consumer.getEmail();
                    String userPhoneNumber = consumer.getPhoneNumber();
                    String userGender = consumer.getGender();
                    char userGrade = consumer.getGrade();
                    int userTotal = consumer.getTotal();
                    double userDiscount = consumer.getDiscount();
                    Member nameChange = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal,userDiscount);
                    System.out.println(consumer.UserInfo());
                    break;
                case 2 :
                    System.out.println("Please write the email to change");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    boolean verify = email.contains("@") && email.contains(".");
                    int check = 0;
                    if(verify){
                        for(Member m : registration.profile){
                            if(m.getEmail().equals(email)){
                                System.out.println("the email can not use");
                            }else{
                                check++;
                            }
                            if(check == registration.profile.size()){
                                System.out.println("Email address that can be used");
                                consumer.setEmail(email);
                                userid = consumer.getId();
                                 userPassword = consumer.getPassword();
                                 userName = consumer.getName();
                                 userEmail = email;
                                 userPhoneNumber = consumer.getPhoneNumber();
                                 userGender = consumer.getGender();
                                 userGrade = consumer.getGrade();
                                 userTotal = consumer.getTotal();
                                 userDiscount = consumer.getDiscount();
                                Member emailChange = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal,userDiscount);
                                System.out.println(consumer.UserInfo());
                            }
                        }

                    }else{
                        System.out.println("Email format is incorrect");
                    }
                    break;
                case 3 :
                    System.out.println("Please write the phoneNumber to change");
                    scanner.nextLine();
                    String phoneNumber = scanner.nextLine();
                    if(phoneNumber.length()<12 && phoneNumber.length()>9){
                        consumer.setPhoneNumber(phoneNumber);
                        userid = consumer.getId();
                        userPassword = consumer.getPassword();
                        userName = consumer.getName();
                        userEmail = consumer.getEmail();
                        userPhoneNumber = phoneNumber;
                        userGender = consumer.getGender();
                        userGrade = consumer.getGrade();
                        userTotal = consumer.getTotal();
                        userDiscount = consumer.getDiscount();
                        Member phoneNumberChange = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal,userDiscount);

                        System.out.println(consumer.UserInfo());
                    }else{
                        System.out.println("Cell phone number format is incorrect");
                    }



            }
        }else {
            System.out.println("Passwords do not match");
        }

    }
    public void MembershipWithdrawal(){
        System.out.println("write your ID");
        String id = scanner.nextLine();
        System.out.println("write your PASSWORD");
        String password = scanner.nextLine();
        if(id.equals(consumer.getId()) && password.equals(consumer.getPassword())){
            consumer.setGrade('D');
            String userid = consumer.getId();
            String userPassword = consumer.getPassword();
            String userName = consumer.getName();
            String userEmail = consumer.getEmail();
            String userPhoneNumber = consumer.getPhoneNumber();
            String userGender = consumer.getGender();
            char userGrade = 'D';
            int  userTotal = consumer.getTotal();
            double userDiscount = consumer.getDiscount();
            Member withdrawal = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal,userDiscount);
            System.out.println(consumer.getId()+" Thank you for using it so far");
            logout();

        }
    }



}
