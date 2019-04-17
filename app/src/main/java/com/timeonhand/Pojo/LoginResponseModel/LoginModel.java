package com.timeonhand.Pojo.LoginResponseModel;

import com.google.gson.annotations.SerializedName;

public class LoginModel{

	@SerializedName("uId")
	private String uId;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("address")
	private Object address;

	@SerializedName("phone")
	private Object phone;

	@SerializedName("address2")
	private Object address2;

	@SerializedName("city")
	private String city;

	@SerializedName("userName")
	private String userName;

	@SerializedName("profileImg")
	private String profileImg;

	@SerializedName("status")
	private String status;

	@SerializedName("statusCode")
	private String statusCode;

	public void setUId(String uId){
		this.uId = uId;
	}

	public String getUId(){
		return uId;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setAddress(Object address){
		this.address = address;
	}

	public Object getAddress(){
		return address;
	}

	public void setPhone(Object phone){
		this.phone = phone;
	}

	public Object getPhone(){
		return phone;
	}

	public void setAddress2(Object address2){
		this.address2 = address2;
	}

	public Object getAddress2(){
		return address2;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setProfileImg(String profileImg){
		this.profileImg = profileImg;
	}

	public String getProfileImg(){
		return profileImg;
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
			"LoginModel{" + 
			"uId = '" + uId + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",address = '" + address + '\'' + 
			",phone = '" + phone + '\'' + 
			",address2 = '" + address2 + '\'' + 
			",city = '" + city + '\'' + 
			",userName = '" + userName + '\'' + 
			",profileImg = '" + profileImg + '\'' + 
			",status = '" + status + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			"}";
		}
}