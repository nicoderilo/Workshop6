/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
 */

package com.example.workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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

    @FXML // fx:id="lbCustomers"
    private Label lbCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="lblBookings"
    private Label lblBookings; // Value injected by FXMLLoader

    @FXML // fx:id="lblPackages"
    private Label lblPackages; // Value injected by FXMLLoader

    @FXML // fx:id="lblInvoices"
    private Label lblInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="tpMain"
    private TabPane tpMain; // Value injected by FXMLLoader

    @FXML // fx:id="tab0"
    private Tab tab0; // Value injected by FXMLLoader

    @FXML // fx:id="tab1"
    private Tab tab1; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddCustomers"
    private Button btnAddCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditCustomers"
    private Button btnEditCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteCustomers"
    private Button btnDeleteCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="tvCustomers"
    private TableView<?> tvCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="colCustomerId"
    private TableColumn<?, ?> colCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="colCustFirstName"
    private TableColumn<?, ?> colCustFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="colCustLastName"
    private TableColumn<?, ?> colCustLastName; // Value injected by FXMLLoader

    @FXML // fx:id="colCustAddress"
    private TableColumn<?, ?> colCustAddress; // Value injected by FXMLLoader

    @FXML // fx:id="colCustCity"
    private TableColumn<?, ?> colCustCity; // Value injected by FXMLLoader

    @FXML // fx:id="colCustProv"
    private TableColumn<?, ?> colCustProv; // Value injected by FXMLLoader

    @FXML // fx:id="colCustPostal"
    private TableColumn<?, ?> colCustPostal; // Value injected by FXMLLoader

    @FXML // fx:id="colCustCountry"
    private TableColumn<?, ?> colCustCountry; // Value injected by FXMLLoader

    @FXML // fx:id="colCustHomePhone"
    private TableColumn<?, ?> colCustHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="colCustBusPhone"
    private TableColumn<?, ?> colCustBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="colCustEmail"
    private TableColumn<?, ?> colCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="col"
    private TableColumn<?, ?> col; // Value injected by FXMLLoader

    @FXML // fx:id="tab2"
    private Tab tab2; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddBookings"
    private Button btnAddBookings; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditBookings"
    private Button btnEditBookings; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteBookings"
    private Button btnDeleteBookings; // Value injected by FXMLLoader

    @FXML // fx:id="tvBookings"
    private TableView<?> tvBookings; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingId"
    private TableColumn<?, ?> colBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingDate"
    private TableColumn<?, ?> colBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingNo"
    private TableColumn<?, ?> colBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="colTravelerCount"
    private TableColumn<?, ?> colTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="colTripTypeId"
    private TableColumn<?, ?> colTripTypeId; // Value injected by FXMLLoader

    @FXML // fx:id="colPackageId"
    private TableColumn<?, ?> colPackageId; // Value injected by FXMLLoader

    @FXML // fx:id="tab3"
    private Tab tab3; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddPackages"
    private Button btnAddPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditPackages"
    private Button btnEditPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeletePackages"
    private Button btnDeletePackages; // Value injected by FXMLLoader

    @FXML // fx:id="tvPackages"
    private TableView<?> tvPackages; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgName"
    private TableColumn<?, ?> colPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgStartDate"
    private TableColumn<?, ?> colPkgStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgEndDate"
    private TableColumn<?, ?> colPkgEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgDesc"
    private TableColumn<?, ?> colPkgDesc; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgBasePrice"
    private TableColumn<?, ?> colPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="colPkgAgencyCommission"
    private TableColumn<?, ?> colPkgAgencyCommission; // Value injected by FXMLLoader

    @FXML // fx:id="tab4"
    private Tab tab4; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddProducts"
    private Button btnAddProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditProducts"
    private Button btnEditProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteProducts"
    private Button btnDeleteProducts; // Value injected by FXMLLoader

    @FXML // fx:id="tvProducts"
    private TableView<?> tvProducts; // Value injected by FXMLLoader

    @FXML // fx:id="colProductId"
    private TableColumn<?, ?> colProductId; // Value injected by FXMLLoader

    @FXML // fx:id="colProductName"
    private TableColumn<?, ?> colProductName; // Value injected by FXMLLoader

    @FXML // fx:id="tab5"
    private Tab tab5; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddInvoices"
    private Button btnAddInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditInvoices"
    private Button btnEditInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteInvoices"
    private Button btnDeleteInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="tvInvoices"
    private TableView<?> tvInvoices; // Value injected by FXMLLoader

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
    void btnProducts_OnClick(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnCustomers != null : "fx:id=\"btnCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnInvoices != null : "fx:id=\"btnInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lbCustomers != null : "fx:id=\"lbCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblBookings != null : "fx:id=\"lblBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblPackages != null : "fx:id=\"lblPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblInvoices != null : "fx:id=\"lblInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tpMain != null : "fx:id=\"tpMain\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab0 != null : "fx:id=\"tab0\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab1 != null : "fx:id=\"tab1\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddCustomers != null : "fx:id=\"btnAddCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditCustomers != null : "fx:id=\"btnEditCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteCustomers != null : "fx:id=\"btnDeleteCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustomerId != null : "fx:id=\"colCustomerId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustFirstName != null : "fx:id=\"colCustFirstName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustLastName != null : "fx:id=\"colCustLastName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustAddress != null : "fx:id=\"colCustAddress\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCity != null : "fx:id=\"colCustCity\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustCountry != null : "fx:id=\"colCustCountry\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustBusPhone != null : "fx:id=\"colCustBusPhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustEmail != null : "fx:id=\"colCustEmail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert col != null : "fx:id=\"col\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddBookings != null : "fx:id=\"btnAddBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditBookings != null : "fx:id=\"btnEditBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteBookings != null : "fx:id=\"btnDeleteBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookings != null : "fx:id=\"tvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingId != null : "fx:id=\"colBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDate != null : "fx:id=\"colBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingNo != null : "fx:id=\"colBookingNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTravelerCount != null : "fx:id=\"colTravelerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripTypeId != null : "fx:id=\"colTripTypeId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab3 != null : "fx:id=\"tab3\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddPackages != null : "fx:id=\"btnAddPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditPackages != null : "fx:id=\"btnEditPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeletePackages != null : "fx:id=\"btnDeletePackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvPackages != null : "fx:id=\"tvPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgName != null : "fx:id=\"colPkgName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgStartDate != null : "fx:id=\"colPkgStartDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgEndDate != null : "fx:id=\"colPkgEndDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgDesc != null : "fx:id=\"colPkgDesc\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgBasePrice != null : "fx:id=\"colPkgBasePrice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPkgAgencyCommission != null : "fx:id=\"colPkgAgencyCommission\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab4 != null : "fx:id=\"tab4\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddProducts != null : "fx:id=\"btnAddProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditProducts != null : "fx:id=\"btnEditProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteProducts != null : "fx:id=\"btnDeleteProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvProducts != null : "fx:id=\"tvProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colProductId != null : "fx:id=\"colProductId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colProductName != null : "fx:id=\"colProductName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab5 != null : "fx:id=\"tab5\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddInvoices != null : "fx:id=\"btnAddInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditInvoices != null : "fx:id=\"btnEditInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteInvoices != null : "fx:id=\"btnDeleteInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvInvoices != null : "fx:id=\"tvInvoices\" was not injected: check your FXML file 'main-view.fxml'.";

    }
}
