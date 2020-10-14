package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.CountryMade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMadeRepo extends JpaRepository<CountryMade, Long> {
}
