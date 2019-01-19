package com.teamfive.merchant.controller;

import com.teamfive.merchant.dto.MerchantDTO;
import com.teamfive.merchant.entity.Merchant;
import com.teamfive.merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RestController
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/addMerchant")
    public Merchant add(@RequestBody MerchantDTO merchantDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        Calendar cal = Calendar. getInstance();
        Date date=cal. getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=dateFormat. format(date);
        merchant.setDateOfJoining(formattedDate);
        return merchantService.addMerchant(merchant);
    }

    @RequestMapping(value = "/getMerchant",method = RequestMethod.GET)
    public Merchant select(@RequestParam String merchantId) {
        Merchant merchant=merchantService.selectMerchant(merchantId);
        return merchant;
    }

    @RequestMapping(value = "/updateMerchant",method = RequestMethod.PUT)
    public Merchant update(@RequestBody MerchantDTO merchantDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        return merchantService.update(merchant);
    }

    @RequestMapping(value = "/deleteMerchant",method = RequestMethod.DELETE)
    public void delete(@RequestParam String merchantId) {
        merchantService.delete(merchantId);
    }

}
