package com.bank.bankingSystem.Repository;

import com.bank.bankingSystem.Model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

    @Query(value = "SELECT * FROM Notification", nativeQuery = true)
    List<Notification> findAll();
}
