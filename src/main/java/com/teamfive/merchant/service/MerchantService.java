package com.teamfive.merchant.service;

import com.teamfive.merchant.entity.Merchant;

public interface MerchantService {

    Merchant addMerchant(Merchant merchant);
    Merchant selectMerchant(String merchantId);
    Merchant update(Merchant merchant);
    void delete(String merchantId);
    float merchantRating(String merchantId);
}
