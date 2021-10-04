/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 * test commit/push by enzel troy oct 4 5:48pm
 */

package com.example.workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class MainController {
    //private TabPane tpMain = new TabPane();


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

    @FXML // fx:id="lvCustomers"
    private ListView<?> lvCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="tab2"
    private Tab tab2; // Value injected by FXMLLoader

    @FXML // fx:id="lvBookings"
    private ListView<?> lvBookings; // Value injected by FXMLLoader

    @FXML // fx:id="tab3"
    private Tab tab3; // Value injected by FXMLLoader

    @FXML // fx:id="lvPackages"
    private ListView<?> lvPackages; // Value injected by FXMLLoader

    @FXML // fx:id="tab4"
    private Tab tab4; // Value injected by FXMLLoader

    @FXML // fx:id="lvProducts"
    private ListView<?> lvProducts; // Value injected by FXMLLoader

    @FXML // fx:id="tab5"
    private Tab tab5; // Value injected by FXMLLoader

    @FXML // fx:id="lvInvoices"
    private ListView<?> lvInvoices; // Value injected by FXMLLoader

    @FXML
    void btnBookings_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab2);
    }


    @FXML
    void btnCustomers_OnClick(ActionEvent event) {
       tpMain.getSelectionModel().select(tab1);
    }

    @FXML
    void btnHome_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab0);
    }

    @FXML
    void btnHome_OnEntered(MouseEvent event) {
        btnHome.setStyle("-fx-background-color: #0099cc");
    }

    @FXML
    void btnHome_OnExited(MouseEvent event) {
        btnHome.setStyle("-fx-background-color:  #0086b3");

    }

    @FXML
    void btnInvoices_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab5);
    }

    @FXML
    void btnPackages_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab3);
    }

    @FXML
    void btnProducts_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab4);
    }

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
        assert lvCustomers != null : "fx:id=\"lvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvBookings != null : "fx:id=\"lvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab3 != null : "fx:id=\"tab3\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvPackages != null : "fx:id=\"lvPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab4 != null : "fx:id=\"tab4\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvProducts != null : "fx:id=\"lvProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab5 != null : "fx:id=\"tab5\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvInvoices != null : "fx:id=\"lvInvoices\" was not injected: check your FXML file 'main-view.fxml'.";


    }
}
