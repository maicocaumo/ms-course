package com.curso.hrpayroll.service;

import com.curso.hrpayroll.entity.Payment;
import com.curso.hrpayroll.entity.Worker;
import com.curso.hrpayroll.feingclient.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeingClient workerFeingClient;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeingClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
