package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.ecommerce.entities.LineOrderItem;

public interface LineOrderRepo extends JpaRepository<LineOrderItem, Long>{

}
