package com.subhashree.exception;

public class ResourceNotFoundException extends RuntimeException {
	String resourceName;
	String fieldValue;
	String FieldName;
	public ResourceNotFoundException(String resourceName, String fieldValue, Integer userId) {
		super(String.format("%s not found with %s", resourceName,userId,fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.FieldName = FieldName;
	}
	
}


