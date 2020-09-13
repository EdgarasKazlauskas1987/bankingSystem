package com.bank.bankingSystem.Repository;

import com.bank.bankingSystem.Model.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Query(value = "SELECT * FROM Payment WHERE status = 'Active'", nativeQuery = true)
    List<Payment> findAll();

    @Query(value = "SELECT * FROM Payment WHERE id = ?1 AND status = 'Active'", nativeQuery = true)
    Payment findById(long id);

    @Query(value = "SELECT * FROM Payment WHERE amount = ?1 AND status = 'Active'", nativeQuery = true)
    List<Payment> findByAmount(double amount);
}
