package com.teamfive.merchant.service.impl;


import com.teamfive.merchant.dto.ratingUpdateKafkaMessage;
import com.teamfive.merchant.entity.Merchant;
import com.teamfive.merchant.repository.MerchantRepository;
import com.teamfive.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    private final double UPDATE_FACTOR=0.35;

    @Override
    public Merchant addMerchant(Merchant merchant) {
        Merchant merchant1=merchantRepository.save(merchant);
        return merchant1;
    }

    @Override
    public Merchant selectMerchant(String merchantId) {
        Merchant merchant=merchantRepository.findOne(merchantId);
        return merchant;
    }

    @Override
    public Merchant update(Merchant merchant) {
        Merchant merchant1=merchantRepository.save(merchant);
        return merchant1;
    }

    @Override
    public void delete(String merchantId) {
        merchantRepository.delete(merchantId);
    }

    @Override
    public double merchantRating(String merchantId) {
        Merchant merchant=merchantRepository.findOne(merchantId);
        if(merchant==null) return 0;
        return merchant.getMerchantRating();
    }

    @Override
    public void updateRating(ratingUpdateKafkaMessage ratingUpdateKafkaMessage) {
        Merchant merchant=this.selectMerchant(ratingUpdateKafkaMessage.getProductId());
        if(merchant==null) return;
        double oldRating=merchant.getMerchantRating();
        double recentRating=ratingUpdateKafkaMessage.getRating();
        double newRating= ((1-UPDATE_FACTOR)*oldRating) + UPDATE_FACTOR*recentRating;
        merchant.setMerchantRating(newRating);
        this.update(merchant);
        System.out.println(("UPDATED RATING FOR " + merchant.getMerchantRating() + " FROM " + oldRating + " TO " + newRating));
    }


}
