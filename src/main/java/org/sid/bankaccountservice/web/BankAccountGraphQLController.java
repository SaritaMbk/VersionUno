package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.entities.BankAcount;
import org.sid.bankaccountservice.repositories.BankAcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAcountRepository bankAcountRepository;

    @QueryMapping
    public List<BankAcount> accountsList(){
        return bankAcountRepository.findAll();
    }

   
}
