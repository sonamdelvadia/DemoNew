package com.timeonhand.Pojo.ProductResponseModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductModel{

	@SerializedName("total")
	private int total;

	@SerializedName("currPage")
	private int currPage;

	@SerializedName("offset")
	private int offset;

	@SerializedName("totalPage")
	private int totalPage;

	@SerializedName("products")
	private List<ProductsItem> products;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setCurrPage(int currPage){
		this.currPage = currPage;
	}

	public int getCurrPage(){
		return currPage;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}

	public int getTotalPage(){
		return totalPage;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"ProductModel{" + 
			"total = '" + total + '\'' + 
			",currPage = '" + currPage + '\'' + 
			",offset = '" + offset + '\'' + 
			",totalPage = '" + totalPage + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}