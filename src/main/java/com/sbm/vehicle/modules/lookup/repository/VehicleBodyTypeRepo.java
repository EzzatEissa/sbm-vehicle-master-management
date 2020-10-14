package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.VehicleBodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBodyTypeRepo extends JpaRepository<VehicleBodyType, Long> {
}
