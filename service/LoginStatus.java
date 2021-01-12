package service;
import app.Minstco;
import sun.lwawt.macosx.CSystemTray;
import vo.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginStatus {
    private static final char[] LoginStatus= null;
    private static final String User =null;
    User consumer = null;
    Scanner scanner = new Scanner(System.in);

    public void login (User consumer){
        System.out.println("welcome "+"\t"+consumer.getId());
        this.consumer = consumer;

        if(consumer.getGrade()=='D'){
            System.out.println("a member who has withdrawn");
        }
        isLogin();
    }

    public boolean isLogin(){
        System.out.println("@@");
        boolean check = false;
        if(this.consumer !=null){
            check = true;
        }else{
            check = false;
        }
        System.out.println(check);
        return check;
    }

    public void logout(){
        consumer=null;
        System.out.println(consumer);
    }


    public void informationDetails(){
        System.out.println("write your password");
        String password = scanner.nextLine();
            if(consumer.getPassword().equals(password)){
                System.out.println(password);
            }


    }

}
