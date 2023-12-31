package com.capstone.kuhako.repositories.ResellerRepositories;

import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignCollectorsRepository extends CrudRepository<AssignCollectors,Object> {
    @Query("SELECT ac FROM AssignCollectors ac WHERE ac.reseller.reseller_id = :resellerId")
    Iterable<AssignCollectors> findAssignCollectorsByResellerId(@Param("resellerId") Long resellerId);


}