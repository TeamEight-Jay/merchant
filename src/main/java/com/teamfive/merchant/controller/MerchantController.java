package com.teamfive.merchant.controller;

import com.teamfive.merchant.dto.MerchantDTO;
import com.teamfive.merchant.entity.Merchant;
import com.teamfive.merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/merchant/add")
    public Merchant add(@RequestBody MerchantDTO merchantDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date=new Date();
        String formattedDate=dateFormat.format(date);
        merchant.setDateOfJoining(formattedDate);
        merchant.setMerchantRating(2.5f);
        return merchantService.addMerchant(merchant);
    }

    @RequestMapping(value = "/merchant/get",method = RequestMethod.GET)
    public Merchant select(@RequestParam String merchantId) {
        Merchant merchant=merchantService.selectMerchant(merchantId);
        return merchant;
    }

    @RequestMapping(value = "/merchant/check",method = RequestMethod.GET)
    public String check(@RequestParam String merchantId) {
        Merchant merchant=merchantService.selectMerchant(merchantId);
        if(merchant==null) return null;
        return merchant.getMerchantName();
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

    @GetMapping(value = "/merchant/rating/{merchantId}")
    public float getRating(@PathVariable String merchantId)
    {
        return merchantService.merchantRating(merchantId);
    }

}
