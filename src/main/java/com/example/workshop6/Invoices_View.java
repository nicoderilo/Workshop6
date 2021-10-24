package com.example.workshop6;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Invoices_View {
    private  SimpleStringProperty CustFirstNameInv;
    private  SimpleStringProperty CustEmailInv;
    private  SimpleStringProperty BookingDateInv;
    private  SimpleStringProperty BookingNoInv;
    private  SimpleStringProperty TripStartInv;
    private  SimpleStringProperty TripEndInv;
    private  SimpleStringProperty DescriptionInv;
    private  SimpleStringProperty BasePriceInv;


    public Invoices_View(String custFirstNameInv,String custEmailInv, String bookingDateInv, String bookingNoInv, String tripStartInv, String tripEndInv, String descriptionInv, String basePriceInv) {
        this.CustFirstNameInv = new SimpleStringProperty(custFirstNameInv);
        this.CustEmailInv = new SimpleStringProperty(custEmailInv);
        this.BookingDateInv = new SimpleStringProperty(bookingDateInv);
        this.BookingNoInv = new SimpleStringProperty(bookingNoInv);
        this.TripStartInv = new SimpleStringProperty(tripStartInv);
        this.TripEndInv = new SimpleStringProperty(tripEndInv);
        this.DescriptionInv = new SimpleStringProperty(descriptionInv);
        this.BasePriceInv = new SimpleStringProperty(basePriceInv);

    }

    public String getCustFirstNameInv() {
        return CustFirstNameInv.get();
    }

    public SimpleStringProperty custFirstNameInvProperty() {
        return CustFirstNameInv;
    }

    public void setCustFirstNameInv(String custFirstNameInv) {
        this.CustFirstNameInv.set(custFirstNameInv);
    }

    public String getCustEmailInv() {
        return CustEmailInv.get();
    }

    public SimpleStringProperty custEmailInvProperty() {
        return CustEmailInv;
    }

    public void setCustEmailInv(String custEmailInv) {
        this.CustEmailInv.set(custEmailInv);
    }

    public String getBookingDateInv() {
        return BookingDateInv.get();
    }

    public SimpleStringProperty bookingDateInvProperty() {
        return BookingDateInv;
    }

    public void setBookingDateInv(String bookingDateInv) {
        this.BookingDateInv.set(bookingDateInv);
    }

    public String getBookingNoInv() {
        return BookingNoInv.get();
    }

    public SimpleStringProperty bookingNoInvProperty() {
        return BookingNoInv;
    }

    public void setBookingNoInv(String bookingNoInv) {
        this.BookingNoInv.set(bookingNoInv);
    }

    public String getTripStartInv() {
        return TripStartInv.get();
    }

    public SimpleStringProperty tripStartInvProperty() {
        return TripStartInv;
    }

    public void setTripStartInv(String tripStartInv) {
        this.TripStartInv.set(tripStartInv);
    }

    public String getTripEndInv() {
        return TripEndInv.get();
    }

    public SimpleStringProperty tripEndInvProperty() {
        return TripEndInv;
    }

    public void setTripEndInv(String tripEndInv) {
        this.TripEndInv.set(tripEndInv);
    }

    public String getDescriptionInv() {
        return DescriptionInv.get();
    }

    public SimpleStringProperty descriptionInvProperty() {
        return DescriptionInv;
    }

    public void setDescriptionInv(String descriptionInv) {
        this.DescriptionInv.set(descriptionInv);
    }

    public String getBasePriceInv() {
        return BasePriceInv.get();
    }

    public SimpleStringProperty basePriceInvProperty() {
        return BasePriceInv;
    }

    public void setBasePriceInv(String basePriceInv) {
        this.BasePriceInv.set(basePriceInv);
    }

    @Override
    public String toString() {
        return "Invoices_View{" +
                "CustFirstNameInv=" + CustFirstNameInv +
                ", CustEmailInv=" + CustEmailInv +
                ", BookingDateInv=" + BookingDateInv +
                ", BookingNoInv=" + BookingNoInv +
                ", TripStartInv=" + TripStartInv +
                ", TripEndInv=" + TripEndInv +
                ", DescriptionInv=" + DescriptionInv +
                ", BasePriceInv=" + BasePriceInv +
                '}';
    }
}
