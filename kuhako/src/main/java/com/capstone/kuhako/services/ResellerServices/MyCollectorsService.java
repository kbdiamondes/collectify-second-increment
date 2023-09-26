package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import org.springframework.http.ResponseEntity;

public interface MyCollectorsService {
    void createMyCollectors(Long resellerId,MyCollectors myCollectors);

    Iterable<MyCollectors> getMyCollectors();

    Iterable<MyCollectors>getMyCollectorsByResellerId(Long resellerId);

    ResponseEntity deleteMyCollectors(Long resellerId,Long id);

    ResponseEntity updateMyCollectors(Long resellerId,Long id, MyCollectors myCollectors);
}
