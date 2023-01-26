package com.ContableAPI.contableAPI.domain.models.personal;

import com.ContableAPI.contableAPI.domain.models.publico.ShopProduct;

import java.sql.Date;
//import java.util.Date;
public class PurchaseProducts {
    private Integer purchaseId;
    private Integer product;
    private Integer quantity;
    private Date date;
    private String description;
    private Double discount;

    private ShopProduct shopProduct;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public ShopProduct getShopProduct() {
        return shopProduct;
    }

    public void setShopProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }
}
