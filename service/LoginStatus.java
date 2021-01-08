package service;
import app.Minstco;
import vo.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginStatus {
    private static final char[] LoginStatus= null;
    private static final String User =null;
    public ArrayList<User> loginUser = new ArrayList<User>();
    Minstco minstco = new Minstco();
    Scanner scanner = new Scanner(System.in);
    public LoginStatus(){
            User user1 = new User("abc","abc","a","a@naver.com","01012345678","M",'C',100);
            loginUser.add(user1);

    }
    public void loginInsert(User user){
        System.out.println("welcome "+"\t"+user.getId());
        loginUser.add(user);
        for(int i=0;i<loginUser.size();i++){
            System.out.println(loginUser.get(i).UserInfo());
        }
        if(user.getGrade()=='D'){
            System.out.println("a member who has withdrawn");
            return;
        }
        String id = user.getId();

       minstco.login(id);


    }
    public void logout(){
        loginUser.clear();
        System.out.println(loginUser);

    }


    public void informationDetails(){
        System.out.println("write your password");
        String password = scanner.nextLine();
        for(int i=0; i<loginUser.size();i++){
            System.out.println("@@@");
            if(loginUser.get(i).getPassword().equals(password)){
                System.out.println(password);
            }
        }

    }

}
