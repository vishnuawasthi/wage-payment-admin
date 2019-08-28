package com.app.utils;

public class ClientType {

	private String typeName;

	private String typeCode;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Override
	public String toString() {
		return "ClientType [typeName=" + typeName + ", typeCode=" + typeCode + "]";
	}

	public ClientType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientType(String typeName, String typeCode) {
		super();
		this.typeName = typeName;
		this.typeCode = typeCode;
	}

}
