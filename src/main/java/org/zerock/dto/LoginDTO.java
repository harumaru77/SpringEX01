package org.zerock.dto;

public class LoginDTO {
	/*
	 * VO(Value Object)�� DTO(Data Transfer Object)
	 * 1. VO�� DTO ��� �������� ������ ���޿� ����� �� �ִٴ� �������� ����
	 * 2. VO�� DB���� �Ÿ��� �� ������ ���̺��� ������ �̿��ؼ� �ۼ��Ǵ� ��찡 ����
	 * 3. DTO�� ���� ���� ȭ�鿡 ������ ȭ�鿡�� ���޵Ǵ� �����͸� �����ϴ� �뵵�� ����ϴ� �ܿ찡 ���� 
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
