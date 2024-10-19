package com.model;

public class VoterReg {
	private int id;
	private String name,address;
	private long aadharNo;
	private String birthDate;
	@Override
	public String toString() {
		return "VoterReg [id=" + id + ", name=" + name + ", address=" + address + ", aadharNo=" + aadharNo
				+ ", birthDate=" + birthDate + ", age=" + age + "]";
	}

	private int age;
	private boolean voting;
	
	
	public String getName() {
		return name;
	}

	public void isVoting(Boolean voting) {
		this.voting = voting;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	
	public boolean getVoting()
	{
		return voting;
	}
	
	public VoterReg(int id,String name, String address, long aadharNo,  String date,int age) {
		this.id=id;
		this.name = name;
		this.address = address;
		this.aadharNo = aadharNo;
		this.age = age;
		this.birthDate = date;
	}


	
}
