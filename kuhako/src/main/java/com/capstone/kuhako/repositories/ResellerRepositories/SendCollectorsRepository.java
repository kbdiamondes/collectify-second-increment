package com.capstone.kuhako.repositories.ResellerRepositories;

import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SendCollectorsRepository extends CrudRepository<SendCollectors,Object> {
    @Query("SELECT sc FROM SendCollectors sc WHERE sc.reseller.reseller_id = :resellerId")
    Iterable<SendCollectors> findSendCollectorsByResellerId(@Param("resellerId") Long resellerId);
}
