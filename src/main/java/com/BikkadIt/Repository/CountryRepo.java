package com.BikkadIt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIt.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

}
