package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.ResourceNotFoundException;
import com.stg.model.BikeModel;
import com.stg.repository.BikeModelRepository;

@Service
public class BikeServiceImpl implements BikeService {
	@Autowired
	private BikeModelRepository bikeModelRepository;

	@Override
	public BikeModel createBike(BikeModel bikeModel) {
		BikeModel bikeModel1 = bikeModelRepository.save(bikeModel);
		return bikeModel1;
	}

	@Override
	public List<BikeModel> readBikeByName(String bikeName) {
		List<BikeModel> bikeModels = bikeModelRepository.findByBikeName(bikeName);
		return bikeModels;
	}

	@Override
	public java.util.Optional<BikeModel> updateBikeById(int modelNo) throws ResourceNotFoundException {
		java.util.Optional<BikeModel> optional = bikeModelRepository.findById(modelNo);
		if (optional.isPresent()) {
			return optional;

		} else {
			throw new ResourceNotFoundException("Id is not found");

		}
	}

	@Override
	public String deleteBikeByName(String bikeName) throws ResourceNotFoundException {
		List<Integer> bikeIds = bikeModelRepository.findByNameReturnBikeId(bikeName);
		String message = null;
		if (bikeIds.size() != 0) {
			for (Integer integer : bikeIds) {
				bikeModelRepository.deleteById(integer);
			}
			message = "Deleted Successfull";
		} else {
			throw new ResourceNotFoundException("Name is not found");
		}
		return message;
	}

	@Override
	public String deleteByBikeId(int bikeId,BikeModel bikeModel) {
		if(bikeModel.getModelNo() == bikeId) {
			bikeModelRepository.deleteById(bikeId);
			return "deleted";
		}
		else {
			throw new ResourceNotFoundException("Id is not found");
		}
	}

}
