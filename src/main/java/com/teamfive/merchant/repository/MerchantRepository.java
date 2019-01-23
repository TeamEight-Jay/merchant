package com.teamfive.merchant.repository;

import com.teamfive.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,String> {

}
