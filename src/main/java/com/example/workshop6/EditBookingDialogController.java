/**
 * Sample Skeleton for 'editbookingdialog.fxml' Controller Class
 */

package com.example.workshop6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class EditBookingDialogController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblBookingId"
    private Label lblBookingId; // Value injected by FXMLLoader


    @FXML // fx:id="tfBookingId"
    private TextField tfBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingDate"
    private TextField tfBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingNo"
    private TextField tfBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="tfTravelerCount"
    private TextField tfTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="cbCustomerId2"
    private ComboBox<Customer> cbCustomerId2; // Value injected by FXMLLoader

    @FXML // fx:id="cbTripTypeId"
    private ComboBox<?> cbTripTypeId; // Value injected by FXMLLoader

    @FXML // fx:id="cbPackageId2"
    private ComboBox<Package> cbPackageId2; // Value injected by FXMLLoader

    @FXML // fx:id="btnSave"
    private Button btnSave; // Value injected by FXMLLoader
    private String mode = "";
    private ObservableList<Booking> data = FXCollections.observableArrayList();

    public void setBookingData(ObservableList<Booking> data) {
        this.data = data;
    }

    private int selectedIndex;
    private int index;

    public void displayBooking(Booking b, int selectedIndex) {
        tfBookingId.setEditable(false);  //Booking Id cannot be edited
        mode = "update";
        this.tfBookingDate.focusedProperty();
        this.tfBookingId.setText(b.getBookingId() + "");
        this.tfBookingDate.setText(b.getBookingDate());
        this.tfBookingNo.setText(b.getBookingNo());
        this.tfTravelerCount.setText(b.getTravelerCount() + "");
        this.cbCustomerId2.getValue();
        this.cbTripTypeId.getValue();
        this.cbPackageId2.getValue();
        index = selectedIndex;
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblBookingId != null : "fx:id=\"lblBookingId\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert tfBookingId != null : "fx:id=\"tfBookingId\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert tfTravelerCount != null : "fx:id=\"tfTravelerCount\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert cbCustomerId2 != null : "fx:id=\"cbCustomerId2\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert cbTripTypeId != null : "fx:id=\"cbTripTypeId\" was not injected: check your FXML file 'editbookingdialog.fxml'.";
        assert cbPackageId2 != null : "fx:id=\"cbPackageId2\" was not injected: check your FXML file 'editbookingdialog.fxml'.";

        getCustomerId();
        getPackageId();
        getTripTypeId();

        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnSaveClicked(mouseEvent);
            }
        });
    }

    private void getTripTypeId() {
        String username = "";
        String password ="";
        String url ="";

        //connect to database
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user"); //
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }//end

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            ResultSet rs = conn.createStatement().executeQuery("SELECT TripTypeId FROM Triptypes");

            ObservableList data3 = FXCollections.observableArrayList();
            while(rs.next()){
                data3.add(new String(rs.getString(1)));
            }
            cbTripTypeId.setItems(data3);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //get package id
    private void getPackageId() {
        String username = "";
        String password ="";
        String url ="";

        //connect to database
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user"); //
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }//end

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            ResultSet rs = conn.createStatement().executeQuery("SELECT PackageId FROM Packages");

            ObservableList data2 = FXCollections.observableArrayList();
            while(rs.next()){
                data2.add(new String(rs.getString(1)));
            }
            cbPackageId2.setItems(data2);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void getCustomerId() {
        String username = "";
        String password ="";
        String url ="";

        //connect to database
        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            username = (String) p.get("user"); //
            password = (String) p.get("password");
            url = (String) p.get("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }//end

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            ResultSet rs = conn.createStatement().executeQuery("SELECT CustomerId FROM Customers");

            ObservableList data1 = FXCollections.observableArrayList();
            while(rs.next()){
                data1.add(new String(rs.getString(1)));
            }
            cbCustomerId2.setItems(data1);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void btnSaveClicked(MouseEvent mouseEvent) {
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
                    PreparedStatement stmt = conn.prepareStatement("UPDATE `bookings` SET `BookingDate`=?,`BookingNo`=?,`TravelerCount`=?,`CustomerId`=?,`TripTypeId`=?,`PackageId`=? WHERE `BookingId`=?");

                    stmt.setString(1, tfBookingDate.getText());
                    stmt.setString(2, tfBookingNo.getText());
                    stmt.setInt(3, Integer.parseInt(tfTravelerCount.getText()));
                    stmt.setInt(4, Integer.parseInt(String.valueOf(cbCustomerId2.getValue())));
                    stmt.setString(5, (String) cbTripTypeId.getValue());
                    stmt.setInt(6, Integer.parseInt(String.valueOf(cbPackageId2.getValue())));
                    stmt.setInt(7, Integer.parseInt(tfBookingId.getText()));
                    int numRows = stmt.executeUpdate();

                    if (numRows == 0) {
                        System.out.println("Update Failed");
                    }

                    Booking b = new Booking(Integer.parseInt(tfBookingId.getText()), tfBookingDate.getText(), tfBookingNo.getText(), Integer.parseInt(tfTravelerCount.getText()), Integer.parseInt(String.valueOf(cbCustomerId2.getValue())), (String) cbTripTypeId.getValue(), Integer.parseInt(String.valueOf(cbPackageId2.getValue())));
                    data.set(index, b);
                    Stage stage = (Stage) btnSave.getScene().getWindow();
                    stage.close();
                } else {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO bookings (BookingDate, BookingNo, TravelerCount, CustomerId, TripTypeId, PackageId)" + "VALUES (?,?,?,?,?,?)");
                    stmt.setString(1, tfBookingDate.getText());
                    stmt.setString(2, tfBookingNo.getText());
                    stmt.setInt(3, Integer.parseInt(tfTravelerCount.getText()));
                    stmt.setInt(4, Integer.parseInt(String.valueOf(cbCustomerId2.getValue())));
                    stmt.setString(5, (String) cbTripTypeId.getValue());
                    stmt.setInt(6, Integer.parseInt(String.valueOf(cbPackageId2.getValue())));
                    int numRows = stmt.executeUpdate();
                    if (numRows == 0) {
                        System.out.println("Insert failed");
                    }

                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery("select  BookingId from Bookings");
                    int bkid = 0;
                    while (rs.next()) {
                        if (rs.getInt(1) > bkid) {
                            bkid = rs.getInt(1);
                        }
                    }
                    Booking b = new Booking(bkid, tfBookingDate.getText(), tfBookingNo.getText(), Integer.parseInt(tfTravelerCount.getText()), Integer.parseInt(String.valueOf(cbCustomerId2.getValue())), (String) cbTripTypeId.getValue(), Integer.parseInt(String.valueOf(cbPackageId2.getValue())));
                    data.add(b);
                    Stage stage = (Stage) btnSave.getScene().getWindow();
                    stage.close();

                }
            } catch (SQLException var7) {
                var7.printStackTrace();
            }
        }
    }

        public void addBooking () {
            mode = "insert";
            lblBookingId.setVisible(false);
            tfBookingId.setVisible(false);
        }


    private boolean validate() {
        StringBuilder errors = new StringBuilder();

        // Confirm mandatory fields are filled out

        if (!(tfBookingDate.getText().matches("^\\d{4}-\\d{2}-\\d{2}$"))) {
            errors.append("- Please enter a valid date in the format YYYY-MM-DD\n");
        }

        if (tfBookingNo.getText().trim().isEmpty()) {
            errors.append("- Please enter booking number.\n");
        }

        /*if (tfTravelerCount.getText().trim().isEmpty() || !tfTravelerCount.getText().matches("^[1-9]\\?[0-9]+$"))
        {
            errors.append("- Please enter a value of 1 or more.\n");
        }*/

        // If any missing information is found, show the error messages and return false
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return false;
        }
        // If there is no error
        return true;
    }
}