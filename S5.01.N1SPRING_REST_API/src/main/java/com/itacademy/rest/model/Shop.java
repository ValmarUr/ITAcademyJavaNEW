package com.itacademy.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="shops")
public class Shop {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotNull @Min(value = 0)
	private int maxCapacity;
	
//	@OneToMany()
//	private List<Picture> pictureStock;
	
	public Shop() {}
	
	public Shop(String name, int maxCapacity) {
		this.name = name;
		this.maxCapacity=maxCapacity;
//		pictureStock = new ArrayList<Picture>();
	}
	
//	public Shop(String name, int maxCapacity, List<Picture> pictureStock) {
//		this(name, maxCapacity);
//		this.pictureStock=pictureStock;
//	}
	
	
	
	
}
