package com.ContableAPI.contableAPI.domain.models.publico;

public class ShopProduct {
    private Integer shopProductId;
    private Integer productId;
    private Integer shopId;
    private String dateCost;
    private String description;

    private Product product;
    private Shop shop;

    public Integer getShopProductId() {
        return shopProductId;
    }

    public void setShopProductId(Integer shopProductId) {
        this.shopProductId = shopProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getDateCost() {
        return dateCost;
    }

    public void setDateCost(String dateCost) {
        this.dateCost = dateCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
