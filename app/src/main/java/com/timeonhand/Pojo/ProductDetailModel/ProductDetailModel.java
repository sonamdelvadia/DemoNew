package com.timeonhand.Pojo.ProductDetailModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetailModel{

	@SerializedName("productDesc")
	private String productDesc;

	@SerializedName("amount")
	private String amount;

	@SerializedName("productImages")
	private List<List<String>> productImages;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("catname")
	private Object catname;

	@SerializedName("pId")
	private String pId;

	@SerializedName("subcatname")
	private Object subcatname;

	@SerializedName("productName")
	private String productName;

	@SerializedName("orgAmount")
	private String orgAmount;

	@SerializedName("status")
	private String status;

	@SerializedName("statusCode")
	private String statusCode;

	public void setProductDesc(String productDesc){
		this.productDesc = productDesc;
	}

	public String getProductDesc(){
		return productDesc;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setProductImages(List<List<String>> productImages){
		this.productImages = productImages;
	}

	public List<List<String>> getProductImages(){
		return productImages;
	}

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
	}

	public void setCatname(Object catname){
		this.catname = catname;
	}

	public Object getCatname(){
		return catname;
	}

	public void setPId(String pId){
		this.pId = pId;
	}

	public String getPId(){
		return pId;
	}

	public void setSubcatname(Object subcatname){
		this.subcatname = subcatname;
	}

	public Object getSubcatname(){
		return subcatname;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setOrgAmount(String orgAmount){
		this.orgAmount = orgAmount;
	}

	public String getOrgAmount(){
		return orgAmount;
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
			"ProductDetailModel{" + 
			"productDesc = '" + productDesc + '\'' + 
			",amount = '" + amount + '\'' + 
			",productImages = '" + productImages + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",catname = '" + catname + '\'' + 
			",pId = '" + pId + '\'' + 
			",subcatname = '" + subcatname + '\'' + 
			",productName = '" + productName + '\'' + 
			",orgAmount = '" + orgAmount + '\'' + 
			",status = '" + status + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			"}";
		}
}