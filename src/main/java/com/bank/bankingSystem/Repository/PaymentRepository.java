package com.bank.bankingSystem.Repository;

import com.bank.bankingSystem.Model.Payment;
import com.bank.bankingSystem.Model.Type1Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Type1Payment> findByAmount(double amount);
}
