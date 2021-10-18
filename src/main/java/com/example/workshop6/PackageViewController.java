/**
 * Sample Skeleton for 'package-view.fxml' Controller Class
 */

package com.example.workshop6;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @FXML
    void onClickCancel(MouseEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

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

    public void addPackage() {
        mode= "insert";
        vbPkgId.setVisible(false);
    }
    public boolean validate() throws ParseException {

        StringBuilder errors = new StringBuilder();

        // Confirm mandatory fields are filled out
        if (tfPkgName.getText().trim().isEmpty()) {
            errors.append("- Please enter a Package name.\n");
        }

       if( isEmpty(tfPkgStartDate.getText())){
            tfPkgStartDate.setText(null);
        } else {
            if (!(tfPkgStartDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)"))) {
                errors.append("- Please enter a valid Start date in the format YYYY-MM-DD.\n");
            }

        }
        if(isEmpty(tfPkgEndDate.getText())){
            tfPkgEndDate.setText(null);
        }else {
            if (!(tfPkgEndDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)"))) {
                errors.append("- Please enter a valid End date in the format YYYY-MM-DD.\n");
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

        if(!isEmpty(tfPkgStartDate.getText()) && !isEmpty(tfPkgEndDate.getText())) {
            if (tfPkgStartDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)") &&
                    tfPkgEndDate.getText().matches("\\d{4}-\\d{2}-\\d{2}(?:(?:\\s([0-1]\\d|[2][0-3])\\:([0-5]\\d)(?::([0-5]\\d))?)?)")) {
                if (sdf.parse(tfPkgStartDate.getText()).compareTo(sdf.parse(tfPkgEndDate.getText())) > 0) {
                    errors.append("- Start date is after End date.\n");
                }
            }
        }

        if (tfPkgBasePrice.getText().trim().isEmpty()) {
            errors.append("- Please enter Base Price.\n");
        }

        if (!tfPkgBasePrice.getText().trim().isEmpty() && !tfPkgBasePrice.getText().matches("[1-9]\\d*(\\.\\d+)?"))
        {
            errors.append("- Please enter Base Price as an Integer or Decimal.\n");
        }

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
    boolean isEmpty(String val) {
        if (val == null || val.isEmpty()) {
            return true;
        }
        return false;
    }

}
