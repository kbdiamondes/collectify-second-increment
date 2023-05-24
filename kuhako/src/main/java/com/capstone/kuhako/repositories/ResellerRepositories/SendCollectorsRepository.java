package com.capstone.kuhako.repositories.ResellerRepositories;

import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendCollectorsRepository extends CrudRepository<SendCollectors,Object> {
}
