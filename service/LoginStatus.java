package service;
import app.Minstco;
import vo.LoginUser;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginStatus {
    private static final char[] LoginStatus= null;
    private static final String User =null;
    public ArrayList<LoginUser> loginUser = new ArrayList<LoginUser>();
    Scanner scanner = new Scanner(System.in);
    public LoginStatus(){
        LoginUser loginUser1 = new LoginUser("abc","abc","a","a@naver.com","01012345678","M",'C',100);
        loginUser.add(loginUser1);
    }
    public void loginInsert(LoginUser user){
        Minstco.login(user.getId(), user.getName(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getGender(), user.getGrade(), user.getTotal());
        loginUser.add(user);
        System.out.println(user);

    }

    public void informationDetails(){
        System.out.println("write your password");
        scanner.nextLine();
        String password = scanner.nextLine();

    }

}
