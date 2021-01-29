package service;

import app.Minstco;
import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import vo.BuyProduct;
import vo.Member;
import vo.Product;
import vo.User;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    private static final char[] Registration = null;
    private static final String Member = null;
    public ArrayList<Member> profile = new ArrayList<Member>();
    Scanner scanner = new Scanner(System.in);
    LoginStatus loginUser = new LoginStatus();
    //Merchandise merchandise = new Merchandise();
    public Registration() {
        Member m1 = new Member("xldkah", "minhee", "kim-min-hee", "xldkah2415@naver.com", "01012342415",
                "F", 'A',0.1, 100000,0);
        Member m2 = new Member("manju", "hyungtaek", "ryu-hyung-taek", "xldkah4548@hanmail.net", "01045672812",
                "M", 'C',0.03, 0,0);
        Member m3 = new Member("q","q","q","xldkah@naver.com","11111111111",
                "F",'B',0.05,0,0);
        Member m4 = new Member("admin","admin","admin","admin@google.com","1234567890","F",
                'A',0.1,100000,0);
        profile.add(m1);
        profile.add(m2);
        profile.add(m3);
        profile.add(m4);
    }


    public void productPurchaseRecord(String id,int total, double discountedAmount) {
            for(int i=0 ; i<profile.size();i++){
                Member member = profile.get(i);

                if(member.getId().equals(id)){
                    String password = member.getPassword();
                    String name = member.getName();
                    String email = member.getEmail();
                    String phone = member.getPhoneNumber();
                    String gender = member.getGender();
                    char grade = member.getGrade();
                    double discountRate = member.getDiscountRate();
                    int sum = member.getTotal() + total;
                    int discount = (int) (member.getDiscount() + discountedAmount);
                    if(sum>=500000 && grade != 'A'){
                        grade='A';
                        System.out.println("Membership level has been changed"+"\n"+member.getGrade()+"->"+grade);
                    }else if(sum >300000 && sum<500000 && grade != 'B'){
                        grade = 'B';
                        System.out.println("Membership level has been changed"+"\n"+member.getGrade()+"->"+grade);
                    }

                    Member member1 = new Member(id, password, name, email, phone, gender, grade,discountRate, sum, discount);
                    profile.add(member1);
                    profile.remove(member);

                    System.out.println("Thank you for using");
                    break;
                }

            }

        }

    public void insertMember() {
        System.out.println("please enter id to use");
        String id = scanner.nextLine();
        for(Member member : profile){
            if(id.equals(member.getId())){
                for(int i = 0; i<3 ;){
                    System.out.println("enter another ID");
                    id= scanner.nextLine();
                    if(id.equals(member.getId())){
                        if(i==2){
                            System.out.println("Membership not allowed");
                            return;
                        }
                        i++;

                    }else{
                        i=3;
                        break;
                    }
                }
            }
        }
        System.out.println("enter password to use");
        String password=scanner.nextLine();

        System.out.println("enter your name");
        String name =scanner.nextLine();

        String email = null;

        int count  =0;
        for(int y=0; y<3 ; ){
            System.out.println("enter your email");
            email = scanner.nextLine();
            boolean verify = email.contains("@") && email.contains(".");
            if(!verify){
                System.out.println("Email format is not correct");
                if(y==2){
                    System.out.println("This email is already in use"+"\t"+"Go back to the beginning");
                    return;
                }
                y++;
            }else{
                for(Member member : profile){
                    if(member.getEmail().equals(email)){
                        System.out.println("This email is already in use");
                        if(y==2){
                            System.out.println("This email is already in use"+"\t"+"Go back to the beginning");
                            return;
                        }
                        y++;
                    }else{
                        count++;
                    }
                    if(count==profile.size()){
                        y=3;
                        System.out.println("you can use the email");
                        break;
                    }
                }
            }
        }
        String phoneNumber=null;
        for(int a=0; a<3; ){
            System.out.println("enter phoneNumber to use");
            phoneNumber=scanner.nextLine();
            if(phoneNumber.length()<10 || phoneNumber.length()>=12){
                System.out.println("The length of the mobile phone number is not correct");
                if(a==2){
                    System.out.println("check your phoneNumber");
                    return;
                }
                a++;
            }else {
                a=3;
                break;
            }
        }

        System.out.println("write woman or  man" +"\t"+ "If it’s a man, M " +"\t"+
                "If it's a woman, F");
        String gender = scanner.nextLine();
        gender = gender.toUpperCase();

        Member member = new Member(id,password,name,email,phoneNumber,gender,'C',0.03,0,0);
        profile.add(member);


    }
    public void selectMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select  1. Member Select All 2. Select by Member Level 3. Search by  ID "+"\n"+
                "4. Search by  email 5. Search by  phone number");
        int select = scanner.nextInt();

        if(select==1){
            System.out.println("show member list");
            for(int i = 0;i<profile.size();i++){
                System.out.println(profile.get(i).getInfo());
            }

        }else if(select==2){
            System.out.println("Which level do you want to search"+"\t"+"1. A 2. B 3. C 4. D");
            int choose = scanner.nextInt();
            char grade;

            if(choose==1){
                grade ='A';
            }else if(choose==2){
                grade = 'B';
            }else if(choose==3){
                grade = 'C';
            }else{
                grade='D';
            }

            for(Member m : profile){
                if(m.getGrade()==grade){
                    System.out.println(m.getInfo());
                }
            }

        }else if(select==3){
            System.out.println("Please enter the ID you want to search");
            scanner.nextLine();
            String id = scanner.nextLine();

            for(Member m : profile){
                if (m.getId().contains(id)) {
                    System.out.println(m.getInfo());
                }
            }
        }else if(select==4){
            System.out.println("enter the Email you want to search");
            scanner.nextLine();
            String email = scanner.nextLine();

            for(Member m : profile){
                if(m.getEmail().contains(email)){
                    System.out.println(m.getEmail());
                }
            }

        }else if(select==5){
            System.out.println("enter the phoneNumber you want to search");
            scanner.nextLine();
            String number = scanner.nextLine();
            for(Member m: profile){
                if(m.getPhoneNumber().equals(number)){
                    System.out.println(m.getInfo());
                }
            }
        }else{
            System.out.println("Wrong number");
        }
    }

    public void informationModification(String editId, String adminPassword){
        for(int i=0;i<profile.size();i++){
            Member m = profile.get(i);

            if(m.getId().equals(editId)){
                System.out.println("write your password");
                String password = scanner.nextLine();

                if(password.equals(adminPassword)){
                    System.out.println("Write down the grade you want to change");
                    String y = scanner.nextLine();

                    char grade = y.charAt(0);
                    Member member = new Member(m.getId(),m.getPassword(),m.getName(),m.getEmail(),m.getPhoneNumber(),m.getGender(),grade,m.getDiscountRate(),
                            m.getTotal(),m.getDiscount());
                    profile.add(member);
                    profile.remove(m);
                }
                break;
            }
        }
    }

    public void salesManagement() {
        System.out.println("Select  1.Total sales amount 2. Total amount of discount 3. Grade discount rate adjustment");
        int choose = scanner.nextInt();

        int total = 0;
        int discount = 0;
        double rateA = 0;
        double rateB = 0;
        double rateC = 0;

        for (Member member : profile) {
            total += member.getTotal();
            discount += member.getDiscount();

            if (member.getGrade() == 'A') {
                rateA = member.getDiscountRate();
            } else if (member.getGrade() == 'B') {
                rateB = member.getDiscountRate();
            } else if (member.getGrade() == 'C') {
                rateC = member.getDiscountRate();
            }
        }

        switch (choose) {
            case 1:
                System.out.println("Total  : " + total);
                break;

            case 2:
                System.out.println("Discount : " + discount);
                break;

            case 3:
                int count=0;
                System.out.println("Current Class A discount rate : " + rateA +"\n"+
                        "Current Class B discount rate : "+rateB +"\n"+ "Current Class C discount rate : "+rateC);
                System.out.println("write in the order of discount rate to change from A to C");

                while(count<=3){
                    double changeA =0;
                    double changeB =0;
                    double changeC =0;
                    double change =0;
                    char grade = 0;

                   if(count==0){
                       changeA = scanner.nextDouble();

                           grade = 'A';
                           change = changeA;

                   }else if(count ==1){
                       changeB = scanner.nextDouble();

                       if(changeA>changeB){
                           grade ='B';
                           change = changeB;
                       }else{
                           count=3;
                       }

                   }else if(count==2){
                       changeC = scanner.nextDouble();

                       if(changeC <changeB && changeC < changeA){
                           grade='C';
                           change= changeC;
                       }else{
                           count=3;
                       }
                   }

                   for(int i=0; i<profile.size();i++){
                       Member member = profile.get(i);
                       if(member.getGrade()==grade){
                           Member member1 = new Member(member.getId(), member.getPassword(), member.getName(), member.getEmail(), member.getPhoneNumber()
                                    , member.getGender(), member.getGrade(), change, member.getTotal(), member.getDiscount());
                       }
                   }
                   if(count==3){
                       System.out.println("It is not possible to set the discount rate because the discount rate is lower than the lower rate discount rate");
                       return;
                   }
                   count++;

                }
        }
    }

    public void tryLogin(String id, String password) {
        int passwordError=0;
        int idError = 0;

        for(Member member : profile){

            if(id.equals(member.getId())){
                if(! password.equals(member.getPassword())){
                    passwordError++;
                }
            }else {
                idError++;
            }

        }
        if(idError==profile.size()){
            System.out.println("ID is wrong");

            realignment("id",password);
        }
        if(passwordError<profile.size()){
            System.out.println("password is wrong");

            realignment("password",id);
        }
    }
        public void realignment(String error, String information){

            if(error.equals("id")){
                System.out.println("1. Find ID 2. Back to the beginning");
                int number  = scanner.nextInt();
                    switch (number){
                        case 1 :
                        System.out.println("write your name");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("write your email");
                        String email = scanner.nextLine();
                            for(Member member : profile){
                                if(member.getName().equals(name) && member.getEmail().equals(email) && member.getPassword().equals(information)){
                                    System.out.println("your id : "+member.getId());
                                }
                            }
                            break;
                        case 2 :
                            break;
                        default :
                            System.out.println("You made the wrong choice");
                    }
        }else if(error.equals("password")){

            System.out.println("choose 1.Re-enter 2. Reset");
            int choose = scanner.nextInt();

            switch (choose){
                case 1 :
                    int i=0;
                    while (i<3){
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("re-enter password");
                        String password = scanner.nextLine();
                        int number =0;
                        for(Member member : profile){
                            if(member.getPassword().equals(password) && member.getId().equals(information)){
                                i=2;
                                System.out.println("password is correct");
                                return;
                            }else{
                                number++;
                            }
                            if(number==profile.size()){
                                i++;
                                System.out.println("password is not correct");
                            }
                        }
                    }
                case 2 :
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("reset your password"+"\n"+"write your ID");
                    String id = scanner.nextLine();
                    System.out.println("write your email");
                    String email= scanner.nextLine();
                    System.out.println("write your gender F or M");
                    String gender = scanner.nextLine();
                    gender = gender.toUpperCase();

                    int count = 0;
                    for(int y=0; y<profile.size();y++){
                        Member member = profile.get(y);

                        if(member.getId().equals(id) && information.equals(id) && member.getEmail().equals(email) && member.getGender().equals(gender)){
                            System.out.println("you can change password");
                            String password =scanner.nextLine();
                            System.out.println("re-enter password");
                            String rePassword = scanner.nextLine();

                            if(password.equals(rePassword)){
                                System.out.println("Password has been changed");

                                Member member1 = new Member(id,password, member.getName(), email,member.getPhoneNumber(),gender,member.getGrade(),
                                        member.getDiscountRate(),member.getTotal(),member.getDiscount());

                                profile.add(member1);
                                profile.remove(member);
                                break;
                            }

                        }else{
                           count++;
                        }
                        if(count == profile.size()){
                            System.out.println("It is difficult to change the password because the information does not match");
                        }
                    }

            }
        }

        }


}




