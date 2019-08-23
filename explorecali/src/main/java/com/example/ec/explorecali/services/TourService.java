package com.example.ec.explorecali.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.explorecali.domain.Difficulty;
import com.example.ec.explorecali.domain.Region;
import com.example.ec.explorecali.domain.Tour;
import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repository.ITourPackageRepository;
import com.example.ec.explorecali.repository.ITourRepository;

@Service
public class TourService {

	private ITourPackageRepository tourPackageRepository;
	private ITourRepository tourRepository;

	@Autowired
	public TourService(ITourPackageRepository tourPackageRepository, ITourRepository tourRepository) {
		this.tourPackageRepository = tourPackageRepository;
		this.tourRepository = tourRepository;
	}

	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageCode, Difficulty difficulty, Region region) {

		TourPackage tourPackage = tourPackageRepository.findById(tourPackageCode).orElse(null);

		if (tourPackage == null) {
			throw new RuntimeException(("Tour package not exist " + tourPackageCode));
		}

		return tourRepository
				.save(new Tour(title, description, blurb, price, duration, bullets, keywords, region, tourPackage));

	}

	public Iterable<Tour> lookup() {
		return tourRepository.findAll();
	}

	public long total() {
		return tourRepository.count();
	}

}
