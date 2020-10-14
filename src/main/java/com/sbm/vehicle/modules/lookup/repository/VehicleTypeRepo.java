package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepo extends JpaRepository<VehicleType, Long> {
}
