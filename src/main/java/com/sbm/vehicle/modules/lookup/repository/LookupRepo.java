package com.sbm.vehicle.modules.lookup.repository;

import com.sbm.vehicle.modules.lookup.model.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LookupRepo extends JpaRepository<Lookup, Long> {
}
