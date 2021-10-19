package com.example.workshop6;
/**
 * Sample Skeleton for 'Product-view.fxml' Controller Class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProductViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnSaveEdit"
    private Button btnSaveEdit; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdId"
    private TextField tfProdId; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdName"
    private TextField tfProdName; // Value injected by FXMLLoader

    private String mode = "";
    public ObservableList<Products> productData = FXCollections.observableArrayList();
    private int selectedIndex;

    public void setProductData(ObservableList<Products> data) {
        this.productData = data;
    }

    public void displayProduct(Products products, int i) {
        mode = "update";
        this.tfProdName.focusedProperty();
        this.tfProdName.setText(products.getProdName());
        this.tfProdId.setText(String.valueOf(products.getProductId()));
        selectedIndex = i;
    }



    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnSaveEdit != null : "fx:id=\"btnSaveEdit\" was not injected: check your FXML file 'Product-view.fxml'.";
        assert tfProdId != null : "fx:id=\"tfProdId\" was not injected: check your FXML file 'Product-view.fxml'.";
        assert tfProdName != null : "fx:id=\"tfProdName\" was not injected: check your FXML file 'Product-view.fxml'.";

        btnSaveEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnSaveEditClicked();
            }
        });
    }

    /** Author: Aidan Goguen
     * Product controller to enable add and edit functionality
     * Validates that product name is not null on add or edit.
     */

    public boolean Validate() {
        if(tfProdName.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a product name");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private void btnSaveEditClicked() {
        Validate();
        String username = "";
        String password = "";
        String url = "";
        try{
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties properties = new Properties();
            properties.load(fis);
            username = (String) properties.get("user");
            password = (String) properties.get("password");
            url = (String) properties.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            if(mode == "update"){
                tfProdId.setEditable(false);
                PreparedStatement stmt = conn.prepareStatement("UPDATE `Products` SET `ProdName`=? WHERE `ProductId`=?");
                stmt.setString(2, this.tfProdName.getText());
                stmt.setString(1, this.tfProdId.getText());

                int numRows = stmt.executeUpdate();
                if (numRows == 0){
                    System.out.println("Product Update Failed!");
                }
                Products products = new Products(Integer.parseInt(tfProdId.getText()), tfProdName.getText());
                productData.set(selectedIndex, products);
                Stage stage = (Stage) btnSaveEdit.getScene().getWindow();
                stage.close();
            }
            else{
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO Products (ProdName) VALUES (?)");
                stmt.setString(1, tfProdName.getText());
                int numRows = stmt.executeUpdate();
                if(numRows == 0){
                    System.out.println("Product Addition Failed!");
                }
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT ProductId FROM Products");
                int prodId = 0;
                while (rs.next()){
                    if(rs.getInt(1) > prodId){
                        prodId = rs.getInt(1);
                    }
                }
                Products products = new Products(prodId, tfProdName.getText());
                productData.add(products);
                Stage stage = (Stage) btnSaveEdit.getScene().getWindow();
                stage.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addProduct() {
        mode= "insert";
        tfProdId.setVisible(false);
    }
}

