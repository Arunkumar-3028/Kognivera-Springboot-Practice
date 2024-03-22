package com.merchant.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.merchant.dto.Merchant;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant, Integer> {

	@Query("{'name':?0}")
	Merchant findByName(String name);

}
