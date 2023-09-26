package com.capstone.kuhako.controllers.ResellersControllers;

import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import com.capstone.kuhako.services.ResellerServices.MyCollectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/resellerPage")
public class MyCollectorsController {
    @Autowired
    MyCollectorsService myCollectorsService;

    @RequestMapping(value="/myCollectors/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createMyCollectors(@PathVariable Long resellerId,@RequestBody MyCollectors myCollectors) {
        myCollectorsService.createMyCollectors(resellerId,myCollectors);
        return new ResponseEntity<>("MyCollectors created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/myCollectors", method = RequestMethod.GET)
    public ResponseEntity<Object> getMyCollectors() {
        return new ResponseEntity<>(myCollectorsService.getMyCollectors(), HttpStatus.OK);
    }
    @RequestMapping(value="/myCollectors/reseller/{resellerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMyCollectorsByResellerId(@PathVariable Long resellerId) {
        return new ResponseEntity<>(myCollectorsService.getMyCollectorsByResellerId(resellerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/myCollectors/{resellerId}/{myCollectors_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMyCollectors(@PathVariable Long resellerId, @PathVariable Long myCollectors_id) {
        return myCollectorsService.deleteMyCollectors(resellerId,myCollectors_id);
    }

    @RequestMapping(value="/myCollectors/{resellerId}/{myCollectors_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMyCollectors(@PathVariable Long resellerId,@PathVariable Long myCollectors_id, @RequestBody MyCollectors myCollectors) {
        return myCollectorsService.updateMyCollectors(resellerId,myCollectors_id, myCollectors);
    }
}
