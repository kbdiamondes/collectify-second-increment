package com.capstone.kuhako.controllers.ResellersControllers;

import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.capstone.kuhako.services.ResellerServices.SendCollectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @CrossOrigin
    public class SendCollectorsController {
        @Autowired
        SendCollectorsService sendCollectorsService;

        @RequestMapping(value="/sendCollectors", method = RequestMethod.POST)
        public ResponseEntity<Object> createSendCollectors(@RequestBody SendCollectors sendCollectors) {
            sendCollectorsService.createSendCollectors(sendCollectors);
            return new ResponseEntity<>("SendCollectors created successfully", HttpStatus.CREATED);
        }

        @RequestMapping(value="/sendCollectors", method = RequestMethod.GET)
        public ResponseEntity<Object> getSendCollectors() {
            return new ResponseEntity<>(sendCollectorsService.getSendCollectors(), HttpStatus.OK);
        }

        @RequestMapping(value = "/sendCollectors/{sendCollectorsid}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> deleteSendCollectors(@PathVariable Long sendCollectorsid) {
            return sendCollectorsService.deleteSendCollectors(sendCollectorsid);
        }

        @RequestMapping(value="/sendCollectors/{sendCollectorsid}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateSendCollectors(@PathVariable Long sendCollectorsid, @RequestBody SendCollectors sendCollectors) {
            return sendCollectorsService.updateSendCollectors(sendCollectorsid, sendCollectors);
        }
}
