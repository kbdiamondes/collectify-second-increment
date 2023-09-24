package com.capstone.kuhako.services.ClientModuleServices;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.ClientModules.DuePayments;
import com.capstone.kuhako.repositories.ClientModuleRepository.DuePaymentsRepository;
import com.capstone.kuhako.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DuePaymentsServiceImpl implements DuePaymentsService {
    @Autowired
    private DuePaymentsRepository duePaymentRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void createDuePayments(DuePayments duePayments, Long clientId) {
/*//      User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
        DuePayments newDuePayments = new DuePayments();
        newDuePayments.setClient(duePayments.getClient());
        newDuePayments.setItemName(duePayments.getItemName());
        newDuePayments.setRequiredCollectible(duePayments.getRequiredCollectible());
        newDuePayments.setDueStatus(duePayments.isDueStatus());
        duePaymentRepository.save(newDuePayments);*/
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            duePayments.setClient(client);
            duePaymentRepository.save(duePayments);
        }

    }

    public Iterable<DuePayments> getDuePayments() {
        return duePaymentRepository.findAll();
    }

    public Iterable<DuePayments> getDuePaymentsByClientId(Long clientId) {
        return duePaymentRepository.findDuePaymentsByClientId(clientId);
    }


    public ResponseEntity deleteDuePayments(Long id) {
        duePaymentRepository.deleteById(id);
        return new ResponseEntity<>("PaymentDues Deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity updateDuePayments(Long clientId , Long id, DuePayments duePayments) {
        DuePayments duePaymentsForUpdate = duePaymentRepository.findById(id).orElse(null);
        if (duePaymentsForUpdate != null) {
            duePaymentsForUpdate.setRequiredCollectible(duePayments.getRequiredCollectible());
            duePaymentsForUpdate.setDueStatus(duePayments.isDueStatus());
            Client client = clientRepository.findById(clientId).orElse(null);
            if (client != null) {
                duePaymentsForUpdate.setClient(client);
            }
            duePaymentRepository.save(duePaymentsForUpdate);
            return new ResponseEntity<>("Due Payments Updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Due payment not found",HttpStatus.NOT_FOUND);
    }



//    public Iterable<DuePayments> getClientDuePayments(Client client) {
//        return duePaymentRepository.findbyClient(client);
//    }
}
