package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAcount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAcount bankAcount){
        BankAccountResponseDTO bankAccountResponseDTO= new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAcount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
