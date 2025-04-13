package com.BikkadIt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIt.Repository.CountryRepo;
import com.BikkadIt.entity.Country;

@Service
public class CountryServiceImpl implements CountryService{
	@Autowired
	private CountryRepo countryRepo;

	public List<Country> getAllCountries() {

		return countryRepo.findAll();

	}
	public Country getCountryById(Integer id) {

		List<Country> all = this.countryRepo.findAll();

		Country country = null;

		for (Country con : all) {
			if (con.getId() == id)
				country = con;

		}
		return country;
	}

	public Country getCountryByName(String countryname) {

		List<Country> countries = this.countryRepo.findAll();

		Country country = null;

		for (Country con : countries) {
			if (con.getCountryname().equalsIgnoreCase(countryname))
				country = con;

		}
		return country;
	}
	public Country addCountry(Country country) {
		Country save = countryRepo.save(country);
		return save;
	}

	public Country updateCountry(Country country, Integer id) {

		country.setId(id);
		//countryRepo.findById(id).orElseThrow(() ->new UserNotFoudException("Id is not present"));
		Country save = countryRepo.save(country);
		return save;
	}

	public void deleteCountry(Country country) {

		countryRepo.delete(country);
	}
}
