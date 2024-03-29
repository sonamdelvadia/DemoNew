package com.timeonhand.Pojo.Test;

import com.google.gson.annotations.SerializedName;

//import javax.annotation.Generated;
//import com.google.gson.annotations.SerializedName;
//
//@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	protected int id;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("first_name")
	private String firstName;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",first_name = '" + firstName + '\'' + 
			"}";
		}
}