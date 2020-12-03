package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.NewVehicleBodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewVehicleBodyTypeRepo extends JpaRepository<NewVehicleBodyType, Long> {

    @Query(value = " select nvbt from NewVehicleBodyType nvbt where nvbt.name = :name or nvbt.nameAr = :name")
    NewVehicleBodyType getByName(@Param("name") String name);
}
