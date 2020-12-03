package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.VehicleBodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBodyTypeRepo extends JpaRepository<VehicleBodyType, Long> {

    @Query(value = " select vbt from VehicleBodyType vbt where vbt.name = :name or vbt.nameAr = :name")
    VehicleBodyType getByName(@Param("name") String name);
}
