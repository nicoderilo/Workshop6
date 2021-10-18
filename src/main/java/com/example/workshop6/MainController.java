/**
 * Sample Skeleton for 'main-view.fxml' Controller Class
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
    private TableView<?> tvBookings; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingId"
    private TableColumn<?, ?> colBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingDate"
    private TableColumn<?, ?> colBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="colBookingNo"
    private TableColumn<?, ?> colBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="colTravelerCount"
    private TableColumn<?, ?> colTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="colCustomerId2"
    private TableColumn<?, ?> colCustomerId2; // Value injected by FXMLLoader

    @FXML // fx:id="colTripTypeId"
    private TableColumn<?, ?> colTripTypeId; // Value injected by FXMLLoader

    @FXML // fx:id="colPackageId2"
    private TableColumn<?, ?> colPackageId2; // Value injected by FXMLLoader

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
    void btnAddBookings_OnClick(ActionEvent event) {

    }

    @FXML
    void btnAddCustomers_Onclick(ActionEvent event) {

    }

    @FXML
    void btnAddInvoices_OnClick(ActionEvent event) {

    }

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
        lblPackages.setText("Packages:" + tvPackages.getItems().size());
    }

    @FXML
    void btnAddProducts_OnClick(ActionEvent event) {

    }


    @FXML
    void btnDeleteBookings_OnClick(ActionEvent event) {

    }

    @FXML
    void btnDeleteCustomers_OnClick(ActionEvent event) {

    }

    @FXML
    void btnDeleteInvoices_OnClick(ActionEvent event) {

    }

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
                    lblPackages.setText("Packages:" + tvPackages.getItems().size());
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

    }

    @FXML
    void btnEditBookings_OnClick(ActionEvent event) {

    }

    @FXML
    void btnEditCustomers_OnClick(ActionEvent event) {

    }

    @FXML
    void btnEditInvoices_OncClick(ActionEvent event) {

    }

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
    void btnEditProducts_OnClick(ActionEvent event) {

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
    void btnPackages_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab3);
    }
    @FXML
    void btnProducts_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab4);
    }
    @FXML
    void btnInvoices_OnClick(ActionEvent event) {
        tpMain.getSelectionModel().select(tab5);
    }


    private ObservableList<Customer> CustomerData = FXCollections.observableArrayList();
    public ObservableList<Package> PackageData = FXCollections.observableArrayList();

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
    //HOVERS EFFECTS - END

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
        getCustomers();
        getPackages();
        lblPackages.setText("Packages:"+tvPackages.getItems().size());
        //enablechanges();

    }



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

    private void events() {
        int selectedIndex = tvPackages.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            btnEditPackages.setDisable(false);
            btnDeletePackages.setDisable(false);
        }
    }

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

}
