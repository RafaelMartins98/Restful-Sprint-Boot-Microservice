package com.example.ec.explorecali.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repository.ITourPackageRepository;

@Service
public class TourPackageService {

	private ITourPackageRepository tourPackageRepository;

	@Autowired
	public TourPackageService(ITourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}

	public TourPackage createTourPackage(String code, String name) {
		if (!tourPackageRepository.existsById(code)) {
			return tourPackageRepository.save(new TourPackage(code, name));
		}
		return null;
	}
	
	public Iterable<TourPackage> lookup(){
		return tourPackageRepository.findAll();
	}
	
	public long total() {
		return tourPackageRepository.count();
	}

}
