package com.kevin.aeas.object;

public class Teacher {
	private int id;
	private String name;
	private String shortName;
	private String phone;
	private boolean isMaster;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String name, String shortName, String phone,
			boolean isMaster) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.phone = phone;
		this.isMaster = isMaster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isMaster() {
		return isMaster;
	}

	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", shortName="
				+ shortName + ", phone=" + phone + ", isMaster=" + isMaster
				+ "]";
	}
	
	

}
