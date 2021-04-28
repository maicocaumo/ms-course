package com.curso.hrpayroll.service;

import com.curso.hrpayroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Maico", 200.00, days);
    }
}
