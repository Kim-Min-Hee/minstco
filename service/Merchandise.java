package service;

import vo.BuyProduct;
import vo.Member;
import vo.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Merchandise {
    private static final char[] Merchadise= null;
    private static final String Product = null;
    public ArrayList<Product> saveGoods = new ArrayList<Product>();
    public ArrayList<BuyProduct>buy = new ArrayList<BuyProduct>();
    Scanner scanner = new Scanner(System.in);
    LoginStatus loginStatus = new LoginStatus();

    public Merchandise() {
        Product goods1 = new Product("food", "F1", "goraebab", 1200, 100);
        Product goods2 = new Product("food", "F2", "pork", 10000, 5);
        Product goods3 = new Product("food", "F3", "Jjolmyeon", 5000, 0);
        Product goods4 = new Product("food", "F4", "ice Americano", 5100, 1000);
        Product goods5 = new Product("dress", "D1", "Kangol", 53000, 20);
        Product goods6 = new Product("dress", "D2", "adidas", 100000, 40);
        Product goods7 = new Product("dress", "D3", "Discovery", 30000, 23);
        Product goods8 = new Product("electromechanical", "E1", "appleLaptop", 3400000, 53);
        Product goods9 = new Product("electromechanical", "E2", "appleWatch", 500000, 77);
        Product goods10 = new Product("electromechanical", "E3", "iPad", 1200000, 5);

        saveGoods.add(goods1);
        saveGoods.add(goods2);
        saveGoods.add(goods3);
        saveGoods.add(goods4);
        saveGoods.add(goods5);
        saveGoods.add(goods6);
        saveGoods.add(goods7);
        saveGoods.add(goods8);
        saveGoods.add(goods9);
        saveGoods.add(goods10);

    }



    public void insertProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write goodsCategory");
        String goodsCategory = scanner.nextLine();
        System.out.println("write goodsCode");
        String goodsCode = scanner.nextLine();
        System.out.println("write goodsName");
        String goodsName = scanner.nextLine();
        System.out.println("write goodsPrice");
        int goodsPrice = scanner.nextInt();
        System.out.println("write goodsQuantity");
        int goodsQuantity = scanner.nextInt();

        Product goods = new Product(goodsCategory,goodsCode,goodsName,goodsPrice,goodsQuantity);
        saveGoods.add(goods);
    }


    public void selectProduct(String id){
        int select;
        if(id.equals("admin")){
            System.out.println("choose 1. View all products 2. Search products by category 3. Search by product name 4. Select Out of stock products");
            select = scanner.nextInt();
        }else {
            System.out.println("choose 1. View all products 2. Search products by category 3. Search by product name");
            select = scanner.nextInt();
        }
        if(select==1){
            for(int i=0; i<saveGoods.size();i++){
                System.out.println(saveGoods.get(i).getInfor());
            }
        }else if(select==2){
            System.out.println("Search products by category 1. food 2. dress 3. electromechanical");
            scanner.nextLine();
            String choose = scanner.nextLine();
            String category= null;
            if(choose.equals("food") || choose.equals("1")) {
                category = "food";
            }else if(choose.equals("dress") || choose.equals("2")){
                category= "dress";
            }else if(choose.equals("electromechanical") || choose.equals("3")){
                category="electromechanical";
            }else{
                System.out.println("Wrong choice");
            }
            for(Product product : saveGoods){
                if(product.getGoodsCategory().equals(category)){
                    System.out.println(product.getInfor());
                }
            }
        }else if(select==3){
            System.out.println("Search by product name");
            scanner.nextLine();
            String name = scanner.nextLine();
            for(Product product : saveGoods){
                if(product.getGoodsName().contains(name)){
                    System.out.println(product.getInfor());
                }
            }

        }else if(select==4 && id.equals("admin")){
            for(Product product : saveGoods){
                if(product.getGoodsQuantity()==0){
                    System.out.println(product.getInfor());
                }
            }
        }else{
            System.out.println("Wrong choice");
        }
    }

    public void amendProduct(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("write productCode"+"\n"+"If you want to stop typing, enter /finish/");
            String code = scanner.nextLine();
                for (int i=0 ; i<saveGoods.size();i++) {
                    Product product = saveGoods.get(i);
                    if (product.getGoodsCode().equals(code)) {
                        System.out.println("Which part do you want to edit " + "\n" + "1. goodsName 2. goodsQuantity 3. goodsPrice");
                        int choose = scanner.nextInt();
                        if (choose == 1) {
                            System.out.println("Please write the name to change");
                            scanner.nextLine();
                            String name = scanner.nextLine();

                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            String goodsName = name;
                            int goodsPrice = product.getGoodsPrice();
                            int goodsQuantity = product.getGoodsQuantity();
                            Product changeProduct = new Product(goodsCategory, goodsCode, goodsName, goodsPrice, goodsQuantity);
                            saveGoods.add(changeProduct);
                            saveGoods.remove(product);
                            break;
                        } else if (choose == 2) {
                            System.out.println("Please write the quantity to change");
                            int quantity = scanner.nextInt();

                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            String goodsName = product.getGoodsName();
                            int goodsPrice = product.getGoodsPrice();
                            int goodsQuantity = quantity;
                            Product changeProduct = new Product(goodsCategory, goodsCode, goodsName, goodsPrice, goodsQuantity);
                            saveGoods.add(changeProduct);
                            saveGoods.remove(product);
                            break;
                        }else if(choose==3){
                            System.out.println("Please write the price to change");
                            int price = scanner.nextInt();

                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            String goodsName = product.getGoodsName();
                            int goodsPrice = price;
                            int goodsQuantity = product.getGoodsQuantity();
                            Product changeProduct = new Product(goodsCategory, goodsCode, goodsName, goodsPrice, goodsQuantity);
                            saveGoods.add(changeProduct);
                            saveGoods.remove(product);
                            System.out.println(product.getInfor());
                            break;
                        }
                    }
                }
            if (code.equals("finish")) {
                break;
            }

            }
        }

        public void deleteProduct(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the product code you want to delete");
            String code = scanner.nextLine();
            for(int i=0; i<saveGoods.size();i++) {
                Product product = saveGoods.get(i);
                if(product.getGoodsCode().equals(code)){
                    System.out.println(product.getInfor());
                    System.out.println("Would you like to delete this product choose Y or N");
                    String select = scanner.nextLine();
                    if(select.equals("Y") || select.equals("y")){
                        System.out.println("write your password");
                        String password = scanner.nextLine();
                        if(password.equals("admin")){
                            saveGoods.remove(product);
                            System.out.println(product.getInfor());

                        }else{
                            System.out.println("Incorrect password");
                            return;
                        }
                    }
                }

            }


        }

        public void buyProduct(){
        boolean zero = true;
        int count = 0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the desired product code");
            String code = scanner.nextLine();

            if(code.contains("finish")){
                for(BuyProduct buyProduct : buy){
                    double purchase=0;
                    if(loginStatus.consumer.getGrade()=='A'){
                        purchase = 0.1;
                    }else if(loginStatus.consumer.getGrade()=='B'){
                        purchase = 0.05;
                    }else {
                        purchase = 0.03;
                    }
                    int sum = buyProduct.getBuyGoodsPrice()* buyProduct.getBuyGoodsQuantity();
                    double total = sum*purchase;
                    System.out.println(total);
                    break;
                }
                break;
            }
            for(int i=0; i<saveGoods.size();i++){
                Product product = saveGoods.get(i);
                if(product.getGoodsCode().equals(code)){
                    System.out.println("Enter the number you want to purchase");
                    int number = scanner.nextInt();
                    if(product.getGoodsQuantity() >= number){
                        BuyProduct buyProduct = new BuyProduct(product.getGoodsCategory(), product.getGoodsCode(), product.getGoodsName(),
                                product.getGoodsPrice(), product.getGoodsQuantity());
                        buy.add(buyProduct);
                        int sum = product.getGoodsQuantity()-number;
                        Product product1 = new Product(product.getGoodsCategory(),product.getGoodsCode(), product.getGoodsName(), product.getGoodsPrice()
                        , sum);
                        saveGoods.remove(product);

                        break;
                    }else {
                        zero=false;
                    }
                }else {
                    count++;
                }
                if(zero==false){
                    System.out.println("The product is out of stock");
                    break;
                }
                if(count==saveGoods.size()){
                    System.out.println("There is no code entered");
                    break;
                }
            }


      }


        }

}
