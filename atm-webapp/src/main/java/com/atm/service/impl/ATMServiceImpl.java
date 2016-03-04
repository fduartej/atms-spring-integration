package com.atm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atm.domain.ATM;
import com.atm.domain.repository.AtmRepository;
import com.atm.service.ATMService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Main implementation for the interface ATMService
 * 
 * @author fduarte
 *
 */
@Service("atmServiceImpl")
public class ATMServiceImpl implements ATMService {

	@Autowired @Qualifier("requestAtmChannel") MessageChannel requestAtmChannel;
	@Autowired @Qualifier("responseAtmChannel") PollableChannel responseAtmChannel;
	
	@Autowired 
	AtmRepository atmRepository;

	@Override
	public String status() throws Exception {
		return "UP";
	}

	@Override
	public List<ATM> getAllAtms() {
		requestAtmChannel.send(MessageBuilder.withPayload("").build());
		String stringAtms =(String) responseAtmChannel.receive().getPayload();
		stringAtms=stringAtms.replace(")]}',", "");
		ObjectMapper mapper = new ObjectMapper();
		List<ATM> atms1= new ArrayList<ATM>();
		try {
			atms1 = mapper.readValue(stringAtms, new TypeReference<List<ATM>>() { });
		}  catch (Exception e) {
			e.printStackTrace();
		}
        Iterable<ATM> atms2=atmRepository.findAll();
        Iterator<ATM> i= atms2.iterator();
        while(i.hasNext()){
        	ATM atm2=i.next();
        	atms1.add(atm2);
        }
		return atms1;
	}

	@Transactional
	@Override
	public String create(ATM atm) throws Exception {
		// TODO Auto-generated method stub
		try{
			atmRepository.save(atm);
		}catch(Exception e){
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCESS";
	}


}
