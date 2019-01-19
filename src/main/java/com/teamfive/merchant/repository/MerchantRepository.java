package com.teamfive.merchant.repository;

import com.teamfive.merchant.entity.Merchant;
import org.springframework.data.repository.CrudRepository;

public interface MerchantRepository extends CrudRepository<Merchant,String> {
}
