package com.teamfive.merchant.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = Merchant.TABLE_NAME)
public class Merchant {

    public static final String TABLE_NAME="Merchant";
    public static final String ID_COLUMN="merchant_id";
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    @Column(name = Merchant.ID_COLUMN)
    private String merchantId;
    private String merchantName;
    private String dateOfJoining;

    private double merchantRating;

    public double getMerchantRating() {
        return merchantRating;
    }

    public void setMerchantRating(double merchantRating) {
        this.merchantRating = merchantRating;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId='" + merchantId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", merchantRating=" + merchantRating +
                '}';
    }
}
