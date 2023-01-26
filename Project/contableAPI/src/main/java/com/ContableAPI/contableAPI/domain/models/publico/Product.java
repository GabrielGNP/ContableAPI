package com.ContableAPI.contableAPI.domain.models.publico;

public class Product {
    private Integer productId;
    private String name;
    private String trademark;
    private String description;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
