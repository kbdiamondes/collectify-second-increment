package com.capstone.kuhako.repositories.ClientModuleRepository;

import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPaymentRecordsRepository extends CrudRepository<ClientPaymentRecords,Object> {
}
