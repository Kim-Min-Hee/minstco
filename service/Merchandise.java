package service;

import vo.BuyProduct;
import vo.Member;
import vo.Product;
import vo.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Merchandise  {
    private static final char[] Merchadise= null;
    private static final String Product = null;
    public ArrayList<Product> saveGoods = new ArrayList<Product>();
    public ArrayList<BuyProduct>buy = new ArrayList<BuyProduct>();
    Scanner scanner = new Scanner(System.in);

    public Merchandise() {
        Product goods1 = new Product("food", "F1", "goraebab", 1200, 100);
        Product goods2 = new Product("food", "F2", "pork", 10000, 5);
        Product goods3 = new Product("food", "F3", "jjolmyeon", 5000, 0);
        Product goods4 = new Product("food", "F4", "ice Americano", 5100, 1000);
        Product goods5 = new Product("dress", "D1", "kangol", 53000, 20);
        Product goods6 = new Product("dress", "D2", "adidas", 100000, 40);
        Product goods7 = new Product("dress", "D3", "discovery", 30000, 23);
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

    public void buyProduct(User consumer,Registration registration) {
        for(Product product : saveGoods){
            System.out.println(product.getInfor());
        }
        while (true) {
            System.out.println("If you want to stop buying, please click (x)");
            System.out.println("Enter the product code you want to buy");
            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();

            if (code.equals("x")) {
                int discount=0;
                int pay=0;
                int total=0;
                for(BuyProduct buyProduct : buy){
                    System.out.println(buyProduct.getBuyInfor());
                    total += buyProduct.getBuyTotal();
                    discount = (int)(consumer.getDiscountRate()*total);
                    pay = total-discount;
                }
                System.out.println("Total : "+total +"discount : "+discount+"payment : "+pay);

                if(total >=500000 && consumer.getGrade() != 'A'){
                    consumer.setGrade('A');
                    consumer.setDiscountRate(0.1);
                }else if(total >300000 && total <500000 && consumer.getGrade() != 'B'){
                    consumer.setGrade('B');
                    consumer.setDiscountRate(0.05);
                }

                for(int i = 0; i<registration.profile.size(); i++){
                    Member member = registration.profile.get(i);
                    if(member.getId().equals(consumer.getId())){
                        Member member1 = new Member(consumer.getId(),consumer.getPassword(),consumer.getName(),consumer.getEmail(),consumer.getPhoneNumber(),
                                consumer.getGender(),consumer.getGrade(),consumer.getDiscountRate(),total,discount);
                        User user = new User(consumer.getId(),consumer.getPassword(),consumer.getName(),consumer.getEmail(),consumer.getPhoneNumber(),
                                consumer.getGender(),consumer.getGrade(),consumer.getDiscountRate(),total,discount);
                        registration.profile.add(member1);
                        registration.profile.remove(member);
                        break;
                    }

                }

                buy.clear();
                break;
                }

            int count=0;

            for(Product product : saveGoods){

                if(product.getGoodsCode().equals(code)){
                    System.out.println("Please fill in the number of purchases");
                    int amount = scanner.nextInt();

                    if(amount <= product.getGoodsQuantity()){
                        String category = product.getGoodsCategory();
                        String name = product.getGoodsName();
                        int price = product.getGoodsPrice();
                        BuyProduct buyProduct = new BuyProduct(category,code,name,price,amount);
                        buy.add(buyProduct);
                        Product product1 = new Product(product.getGoodsCategory(),product.getGoodsCode(),
                                product.getGoodsName(),product.getGoodsPrice(),product.getGoodsQuantity()-amount);
                        saveGoods.add(product1);
                        saveGoods.remove(product);
                        break;

                    }else{
                        System.out.println("You have exceeded the number you can purchase");
                    }

                }else{
                    count++;
                }
                if(count==saveGoods.size()){
                    System.out.println("No such code");
                }
            }
        }
    }

    public void insertProduct(){
        ArrayList<String> category = new ArrayList<String>();

        for(Product product : saveGoods){
            String categoryType = product.getGoodsCategory();

            if(!category.contains(categoryType)){
                category.add(categoryType);
            }
        }

        for (String value : category){
            System.out.println("Current category : "+value);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("write goodsCategory");
        String goodsCategory = scanner.nextLine();

        int count=1;
        for(Product product :saveGoods){
            if(product.getGoodsCategory().equals(goodsCategory)){
                count++;
            }
        }
        String number = String.valueOf(count);
        String goodsCode = goodsCategory.charAt(0)+number;
        goodsCode = goodsCode.toUpperCase();
        System.out.println("Given code : "+goodsCode);

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

        }else if(select==2) {
            System.out.println("search product by category");
            scanner.nextLine();
            String category = scanner.nextLine();
            category = category.toLowerCase();
            int count=0;
            for(Product product : saveGoods){
                if(product.getGoodsCategory().contains(category)){
                    System.out.println(product.getInfor());
                }else{
                    count++;
                }
                if(count==saveGoods.size()){
                    System.out.println("There is no category");
                }
            }



        }else if(select==3){
            System.out.println("Search by product name");
            scanner.nextLine();
            String name = scanner.nextLine();
            name = name.toLowerCase();
            int number = 0;
            for(Product product : saveGoods){
                if(product.getGoodsName().contains(name)){
                    System.out.println(product.getInfor());
                }else{
                    number++;
                }
                if(number==saveGoods.size()){
                    System.out.println("There is no product name");
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
                        System.out.println(product.getInfor());
                        System.out.println("Which part do you want to edit " + "\n" + "1. goodsName 2. goodsQuantity 3. goodsPrice");
                        int choose = scanner.nextInt();

                        if (choose == 1) {
                            System.out.println("Please write the name to change");
                            scanner.nextLine();
                            String goodsName = scanner.nextLine();
                            goodsName = goodsName.toLowerCase();
                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            int goodsPrice = product.getGoodsPrice();
                            int goodsQuantity = product.getGoodsQuantity();
                            Product changeProduct = new Product(goodsCategory, goodsCode, goodsName, goodsPrice, goodsQuantity);
                            saveGoods.add(changeProduct);
                            saveGoods.remove(product);
                            break;

                        } else if (choose == 2) {
                            System.out.println("Please write the quantity to change");
                            int goodsQuantity = scanner.nextInt();

                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            String goodsName = product.getGoodsName();
                            int goodsPrice = product.getGoodsPrice();
                            Product changeProduct = new Product(goodsCategory, goodsCode, goodsName, goodsPrice, goodsQuantity);
                            saveGoods.add(changeProduct);
                            saveGoods.remove(product);
                            break;

                        }else if(choose==3){
                            System.out.println("Please write the price to change");
                            int goodsPrice = scanner.nextInt();

                            String goodsCategory = product.getGoodsCategory();
                            String goodsCode = product.getGoodsCode();
                            String goodsName = product.getGoodsName();
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
            code = code.toUpperCase();
            int count=0;
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
                }else{
                    count++;
                    if(count==saveGoods.size()){
                        System.out.println("The code you entered does not exist");
                    }
                }

            }

        }


}
