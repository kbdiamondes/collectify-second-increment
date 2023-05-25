package com.capstone.kuhako.repositories.CollectorModuleRepository;

import com.capstone.kuhako.models.CollectorModules.SendFollowUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendFollowUpRepository extends CrudRepository<SendFollowUp,Object> {
}
