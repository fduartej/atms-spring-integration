package com.atm.domain.repository;

import com.atm.domain.ATM;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository CRUD for ATM
 * 
 * @author fduarte
 *
 */
@Repository
public interface AtmRepository extends CrudRepository<ATM, Long> {


}