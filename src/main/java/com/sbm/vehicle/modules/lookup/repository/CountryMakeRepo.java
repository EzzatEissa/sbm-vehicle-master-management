package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.CountryMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMakeRepo extends JpaRepository<CountryMake, Long> {

    CountryMake getByName(String name);
}
