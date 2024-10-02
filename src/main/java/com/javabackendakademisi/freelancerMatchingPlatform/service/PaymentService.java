package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.model.Payment;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Ödeme oluşturma
    public Payment createPayment(Payment payment) {
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Ödeme miktarı negatif olamaz.");
        }
        return paymentRepository.save(payment);
    }

    // Tüm ödemeleri listeleme
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    //id'ye göre listeleme
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bu ID ile ödeme bulunamadı: " + id));
    }

    // Ödeme güncelleme
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = getPaymentById(id);
        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setStatus(updatedPayment.getStatus());
        return paymentRepository.save(existingPayment);
    }

    // Ödeme silme
    public void deletePayment(Long id) {
        Payment payment = getPaymentById(id);
        paymentRepository.delete(payment);
    }
}
