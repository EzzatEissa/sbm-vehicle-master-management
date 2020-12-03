package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryRepo extends JpaRepository<VehicleCategory, Long> {

    @Query(value = " select vc from VehicleCategory vc where vc.name = :name or vc.nameAr = :name ")
    VehicleCategory getByName(@Param("name") String name);
}
