package com.example.workshop6;
/**
 * Sample Skeleton for 'Product-view.fxml' Controller Class
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddEditDialogController extends MainController{

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

    private ObservableList<Products> productData;
    private int selectedIndex;

    public AddEditDialogController(Products products) {
        this. = products;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnSaveEdit != null : "fx:id=\"btnSaveEdit\" was not injected: check your FXML file 'Product-view.fxml'.";
        assert tfProdId != null : "fx:id=\"tfProdId\" was not injected: check your FXML file 'Product-view.fxml'.";
        assert tfProdName != null : "fx:id=\"tfProdName\" was not injected: check your FXML file 'Product-view.fxml'.";

        tfProdId.isDisable();
        tfProdName.isFocused();
        btnSaveEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnSaveEditClicked(mouseEvent);
            }
        });
    }

    private void btnSaveEditClicked(MouseEvent mouseEvent) {
        ConnectToDatabase();
        if (isEdit == false){
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO products ( ProdName) VALUES (?)");
               // stmt.setInt(1, Integer.parseInt(tfProdId.getText()));
                stmt.setString(1, tfProdName.getText());

                int numRows = stmt.executeUpdate();

                if (numRows == 0){
                    System.out.println("Product Addition Failed!");
                }
                else {
                    System.out.println("Product was added successfully.");
                }
                Node source = (Node) mouseEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(isEdit == true){
            Connection conn = null;
            try{
                conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement("UPDATE products SET ProdName=[?] WHERE ProductId=?");
                stmt.setString(2, tfProdName.getText());

                int numRows = stmt.executeUpdate();

                if (numRows == 0){
                    System.out.println("Failed to Update");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public void setMainObservableList(ObservableList<Products> data){
        this.productData = data;
    }
    public void setMainSelectedIndex(){
        this.selectedIndex = selectedIndex;
        Products p = productData.get(selectedIndex);
    }
}
