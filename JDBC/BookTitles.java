package com.metacube.jdbc.session1;

public class BookTitles {
	
	private int titleId ;
	private String titleName;

	
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	@Override
	public String toString() {
		return "BookTitles [titleId=" + titleId + ", titleName=" + titleName
				+ "]";
	}
	
}
