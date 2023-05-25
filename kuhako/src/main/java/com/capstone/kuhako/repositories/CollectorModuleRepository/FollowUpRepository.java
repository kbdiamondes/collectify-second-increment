package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowUpRepository extends CrudRepository<FollowUp,Object> {
}
