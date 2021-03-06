package com.sbm.vehicle.modules.vehicle.repository;

import com.sbm.vehicle.modules.vehicle.dto.VehicleDto;
import com.sbm.vehicle.modules.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{
    @Query("select distinct (vcl) from Vehicle vcl "
    		+ " left join vcl.countryMake cm "
    		+ " left join vcl.newVehicleBodyType nvbt "
    		+ " left join vcl.vehicleBodyType vbt "
    		+ " left join vcl.vehicleCategory vc "
    		+ " left join vcl.vehicleType vt " +
            " where vcl.active = true " +
            " and ( coalesce(:#{#vehicleDto.vehicleMaker}, null) is null or  vcl.vehicleMaker = :#{#vehicleDto.vehicleMaker})" +
            " and ( coalesce(:#{#vehicleDto.vehicleModel}, null) is null or  vcl.vehicleModel = :#{#vehicleDto.vehicleModel})" +
            " and ( coalesce(:#{#vehicleDto.countryMake}, null) is null or  cm.name = :#{#vehicleDto.countryMake})" +
            " and ( coalesce(:#{#vehicleDto.newVehicleBodyType}, null) is null or  nvbt.name = :#{#vehicleDto.newVehicleBodyType})" +
            " and ( coalesce(:#{#vehicleDto.vehicleBodyType}, null) is null or  vbt.name = :#{#vehicleDto.vehicleBodyType})" +
            " and ( coalesce(:#{#vehicleDto.vehicleCategory}, null) is null or  vc.name = :#{#vehicleDto.vehicleCategory})" +
            " and ( coalesce(:#{#vehicleDto.vehicleType}, null) is null or  vt.name = :#{#vehicleDto.vehicleType})" +
            " and ( coalesce(:#{#vehicleDto.category50per50}, null) is null or  vcl.category50per50 = :#{#vehicleDto.category50per50})" +
            " and ( coalesce(:#{#vehicleDto.usedCategory}, null) is null or  vcl.usedCategory = :#{#vehicleDto.usedCategory})" +
            " and ( coalesce(:#{#vehicleDto.cdaInput}, null) is null or  vcl.cdaInput = :#{#vehicleDto.cdaInput})" +
            " and ( coalesce(:#{#vehicleDto.sijilVehicleCode}, null) is null or  vcl.sijilVehicleCode = :#{#vehicleDto.sijilVehicleCode})"
    )
    List<Vehicle> getVehiclesByFields(@Param("vehicleDto") VehicleDto vehicleDto);
}
