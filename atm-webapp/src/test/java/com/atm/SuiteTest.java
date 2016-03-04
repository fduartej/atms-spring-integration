package com.atm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atm.domain.repository.ATMRepositoryTest;
import com.atm.service.ATMServiceTest;
import com.atm.web.IndexControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SuiteClasses({ ATMRepositoryTest.class, ATMServiceTest.class,IndexControllerTest.class })
public class SuiteTest {

}
