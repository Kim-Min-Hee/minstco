package vo;

public class BuyProduct {
    String buyGoodsName;
    int buyGoodsQuantity;
    String buyGoodsCategory;
    int buyGoodsPrice;
    String buyGoodsCode;
    int buyTotal;

    public void setBuyTotla(int buyTotal) {
        this.buyTotal = buyTotal;
    }

    public int getBuyTotal() {
        return buyTotal;
    }

    public void setBuyGoodsName(String buyGoodsName) {
        this.buyGoodsName = buyGoodsName;
    }

    public void setBuyGoodsQuantity(int buyGoodsQuantity) {
        this.buyGoodsQuantity = buyGoodsQuantity;
    }

    public void setBuyGoodsCategory(String buyGoodsCategory) {
        this.buyGoodsCategory = buyGoodsCategory;
    }

    public void setBuyGoodsPrice(int buyGoodsPrice) {
        this.buyGoodsPrice = buyGoodsPrice;
    }

    public void setBuyGoodsCode(String buyGoodsCode) {
        this.buyGoodsCode = buyGoodsCode;
    }

    public String getBuyGoodsName() {
        return buyGoodsName;
    }

    public int getBuyGoodsQuantity() {
        return buyGoodsQuantity;
    }

    public String getBuyGoodsCategory() {
        return buyGoodsCategory;
    }

    public int getBuyGoodsPrice() {
        return buyGoodsPrice;
    }

    public String getBuyGoodsCode() {
        return buyGoodsCode;
    }

    public BuyProduct(String buyGoodsCategory , String buyGoodsCode , String buyGoodsName , int buyGoodsPrice , int buyGoodsQuantity){
        this.buyGoodsCategory= buyGoodsCategory;
        this.buyGoodsCode = buyGoodsCode;
        this.buyGoodsName = buyGoodsName;
        this.buyGoodsPrice = buyGoodsPrice;
        this.buyGoodsQuantity=buyGoodsQuantity;
        this.buyTotal = buyGoodsPrice * buyGoodsQuantity;

        System.out.println("Buy category : "+buyGoodsCategory+"\t"+"code : "+buyGoodsCode+"\t"+"name : "+buyGoodsName+"\t"+"price : "+buyGoodsPrice+
                "\t"+"quantity : "+buyGoodsQuantity);

    }
    public String getBuyInfor(){
        return "BuyGoodsInformation"+"\n"+"Category : "+buyGoodsCategory+"\t"+"Code : "+buyGoodsCode+"\t"+"goodsName : "+buyGoodsName+
                "\t"+"Price : "+buyGoodsPrice+"\t"+"Quantity : "+buyGoodsQuantity;
    }

}

