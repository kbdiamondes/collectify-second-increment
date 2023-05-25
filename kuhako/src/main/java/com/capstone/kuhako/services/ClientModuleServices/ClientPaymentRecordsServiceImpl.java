package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.ClientModules.ClientPaymentRecords;
import com.capstone.kuhako.repositories.ClientModuleRepository.ClientPaymentRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientPaymentRecordsServiceImpl {
    @Autowired
    private ClientPaymentRecordsRepository clientPaymentRecordsRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createClientPaymentRecords(ClientPaymentRecords clientPaymentRecords){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        ClientPaymentRecords newClientPaymentRecords = new ClientPaymentRecords();
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

//        ClientPaymentRecords clientPaymentRecordsForDeleting = clientPaymentRecordsRepository.findById(id).get();
//        String clientPaymentRecordsName = clientPaymentRecordsForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(clientPaymentRecordsName)){
//            clientPaymentRecordsRepository.deleteById(id);
//            return new ResponseEntity<>("ClientPaymentRecords Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this ClientPaymentRecords",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateClientPaymentRecords(Long id, ClientPaymentRecords clientPaymentRecords){
        ClientPaymentRecords clientPaymentRecordsForUpdate = clientPaymentRecordsRepository.findById(id).get();

        clientPaymentRecordsForUpdate.setPayDues(clientPaymentRecords.getPayDues());
        clientPaymentRecordsForUpdate.setCollectPayments(clientPaymentRecords.getCollectPayments());

        clientPaymentRecordsRepository.save(clientPaymentRecordsForUpdate);

        return new ResponseEntity("ClientPaymentRecords updated successfully", HttpStatus.OK);

//        ClientPaymentRecords clientPaymentRecordsForUpdating = clientPaymentRecordsRepository.findById(id).get();
//        String clientPaymentRecordsName = clientPaymentRecordsForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(clientPaymentRecordsName)){
//            clientPaymentRecordsForUpdating.setName(clientPaymentRecords.getName());
//            clientPaymentRecordsForUpdating.setDescription(clientPaymentRecords.getDescription());
//            clientPaymentRecordsForUpdating.setPrice(clientPaymentRecords.getPrice());
//
//            clientPaymentRecordsRepository.save(clientPaymentRecordsForUpdating);
//            return  new ResponseEntity("ClientPaymentRecords has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Your are not authorize to update this ClientPaymentRecords.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
