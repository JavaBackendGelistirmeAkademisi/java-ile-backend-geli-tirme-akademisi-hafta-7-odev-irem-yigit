package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.exception.InvalidInputException;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.OfferAlreadyExistsException;
import com.javabackendakademisi.freelancerMatchingPlatform.exception.ProjectClosedForOfferingException;
import com.javabackendakademisi.freelancerMatchingPlatform.model.Offer;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    // Teklif oluşturma
    public Offer createOffer(Offer offer) {
        // Teklif miktarı negatif olamaz
        if (offer.getAmount() <= 0) {
            throw new InvalidInputException("Teklif miktarı negatif olamaz.");
        }
        //Aynı projeye birden fazla teklif yapılamaz
        if (offerRepository.existsByFreelancerAndProject(offer.getFreelancer(), offer.getProject())) {
            throw new OfferAlreadyExistsException("Bu proje için zaten bir teklifiniz var.");
        }
        // Proje teklif vermeye kapalı olabilir
        if ("closed".equals(offer.getProject().getStatus())) {
            throw new ProjectClosedForOfferingException("Bu proje tekliflere kapalı.");
        }
        return offerRepository.save(offer);
    }

    // Tüm teklifleri listeleme
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    // id'ye göre teklifi bulma
    public Offer getOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bu ID ile teklif bulunamadı: " + id));
    }

    // Teklif güncelleme
    public Offer updateOffer(Long id, Offer updatedOffer) {
        Offer existingOffer = getOfferById(id);
        existingOffer.setAmount(updatedOffer.getAmount());
        existingOffer.setStatus(updatedOffer.getStatus());
        return offerRepository.save(existingOffer);
    }

    // Teklif silme
    public void deleteOffer(Long id) {
        Offer offer = getOfferById(id);
        offerRepository.delete(offer);
    }
}
