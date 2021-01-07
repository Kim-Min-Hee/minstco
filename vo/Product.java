package vo;

public class Product {
    String goodsName;
    int goodsNumner;
    String goodsCategory;
    int goodsPrice;
    int goodsCode;

    public void setGoodsCode(int goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsNumner(int goodsNumner) {
        this.goodsNumner = goodsNumner;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsNumner() {
        return goodsNumner;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }
}
