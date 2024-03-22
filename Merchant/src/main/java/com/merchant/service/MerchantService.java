package com.merchant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchant.dto.Merchant;
import com.merchant.repo.MerchantRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class MerchantService {
	@Autowired
	private MerchantRepository repository;

	public Merchant saveMerchant(Merchant Merchant) {
		log.debug("Saving Merchant: {}", Merchant);
		return repository.save(Merchant);
	}

	public List<Merchant> getMerchants() {
		log.info("Getting all Merchants");
		return repository.findAll();
	}

	public Merchant getMerchantById(int id) {
		log.debug("Getting Merchant by ID: {}", id);
		return repository.findById(id).orElse(null);
	}

	public String deleteMerchant(int id) {
		log.debug("Deleting Merchant by ID: {}", id);
		repository.deleteById(id);
		return "Merchant removed: " + id;
	}

	public String updateMerchant(int id, Merchant Merchant) {
		log.debug("Updating Merchant with ID: {}", id);
		Merchant existingMerchant = repository.findById(id).orElse(null);
		if (existingMerchant != null) {
			repository.save(Merchant);
			return "Merchant updated successfully";
		} else {
			return "Merchant not found";
		}
	}

	public Merchant getMerchantByName(String name) {
		log.debug("Getting Merchant by name: {}", name);
		return repository.findByName(name);
	}
}
