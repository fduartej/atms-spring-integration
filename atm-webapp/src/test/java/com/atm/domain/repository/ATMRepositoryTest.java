package com.atm.domain.repository;

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
 * Repository test for ATM
 * 
 * @author fduarte
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class ATMRepositoryTest {
	
	@Autowired 
	AtmRepository atmRepository;
	
	@Before
	public void create() throws Exception {
		
		GeoLocation geoLocation= new GeoLocation();
		geoLocation.setLat("51.854636");
		geoLocation.setLng("4.316897");
		
		Address address =new Address();
		address.setCity("SPIJKENISSE TEST");
		address.setPostalcode("3202 GM TEST");
		address.setHousenumber("14");
		address.setStreet("t Plateau TEST");
		address.setGeoLocation(geoLocation);
		
		ATM atm = new ATM();
		atm.setType("ING");
		atm.setDistance(0);
		atm.setAddress(address);
		
		ATM saved=atmRepository.save(atm);
		Assert.isTrue(saved!=null);
	}

	@Test
	public void getListAtms() throws Exception {
		Assert.isTrue(atmRepository.findAll().iterator().hasNext());
	}

}
