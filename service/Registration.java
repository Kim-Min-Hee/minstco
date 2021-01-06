package service;

import app.Minstco;
import vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    private static final char[] Registration = null;
    private static final String Member = null;
    ArrayList<Member> profile = new ArrayList<Member>();
    Scanner scanner = new Scanner(System.in);


    public Registration() {
        Member m1 = new Member("xldkah", "minhee", "kim-min-hee", "xldkah2415@naver.com", "01012342415", "F", 'A', 0);
        Member m2 = new Member("manju", "hyungtaek", "ryu-hyung-taek", "xldkah4548@hanmail.net", "01045672812", "M", 'D', 0);
        profile.add(m1);
        profile.add(m2);
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

    public void loginMember() {
        System.out.println("This is the login screen");
        System.out.println("write your ID");
        String id = scanner.nextLine();
        System.out.println("write your password");
        String password = scanner.nextLine();
        for (int i=0; i<profile.size();i++) {
            Member m = profile.get(i);
            if (m.getId().equals(id)) {
                System.out.println("???");
                if (m.getPassword().equals(password)) {
                    System.out.println("login OK");
                    break;
                } else {
                    rePassword();
                }
                break;
            } else {
                System.out.println("Id does not match");
                if (m.getPassword().equals(password)) {
                    System.out.println("passwords match");
                } else {
                    System.out.println("Passwords do not match");
                }

            }
        }
    }

    public void rePassword() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Passwords do not match");
            System.out.println("Please re-enter your password");
            String password = scanner.nextLine();
            for (int y=0; y<profile.size();y++) {
                Member m = profile.get(y);
                if (m.getPassword().equals(password)) {
                    System.out.println("login OK");
                    break;
                } else {
                    if(i==3){
                        System.out.println("Passwords do not match");
                        realignment();
                    }
                    i++;
                }
            }

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
                    scanner.nextLine();
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
                                System.out.println(profile);
                                loginMember();
                                break;
                            }else{
                                System.out.println("The two passwords you entered do not match");
                                return;
                            }

                        }
                    }
            }
        }

    }


