package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.ecommerce.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{

}
