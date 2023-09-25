package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.models.CollectorModules.collectorCollectionRecords;
import com.capstone.kuhako.services.CollectorModuleServices.collectorCollectionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/collectorPage")
public class collectorCollectionRecordsController {
    @Autowired
    collectorCollectionRecordsService collectorCollectionRecordsService;

    @RequestMapping(value="/collectorCollectionRecords", method = RequestMethod.POST)
    public ResponseEntity<Object> createCollectorCollectionRecords(@RequestBody collectorCollectionRecords collectorCollectionRecords) {
        collectorCollectionRecordsService.createCollectorCollectionRecords(collectorCollectionRecords);
        return new ResponseEntity<>("collectorCollectionRecords created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/collectorCollectionRecords", method = RequestMethod.GET)
    public ResponseEntity<Object> getCollectorCollectionRecords() {
        return new ResponseEntity<>(collectorCollectionRecordsService.getCollectorCollectionRecords(), HttpStatus.OK);
    }

    @RequestMapping(value = "/collectorCollectionRecords/{collectorCollectionRecordsid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCollectorCollectionRecords(@PathVariable Long collectorCollectionRecordsid) {
        return collectorCollectionRecordsService.deleteCollectorCollectionRecords(collectorCollectionRecordsid);
    }

    @RequestMapping(value="/collectorCollectionRecords/{collectorCollectionRecordsid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollectorCollectionRecords(@PathVariable Long collectorCollectionRecordsid, @RequestBody collectorCollectionRecords collectorCollectionRecords) {
        return collectorCollectionRecordsService.updateCollectorCollectionRecords(collectorCollectionRecordsid, collectorCollectionRecords);
    }
}