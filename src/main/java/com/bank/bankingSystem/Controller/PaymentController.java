package com.bank.bankingSystem.Controller;

import com.bank.bankingSystem.Model.Payment;
import com.bank.bankingSystem.Model.Type1Payment;
import com.bank.bankingSystem.Model.Type2Payment;
import com.bank.bankingSystem.Model.Type3Payment;
import com.bank.bankingSystem.Repository.PaymentRepository;
import com.bank.bankingSystem.Utilities.IPhandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PaymentController {

    //Add final string for not changing view names

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/index")
    public String showIndex() {
        IPhandler.publishClientsCountry();
        return "index";
    }

   @GetMapping("/payments")
   public String getAllPayments(Model model) {
        //model.addAttribute("payments", paymentRepository.findAll());
        model.addAttribute("payments", paymentRepository.findAll());
        return "payments";
   }

   @GetMapping("/payments/{id}")
   public String getPaymentById(@PathVariable("id") long id, Model model) {
        Payment payment = paymentRepository.findById(id);
        model.addAttribute("payment", payment);
        return "payment";
   }

   @GetMapping("/payments/amount/{amount}")
   public String getPaymentByAmount(@PathVariable("amount") double amount, Model model) {
        List<Payment> payments = paymentRepository.findByAmount(amount);
        model.addAttribute("payments", payments);
        return "payments";
   }

    @GetMapping("/addtype1payment")
    public String addType1Payment(Type1Payment type1Payment) {
        return "add-type1-payment";
    }

    @PostMapping("/addtype1payment")
    public String addType1Payment(@Valid Type1Payment type1Payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-type1-payment";
        }

        paymentRepository.save(type1Payment);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }

    @GetMapping("/addtype2payment")
    public String addType2Payment(Type2Payment type2Payment) {
        return "add-type2-payment";
    }

    @PostMapping("/addtype2payment")
    public String addType2Payment(@Valid Type2Payment type2Payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-type2-payment";
        }

        paymentRepository.save(type2Payment);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }

    @GetMapping("/addtype3payment")
    public String addType3Payment(Type3Payment type3Payment) {
        return "add-type3-payment";
    }

    @PostMapping("/addtype3payment")
    public String addType3Payment(@Valid Type3Payment type3Payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-type3-payment";
        }

        paymentRepository.save(type3Payment);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }

    @GetMapping("/cancel/{id}")
    public String showCancelationForm(@PathVariable("id") long id, Model model) {
        Payment payment = paymentRepository.findById(id);

        model.addAttribute("payment", payment);
        return "cancel-payment";
    }

    @PostMapping("/cancel/{id}")
    public String cancelPayment(@PathVariable("id") long id, @Valid Payment payment,
                                BindingResult result, Model model) {

        if (result.hasErrors()) {
            payment.setId(id);
            return "cancel-payment";
        }
        // make payment object according to its type
        Type1Payment type1Payment = (Type1Payment) payment;
        paymentRepository.save(type1Payment);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }
}
