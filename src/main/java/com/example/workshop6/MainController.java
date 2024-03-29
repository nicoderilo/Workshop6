/**
 * GROUP 1 JAVAFX GUI for travel agents that allows data manipultion
 * of Customers, Bookings, Packages, Products, Invoices
 * Includes feature to e-mail invoices to customers
 * TEAM MEMBERS - Group 1
 * Nico Derilo
 * Aidan Goguen
 * Sai Shalini Karaikatte Venugopal
 * Stan Abana
 */

package com.example.workshop6;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML // fx:id="lbCustomers"
    private Label lblCustomers; // Value injected by FXMLLoader

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
    private TableView<Customer> tvCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="colCustomerId"
    private TableColumn<Customer, Integer> colCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="colCustFirstName"
    private TableColumn<Customer, String> colCustFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="colCustLastName"
    private TableColumn<Customer, String> colCustLastName; // Value injected by FXMLLoader

    @FXML // fx:id="colCustAddress"
    private TableColumn<Customer, String> colCustAddress; // Value injected by FXMLLoader

    @FXML // fx:id="colCustCity"
    private TableColumn<Customer, String> colCustCity; // Value injected by FXMLLoader

    @FXML // fx:id="colCustProv"
    private TableColumn<Customer, String> colCustProv; // Value injected by FXMLLoader

    @FXML // fx:id="colCustPostal"
    private TableColumn<Customer, String> colCustPostal; // Value injected by FXMLLoader

    @FXML // fx:id="colCustCountry"
    private TableColumn<Customer, String> colCustCountry; // Value injected by FXMLLoader

    @FXML // fx:id="colCustHomePhone"
    private TableColumn<Customer, String> colCustHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="colCustBusPhone"
    private TableColumn<Customer, String> colCustBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="colCustEmail"
    private TableColumn<Customer, String> colCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="colAgentId"
    private TableColumn<Customer, Integer> colAgentId; // Value injected by FXMLLoader

    @FXML // fx:id="tab2"
    private Tab tab2; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddBookings"
    private Button btnAddBookings; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditBookings"
    private Button btnEditBookings; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteBookings"
    private Button btnDeleteBookings; // Value injected by FXMLLoader

    @FXML // fx:id="tvBookings"
    private TableView<Booking> tvBookings; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingId"
    private TableColumn<Booking, Integer> colBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingDate"
    private TableColumn<Booking, String> colBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingNo"
    private TableColumn<Booking, String> colBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="colTravelerCount"
    private TableColumn<Booking, Integer> colTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="colCustomerId2"
    private TableColumn<Booking, Integer> colCustomerId2; // Value injected by FXMLLoader

    @FXML // fx:id="colTripTypeId"
    private TableColumn<Booking, String> colTripTypeId; // Value injected by FXMLLoader

    @FXML // fx:id="colPackageId2"
    private TableColumn<Booking, Integer> colPackageId2; // Value injected by FXMLLoader

    @FXML // fx:id="tab3"
    private Tab tab3; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddPackages"
    private Button btnAddPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditPackages"
    private Button btnEditPackages; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeletePackages"
    private Button btnDeletePackages; // Value injected by FXMLLoader

    @FXML // fx:id="tvPackages"
    private TableView<Package> tvPackages; // Value injected by FXMLLoader
    @FXML // fx:id="colPackageId"
    private TableColumn<Package, Integer> colPackageId; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgName"
    private TableColumn<Package, String> colPkgName; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgStartDate"
    private TableColumn<Package, String> colPkgStartDate; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgEndDate"
    private TableColumn<Package, String> colPkgEndDate; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgDesc"
    private TableColumn<Package, String> colPkgDesc; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgBasePrice"
    private TableColumn<Package, String> colPkgBasePrice; // Value injected by FXMLLoader
    @FXML // fx:id="colPkgAgencyCommission"
    private TableColumn<Package, String> colPkgAgencyCommission; // Value injected by FXMLLoader
    @FXML // fx:id="tab4"
    private Tab tab4; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddProducts"
    private Button btnAddProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditProducts"
    private Button btnEditProducts; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteProducts"
    private Button btnDeleteProducts; // Value injected by FXMLLoader

    @FXML // fx:id="tvProducts"
    private TableView<Products> tvProducts; // Value injected by FXMLLoader

    @FXML // fx:id="colProductId"
    private TableColumn<Products, Integer> colProductId; // Value injected by FXMLLoader

    @FXML // fx:id="colProductName"
    private TableColumn<Products, String> colProductName; // Value injected by FXMLLoader

    @FXML // fx:id="tab5"
    private Tab tab5; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddInvoices"
    private Button btnAddInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditInvoices"
    private Button btnEditInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteInvoices"
    private Button btnDeleteInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="tvInvoices"
    private TableView<Invoices_View> tvInvoices; // Value injected by FXMLLoader

    @FXML // fx:id="colCustFirstNameInv"
    private TableColumn<Invoices_View, String> colCustFirstNameInv; // Value injected by FXMLLoader

    @FXML // fx:id="colCustEmailInv"
    private TableColumn<Invoices_View, String> colCustEmailInv; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingDateInv"
    private TableColumn<Invoices_View, String> colBookingDateInv; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingNoInv"
    private TableColumn<Invoices_View, String> colBookingNoInv; // Value injected by FXMLLoader

    @FXML // fx:id="colTripStartInv"
    private TableColumn<Invoices_View, String> colTripStartInv; // Value injected by FXMLLoader

    @FXML // fx:id="colTripEndInv"
    private TableColumn<Invoices_View, String> colTripEndInv; // Value injected by FXMLLoader

    @FXML // fx:id="colDescriptionInv"
    private TableColumn<Invoices_View, String> colDescriptionInv; // Value injected by FXMLLoader

    @FXML // fx:id="colBasePriceInv"
    private TableColumn<Invoices_View, String> colBasePriceInv; // Value injected by FXMLLoader //   <-- folded to make the code short. click the + to expand

    /**
     * Author: Stan Abana
     * Add booking on button click
     */
    @FXML
    void btnAddBookings_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("editbookingdialog.fxml"));
        Parent root1 = fxmlLoader.load();
        EditBookingDialogController ebdc = fxmlLoader.getController();
        ebdc.setBookingData(tvBookings.getItems());
        ebdc.addBooking();
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Booking");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        lblBookings.setText("Bookings: " + tvBookings.getItems().size());
    }

    /**
     * Author: Nico Derilo
     * Add Customer on button click
     */
    @FXML
    void btnAddCustomers_Onclick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editcustomer.fxml"));
        Parent parent = fxmlLoader.load();
        EditCustomerController editCustomerController = fxmlLoader.<EditCustomerController>getController();
        editCustomerController.lblCustomers.setText("Add Customer");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        stage.close();

        displayCounts();
        getCustomers();
    }

    /**
     * Author: Nico Derilo
     * Opens 2nd form that shows invoice details of the customer
     */

    //VIEW INVOICES
    @FXML
    void btnAddInvoices_OnClick(ActionEvent event) throws IOException {
        int selectedIndex = tvInvoices.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            Invoices_View iv = this.Invoices_ViewData.get(selectedIndex);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("invoice-view.fxml"));
            Parent root1 = fxmlLoader.load();
            InvoiceViewController ivc = fxmlLoader.getController();
            ivc.setInvoiceViewData(tvInvoices.getItems());
            ivc.displayInvoice(iv, selectedIndex);
            Stage stage = new Stage();
            //set what you want on your stage
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.setTitle("Edit Package");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }
    }

    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Code to Add package on button click
     * Opens the Package view in Insert mode to allow addition of packages
     * Calls the method addPackage in the package view controller
     */
    @FXML
    void btnAddPackages_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new
        FXMLLoader(getClass().getResource("package-view.fxml"));
        Parent root1 = fxmlLoader.load();
        PackageViewController pvc = fxmlLoader.getController();
        pvc.setPackageData(tvPackages.getItems());
        pvc.addPackage();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Package");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.showAndWait();
        displayCounts();
    }

    @FXML
    void btnAddProducts_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("Product-view.fxml"));
        Parent parent = fxmlLoader.load();
        ProductViewController productController = fxmlLoader.getController();
        productController.setProductData(tvProducts.getItems());
        productController.addProduct();
        Stage stage = new Stage();
        //set what you want on your stage
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Product");
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.show();

        displayCounts();
        LoadProducts();
    }

    /**
     * Author: Stan Abana
     * Delete booking on button click
     */
    @FXML
    void btnDeleteBookings_OnClick(ActionEvent event) throws SQLException {
        int selectedIndex = tvBookings.getSelectionModel().getSelectedIndex();
        if (selectedIndex >=0) {
            int bookingId = tvBookings.getSelectionModel().getSelectedItem().getBookingId();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete confirmation Dialog");
            alert.setContentText("Deleting booking will delete corresponding bookingdetails. Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deleteBooking(bookingId);
                tvBookings.getItems().remove(selectedIndex);
                lblBookings.setText("Bookings: " + tvBookings.getItems().size());
            } else {
                alert.close();
            }

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }

    }
    /**
     * Author: Nico Derilo
     * Delete Customer on button click
     */
    @FXML
    void btnDeleteCustomers_OnClick(ActionEvent event) throws SQLException {
        int selectedIndex = tvCustomers.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Customer");
            alert.setHeaderText("Delete");
            alert.setContentText("Are you sure you want to delete this customer?");
            displayCounts();

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
                Customer customer = tvCustomers.getSelectionModel().getSelectedItem();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM `customers` WHERE `CustomerId` = "+customer.getCustomerId());
                stmt.execute();
                displayCounts();
                getCustomers();

            } else {

            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }
        displayCounts();

    }

    @FXML
    void btnDeleteInvoices_OnClick(ActionEvent event) {

    }
    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Code to Delete package on button click
     * Displays an alert and deletes package on confirmation
     * Calls the method deletePackage which deletes the selected package from the database
     */
    @FXML
    void btnDeletePackages_OnClick(ActionEvent event) {
        int selectedIndex = tvPackages.getSelectionModel().getSelectedIndex();
        if (selectedIndex >=0) {
            String pkgId = tvPackages.getSelectionModel().getSelectedItem().getPkgId();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Delete confirmation Dialog");
                alert.setContentText("Deleting package will delete corresponding product-supplers and bookings. Are you sure?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    deletePackage(pkgId);
                    tvPackages.getItems().remove(selectedIndex);

                    displayCounts();
                    //getPackages();
                    //lblPackages.setText("Packages:" + tvPackages.getItems().size());
                } else {
                    alert.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }
    }


    @FXML
    void btnDeleteProducts_OnClick(ActionEvent event) {
        int selectedIndex = tvProducts.getSelectionModel().getSelectedIndex();
        if (selectedIndex >=0) {
            String ProductId = String.valueOf(tvProducts.getSelectionModel().getSelectedItem().getProductId());
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Delete confirmation Dialog");
                alert.setContentText("Confirm deletion of product");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    deleteProduct(ProductId);
                    tvProducts.getItems().remove(selectedIndex);
                } else {
                    alert.close();
                }

                displayCounts();
                LoadProducts();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }

    }

    /**
     * Author: Stan Abana
     * Edit booking on button click
     */
    @FXML
    void btnEditBookings_OnClick(ActionEvent event) throws IOException {
        int selectedIndex = tvBookings.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            Booking b = this.BookingData.get(selectedIndex);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editbookingdialog.fxml"));
            Parent root1 = fxmlLoader.load();
            EditBookingDialogController ebdc = fxmlLoader.getController();
            ebdc.setBookingData(tvBookings.getItems());
            ebdc.displayBooking(b, selectedIndex);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Booking");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
        else
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }

    }
    /**
     * Author: Nico Derilo
     * Calls 2nd form form in edit mode.
     */
    @FXML
    void btnEditCustomers_OnClick(ActionEvent event) {
        int selectedIndex = tvCustomers.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0){
            try {
                onCustomerOpenDialog(tvCustomers.getSelectionModel().getSelectedIndex());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }

    }

    @FXML
    void btnEditInvoices_OncClick(ActionEvent event) {

    }
    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Code to Edit package on button click
     * Opens the Package view in update mode to allow changes to packages
     * Calls the method displayPackage() in the package view controller and passes the selected package
     */
    @FXML
    void btnEditPackages_OnClick(ActionEvent event) throws IOException {
        int selectedIndex = tvPackages.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            Package p = this.PackageData.get(selectedIndex);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("package-view.fxml"));
            Parent root1 = fxmlLoader.load();
            PackageViewController pvc = fxmlLoader.getController();
            pvc.setPackageData(tvPackages.getItems());
            pvc.displayPackage(p, selectedIndex);
            Stage stage = new Stage();
            //set what you want on your stage
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Package");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No rows selected!");
            alert.showAndWait();
        }
    }

    @FXML
    void btnEditProducts_OnClick(ActionEvent event) throws IOException {
        int selectedIndex = tvProducts.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
           Products prod = this.ProductData.get(selectedIndex);
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Product-view.fxml"));
           Parent parent = fxmlLoader.load();
           ProductViewController productController = fxmlLoader.getController();
           productController.setProductData(tvProducts.getItems());
           productController.displayProduct(prod, selectedIndex);
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Edit Products");
           stage.setScene(new Scene(parent));
           stage.show();
        }
        else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("No selected data");
        alert.showAndWait();
        }


    }

    @FXML
    void btnHome_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab0);
    }
    @FXML
    void btnCustomers_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab1);
    }
    @FXML
    void btnBookings_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab2);
    }
    @FXML
    void btnPackages_OnClick(ActionEvent event) { tpMain.getSelectionModel().select(tab3);
    }
    @FXML
    void btnProducts_OnClick(ActionEvent event) { tpMain.getSelectionModel().select(tab4);
    }

    @FXML
    void btnInvoices_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab5);
    } // <-- folded to make the code short. Click + to expand.


    private ObservableList<Customer> CustomerData = FXCollections.observableArrayList();
    private ObservableList<Booking> BookingData = FXCollections.observableArrayList();
    public ObservableList<Package> PackageData = FXCollections.observableArrayList();
    public ObservableList<Products> ProductData = FXCollections.observableArrayList();
    public ObservableList<Invoices_View> Invoices_ViewData = FXCollections.observableArrayList();

    //HOVERS EFFECTS - START
    @FXML
    void btnBookings_OnEntered(MouseEvent event) {
        btnBookings.setStyle("-fx-background-color: #0099cc");
    }

    @FXML
    void btnBookings_OnExited(MouseEvent event) {
        btnBookings.setStyle("-fx-background-color:  #0086b3");
    }

    @FXML
    void btnCustomers_OnExit(MouseEvent event) {
        btnCustomers.setStyle("-fx-background-color:  #0086b3");
    }

    @FXML
    void btnCustomers_OnEntered(MouseEvent event) {
        btnCustomers.setStyle("-fx-background-color: #0099cc");
    }

    @FXML
    void btnPackages_OnEntered(MouseEvent event) {
        btnPackages.setStyle("-fx-background-color: #0099cc");
    }

    @FXML
    void btnPackages_OnExited(MouseEvent event) {
        btnPackages.setStyle("-fx-background-color:  #0086b3");
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
    void btnInvoice_OnEntered(MouseEvent event) {
        btnInvoices.setStyle("-fx-background-color:  #0099cc");
    }

    @FXML
    void btnInvoice_OnExited(MouseEvent event) {
        btnInvoices.setStyle("-fx-background-color:  #0086b3");
    }

    @FXML
    void btnProducts_OnEntered(MouseEvent event) {
        btnProducts.setStyle("-fx-background-color: #0099cc");
    }

    @FXML
    void btnProducts_OnExited(MouseEvent event) {
        btnProducts.setStyle("-fx-background-color:  #0086b3");
    }
    //HOVERS EFFECTS - END // <-- Hover button effects.Folded to make the code short. Click + to expand.

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnCustomers != null : "fx:id=\"btnCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnInvoices != null : "fx:id=\"btnInvoices\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lblCustomers != null : "fx:id=\"lblCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
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
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab2 != null : "fx:id=\"tab2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddBookings != null : "fx:id=\"btnAddBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditBookings != null : "fx:id=\"btnEditBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteBookings != null : "fx:id=\"btnDeleteBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvBookings != null : "fx:id=\"tvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingId != null : "fx:id=\"colBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDate != null : "fx:id=\"colBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingNo != null : "fx:id=\"colBookingNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTravelerCount != null : "fx:id=\"colTravelerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustomerId2 != null : "fx:id=\"colCustomerId2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripTypeId != null : "fx:id=\"colTripTypeId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPackageId2 != null : "fx:id=\"colPackageId2\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tab3 != null : "fx:id=\"tab3\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddPackages != null : "fx:id=\"btnAddPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditPackages != null : "fx:id=\"btnEditPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeletePackages != null : "fx:id=\"btnDeletePackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tvPackages != null : "fx:id=\"tvPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'main-view.fxml'.";
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
        assert colCustFirstNameInv != null : "fx:id=\"colCustFirstNameInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colCustEmailInv != null : "fx:id=\"colCustEmailInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingDateInv != null : "fx:id=\"colBookingDateInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBookingNoInv != null : "fx:id=\"colBookingNoInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripStartInv != null : "fx:id=\"colTripStartInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colTripEndInv != null : "fx:id=\"colTripEndInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colDescriptionInv != null : "fx:id=\"colDescriptionInv\" was not injected: check your FXML file 'main-view.fxml'.";
        assert colBasePriceInv != null : "fx:id=\"colBasePriceInv\" was not injected: check your FXML file 'main-view.fxml'.";  //   <-- folded to make the code short. click the + to expand

        displayCounts();
        getCustomers();
        getBookings();
        getPackages();
        getInvoices_View();
        LoadProducts();

    }

    /**
     * Author: Nico derilo
     * gets the selected value from customers tableview and
     * displays Customer data in EditCustomerController.
     * Change text to Update Customer
     */

    private void onCustomerOpenDialog(int selectedIndex) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editcustomer.fxml"));
        Parent parent = fxmlLoader.load();
        EditCustomerController editCustomerController = fxmlLoader.<EditCustomerController>getController();
        editCustomerController.lblCustomers.setText("Update Customer");
        editCustomerController.setCustomerObservableList(CustomerData);
        editCustomerController.setCustomerSelectedIndex(selectedIndex);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private void LoadProducts() {
        String username = "";
        String password = "";
        String url = "";
        try{
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            while (rs.next()){
                ProductData.add(new Products(rs.getInt(1), rs.getString(2)));
                colProductId.setCellValueFactory(new PropertyValueFactory<Products, Integer>("ProductId"));
                colProductName.setCellValueFactory(new PropertyValueFactory<Products, String>("ProdName"));
                tvProducts.setItems(ProductData);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void deleteProduct(String ProductId) throws SQLException {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
            displayCounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = String.format("delete from Products where ProductId = ?");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ProductId);
            ps.execute();
            System.out.println("Deleted");
            tvProducts.setItems(ProductData);
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Author: Nico Derilo
     * Method that connects to the database, fetch existing Customers and displays
     * them on a table view on application load
     */
    private void getCustomers() {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            while (rs.next())
            {
                CustomerData.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12)));
                colCustomerId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("CustomerId"));
                colCustFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustFirstName"));
                colCustLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustLastName"));
                colCustAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustAddress"));
                colCustCity.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustCity"));
                colCustProv.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustProv"));
                colCustPostal.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustPostal"));
                colCustCountry.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustCountry"));
                colCustHomePhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustHomePhone"));
                colCustBusPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustBusPhone"));
                colCustEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("CustEmail"));
                colAgentId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("AgentId"));
                tvCustomers.setItems(CustomerData);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//getCustomers - End

    /**
     * Author: Stan Abana
     * Method that connects to the database, fetch existing bookings and displays
     * them on a table view on application load
     */
    private void getBookings(){
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bookings");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            while (rs.next())
            {
                BookingData.add(new Booking(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
                colBookingId.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingId"));
                colBookingDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingDate"));
                colBookingNo.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingNo"));
                colTravelerCount.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("travelerCount"));
                colCustomerId2.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("customerId"));
                colTripTypeId.setCellValueFactory(new PropertyValueFactory<Booking, String>("tripTypeId"));
                colPackageId2.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("packageId"));
                tvBookings.setItems(BookingData);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//getBookings - End

    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Method getPackages() that establishes connection to database
     * Fetches all available packages and displays in the table view
     */
    private void getPackages() {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from packages");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            while (rs.next())
            {
                PackageData.add(new Package(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7)));
                colPackageId.setCellValueFactory(new PropertyValueFactory<Package, Integer>("pkgId"));
                colPkgName.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgName"));
                colPkgStartDate.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgStartDate"));
                colPkgEndDate.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgEndDate"));
                colPkgDesc.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgDescription"));
                colPkgBasePrice.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgBasePrice"));
                colPkgAgencyCommission.setCellValueFactory(new PropertyValueFactory<Package, String>("pkgAgencyCommission"));
                tvPackages.setItems(PackageData);
            }
            tvPackages.setOnMouseClicked(event -> {events();});
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//getPackages - End*/
    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Method events() that disables edit and delete buttons until packages is selected
     */
    private void events() {
        int selectedIndex = tvPackages.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            btnEditPackages.setDisable(false);
            btnDeletePackages.setDisable(false);
        }
    }
    /**
     * Author: Sai Shalini Karaikatte Venugopal
     * Method deletePackage() that connects to the database and deletes selected package
     * Deletes related data from related tables with foreign key constraints
     */
    private void deletePackage(String pkgId) throws SQLException {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
            displayCounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql2 = String.format("delete from Bookings where PackageId = ?");
            String sql1 = String.format("delete from Packages_Products_Suppliers where PackageId = ?");
            String  sql = String.format("delete from Packages where PackageId = ?");
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps2.setString(1, pkgId);
            ps1.setString(1, pkgId);
            ps.setString(1, pkgId);
            ps2.execute();
            ps1.execute();
            ps.execute();
            System.out.println("Deleted");
            tvPackages.setItems(PackageData);
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Author: Stan Abana
     * Method that deletes selected record from the booking table and related table with foreign key constraints
     */
    private void deleteBooking(int bookingId) throws SQLException  {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sqla = String.format("delete from BookingDetails where BookingId = ?");
            String  sql = String.format("delete from bookings where BookingId = ?");
            PreparedStatement preparedStatement1 = conn.prepareStatement(sqla);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement1.setInt(1, bookingId);
            preparedStatement.setInt(1, bookingId);

            preparedStatement1.execute();
            preparedStatement.execute();

            System.out.println("Deleted");
            tvBookings.setItems(BookingData);
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * Author: Nico Derilo
     * Calls Invoice_View VIEW that I created from mysql database and display it to textview
     */
    private void getInvoices_View() {
        String username = "";
        String password = "";
        String url = "";
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user");
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from invoices_view");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());
            while (rs.next())
            {
                Invoices_ViewData.add(new Invoices_View(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                colCustFirstNameInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("CustFirstNameInv"));
                colCustEmailInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("CustEmailInv"));
                colBookingDateInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("BookingDateInv"));
                colBookingNoInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("BookingNoInv"));
                colTripStartInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("TripStartInv"));
                colTripEndInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("TripEndInv"));
                colDescriptionInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("DescriptionInv"));
                colBasePriceInv.setCellValueFactory(new PropertyValueFactory<Invoices_View, String>("BasePriceInv"));
                tvInvoices.setItems(Invoices_ViewData);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * this function will COUNT total number of rows for tables customer, bookings,packages, invoices.
     */
    private void displayCounts() {
        try {
            lblCustomers.setText( "Customers  "+ Integer.toString((MyFunction.countData("customers"))));
            lblBookings.setText( "Bookings  "+ Integer.toString((MyFunction.countData("bookings"))));
            lblPackages.setText( "Packages  "+ Integer.toString((MyFunction.countData("packages"))));
            lblInvoices.setText( "Invoices  "+ Integer.toString((MyFunction.countData("Invoices_View"))));
        } catch (SQLException e) {
            e.printStackTrace();
        } //Display Total Counts
    }

}
