package app;

import service.LoginStatus;
import service.Merchandise;
import service.Registration;
import vo.BuyProduct;
import vo.Member;
import vo.User;
import vo.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Minstco {
    public static void main(String[] args) {
        Registration registration = new Registration();
        LoginStatus loginUser = new LoginStatus();
        Merchandise merchandise = new Merchandise();
        while (true) {
            if (!loginUser.isLogin()) {
                System.out.println("choose number " + "\n" + "1. registration 2. login ");
                Scanner scanner = new Scanner(System.in);
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("Would you like to become a member?" + "\t" + "1. Yes 2. No");
                        int extra = scanner.nextInt();
                        if (extra == 1) {
                            registration.insertMember();
                        } else {
                            return;
                        }
                        break;

                    case 2:
                        System.out.println("Please enter ID to log in");
                        scanner.nextLine();
                        String id = scanner.nextLine();
                        System.out.println("Please enter password to log in");
                        String password = scanner.nextLine();
                        int error = 0;
                        for (Member m : registration.profile) {
                            if (m.getId().equals(id) && m.getPassword().equals(password)) {
                                    String userid = m.getId();
                                    String userPassword = m.getPassword();
                                    String userName = m.getName();
                                    String userEmail = m.getEmail();
                                    String userPhoneNumber = m.getPhoneNumber();
                                    String userGender = m.getGender();
                                    char userGrade = m.getGrade();
                                    int userTotal = m.getTotal();
                                    double userDiscount= m.getDiscount();
                                    User user = new User(userid, userPassword, userName, userEmail, userPhoneNumber, userGender, userGrade, userTotal,userDiscount);
                                    loginUser.login(user);


                            } else {
                                error++;
                            }
                            if (error >= registration.profile.size()) {
                                registration.tryLogin(id, password);
                                break;
                            }

                        }
                }

            } else {
                Scanner scanner = new Scanner(System.in);
                User loginConsumer = loginUser.loginInformation();
                if(loginConsumer.getId().equals("admin")){
                    System.out.println("choose 1. Product management 2. Member management 3. Sales management");
                    int number = scanner.nextInt();
                    switch (number){
                        case 1 :
                            System.out.println("choose 1. New product registration 2. Select Product list 3. Amend product information 4. Delete product ");
                            int choose = scanner.nextInt();
                            if(choose==1){
                                merchandise.insertProduct();
                            }else if(choose ==2){
                                merchandise.selectProduct(loginConsumer.getId());
                            }else if(choose==3){
                                merchandise.amendProduct();
                            }else if(choose==4){
                                merchandise.deleteProduct();
                            }else{
                                System.out.println("Wrong choice");
                            }
                            break;

                        case 2 :
                            System.out.println("1. Select Member 2. Member information modification");
                            int select = scanner.nextInt();
                            if(select==1){
                                registration.selectMember();
                            }else if(select==2){
                                System.out.println("Write down the ID you want to edit");
                                scanner.nextLine();
                                String id = scanner.nextLine();
                                registration.informationModification(id);
                            }else{
                                System.out.println("Wrong choice");
                            }

                        case 3 :
                            registration.salesManagement();

                    }
                    return;
                }else{
                    System.out.println("choose 1. My information management 2. Select Product 3. Purchase of products 4. logout");
                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("choose 1. View my information details 2. Edit my information 3. Membership withdrawal 4. logout");
                            int number = scanner.nextInt();

                            if (number == 1) {
                                System.out.println("write your password");
                                String password =scanner.nextLine();
                                if(password.equals(loginConsumer.getPassword())){
                                    loginUser.informationDetails();
                                }else{
                                    System.out.println("passwords are Wrong");
                                }

                            } else if (number == 2) {
                                loginUser.editInformation();
                            }else if(number==3){
                                loginUser.MembershipWithdrawal();
                            }else if(number==4){
                                loginUser.logout();
                            }else{
                                System.out.println("Wrong choice");
                            }
                            break;
                        case 2:
                            merchandise.selectProduct(loginConsumer.getId());
                            break;
                        case 3 :
                            while (true) {
                                System.out.println("If you want to stop buying, please click (x)");
                                System.out.println("Enter the product code you want to buy");
                                scanner.nextLine();
                                String code = scanner.nextLine();
                                if (!code.equals("x")) {
                                    int count = 0;
                                    for (int i = 0; i < merchandise.saveGoods.size(); i++) {
                                        Product product = merchandise.saveGoods.get(i);
                                        if (product.getGoodsCode().equals(code)) {
                                            System.out.println("Enter the number of products you want to buy");
                                            int quantity = scanner.nextInt();
                                            if (product.getGoodsQuantity() >= quantity) {
                                                String category = product.getGoodsCategory();
                                                String name = product.getGoodsName();
                                                int price = product.getGoodsPrice();

                                                BuyProduct buyProduct = new BuyProduct(category, code, name, price, quantity);
                                                merchandise.buy.add(buyProduct);
                                                break;
                                            } else {
                                                System.out.println("The number of products has been exceeded");
                                            }
                                        } else {
                                            count++;
                                        }
                                        if (count == merchandise.saveGoods.size()) {
                                            System.out.println("Wrong Code");
                                            break;
                                        }
                                    }
                                }
                                double discount = 0;
                                if (loginConsumer.getGrade() == 'A') {
                                    discount = 0.1;
                                } else if (loginConsumer.getGrade() == 'B') {
                                    discount = 0.05;
                                } else {
                                    discount = 0.01;
                                }

                                registration.calculation(discount);
                            }

                        case 4:
                            System.out.println("You are logged out");
                            loginUser.logout();
                            break;


                    }
                }



                }

            }
        }

    }
