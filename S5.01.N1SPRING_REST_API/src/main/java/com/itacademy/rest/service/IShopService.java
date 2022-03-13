package com.itacademy.rest.service;

import java.util.List;

import com.itacademy.rest.model.Picture;
import com.itacademy.rest.model.Shop;

public interface IShopService {

	Shop createShop(Shop shop);

	List<Shop> getAllShops();

	Picture createPicture(Picture picture, long id);

	List<Picture> getAllPictures(long id);

	void deleteAllPictures(long id);
	
	

}
