package com.valtech.training.restapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restapi.entities.Watch;
import com.valtech.training.restapi.vos.WatchVO;
@Repository
public interface WatchRepo extends JpaRepository<Watch, Long> {

	List<Watch> findAllByBrand(String brand);

}
