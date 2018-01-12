package org.zerock.dto;

public class LoginDTO {
	/*
	 * VO(Value Object)와 DTO(Data Transfer Object)
	 * 1. VO와 DTO 모두 데이터의 수집과 전달에 사용할 수 있다는 공통점이 있음
	 * 2. VO는 DB와의 거리가 더 가까우며 테이블의 구조를 이용해서 작성되는 경우가 많음
	 * 3. DTO의 경우는 보다 화면에 가까우며 화면에서 전달되는 데이터를 수집하는 용도로 사용하는 겨우가 많음 
	 */	
	
	private String uid;
	private String upw;
	private boolean useCookies;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUseCookies() {
		return useCookies;
	}
	public void setUseCookies(boolean useCookies) {
		this.useCookies = useCookies;
	}
	
	
}
