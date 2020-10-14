package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryRepo extends JpaRepository<VehicleCategory, Long> {
}
