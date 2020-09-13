package com.bank.bankingSystem.Controller;

import com.bank.bankingSystem.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationController {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/notifications")
    public String getAllNotifications(Model model) {
        model.addAttribute("notifications", notificationRepository.findAll());
        return "notifications";
    }
}
