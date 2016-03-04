package com.atm.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import com.atm.domain.ATM;
import com.atm.domain.Address;
import com.atm.domain.GeoLocation;
import com.atm.main.Application;

/**
 * Service test for ATM
 * 
 * @author fduarte
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class ATMServiceTest {

	@Autowired 
	ATMService atmServiceImpl;
	
	private ATM atm;
	
	@Before
	public void setUp() throws Exception {
		GeoLocation geoLocation= new GeoLocation();
		geoLocation.setLat("51.854636");
		geoLocation.setLng("4.316897");
		
		Address address =new Address();
		address.setCity("SPIJKENISSE TEST");
		address.setPostalcode("3202 GM TEST");
		address.setHousenumber("14");
		address.setStreet("t Plateau TEST");
		address.setGeoLocation(geoLocation);
		
		atm = new ATM();
		atm.setType("ING");
		atm.setDistance(0);
		atm.setAddress(address);
	}

	
	@Test
	public void status() throws Exception {
		Assert.isTrue(atmServiceImpl.status().equals("UP"));
	}
	
	@Test
	public void create() throws Exception {
		Assert.isTrue(atmServiceImpl.create(atm).equals("SUCESS"));
	}
	
	@Test
	public void getAllAtms() throws Exception {
		Assert.isTrue(atmServiceImpl.getAllAtms().size()>0);
	}
		
}
