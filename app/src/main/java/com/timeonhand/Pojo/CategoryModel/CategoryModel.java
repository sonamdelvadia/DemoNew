package com.timeonhand.Pojo.CategoryModel;

import com.google.gson.annotations.SerializedName;

public class CategoryModel{

	@SerializedName("categoryImage")
	private String categoryImage;

	@SerializedName("categoryThumb")
	private String categoryThumb;

	@SerializedName(value = "categoryName",alternate = "subCategoryName")
	private String categoryName;

	@SerializedName(value = "categoryId",alternate = "subCategoryId")
	private String categoryId;

	@SerializedName("status")
	private String status;

	@SerializedName("statusCode")
	private String statusCode;

	public void setCategoryImage(String categoryImage){
		this.categoryImage = categoryImage;
	}

	public String getCategoryImage(){
		return categoryImage;
	}

	public void setCategoryThumb(String categoryThumb){
		this.categoryThumb = categoryThumb;
	}

	public String getCategoryThumb(){
		return categoryThumb;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setStatusCode(String statusCode){
		this.statusCode = statusCode;
	}

	public String getStatusCode(){
		return statusCode;
	}

	@Override
 	public String toString(){
		return 
			"CategoryModel{" + 
			"categoryImage = '" + categoryImage + '\'' + 
			",categoryThumb = '" + categoryThumb + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",status = '" + status + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			"}";
		}
}