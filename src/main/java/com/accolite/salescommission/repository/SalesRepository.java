package com.accolite.salescommission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.salescommission.model.SalesCommission;

@Repository
public interface SalesRepository extends JpaRepository<SalesCommission, Integer>{

}
