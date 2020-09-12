package com.bank.bankingSystem.Repository;

import com.bank.bankingSystem.Model.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findByAmount(double amount);
    Payment findById(long id);
}
