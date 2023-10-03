package com.capstone.kuhako.repositories;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import com.capstone.kuhako.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResellerRepository extends CrudRepository<Reseller,Object> {
    Reseller findByUsername(String username);


}