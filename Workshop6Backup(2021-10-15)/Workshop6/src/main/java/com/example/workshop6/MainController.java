/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */

package com.example.workshop6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.sql.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnHome"
    private Button btnHome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCustomers"
    private Button btnCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="btnBookings"
    private Button btnBookings; // Value injected by FXMLLoader

    @FXML // fx:id="btnPackages"
    private Button btnPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnProducts"
    private Button btnProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnInvoices"
    private Button btnInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="tpMain"
    private TabPane tpMain; // Value injected by FXMLLoader

    @FXML // fx:id="tab0"
    private Tab tab0; // Value injected by FXMLLoader

    @FXML // fx:id="tab1"
    private Tab tab1; // Value injected by FXMLLoader

    @FXML // fx:id="tab2"
    private Tab tab2; // Value injected by FXMLLoader

    @FXML // fx:id="tab3"
    private Tab tab3; // Value injected by FXMLLoader

    @FXML // fx:id="tab4"
    private Tab tab4; // Value injected by FXMLLoader

    @FXML // fx:id="lvProducts"
    private ListView<Products> lvProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddProd"
    private Button btnAddProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditProd"
    private Button btnEditProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteProd"
    private Button btnDeleteProd; // Value injected by FXMLLoader

    @FXML // fx:id="tab5"
    private Tab tab5; // Value injected by FXMLLoader

    @FXML
    void btnBookings_OnClick(ActionEvent event) {

    }

    @FXML
    void btnCustomers_OnClick(ActionEvent event) {

    }

    @FXML
    void btnHome_OnClick(ActionEvent event) {

    }

    @FXML
    void btnHome_OnEntered(MouseEvent event) {

    }

    @FXML
    void btnHome_OnExited(MouseEvent event) {

    }

    @FXML
    void btnInvoices_OnClick(ActionEvent event) {

    }

    @FXML
    void btnPackages_OnClick(ActionEvent event) {

    }

    @FXML
    void btnProducts_OnClick(ActionEvent event) throws FileNotFoundException {
        tpMain.getSelectionModel().select(tab4);
        lvProducts.getItems().clear();
        getProducts();
    }

    private ObservableList<Products> Data = FXCollections.observableArrayList();
    private ObservableList EmptyList = FXCollections.observableArrayList();
    private int selectedIndex;
    public boolean isEdit;
    public String username = "";
    public String password = "";
    public String url = "";


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnCustomers != null : "fx:id=\"btnCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnInvoices != null : "fx:id=\"btnInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tpMain != null : "fx:id=\"tpMain\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab0 != null : "fx:id=\"tab0\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab1 != null : "fx:id=\"tab1\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab3 != null : "fx:id=\"tab3\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab4 != null : "fx:id=\"tab4\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvProducts != null : "fx:id=\"lvProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddProd != null : "fx:id=\"btnAddProd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditProd != null : "fx:id=\"btnEditProd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteProd != null : "fx:id=\"btnDeleteProd\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab5 != null : "fx:id=\"tab5\" was not injected: check your FXML file 'main-view.fxml'.";

        lvProducts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

//        lvProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Products>() {
//            @Override
//            public void changed(ObservableValue<? extends Products> observableValue, Products products, Products t1) {
//                System.out.println("Listview selection changed");
//                lvProducts.getSelectionModel().getSelectedIndex();
//            }
//        });

        btnAddProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                isEdit = false;
                try {
                    OpenAddEditDialog(lvProducts.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnEditProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                isEdit = true;
                try {
                    OpenAddEditDialog(lvProducts.getSelectionModel().getSelectedIndex());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnDeleteProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DeleteProduct();
            }
        });
    }

    private void DeleteProduct() {
        ConnectToDatabase();
    }


    private void OpenAddEditDialog(int selectedIndex) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Product-view.fxml"));
        Parent parent = fxmlLoader.load();
        AddEditDialogController dialogController = new AddEditDialogController(lvProducts.getSelectionModel().getSelectedIndex());
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }

    private void getProducts() throws FileNotFoundException {
        ConnectToDatabase();
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Products");
            System.out.println("Loading Data");
            while(rs.next()){
                Data.add(new Products(rs.getInt(1), rs.getString(2)));
                lvProducts.setItems(Data);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void ConnectToDatabase(){
        try {
            FileInputStream fis = new FileInputStream("C:\\connection.properties");
            Properties props = new Properties();
            props.load(fis);

            username = (String) props.get("user");
            password = (String) props.get("password");
            url = (String) props.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
