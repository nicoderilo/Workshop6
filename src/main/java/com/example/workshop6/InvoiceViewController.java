/**
 * Sample Skeleton for 'invoice-view.fxml' Controller Class
 */

package com.example.workshop6;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.text.*;
import java.awt.print.PrinterException;
import javafx.print.Printer;

public class InvoiceViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tfCustFirstNameInv"
    private TextField tfCustFirstNameInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustEmailInv"
    private TextField tfCustEmailInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingDateInv"
    private TextField tfBookingDateInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingNoInv"
    private TextField tfBookingNoInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfTripStartInv"
    private TextField tfTripStartInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfTripEndInv"
    private TextField tfTripEndInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfDescriptionInv"
    private TextField tfDescriptionInv; // Value injected by FXMLLoader

    @FXML // fx:id="tfBasePriceInv"
    private TextField tfBasePriceInv; // Value injected by FXMLLoader

    @FXML // fx:id="taAll"
    private TextArea taAll; // Value injected by FXMLLoader

    @FXML // fx:id="btnSendEmail"
    private Button btnSendEmail; // Value injected by FXMLLoader


    @FXML // fx:id="btnPrint"
    private Button btnPrint; // Value injected by FXMLLoader

    @FXML
    void btnPrint_OnClick(ActionEvent event) {
        try {
            //taAll.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnSendEmail_Onclick(ActionEvent event) {
       // SendMail SE = new SendMail(tfCustEmailInv.getText(), tfBookingNoInv.getText(),tfBasePriceInv.getText());
        SendMail SE = new SendMail(tfCustEmailInv.getText(), ( "Your invoice No: INV"+ tfBookingNoInv.getText()),taAll.getText());
    }
    public ObservableList<Invoices_View> data = FXCollections.observableArrayList();
    public void setInvoiceViewData(ObservableList<Invoices_View> data) {
        this.data = data ;
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tfCustFirstNameInv != null : "fx:id=\"tfCustFirstNameInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfCustEmailInv != null : "fx:id=\"tfCustEmailInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfBookingDateInv != null : "fx:id=\"tfBookingDateInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfBookingNoInv != null : "fx:id=\"tfBookingNoInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfTripStartInv != null : "fx:id=\"tfTripStartInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfTripEndInv != null : "fx:id=\"tfTripEndInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfDescriptionInv != null : "fx:id=\"tfDescriptionInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfBasePriceInv != null : "fx:id=\"tfBasePriceInv\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert tfCustEmailInv != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert taAll != null : "fx:id=\"taAll\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert btnSendEmail != null : "fx:id=\"btnSendEmail\" was not injected: check your FXML file 'invoice-view.fxml'.";
        assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'invoice-view.fxml'.";


    }

    public void displayInvoice(Invoices_View iv, int i) {
        //mode = "update";
        this.tfCustFirstNameInv.setText(iv.getCustFirstNameInv());
        this.tfCustEmailInv.setText(iv.getCustEmailInv());
        this.tfBookingDateInv.setText(iv.getBookingDateInv());
        this.tfBookingNoInv.setText(iv.getBookingNoInv());
        this.tfTripStartInv.setText(iv.getTripStartInv());
        this.tfTripEndInv.setText(iv.getTripEndInv());
        this.tfDescriptionInv.setText(iv.getDescriptionInv());
        this.tfBasePriceInv.setText(iv.getBasePriceInv());
        this.taAll.setText("Hello, " + iv.getCustFirstNameInv() + "! \n\n"+ "Thank you for choosing us! \n\n" + "Invoice Number    : "+ "INV" +iv.getBookingNoInv() +"\n" + "Total Amount     : $" + iv.getBasePriceInv() );
        int index = i;
    }
}
