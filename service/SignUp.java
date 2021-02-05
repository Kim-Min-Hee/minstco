package service;

import vo.Member;

import java.util.regex.Pattern;
public class SignUp {

    public void idForm(String id){
        if(id.length()<5 || id.length()>15){
            System.out.println("Only IDs within 5~15 characters are possible");

        }
    }

    public void passwordForm(String password1, String password2){
        if(password1.length()<5 ){
            System.out.println("enter a password of at least 5 characters");
        }

        String pattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
       boolean password_check = Pattern.matches(pattern,password1);
       if(password_check=false){
           System.out.println("Please enter 8 to 20 characters including English, numbers, and special characters.");
       }

       if(!password1.equals(password2)){
           System.out.println("password is not correct");
       }
    }

    public void nameForm (String name){

        String pattern = "^[가-힣]|[a-zA-Z]*$";
        boolean name_check = Pattern.matches(pattern,name);

        if(name_check=false){
            System.out.println("Special characters or numbers cannot be entered in the name");
        }

    }

    public void emailForm(String email){

       boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?",email);
       if(email_check=false){
           System.out.println("Email format is incorrect");
       }
    }

    public void phoneNumberForm(String phoneNumber){
        if(phoneNumber.length() != 11){
            System.out.println("Doesn't fit the format of your mobile phone number");
        }
    }

    public void genderForm(String gender){
       gender = gender.toUpperCase();
        if( !gender.equals("F") && !gender.equals("Female") && !gender.equals("M") && !gender.equals("men")){
            System.out.println("Please select gender");
        }
    }

}
