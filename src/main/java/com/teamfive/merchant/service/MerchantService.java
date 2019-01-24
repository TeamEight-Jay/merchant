package com.teamfive.merchant.service;

import com.teamfive.merchant.dto.ratingUpdateKafkaMessage;
import com.teamfive.merchant.entity.Merchant;

public interface MerchantService {

    Merchant addMerchant(Merchant merchant);
    Merchant selectMerchant(String merchantId);
    Merchant update(Merchant merchant);
    void delete(String merchantId);
    double merchantRating(String merchantId);
    void updateRating(ratingUpdateKafkaMessage ratingUpdateKafkaMessage);
}
