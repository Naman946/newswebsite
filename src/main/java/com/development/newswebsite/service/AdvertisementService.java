package com.development.newswebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.newswebsite.domain.Advertisement;
import com.development.newswebsite.repository.AdvertisementRepository;
import com.development.newswebsite.repository.ArticleRepository;

@Service
public class AdvertisementService {
	 @Autowired
	    private AdvertisementRepository advertisementRepository;

    // This is a placeholder. Implement the logic to save advertisements.
    public Advertisement createAdvertisement(Advertisement advertisement) {
        // Save advertisement to the database or collection
        // For example: return advertisementRepository.save(advertisement);
        return advertisementRepository.save(advertisement);
    }
    
    // Method to fetch all advertisements
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }
}
