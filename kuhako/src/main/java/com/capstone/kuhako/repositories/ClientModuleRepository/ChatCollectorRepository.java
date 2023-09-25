package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.ChatCollector;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatCollectorRepository extends CrudRepository<ChatCollector,Object> {
    @Query("SELECT cc FROM ChatCollector cc WHERE cc.client.client_id = :clientId")
    Iterable<ChatCollector> findChatCollectorByClientId(@Param("clientId") Long clientId);
}
