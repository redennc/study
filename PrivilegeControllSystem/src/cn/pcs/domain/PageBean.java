package cn.pcs.domain;

import java.util.List;

public class PageBean {

	private int currentPageIndex = 1;
	private int pageSize = 10;
	private int pageBarLength = 10;
	
	private List items;
	private List<Integer> pageBar;
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	public List<Integer> getPageBar() {
		
		
		return pageBar;
	}

	
}
