package com.teamfive.merchant.dto;

public class MerchantCreateDTO {
    private String merchantName;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        return "MerchantDTO{" +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }
}
