package com.development.newswebsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.development.newswebsite.domain.Advertisement;

public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {
}
