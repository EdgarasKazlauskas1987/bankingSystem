package com.bank.bankingSystem.Controller;

import com.bank.bankingSystem.Model.Type1Payment;
import com.bank.bankingSystem.Model.Type2Payment;
import com.bank.bankingSystem.Model.Type3Payment;
import com.bank.bankingSystem.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        return "index";
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


    @GetMapping("/addpayment")
    public String showSignUpForm(Type1Payment type1Payment) {
        return "add-payment";
    }

    @PostMapping("/addpayment")
    public String addPayment(@Valid Type1Payment type1Payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-payment";
        }

        paymentRepository.save(type1Payment);
        model.addAttribute("payments", paymentRepository.findAll());
        return "index";
    }



}
