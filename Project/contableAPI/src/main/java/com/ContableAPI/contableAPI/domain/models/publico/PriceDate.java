package com.ContableAPI.contableAPI.domain.models.publico;


public class PriceDate {
        private int idShopProduct;
        private String newPrice;

        public int getIdShopProduct() {
            return idShopProduct;
        }

        public void setIdShopProduct(int idShopProduct) {
            this.idShopProduct = idShopProduct;
        }

        public String getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(String newPrice) {
            this.newPrice = newPrice;
        }
}
