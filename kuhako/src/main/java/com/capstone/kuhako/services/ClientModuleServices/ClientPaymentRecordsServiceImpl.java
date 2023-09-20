package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import com.capstone.kuhako.repositories.ClientModuleRepository.ClientPaymentRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientPaymentRecordsServiceImpl implements ClientPaymentRecordsService {
    @Autowired
    private ClientPaymentRecordsRepository clientPaymentRecordsRepository;

    public void createClientPaymentRecords(ClientPaymentRecords clientPaymentRecords){
//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        ClientPaymentRecords newClientPaymentRecords = new ClientPaymentRecords();
        newClientPaymentRecords.setClient(clientPaymentRecords.getClient());
        newClientPaymentRecords.setPayDues(clientPaymentRecords.getPayDues());
        newClientPaymentRecords.setCollectPayments(clientPaymentRecords.getCollectPayments());
        clientPaymentRecordsRepository.save(newClientPaymentRecords);
    }
    public Iterable<ClientPaymentRecords> getClientPaymentRecords(){
        return clientPaymentRecordsRepository.findAll();
    }

    public ResponseEntity deleteClientPaymentRecords(Long id){
        clientPaymentRecordsRepository.deleteById(id);
        return new ResponseEntity<>("ClientPaymentRecords Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateClientPaymentRecords(Long id, ClientPaymentRecords clientPaymentRecords){
        ClientPaymentRecords clientPaymentRecordsForUpdate = clientPaymentRecordsRepository.findById(id).get();
        clientPaymentRecordsForUpdate.setClient(clientPaymentRecords.getClient());
        clientPaymentRecordsForUpdate.setPayDues(clientPaymentRecords.getPayDues());
        clientPaymentRecordsForUpdate.setCollectPayments(clientPaymentRecords.getCollectPayments());
        clientPaymentRecordsRepository.save(clientPaymentRecordsForUpdate);
        return new ResponseEntity("ClientPaymentRecords updated successfully", HttpStatus.OK);
    }
}
