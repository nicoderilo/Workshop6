package com.example.workshop6;

import javafx.beans.property.SimpleStringProperty;

public class Package {
    private final SimpleStringProperty pkgId;
    private final SimpleStringProperty pkgName;
    private final SimpleStringProperty pkgStartDate;
    private final SimpleStringProperty pkgEndDate;
    private final SimpleStringProperty pkgDescription;
    private final SimpleStringProperty pkgBasePrice;
    private final SimpleStringProperty pkgAgencyCommission;
    public Package(int pkgId, String pkgName,
                   String pkgStartDate, String pkgEndDate,
                   String pkgDescription, String pkgBasePrice,
                   String pkgAgencyCommission) {
        this.pkgId = new SimpleStringProperty(Integer.toString(pkgId));
        this.pkgName = new SimpleStringProperty(pkgName);
        this.pkgStartDate = new SimpleStringProperty(pkgStartDate);
        this.pkgEndDate = new SimpleStringProperty(pkgEndDate);
        this.pkgDescription = new SimpleStringProperty(pkgDescription);
        this.pkgBasePrice = new SimpleStringProperty(pkgBasePrice);
        this.pkgAgencyCommission = new SimpleStringProperty(pkgAgencyCommission);
    }

    public String getPkgId() {
        return pkgId.get();
    }

    public SimpleStringProperty pkgIdProperty() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId.set(pkgId);
    }

    public String getPkgName() {
        return pkgName.get();
    }

    public SimpleStringProperty pkgNameProperty() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName.set(pkgName);
    }

    public String getPkgStartDate() {
        return pkgStartDate.get();
    }

    public SimpleStringProperty pkgStartDateProperty() {
        return pkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        this.pkgStartDate.set(pkgStartDate);
    }

    public String getPkgEndDate() {
        return pkgEndDate.get();
    }

    public SimpleStringProperty pkgEndDateProperty() {
        return pkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
        this.pkgEndDate.set(pkgEndDate);
    }

    public String getPkgDescription() {
        return pkgDescription.get();
    }

    public SimpleStringProperty pkgDescriptionProperty() {
        return pkgDescription;
    }

    public void setPkgDescription(String pkgDescription) {
        this.pkgDescription.set(pkgDescription);
    }

    public String getPkgBasePrice() {
        return pkgBasePrice.get();
    }

    public SimpleStringProperty pkgBasePriceProperty() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(String pkgBasePrice) {
        this.pkgBasePrice.set(pkgBasePrice);
    }

    public String getPkgAgencyCommission() {
        return pkgAgencyCommission.get();
    }

    public SimpleStringProperty pkgAgencyCommissionProperty() {
        return pkgAgencyCommission;
    }

    public void setPkgAgencyCommission(String pkgAgencyCommission) {
        this.pkgAgencyCommission.set(pkgAgencyCommission);
    }

    @Override
    public String toString() {
        return "Package{" +
                "pkgId=" + pkgId +
                ", pkgName=" + pkgName +
                ", pkgStartDate=" + pkgStartDate +
                ", pkgEndDate=" + pkgEndDate +
                ", pkgDescription=" + pkgDescription +
                ", pkgBasePrice=" + pkgBasePrice +
                ", pkgAgencyCommission=" + pkgAgencyCommission +
                '}';
    }

}
