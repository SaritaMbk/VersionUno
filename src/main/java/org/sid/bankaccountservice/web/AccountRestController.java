package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAcount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAcountRepository;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAcountRepository bankAcountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAcountRepository bankAcountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAcountRepository = bankAcountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAcount> bankAcounts(){
        return bankAcountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAcount bankAcount(@PathVariable String id){
        return bankAcountRepository.findById(id).
                orElseThrow(()-> new RuntimeException(String.format("Account is not found !",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAcount update(@PathVariable String id, @RequestBody BankAcount bankAcount){
        BankAcount account = bankAcountRepository.findById(id).orElseThrow();
        if(bankAcount.getBalance()!=null) account.setBalance(bankAcount.getBalance());
        if(bankAcount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(bankAcount.getType()!=null) account.setType(bankAcount.getType());
        if(bankAcount.getCurrency()!=null) account.setCurrency(bankAcount.getCurrency());
        return bankAcountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAcountRepository.deleteById(id);
    }












}
