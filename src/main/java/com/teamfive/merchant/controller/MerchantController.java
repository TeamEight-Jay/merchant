package com.teamfive.merchant.controller;

import com.teamfive.merchant.dto.MerchantCreateDTO;
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
    public MerchantDTO add(@RequestBody MerchantCreateDTO merchantCreateDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantCreateDTO,merchant);
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date=new Date();
        String formattedDate=dateFormat.format(date);
        merchant.setDateOfJoining(formattedDate);
        merchant.setMerchantRating(2.5f);
        merchant=merchantService.addMerchant(merchant);
        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchant,merchantDTO);
        return merchantDTO;
    }

    @RequestMapping(value = "/merchant/get",method = RequestMethod.GET)
    public MerchantDTO select(@RequestParam String merchantId) {
        Merchant merchant=merchantService.selectMerchant(merchantId);
        if(merchant==null) return new MerchantDTO();
        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchant,merchantDTO);
        return merchantDTO;
    }

    @RequestMapping(value = "/updateMerchant",method = RequestMethod.PUT)
    public MerchantDTO update(@RequestBody MerchantCreateDTO merchantCreateDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantCreateDTO,merchant);
        merchant=merchantService.update(merchant);
        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchant,merchantDTO);
        return merchantDTO;
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
