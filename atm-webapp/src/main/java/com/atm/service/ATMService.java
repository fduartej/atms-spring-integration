package com.atm.service;

import java.util.List;

import com.atm.domain.ATM;

/**
 * Interface that contents the main method exposed as a interfaces to connect
 * 
 * @author fduarte
 *
 */
public interface ATMService {

	/**
	 * allow to see the health of the application 
	 * @return String
	 * @throws Exception
	 */
	String status() throws Exception;

	/**
	 * get all the atms included the original list
	 *  
	 * @return
	 * @throws Exception
	 */
	List<ATM> getAllAtms();
	
	/**
	 * Create new atm in our own database created in h2 in memory
	 * 
	 * @param atm <code>ATM Pojo</code>
	 * @return
	 * @throws Exception
	 */
	String create(ATM atm) throws Exception;
}
