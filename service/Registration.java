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
        Member m1 = new Member("xldkah", "minhee" ,"kim-min-hee","xldkah2415@naver.com","01012342415","F",'A',0);
        Member m2 = new Member("manju", "hyungtaek","ryu-hyung-taek", "xldkah4548@hanmail.net", "01045672812", "M",'D',0);
        profile.add(m1);
        profile.add(m2);
    }

    public void insertMember() {
        System.out.println("please enter id to use");
        String id= scanner.nextLine();
                for(Member m : profile){
                    if(m.getId().equals(id)){
                        System.out.println("This information already exists"+"\n"+"Please enter another ID");
                        String reId = scanner.nextLine();
                        if(m.getId().equals(reId)){
                            System.out.println("This information already exists");
                            return;
                        }
                    }else {
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
                for(int i=0 ; i<4 ;i++){
                    for(Member m : profile){
                        if(m.getEmail().equals(email)){
                            System.out.println("This email address cannot be used"+"\n"+"Please enter another email");
                            email=scanner.nextLine();
                                i++;
                        }else if(verify && ! m.getEmail().equals(email)){
                            break;
                        }
                }
                    if( !verify){
                        System.out.println("Email format is incorrect");
                        email = scanner.nextLine();
                    }
                }


        System.out.println("write your phoneNumber");
        String phoneNumber = scanner.nextLine();

        if(phoneNumber.length()<10 || phoneNumber.length()>11){
            System.out.println("You entered incorrectly");
            String rePhoneNumber = scanner.nextLine();
            phoneNumber=rePhoneNumber;
        }

        System.out.println("Please select a gender 1. F 2. M");
        String gender = scanner.nextLine();
        if(gender.equals("1")){
            gender= "F";
        }else if(gender.equals("2")){
            gender="M";
        }else{
            System.out.println("You entered incorrectly");
        }

        Member member= new Member(id,password,name,email,phoneNumber,gender,'C',0);
        profile.add(member);


    }
    public void loginMember(String id , String password){
            for(Member m : profile){
                if(m.getId().equals(id)){
                    if(m.getPassword().equals(password)){
                        System.out.println("login OK");
                    }else{
                        for(int i=0; i<4 ; i++){
                            System.out.println("password does not match"+"\n"+"Please password re-enter");
                            password= scanner.nextLine();
                            if(password.equals(m.getPassword())){
                                System.out.println("login OK!");
                                break;
                            }else {
                                i++;
                            }
                                if(i==3){
                                    System.out.println("Select 1. Reset or 2. Re-enter Password");
                                    int select= scanner.nextInt();
                                    if(select==1){

                                    }else if(select==2){
                                        i=2;
                                    }
                                }
                            }
                        }
                    }
                }
            }

    }

