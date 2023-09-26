package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import org.springframework.http.ResponseEntity;

public interface MyCollectorsService {
    void createMyCollectors(Long resellerId,MyCollectors myCollectors);

    Iterable<MyCollectors> getMyCollectors();

    ResponseEntity deleteMyCollectors(Long id);

    ResponseEntity updateMyCollectors(Long id, MyCollectors myCollectors);
}
