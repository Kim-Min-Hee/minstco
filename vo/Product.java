package vo;

public class Product {
    String goodsName;
    int goodsQuantity;
    String goodsCategory;
    int goodsPrice;
    String goodsCode;

    public Product(String goodsCategory , String goodsCode , String goodsName , int goodsPrice , int goodsQuantity){
        this.goodsCategory= goodsCategory;
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsQuantity=goodsQuantity;

        System.out.println("category : "+goodsCategory+"\t"+"code : "+goodsCode+"\t"+"name : "+goodsName+"\t"+"price : "+goodsPrice+"\t"+"quantity : "+goodsQuantity);

    }
    public String getInfor(){
        return "goodsInformation"+"\n"+"goodsCategory : "+goodsCategory+"\t"+"goodsCode : "+goodsCode+"\t"+"goodsName : "+goodsName+
                "\t"+"goodsPrice : "+goodsPrice+"\t"+"goodsQuantity : "+goodsQuantity;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public String getGoodsCode() {
        return goodsCode;
    }
}
