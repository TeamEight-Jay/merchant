package com.teamfive.merchant.service.impl;


import com.teamfive.merchant.dto.MerchantDTO;
import com.teamfive.merchant.entity.Merchant;
import com.teamfive.merchant.repository.MerchantRepository;
import com.teamfive.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

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
}
