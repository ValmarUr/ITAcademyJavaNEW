package com.itacademy.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
//@DynamicInsert
@Entity
@Table(name="pictures")
public class Picture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String author="Anonymous";
	@NotNull
	private String title;
	@PositiveOrZero
	private int price;
	
	private Date entryDay = new Date();
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="shop_id", nullable=false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Shop shop;
	
	
	private Picture() {}
	
	
	public Picture(String author, String title, int price, Shop shop) {
		this.author=author;
		this.title=title;
		this.price=price;
		this.shop=shop;
	}
	
}
