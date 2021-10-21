package com.example.workshop6;

public class Products {
    private int ProductId;
    private String ProdName;

    public Products(int productId, String prodName) {
        ProductId = productId;
        ProdName = prodName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    @Override
    public String toString() {
        return ProductId + ProdName;
    }
}
