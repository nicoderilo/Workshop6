/**
 * Sample Skeleton for 'editcustomer.fxml' Controller Class
 */

package com.example.workshop6;

//import java.awt.*;
//import java.awt.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditCustomerController {


    //public Label btnSave;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblCustomers"
    public Label lblCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="btnSave"
    private Button btnSave; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustomerId"
    private TextField tfCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustFirstName"
    private TextField tfCustFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustLastName"
    private TextField tfCustLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustAddress"
    private TextField tfCustAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCity"
    private TextField tfCustCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustProv"
    private TextField tfCustProv; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustPostal"
    private TextField tfCustPostal; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCountry"
    private TextField tfCustCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustHomePhone"
    private TextField tfCustHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustBusPhone"
    private TextField tfCustBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustEmail"
    private TextField tfCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentId"
    private TextField tfAgentId; // Value injected by FXMLLoader
    //private Object ObservableList;

    @FXML
    void btnCancel_OnClick(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void btnSave_Entered(MouseDragEvent event) {

    }

    @FXML
    void btnSave_Exited(MouseDragEvent event) {

    }

    @FXML
    void btnSave_OnClick(ActionEvent event) {

    }
    private ObservableList<Customer> mainData;
    private int selectedIndex;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        tfCustomerId.setEditable(false);
        assert lblCustomers != null : "fx:id=\"lblCustomers\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustProv != null : "fx:id=\"tfCustProv\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfCustPostal\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfCustBusPhone\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'editcustomer.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'editcustomer.fxml'.";

        tfCustFirstName.requestFocus();

        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    btnSaveClicked(mouseEvent);
                } catch (SQLException | ParseException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void btnSaveClicked(MouseEvent mouseEvent) throws SQLException, ParseException {
        boolean valid = validateCustomers();
        if (valid){

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            if (lblCustomers.getText() == "Update Customer")
            {
                try {
                    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
                    PreparedStatement stmt = conn.prepareStatement("UPDATE `customers` SET `CustFirstName`=?,`CustLastName`=?,`CustAddress`=?,`CustCity`=?,`CustProv`=?,`CustPostal`=?,`CustCountry`=?,`CustHomePhone`=?,`CustBusPhone`=?,`CustEmail`=?,`AgentId`=? WHERE `CustomerId`=?");
                    stmt.setString(1, tfCustFirstName.getText());
                    stmt.setString(2, tfCustLastName.getText());
                    stmt.setString(3, tfCustAddress.getText());
                    stmt.setString(4, tfCustCity.getText());
                    stmt.setString(5, tfCustProv.getText());
                    stmt.setString(6, tfCustPostal.getText());
                    stmt.setString(7, tfCustCountry.getText());
                    stmt.setString(8, tfCustHomePhone.getText());
                    stmt.setString(9, tfCustBusPhone.getText());
                    stmt.setString(10, tfCustEmail.getText());
                    stmt.setInt(11, Integer.parseInt(tfAgentId.getText()));
                    stmt.setInt(12, Integer.parseInt(tfCustomerId.getText()));
                    int numRows = stmt.executeUpdate();
                    //AlertBox
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update Customer");
                    alert.setHeaderText(null);
                    alert.setContentText("Update successful");

                    alert.showAndWait();

                    if (numRows == 0)
                    {
                        System.out.println("update failed");
                    }

                    //make an agent object to match the database update and update the tableview with it
                    mainData.set(selectedIndex, new Customer(Integer.parseInt(tfCustomerId.getText()), tfCustFirstName.getText(), tfCustLastName.getText(), tfCustAddress.getText(), tfCustCity.getText(), tfCustProv.getText(), tfCustPostal.getText(), tfCustCountry.getText(), tfCustHomePhone.getText(), tfCustBusPhone.getText(), tfCustEmail.getText(), Integer.parseInt(tfAgentId.getText())));

                    Node source = (Node) mouseEvent.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {

                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `customers`(`CustFirstName`, `CustLastName`, `CustAddress`, `CustCity`, `CustProv`, `CustPostal`, `CustCountry`, `CustHomePhone`, `CustBusPhone`, `CustEmail`, `AgentId`) VALUES ('"+tfCustFirstName.getText() +"','"+ tfCustLastName.getText() +"','"+ tfCustAddress.getText() +"','"+ tfCustCity.getText() +"','"+ tfCustProv.getText() +"','"+ tfCustPostal.getText() +"','"+ tfCustCountry.getText() +"','"+ tfCustHomePhone.getText() +"','"+ tfCustBusPhone.getText() +"','"+ tfCustEmail.getText() +"',"+ tfAgentId.getText() +")");
                stmt.executeUpdate();

                //AlertBox
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Add Customer");
                alert.setHeaderText(null);
                alert.setContentText("Add Customer '"+ tfCustFirstName.getText() +"' successful");

                alert.showAndWait();
                Node source = (Node) mouseEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }

        }



    }

    public void setCustomerObservableList(ObservableList<Customer> customerData) {
        this.mainData = customerData;
    }

    public void setCustomerSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;

        Customer c = mainData.get(selectedIndex);
        tfCustomerId.setText(c.getCustomerId() + "");
        tfCustFirstName.setText(c.getCustFirstName());
        tfCustLastName.setText(c.getCustLastName());
        tfCustAddress.setText(c.getCustAddress());
        tfCustCity.setText(c.getCustCity());
        tfCustProv.setText(c.getCustProv());
        tfCustPostal.setText(c.getCustPostal());
        tfCustCountry.setText(c.getCustCountry());
        tfCustHomePhone.setText(c.getCustHomePhone());
        tfCustBusPhone.setText(c.getCustBusPhone());
        tfCustEmail.setText(c.getCustEmail());
        tfAgentId.setText(c.getAgentId() + "");
    }

    public boolean validateCustomers() throws ParseException {

        StringBuilder errors = new StringBuilder();

        // Confirm mandatory fields are filled out
        if (tfCustFirstName.getText().trim().isEmpty()) {
            errors.append("- Please enter a Firstname.\n");
        }
        if (tfCustLastName.getText().trim().isEmpty()) {
            errors.append("- Please enter a Lastname.\n");
        }
        if (tfCustAddress.getText().trim().isEmpty()) {
            errors.append("- Please enter a Address.\n");
        }
        if (tfCustCity.getText().trim().isEmpty()) {
            errors.append("- Please enter a City.\n");
        }

        btnCancel.setTooltip(new Tooltip("AB - Alberta"));

        if (tfCustProv.getText().trim().isEmpty()) {
            errors.append("- Please enter a Province.\n");
        } else {
            if (!(tfCustProv.getText().matches("[a-zA-Z]{2}"))) {
                errors.append("- Please enter a valid Province ex: AB for Alberta\n");
            }
        }

        if (tfCustPostal.getText().trim().isEmpty()) {
            errors.append("- Please enter a Postal Code.\n");
        } //else {
        //if (!(tfCustPostal.getText().matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$"))) {
        // errors.append("- Please enter a valid Postal code\n");
        //}
        //}

        if (tfCustHomePhone.getText().trim().isEmpty()) {
            errors.append("- Please enter a Customer name.\n");
        } else {
            if (!(tfCustHomePhone.getText().matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"))) {
                errors.append("- Please enter valid phone number\n");
            }
        }
        //Business phone - Allow null
        if (!tfCustBusPhone.getText().matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"))
        {
            errors.append("- Please enter valid phone number.\n");
        }

        //EMAIL - Allow null
        if (tfCustEmail.getText().trim().isEmpty()) {
            tfCustEmail.setText("");
        } else {
            if (!tfCustEmail.getText().matches("^(.+)@(.+)$"))
            {
                errors.append("- Please enter a valid email address.\n");
            }
        }

        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return false;
        }
        // No errors
        return true;
    }

}
