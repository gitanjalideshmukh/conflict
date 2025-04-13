package com.BikkadIt.Service;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.jupiter.api.BeforeAll;

import com.BikkadIt.Repository.CountryRepo;
import com.BikkadIt.entity.Country;

class CountryServiceImplTest {

	public static CountryServiceImpl countryServiceImpl =null;
	
	@BeforeAll
	public static void init() {
		Object repoProxy = EasyMock.createMock(CountryRepo.class);
		
		List<String> list = new ArrayList<String>() ;
		list.add("India");
		list.add("USA");
		list.add("Nepal");
		
		
		
		
	}

}
