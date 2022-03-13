package com.itacademy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.rest.exception.FullShopException;
import com.itacademy.rest.exception.ResourceNotFoundException;
import com.itacademy.rest.model.Picture;
import com.itacademy.rest.model.Shop;
import com.itacademy.rest.repository.IPictureRepository;
import com.itacademy.rest.repository.IShopRepository;

@Service
public class ShopServiceImpl implements IShopService {

	@Autowired
	private IShopRepository shopRepo;
	
	@Autowired
	private IPictureRepository picRepo;
	
	@Override
	public Shop createShop(Shop shop) {
		
		return shopRepo.save(shop);
	}

	@Override
	public List<Shop> getAllShops() {
		
		return this.shopRepo.findAll();
	}

	@Override
	public Picture createPicture(Picture picture, long id) {
		
		Picture pic = shopRepo.findById(id).map(shop ->{

			if(shop.getMaxCapacity() > getAllPictures(id).size()) {
				picture.setShop(shop);
				return picRepo.save(picture);
			}
			else throw new FullShopException("The Shop's full of pictures and you can't aquire anymore");
		}).orElseThrow(()-> new ResourceNotFoundException("Not found Shop with id = " + id));
		
		return pic;
	}

	@Override
	public List<Picture> getAllPictures(long id) {
		return this.picRepo.findByShopId(id);
	}

	@Override
	public void deleteAllPictures(long id) {
		this.picRepo.deleteByShopId(id);
	}

}
