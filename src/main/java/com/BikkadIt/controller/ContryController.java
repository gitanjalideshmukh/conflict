package com.BikkadIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIt.Exception.UserNotFoudException;
import com.BikkadIt.Service.CountryServiceImpl;
import com.BikkadIt.entity.Country;

@RestController
public class ContryController {


	@Autowired
	private CountryServiceImpl service;

	@PostMapping("/saveUser")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) throws UserNotFoudException {

		if (country == null) {
			throw new UserNotFoudException("User Not Found");
		} else {
			Country save = service.addCountry(country);
			return new ResponseEntity<Country>(save, HttpStatus.CREATED);
		}
	}

//	@GetMapping("/getAllCountries/pageNumber/{pageNumber}/pageSize/{pageSize}")
//	public ResponseEntity<List<Country>> getAllCountries(
//			@RequestParam(value = "pageNumber", defaultValue = "1", required = true) Integer pageNumber,
//			@RequestParam(value = "pageSize", defaultValue = "1", required = true) Integer pageSize) {
//		if (pageNumber == null  && pageSize==null) {
//			throw new UserNotFoudException("User Not Found");
//
//		}
//
//		else {
//
//			List<Country> allCountries = this.service.getAllCountries();
//
//			return new ResponseEntity<List<Country>>(allCountries, HttpStatus.FOUND);
//		}
//
//	}
//	
//	
	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries()
		{
		
			List<Country> allCountries = this.service.getAllCountries();

			return new ResponseEntity<List<Country>>(allCountries, HttpStatus.FOUND);
		}

	


	@GetMapping("/getCountryById/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {

		if (id == null) {
			throw new UserNotFoudException("User Not found");
		} else {
			Country countryById = this.service.getCountryById(id);
			return new ResponseEntity<Country>(countryById, HttpStatus.FOUND);
		}
	}

	@GetMapping("/getCountryByName")
	public ResponseEntity<Country> getCountryByName(@RequestParam String countryname) throws UserNotFoudException {

		if (countryname == null) {
			throw new UserNotFoudException(countryname);

		} else {
			

			Country countryByName = this.service.getCountryByName(countryname);
			return new ResponseEntity<Country>(countryByName, HttpStatus.FOUND);
		}
	}

}

//
//	public Country addCountry(Country country) {
//		Country save = countryRepo.save(country);
//		return save;
//	}
//
//	public Country updateCountry(Country country, Integer id) {
//
//		country.setId(id);
//		Country save = countryRepo.save(country);
//		return save;
//	}
//
//	public void deleteCountry(Country country) {
//
//		countryRepo.delete(country);
//	}