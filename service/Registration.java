package service;

import app.Minstco;
import vo.BuyProduct;
import vo.Member;
import vo.Product;
import vo.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Registration {
    private static final char[] Registration = null;
    private static final String Member = null;
    public ArrayList<Member> profile = new ArrayList<Member>();
    Scanner scanner = new Scanner(System.in);
    LoginStatus loginUser = new LoginStatus();

    public Registration() {
        Member m1 = new Member("xldkah", "minhee", "kim-min-hee", "xldkah2415@naver.com", "01012342415",
                "F", 'A',  0.1,100000, 0);
        Member m2 = new Member("manju", "hyungtaek", "ryu-hyung-taek", "xldkah4548@hanmail.net", "01045672812",
                "M", 'C',  0.03,0, 0);
        Member m3 = new Member("q", "q", "q", "xldkah@naver.com", "11111111111",
                "F", 'B', 0.05, 0, 0);
        Member m4 = new Member("admin", "admin", "admin", "admin@google.com", "1234567890", "F",
                'A', 0.1, 100000, 0);


        profile.add(m1);
        profile.add(m1);
        profile.add(m2);
        profile.add(m3);
        profile.add(m4);
    }

//    private static double discountRate(ArrayList<Member>profile){
//        double rate = 0;
//        for(int i=0; i<profile.size();i++){
//            Member member= profile.get(i);
//            if(member.getGrade() =='A'){
//                rate = 0.2;
//            }else if(member.getGrade() =='B'){
//                rate = 0.06;
//            }else if(member.getGrade() =='C'){
//                rate =0.04;
//            }else{
//                rate =0;
//            }
//        }
//        return rate;
//
//    }


    public void insertMember() {
        String id = null;
        String password = null;
        String name = null;
        String email = null;
        String phoneNumber = null;
        String gender = null;
        char grade = 0;
        for(int i=0; i<7 ;){
            boolean check = false;
            switch (i){
                case 1 :
                System.out.println("write id to use");
                id = scanner.nextLine();
                if(id.length()>5 && id.length()<20){
                    check = true;
                }
                break;
                case 2 :
                System.out.println("write password to use");
                password = scanner.nextLine();

                break;

            }
            if(check = true){
                Member member = new Member(id,password,name , email, phoneNumber , gender , grade , 0.03 , 0,0);
                i++;
            }
        }













//        String id = null;
//        int i = 0;
//
//        System.out.println("please enter id to use");
//        while (i < 3) {
//            id = scanner.nextLine();
//            int userId = 0;
//            for (Member member : profile) {
//                if (member.getId().equals(id)) {
//                    if (i == 2) {
//                        System.out.println("you can not join ");
//                        return;
//                    }
//                    System.out.println("enter another Id");
//                    break;
//                } else {
//                    userId++;
//                }
//                if (userId == profile.size()) {
//                    System.out.println("you can use the ID");
//                    i = 2;
//                    break;
//                }
//            }
//            i++;
//        }
//        System.out.println("enter password to use");
//        String password = scanner.nextLine();
//
//        System.out.println("enter your name");
//        String name = scanner.nextLine();
//        String pattern = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$";
//        boolean result = Pattern.matches(pattern, name);
//        if (result == false) {
//            System.out.println("Special characters cannot be entered in the name");
//            return;
//        }
//
//
//        String email = null;
//        for (int y = 0; y < 3; ) {
//            System.out.println("enter your email");
//            email = scanner.nextLine();
//            boolean verify = email.contains("@") && email.contains(".");
//            if (!verify) {
//                System.out.println("Email format is not correct");
//
//            } else {
//                int count = 0;
//                for (Member member : profile) {
//                    if (member.getEmail().equals(email)) {
//                        System.out.println("This email is already in use");
//                        break;
//
//                    } else {
//                        count++;
//                    }
//                    if (count == profile.size()) {
//                        y = 3;
//                        System.out.println("you can use the email");
//                        break;
//                    }
//                }
//            }
//            if (y == 2) {
//                System.out.println("you can not join");
//                return;
//            }
//            y++;
//        }
//        String phoneNumber = null;
//        for (int a = 0; a < 3; ) {
//            System.out.println("enter phoneNumber to use");
//            phoneNumber = scanner.nextLine();
//            if (phoneNumber.length() < 10 || phoneNumber.length() >= 12) {
//                System.out.println("The length of the mobile phone number is not correct");
//                if (a == 2) {
//                    System.out.println("check your phoneNumber");
//                    return;
//                }
//                a++;
//            } else {
//                a = 3;
//                break;
//            }
//        }
//
//        System.out.println("write woman or  man" + "\t" + "If it’s a man, M " + "\t" +
//                "If it's a woman, F");
//        String gender = scanner.nextLine();
//        gender = gender.toUpperCase();
//
//
//        Member member = new Member(id, password, name, email, phoneNumber, gender, 'C', 0.03, 0, 0);
//        profile.add(member);


    }

    public void selectMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select  1. Member Select All 2. Select by Member Level 3. Search by  ID " + "\n" +
                "4. Search by  email 5. Search by  phone number");
        int select = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        if (select == 1) {
            System.out.println("show member list");
            for (Member member : profile) {
                System.out.println(member.getInfo());
            }

        } else if (select == 2) {
            System.out.println("Which level do you want to search" + "\t" + "1. A 2. B 3. C 4. D");
            String choose = scanner.nextLine();
            choose = choose.toUpperCase();
            char grade = 0;

            if (choose.equals("1") || choose.equals("A")) {
                grade = 'A';
            } else if (choose.equals("2") || choose.equals("B")) {
                grade = 'B';
            } else if (choose.equals("3") || choose.equals("C")) {
                grade = 'C';
            } else if (choose.equals("4") || choose.equals("D")) {
                grade = 'D';
            } else {
                System.out.println("That level doesn't exist");
            }

            for (Member m : profile) {
                if (m.getGrade() == grade) {
                    System.out.println(m.getInfo());
                    break;
                }
            }

        } else if (select == 3) {
            System.out.println("Please enter the ID you want to search");
            String id = scanner.nextLine();

            for (Member m : profile) {
                if (m.getId().contains(id)) {
                    System.out.println(m.getInfo());
                } else {
                    count++;
                }
            }
        } else if (select == 4) {
            System.out.println("enter the Email you want to search");
            String email = scanner.nextLine();

            for (Member m : profile) {
                if (m.getEmail().contains(email)) {
                    System.out.println(m.getInfo());
                } else {
                    count++;
                }
            }

        } else if (select == 5) {
            System.out.println("enter the phoneNumber you want to search");
            String number = scanner.nextLine();
            for (Member m : profile) {
                if (m.getPhoneNumber().equals(number)) {
                    System.out.println(m.getInfo());
                } else {
                    count++;
                }
            }
        } else {
            System.out.println("Wrong number");
        }
        if (count == profile.size()) {
            System.out.println("The information you entered does not exist");
        }
    }

    public void tryLogin(String id, String password) {
        int passwordError = 0;
        int idError = 0;

        for (Member member : profile) {

            if (id.equals(member.getId())) {
                if (!password.equals(member.getPassword())) {
                    passwordError++;
                }
            } else {
                idError++;
            }

        }
        if (idError == profile.size()) {
            System.out.println("ID is wrong");

            realignment("id", password);
        }
        if (passwordError < profile.size()) {
            System.out.println("password is wrong");

            realignment("password", id);
        }
    }

    public void realignment(String error, String information) {

        if (error.equals("id")) {
            System.out.println("1. Find ID 2. Back to the beginning");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("write your name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("write your email");
                    String email = scanner.nextLine();
                    for (Member member : profile) {
                        if (member.getName().equals(name) && member.getEmail().equals(email) && member.getPassword().equals(information)) {
                            System.out.println("your id : " + member.getId());
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("You made the wrong choice");
            }
        } else if (error.equals("password")) {

            System.out.println("choose 1.Re-enter 2. Reset");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    int i = 0;
                    while (i < 3) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("re-enter password");
                        String password = scanner.nextLine();
                        int number = 0;
                        for (Member member : profile) {
                            if (member.getPassword().equals(password) && member.getId().equals(information)) {
                                i = 2;
                                System.out.println("password is correct");
                                return;
                            } else {
                                number++;
                            }
                            if (number == profile.size()) {
                                i++;
                                System.out.println("password is not correct");
                            }
                        }
                    }
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("reset your password" + "\n" + "write your ID");
                    String id = scanner.nextLine();
                    System.out.println("write your email");
                    String email = scanner.nextLine();
                    System.out.println("write your gender F or M");
                    String gender = scanner.nextLine();
                    gender = gender.toUpperCase();

                    int count = 0;
                    for (int y = 0; y < profile.size(); y++) {
                        Member member = profile.get(y);

                        if (member.getId().equals(id) && information.equals(id) && member.getEmail().equals(email) && member.getGender().equals(gender)) {
                            System.out.println("you can change password");
                            String password = scanner.nextLine();
                            System.out.println("re-enter password");
                            String rePassword = scanner.nextLine();

                            if (password.equals(rePassword)) {
                                System.out.println("Password has been changed");

                                Member member1 = new Member(id, password, member.getName(), email, member.getPhoneNumber(), gender, member.getGrade(),
                                        member.getDiscountRate(), member.getTotal(), member.getDiscount());

                                profile.add(member1);
                                profile.remove(member);
                                break;
                            }

                        } else {
                            count++;
                        }
                        if (count == profile.size()) {
                            System.out.println("It is difficult to change the password because the information does not match");
                        }
                    }

            }
        }

    }

    public void consumerInformationDetails(String consumerId, String consumerPassword) {
        for (Member member : profile) {
            if (member.getId().equals(consumerId) && member.getPassword().equals(consumerPassword)) {
                System.out.println(member.getInfo());
                break;
            }
        }
    }

    public void editConsumerInformation(String consumerId) {

        System.out.println("You can edit your information / Select the information you want to edit" + "\n"
                + "1. name 2. email 3. phoneNumber ");
        int select = scanner.nextInt();

        String name = null;
        String email = null;
        String phone = null;
        switch (select) {
            case 1:
                String pattern = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$";
                System.out.println("Please write the name to change");
                scanner.nextLine();
                name = scanner.nextLine();
                boolean result = Pattern.matches(pattern, name);
                if (result != true) {
                    System.out.println("Special characters cannot be entered in the name");
                    name = null;
                }
                break;

            case 2:

                int count = 0;
                scanner.nextLine();
                while (count < 3) {
                    System.out.println("Please write the email to change");
                    email = scanner.nextLine();
                    int check = 0;
                    boolean verify = email.contains("@") && email.contains(".");
                    if (verify) {
                        for (Member m : profile) {
                            if (m.getEmail().equals(email)) {
                                System.out.println("the email can not use");
                                email = null;
                                break;
                            } else {
                                check++;
                            }
                            if (check == profile.size()) {
                                count = 3;
                                System.out.println("Email address that can be used");
                                break;
                            }
                        }

                    } else {
                        System.out.println("Email format is incorrect");
                    }
                    count++;
                }

                break;
            case 3:
                System.out.println("Please write the phoneNumber to change");
                scanner.nextLine();
                String phoneNumber = scanner.nextLine();
                if (phoneNumber.length() < 12 && phoneNumber.length() > 9) {
                    phone = phoneNumber;

                } else {
                    System.out.println("Cell phone number format is incorrect");

                }
                break;
        }
        for (int i = 0; i < profile.size(); i++) {
            Member member = profile.get(i);
            if (consumerId.equals(member.getId())) {

                if (name != null) {
                    Member member1 = new Member(member.getId(), member.getPassword(), name, member.getEmail(), member.getPhoneNumber(),
                            member.getGender(), member.getGrade(),member.getDiscountRate(),  member.getTotal(), member.getDiscount());
                    profile.add(member1);
                    profile.remove(member);
                    break;
                } else if (email != null) {
                    Member member1 = new Member(member.getId(), member.getPassword(), member.getName(), email, member.getPhoneNumber(),
                            member.getGender(), member.getGrade(),member.getDiscountRate(), member.getTotal(), member.getDiscount());
                    profile.add(member1);
                    profile.remove(member);
                    break;
                } else if (phone != null) {
                    Member member1 = new Member(member.getId(), member.getPassword(), member.getName(), member.getEmail(), phone,
                            member.getGender(), member.getGrade(),member.getDiscountRate(),  member.getTotal(), member.getDiscount());
                    profile.add(member1);
                    profile.remove(member);
                    break;
                }

            }
        }
    }

    public void MembershipWithdrawal(String consumerId, String consumerPassword) {
        System.out.println("write your ID");
        String id = scanner.nextLine();
        System.out.println("write your PASSWORD");
        String password = scanner.nextLine();
        for (int i = 0; i < profile.size(); i++) {
            Member member = profile.get(i);
            if (consumerId.equals(id) && consumerPassword.equals(password) && member.getId().equals(id) && member.getPassword().equals(password)) {
                String userid = member.getId();
                String userPassword = member.getPassword();
                String userName = member.getName();
                String userEmail = member.getEmail();
                String userPhoneNumber = member.getPhoneNumber();
                String userGender = member.getGender();
                char userGrade = 'D';
                double userDiscountRate = member.getDiscountRate();
                int userTotal = member.getTotal();
                int userDiscount = member.getDiscount();
                Member withdrawal = new Member(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade,userDiscountRate,
                        userTotal, userDiscount);
                profile.add(withdrawal);
                profile.remove(member);
                System.out.println(userid + " Thank you for using it so far");
                break;
            }
        }

    }


    public void informationModification(User consumer) {
        ArrayList<Character>gradeType = new ArrayList<Character>();
        for(Member member : profile){
            char grade = member.getGrade();
            if(! gradeType.contains(grade)){
                gradeType.add(grade);
            }
        }
        int count =0;
        int number=0;
        System.out.println("Write your password");
        String password = scanner.nextLine();
        if(consumer.getPassword().equals(password)){
            System.out.println("enter the ID you want to edit the rating ");
            String editId = scanner.nextLine();
            for(Member member : profile){
                if(member.getId().equals(editId)){
                    System.out.println("write down the grade to change");
                    String change = scanner.nextLine();
                    change = change.toUpperCase();
                    char grade = change.charAt(0);

                    for(char value : gradeType){
                        System.out.println(value);
                        if(value == grade){
                            if(grade=='A'){
                                member.setGrade(grade);
                                member.setDiscountRate(0.1);
                            }else if(grade =='B'){
                                member.setGrade(grade);
                                member.setDiscountRate(0.05);
                            }else if(grade=='C'){
                                member.setGrade('C');
                                member.setDiscountRate(0.03);
                            }

                            System.out.println(member.getInfo());
                            break;
                        }else{
                            number++;
                            if(number==gradeType.size()){
                                System.out.println("The grade you wrote down does not exist.");
                            }
                        }
                    }
                }else{
                    count++;
                    if(count ==profile.size()){
                        System.out.println("The ID you wrote down does not exist.");
                    }
                }
            }
        }else{
            System.out.println("your password is not correct");
        }
    }


    public void salesManagement() {
        System.out.println("Select  1.Total sales amount 2. Total amount of discount 3. Grade discount rate adjustment");
        int choose = scanner.nextInt();

        int total = 0;
        int discount = 0;

        for (Member member : profile) {
            total += member.getTotal();
            discount += member.getDiscount();
        }

        switch (choose) {
            case 1:
                System.out.println("Total  : " + total);
                break;

            case 2:
                System.out.println("Discount : " + discount);
                break;

            case 3:
                double rateA =0;
                double rateB=0;
                double rateC=0;
                for(Member member : profile){
                    if(member.getGrade() =='A'){
                        rateA = member.getDiscountRate();
                    }else if(member.getGrade() =='B'){
                        rateB = member.getDiscountRate();
                    }else if(member.getGrade() =='C'){
                        rateC = member.getDiscountRate();
                    }
                }
                    System.out.println("Current Class A discount rate : " + rateA +"\n"+
                            "Current Class B discount rate : "+rateB +"\n"+ "Current Class C discount rate : "+rateC);

                        System.out.println("write in the order of discount rate to change from A to C");



                        System.out.println("A rate : ");
                        double changeA = scanner.nextDouble();

                        System.out.println("B rate : ");
                        double changeB = scanner.nextDouble();

                        double change=0;
                        while(changeB >= changeA) {
                            System.out.println("That rating percentage must be lower than the upper level percentage");
                            change = scanner.nextDouble();
                            if (change <= changeA) {
                                changeB = change;
                                break;
                            }
                        }

                        System.out.println("C rate : ");
                        double changeC = scanner.nextDouble();

                        while(changeC >= changeB) {
                            System.out.println("That rating percentage must be lower than the upper level percentage");
                            change = scanner.nextDouble();
                            if (change <= changeB) {
                            changeC = change;
                            break;
                            }
                        }


                        for(Member member : profile){
                            if(member.getGrade()=='A'){
                                member.setDiscountRate(changeA);
                                System.out.println(member.getInfo());
                            }else if(member.getGrade()=='B'){
                                member.setDiscountRate(changeB);
                                System.out.println(member.getInfo());
                            }else if(member.getGrade()=='C'){
                                member.setDiscountRate(changeC);
                                System.out.println(member.getInfo());
                            }
                        }
                        break;

                }
        }
    }





