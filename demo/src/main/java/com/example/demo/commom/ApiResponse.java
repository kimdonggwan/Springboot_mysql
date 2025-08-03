package com.example.demo.commom;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private boolean success;
	private T data;
	private String message;
	
	public ApiResponse() {}
	
	public ApiResponse(boolean success, T data, String message) {
		this.success = success;
		this.data = data;
		this.message = message;
	}
	
	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(true, data, null);
	}
	
	public static <T> ApiResponse<T> fail(String message) {
		return new ApiResponse<>(false, null, message);
	}
}
