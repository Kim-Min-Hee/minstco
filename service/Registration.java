package service;

import app.Minstco;
import vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    private static final char[] Registration = null;
    private static final String Member = null;
    public ArrayList<Member> profile = new ArrayList<Member>();
    Scanner scanner = new Scanner(System.in);

    public Registration() {
        Member m1 = new Member("xldkah", "minhee", "kim-min-hee", "xldkah2415@naver.com", "01012342415", "F", 'A', 0);
        Member m2 = new Member("manju", "hyungtaek", "ryu-hyung-taek", "xldkah4548@hanmail.net", "01045672812", "M", 'D', 0);
        Member m3 = new Member("q","q","q","xldkah@naver.com","11111111111","F",'B',0);
        Member m4 = new Member("admin","admin","admin","admin@google.com","1234567890","F",'A',100000);
        profile.add(m1);
        profile.add(m2);
        profile.add(m3);
        profile.add(m4);
    }


    public void insertMember() {
        System.out.println("please enter id to use");
        String id = scanner.nextLine();
        for (Member m : profile) {
            if (m.getId().equals(id)) {
                System.out.println("This information already exists" + "\n" + "Please enter another ID");
                String reId = scanner.nextLine();
                if (m.getId().equals(reId)) {
                    System.out.println("This information already exists");
                    return;
                }
            } else {
                break;
            }
        }

        System.out.println("enter password to use");
        String password = scanner.nextLine();

        System.out.println("write your name");
        String name = scanner.nextLine();


        System.out.println("enter email to use");
        String email = scanner.nextLine();
        boolean verify = email.contains("@") && email.contains(".");
        for (int i = 0; i < 4; i++) {
            for (Member m : profile) {
                if (m.getEmail().equals(email)) {
                    System.out.println("This email address cannot be used" + "\n" + "Please enter another email");
                    email = scanner.nextLine();
                    i++;
                } else if (verify && !m.getEmail().equals(email)) {
                    break;
                }
            }
            if (!verify) {
                System.out.println("Email format is incorrect");
                email = scanner.nextLine();
            }
        }


        System.out.println("write your phoneNumber");
        String phoneNumber = scanner.nextLine();

        if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            System.out.println("You entered incorrectly");
            String rePhoneNumber = scanner.nextLine();
            phoneNumber = rePhoneNumber;
        }

        System.out.println("Please select a gender 1. F 2. M");
        String gender = scanner.nextLine();
        if (gender.equals("1")) {
            gender = "F";
        } else if (gender.equals("2")) {
            gender = "M";
        } else {
            System.out.println("You entered incorrectly");
        }

        Member member = new Member(id, password, name, email, phoneNumber, gender, 'C', 0);
        profile.add(member);

    }
    public void selectAllMember(){
        System.out.println("show member list");
        for(int i = 0;i<profile.size();i++){
            System.out.println(profile.get(i).getInfo());
        }
    }

    public void loginMember() {
//        System.out.println("This is the login screen");
//        System.out.println("write your ID");
//        Scanner scanner = new Scanner(System.in);
//        String id = scanner.nextLine();
//        System.out.println("write your password");
//        String password = scanner.nextLine();
//        int result=0;
//        int result1=0;
//        for(Member m : profile){
//            if(m.getId().equals(id)){
//                if(m.getPassword().equals(password)){
//                    System.out.println("login OK");
//                    LoginUser loginUser = new LoginUser(m.getId(),m.getPassword(),m.getName(),m.getEmail(),m.getPhoneNumber(),m.getGender(),m.getGrade(),m.getTotal());
//                    return ;
//                }else {
//                    result++;
//                }
//            }else {
//                result1++;
//            }
//        }
//        if(result<profile.size()){
//            reLogin(1,id);
//        }else if(result1<profile.size()){
//            reLogin(2,id);
//        }

    }

    public void reLogin(int number,String id) {
        switch (number){
            case 1 :
                for(int i=0 ; i<3 ; i++){
                    System.out.println("Passwords do not match"+"\n"+"Please re-enter your password");
                    String password = scanner.nextLine();

                    for(Member m : profile){
                        if(m.getPassword().equals(password) && m.getId().equals(id)){
                            System.out.println("login OK");
                            break;
                        }
                    }
                    if(i==2){
                        System.out.println("Passwords do not match");
                        realignment();
                    }
                }
                break;
            case 2 :
                realignment();
                break;

        }
    }
        public void realignment(){
            System.out.println("choose 1. Re-enter 2. reset your password");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Please re-enter login");
                    System.out.println("id : ");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    System.out.println("pw : ");
                    String password = scanner.nextLine();
                    for(Member m : profile){
                        if(m.getId().equals(id) && m.getPassword().equals(password)){
                            System.out.println("login Ok");
                            break;
                        }
                    }
                    System.out.println("reset your password ");
                case 2:
                    System.out.println("write your Id ");
                    Scanner scanner = new Scanner(System.in);
                    id = scanner.nextLine();
                    System.out.println("write your email");
                    String email = scanner.nextLine();
                    System.out.println("choose your gender F or M");
                    String gender = scanner.nextLine();
                    for (int i=0; i<profile.size();i++) {
                        if (profile.get(i).getId().equals(id) && profile.get(i).getEmail().equals(email) && profile.get(i).getGender().equals(gender)) {
                            System.out.println("you can change password. \n" +
                                    "Please enter a password to change");
                            String rePassword = scanner.nextLine();
                            System.out.println("Re-enter ");
                            password= scanner.nextLine();
                            if(rePassword.equals(password)){
                                Member member = new Member(id, rePassword,profile.get(i).getName(),email,profile.get(i).getPhoneNumber(),
                                        gender,profile.get(i).getGrade(),profile.get(i).getTotal());
                                profile.add(member);
                                profile.remove(i);
                                if(member.getGrade()=='D'){
                                    System.out.println("a member who has withdrawn");
                                    return;
                                }
                                loginMember();
                                break;
                            }else{
                                System.out.println("The two passwords you entered do not match");
                                return;
                            }

                        }
                    }
                    break;
            }
        }

    }


