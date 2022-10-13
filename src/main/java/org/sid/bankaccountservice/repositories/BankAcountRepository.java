package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.BankAcount;
import org.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAcountRepository extends JpaRepository<BankAcount,String> {
    @RestResource(path="/byType")
    List<BankAcount> findByType(@Param("t")AccountType type);
}
