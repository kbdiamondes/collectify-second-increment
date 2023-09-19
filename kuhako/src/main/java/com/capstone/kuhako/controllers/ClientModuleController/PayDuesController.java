package com.capstone.kuhako.controllers.ClientModuleController;


import com.capstone.kuhako.models.ClientModules.PayDues;
import com.capstone.kuhako.services.ClientModuleServices.PayDuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class PayDuesController {
    @Autowired
    PayDuesService payDuesService;

    @RequestMapping(value="/payDues", method = RequestMethod.POST)
    public ResponseEntity<Object> createPayDues(@RequestBody PayDues payDues) {
        payDuesService.createPayDues(payDues);
        return new ResponseEntity<>("PayDues created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/payDues", method = RequestMethod.GET)
    public ResponseEntity<Object> getPayDues() {
        return new ResponseEntity<>(payDuesService.getPayDues(), HttpStatus.OK);
    }

    @RequestMapping(value = "/payDues/{payDuesid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePayDues(@PathVariable Long payDuesid) {
        return payDuesService.deletePayDues(payDuesid);
    }

    @RequestMapping(value="/payDues/{payDuesid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePayDues(@PathVariable Long payDuesid, @RequestBody PayDues payDues) {
        return payDuesService.updatePayDues(payDuesid, payDues);
    }
}