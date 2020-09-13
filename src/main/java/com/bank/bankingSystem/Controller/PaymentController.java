package com.bank.bankingSystem.Controller;

import com.bank.bankingSystem.Model.*;
import com.bank.bankingSystem.Repository.NotificationRepository;
import com.bank.bankingSystem.Repository.PaymentRepository;
import com.bank.bankingSystem.Utilities.IPhandler;
import com.bank.bankingSystem.Utilities.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class PaymentController {

    private final String INDEX_PAGE = "index";
    private final String ADD_TYPE1_PAYMENT_PAGE = "add-type1-payment";
    private final String ADD_TYPE2_PAYMENT_PAGE = "add-type2-payment";
    private final String ADD_TYPE3_PAYMENT_PAGE = "add-type3-payment";
    private final String PAYMENT_PAGE = "payment";
    private final String PAYMENTS_PAGE = "payments";
    private final String CANCEL_PAYMENT_PAGE = "cancel-payment";

    private final PaymentRepository paymentRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, NotificationRepository notificationRepository) {
        this.paymentRepository = paymentRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/index")
    public String showIndex() {
        IPhandler.publishClientsCountry();
        return INDEX_PAGE;
    }

   @GetMapping("/payments")
   public String getAllPayments(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        return PAYMENTS_PAGE;
   }

   @GetMapping("/payments/{id}")
   public String getPaymentById(@PathVariable("id") long id, Model model) {
        Payment payment = paymentRepository.findById(id);
        model.addAttribute("payment", payment);
        return PAYMENT_PAGE;
   }

   @GetMapping("/payments/amount/{amount}")
   public String getPaymentsByAmount(@PathVariable("amount") double amount, Model model) {
        List<Payment> payments = paymentRepository.findByAmount(amount);
        model.addAttribute("payments", payments);
        return PAYMENTS_PAGE;
   }

    @GetMapping("/addtype1payment")
    public String addType1Payment(Type1Payment type1Payment) {
        return ADD_TYPE1_PAYMENT_PAGE;
    }

    @PostMapping("/addtype1payment")
    public String addType1Payment(@Valid Type1Payment type1Payment, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return ADD_TYPE1_PAYMENT_PAGE;
        }

        paymentRepository.save(type1Payment);
        model.addAttribute("payments", paymentRepository.findAll());

        boolean isResponseSuccessful = Notifier.notifyExternalService("http://google.com");
        saveNotification(type1Payment, isResponseSuccessful);

        return INDEX_PAGE;
    }

    @GetMapping("/addtype2payment")
    public String addType2Payment(Type2Payment type2Payment) {
        return ADD_TYPE2_PAYMENT_PAGE;
    }

    @PostMapping("/addtype2payment")
    public String addType2Payment(@Valid Type2Payment type2Payment, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return ADD_TYPE2_PAYMENT_PAGE;
        }

        paymentRepository.save(type2Payment);
        model.addAttribute("payments", paymentRepository.findAll());

        boolean isResponseSuccessful = Notifier.notifyExternalService("http://bing.com");
        saveNotification(type2Payment, isResponseSuccessful);

        return INDEX_PAGE;
    }

    @GetMapping("/addtype3payment")
    public String addType3Payment(Type3Payment type3Payment) {
        return ADD_TYPE3_PAYMENT_PAGE;
    }

    @PostMapping("/addtype3payment")
    public String addType3Payment(@Valid Type3Payment type3Payment, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return ADD_TYPE3_PAYMENT_PAGE;
        }

        paymentRepository.save(type3Payment);
        model.addAttribute("payments", paymentRepository.findAll());

        return INDEX_PAGE;
    }

    private void saveNotification(Payment payment, boolean notified) {
        Notification notification = new Notification();
        notification.setPaymentId(payment.getId());

        if (notified)
            notification.setNotified(true);
        else
            notification.setNotified(false);

        notificationRepository.save(notification);
    }
}
