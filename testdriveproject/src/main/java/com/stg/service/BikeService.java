package com.stg.service;

import java.util.List;

import com.stg.model.BikeModel;

public interface BikeService {
	public abstract BikeModel createBike(BikeModel bikeModel);

	public abstract List<BikeModel> readBikeByName(String bikeName);

	public abstract java.util.Optional<BikeModel> updateBikeById(int modelNo);

	public abstract String deleteBikeByName(String bikeName);
	
	public abstract String deleteByBikeId(int bikeId,BikeModel bikeModel);

}