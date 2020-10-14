package com.sbm.vehicle.modules.vehicle.repository;

import com.sbm.vehicle.modules.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
