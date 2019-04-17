package com.timeonhand.Pojo.ProductResponseModel;

import com.google.gson.annotations.SerializedName;

public class ProductsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("amount")
	private String amount;

	@SerializedName("average_rating")
	private String averageRating;

	@SerializedName("id")
	private String id;

	@SerializedName("categoryName")
	private String categoryName;

	@SerializedName("productName")
	private String productName;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setAverageRating(String averageRating){
		this.averageRating = averageRating;
	}

	public String getAverageRating(){
		return averageRating;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	@Override
 	public String toString(){
		return 
			"ProductsItem{" + 
			"image = '" + image + '\'' + 
			",amount = '" + amount + '\'' + 
			",average_rating = '" + averageRating + '\'' + 
			",id = '" + id + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			",productName = '" + productName + '\'' + 
			"}";
		}
}