package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.CountryMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMakeRepo extends JpaRepository<CountryMake, Long> {

    @Query(value = " select cm from CountryMake cm where cm.name = :name or cm.nameAr = :name")
    CountryMake getByName(@Param("name") String name);
}
