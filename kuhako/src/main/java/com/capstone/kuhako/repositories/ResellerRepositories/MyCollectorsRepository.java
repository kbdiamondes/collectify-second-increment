package com.capstone.kuhako.repositories.ResellerRepositories;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCollectorsRepository extends CrudRepository<MyCollectors,Object> {
    @Query("SELECT mc FROM MyCollectors mc WHERE mc.reseller.reseller_id = :resellerId")
    Iterable<MyCollectors> findMyCollectorsByResellerId(@Param("resellerId") Long resellerId);
}
