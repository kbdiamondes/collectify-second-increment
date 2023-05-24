package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import org.springframework.http.ResponseEntity;

public interface AssignCollectorsService{
    void createAssignCollectors(AssignCollectors assignCollectors);

    Iterable<AssignCollectors> getAssignCollectors();

    ResponseEntity deleteAssignCollectors(Long id);

    ResponseEntity updateAssignCollectors(Long id, AssignCollectors assignCollectors);
}