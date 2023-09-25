package com.capstone.kuhako.repositories.ResellerRepositories;

import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.capstone.kuhako.models.ResellerModule.SoldItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldItemsRepository extends CrudRepository<SoldItems,Object> {
    @Query("SELECT si FROM SoldItems si WHERE si.reseller.reseller_id = :resellerId")
    Iterable<SoldItems> findSoldItemsByResellerId(@Param("resellerId") Long resellerId);
}

