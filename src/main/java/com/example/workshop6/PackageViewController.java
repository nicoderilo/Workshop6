/**
 * Author: Sai Shalini Karaikatte Venugopal
 * Date: 2021/10/18
 * Course Module: PROJ207A_CMPP264_Java_Workshop6
 * Assignment name: Threaded Project for OOSD_Term3_Workshop6_Group1
 */


/**
 * Skeleton for 'package-view.fxml' Controller Class
 * Consists of Package details which allows addition or update of Packages
 */

package com.example.workshop6;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;

public class PackageViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private VBox vbPkgId;

    @FXML // fx:id="lblAgtName"
    private Label lblAgtName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPackageId"
    private TextField tfPackageId; // Value injected by FXMLLoader

    @FXML // fx:id="btnSave"
    private Button btnSave; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="lblPkgName"
    private Label lblPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="lblPkgStartDate"
    private Label lblPkgStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="lblEndDate"
    private Label lblEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="lblPkgDescription"
    private Label lblPkgDescription; // Value injected by FXMLLoader

    @FXML // fx:id="lblPkgBasePrice"
    private Label lblPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="lblAgencyCommission"
    private Label lblAgencyCommission; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgName"
    private TextField tfPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgStartDate"
    private TextField tfPkgStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgEndDate"
    private TextField tfPkgEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgDescription"
    private TextField tfPkgDescription; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgBasePrice"
    private TextField tfPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgencyCommission"
    private TextField tfAgencyCommission; // Value injected by FXMLLoader
    private String mode = "";
    public ObservableList<Package> data = FXCollections.observableArrayList();
    public int index;
    public int l1 = 50;
    private MainController mc;
    public void setPackageData(ObservableList<Package> data) {
        this.data = data ;
    }

    /**
     * If Cancel button is clicked closes the package view
     */
    @FXML
    void onClickCancel(MouseEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Code to Save package details on button click
     * Establishes connection to database and inserts or updates the Packages table according to the mode
     * Calls the method validate() to ensure that false data is not entered into the database
     * @throws ParseException
     */
    @FXML
    void onClickSave(MouseEvent event) throws ParseException {
        boolean valid = validate();
        if (valid) {
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
                if (mode == "update") {
                    PreparedStatement stmt = conn.prepareStatement("UPDATE `Packages` SET `PkgName`=?,`PkgStartDate`=?,`PkgEndDate`=?,`PkgDesc`=?,`PkgBasePrice`=?,`PkgAgencyCommission`=? WHERE `PackageId`=?");
                    stmt.setString(1, this.tfPkgName.getText());
                    stmt.setString(2, this.tfPkgStartDate.getText());
                    stmt.setString(3, this.tfPkgEndDate.getText());
                    stmt.setString(4, this.tfPkgDescription.getText());
                    stmt.setString(5, this.tfPkgBasePrice.getText());
                    stmt.setString(6, this.tfAgencyCommission.getText());
                    stmt.setString(7, this.tfPackageId.getText());
                    int numRows = stmt.executeUpdate();
                    if (numRows == 0) {
                        System.out.println("update failed");
                    }
                    Package p = new Package(Integer.parseInt(tfPackageId.getText()), tfPkgName.getText(), tfPkgStartDate.getText(), tfPkgEndDate.getText(), tfPkgDescription.getText(), tfPkgBasePrice.getText(), tfAgencyCommission.getText());
                    data.set(index, p);
                    Stage stage = (Stage) btnSave.getScene().getWindow();
                    stage.close();
                } else {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO Packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission)" +
                            "VALUES (?,?,?,?,?,?)");
                    stmt.setString(1, this.tfPkgName.getText());
                    stmt.setString(2, this.tfPkgStartDate.getText());
                    stmt.setString(3, this.tfPkgEndDate.getText());
                    stmt.setString(4, this.tfPkgDescription.getText());
                    stmt.setString(5, this.tfPkgBasePrice.getText());
                    stmt.setString(6, this.tfAgencyCommission.getText());
                    int numRows = stmt.executeUpdate();
                    if (numRows == 0) {
                        System.out.println("Insert failed");
                    }
                    Statement stmt1 = conn.createStatement();
                    ResultSet rs = stmt1.executeQuery("select  PackageId from Packages");
                    int pid = 0;
                    while (rs.next()) {
                        if (rs.getInt(1) > pid) {
                            pid = rs.getInt(1);
                        }
                    }
                    Package p = new Package(pid, tfPkgName.getText(), tfPkgStartDate.getText(), tfPkgEndDate.getText(), tfPkgDescription.getText(), tfPkgBasePrice.getText(), tfAgencyCommission.getText());
                    data.add(p);
                    Stage stage = (Stage) btnSave.getScene().getWindow();
                    stage.close();

                }
            } catch (SQLException var7) {
                var7.printStackTrace();
            }
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblAgtName != null : "fx:id=\"lblAgtName\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPackageId != null : "fx:id=\"tfPackageId\" was not injected: check your FXML file 'package-view.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'package-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblPkgName != null : "fx:id=\"lblPkgName\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblPkgStartDate != null : "fx:id=\"lblPkgStartDate\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblEndDate != null : "fx:id=\"lblEndDate\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblPkgDescription != null : "fx:id=\"lblPkgDescription\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblPkgBasePrice != null : "fx:id=\"lblPkgBasePrice\" was not injected: check your FXML file 'package-view.fxml'.";
        assert lblAgencyCommission != null : "fx:id=\"lblAgencyCommission\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPkgStartDate != null : "fx:id=\"tfPkgStartDate\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPkgEndDate != null : "fx:id=\"tfPkgEndDate\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPkgDescription != null : "fx:id=\"tfPkgDescription\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'package-view.fxml'.";
        assert tfAgencyCommission != null : "fx:id=\"tfAgencyCommission\" was not injected: check your FXML file 'package-view.fxml'.";


    }

    /**
     * If Add button is clicked on the Main Controller this method
     * makes the text field and label for PackageId invisible
     * Sets the mode to insert
     */
    public void addPackage() {
        mode= "insert";
        vbPkgId.setVisible(false);
    }

    /**
     * If Edit button is clicked on the Main Controller this method
     * displays the details of the selected package
     * Accepts the package array and selected index as parameters
     * Sets the mode to update
     */
    public void displayPackage(Package p, int i) {
        mode = "update";
        this.tfPkgName.focusedProperty();
        this.tfPackageId.setText(p.getPkgId());
        this.tfPkgName.setText(p.getPkgName());
        this.tfPkgStartDate.setText(p.getPkgStartDate());
        this.tfPkgEndDate.setText(p.getPkgEndDate());
        this.tfPkgDescription.setText(p.getPkgDescription());
        this.tfPkgBasePrice.setText(p.getPkgBasePrice());
        this.tfAgencyCommission.setText(p.getPkgAgencyCommission());
        index= i;
    }

    /**
     * Method validate() that verifies that valid input is entered into the database
     * @return
     * @throws ParseException
     */
    public boolean validate() throws ParseException {

        StringBuilder errors = new StringBuilder();

        // Mandatory field validation
        if (tfPkgName.getText().trim().isEmpty()) {
            errors.append("- Please enter a Package name.\n");
        }

        //Validate Start Date if not empty
        if( isEmpty(tfPkgStartDate.getText())){
            tfPkgStartDate.setText(null);
        } else {
            if (!(tfPkgStartDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)"))) {
                errors.append("- Please enter a valid Start date in the format YYYY-MM-DD.\n");
            }

        }

        //Validate End Date if not empty
        if(isEmpty(tfPkgEndDate.getText())){
            tfPkgEndDate.setText(null);
        }else {
            if (!(tfPkgEndDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)"))) {
                errors.append("- Please enter a valid End date in the format YYYY-MM-DD.\n");
            }
        }

        //If Start date is not empty and is of proper date format
        //validate that Start date is not a past date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(!isEmpty(tfPkgStartDate.getText()))
        {
            if(tfPkgStartDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)"))
            {
                if(sdf.parse(String.valueOf(LocalDate.now())).compareTo(sdf.parse(tfPkgStartDate.getText().substring(0,10))) > 0) {
                    errors.append("- Start date cannot be in the past.\n");
                }
            }
        }

        //If both Start Date and End Date are entered and are valid dates
        //validate that Start Date is not greater than End Date
        if(!isEmpty(tfPkgStartDate.getText()) && !isEmpty(tfPkgEndDate.getText())) {
            if (tfPkgStartDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)") &&
                    tfPkgEndDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)")) {
                if (sdf.parse(tfPkgStartDate.getText().substring(0,10)).compareTo(sdf.parse(tfPkgEndDate.getText().substring(0,10))) > 0) {
                    errors.append("- Start date is after End date.\n");
                }
            }
        }

        //Mandatory field validation
        if (tfPkgBasePrice.getText().trim().isEmpty()) {
            errors.append("- Please enter Base Price.\n");
        }

        //Validate that Base price is an Integer or Decimal
        if (!tfPkgBasePrice.getText().trim().isEmpty() && !tfPkgBasePrice.getText().matches("[1-9]\\d*(\\.\\d+)?"))
        {
            errors.append("- Please enter Base Price as an Integer or Decimal.\n");
        }

        //If Agency commission is entered validate that it is an Integer or Decimal
        //if entered and valid , check that Agency commission is not greater than Base price
        if(isEmpty(tfAgencyCommission.getText())) {
            tfAgencyCommission.setText(null);
        }
        else if (!tfAgencyCommission.getText().matches("[0-9]\\d*(\\.\\d+)?"))
        {
            errors.append("- Please enter Agency Commission as an Integer or Decimal.\n");
        }
        else if ((Double.parseDouble(tfAgencyCommission.getText()) > Double.parseDouble(tfPkgBasePrice.getText())))
        {
            errors.append("- Agency commission cannot be greater than Base price.\n");

        }

        // If any missing information is found, show the error messages and return false
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter appropriate values");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return false;
        }
        // No errors
        return true;
    }

    /**
     * Function to check if input field is null or empty
     * @param val
     * @return
     */
    boolean isEmpty(String val) {
        if (val == null || val.isEmpty()) {
            return true;
        }
        return false;
    }

}
