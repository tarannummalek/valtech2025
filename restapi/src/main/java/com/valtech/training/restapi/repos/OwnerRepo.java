package com.valtech.training.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restapi.entities.Owner;
@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long>{

}
