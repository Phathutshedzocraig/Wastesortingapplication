package com.enviro.assessment.grad001.phathutshedzomakala.service;

import com.enviro.assessment.grad001.phathutshedzomakala.model.DisposalGuideline;
import com.enviro.assessment.grad001.phathutshedzomakala.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    private final DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id).orElse(null);
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline disposalGuideline) {
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline disposalGuideline) {
        DisposalGuideline existingGuideline = disposalGuidelineRepository.findById(id).orElse(null);
        if (existingGuideline != null) {
            existingGuideline.setTitle(disposalGuideline.getTitle());
            existingGuideline.setDescription(disposalGuideline.getDescription());
            existingGuideline.setWasteCategory(disposalGuideline.getWasteCategory());
            return disposalGuidelineRepository.save(existingGuideline);
        }
        return null;
    }

    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
