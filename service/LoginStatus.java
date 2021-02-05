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
        System.out.println(consumer.UserInfo());
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

}
