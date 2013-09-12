package cn.pcs.domain;

import java.util.List;

public class PageBean {

	private int sumRecord;  //表中总的记录数
	
	private int currentPageIndex = 1;
	private int pageSize = 10;
	private int pageBarLength = 4;
	
	private List items;
	private List<Integer> pageBar;
	
	public int getSumRecord() {
		return sumRecord;
	}
	public void setSumRecord(int sumRecord) {
		this.sumRecord = sumRecord;
	}
	public int getPageBarLength() {
		return pageBarLength;
	}
	public void setPageBarLength(int pageBarLength) {
		this.pageBarLength = pageBarLength;
	}
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
		
		int maxPageBarLength = (sumRecord % pageSize)==0 ? (sumRecord / pageSize) : (sumRecord / pageSize +1);
		int pageBarStartIndex = 1;
		int pageBarEndIndex = 1;
		if((currentPageIndex - pageBarLength/2) < 1)
		{
			pageBarEndIndex = pageBarLength>maxPageBarLength ? maxPageBarLength : pageBarLength;
		}else if(((currentPageIndex - pageBarLength/2)+pageBarLength-1) > maxPageBarLength)
		{
			pageBarStartIndex = currentPageIndex - pageBarLength/2;
			pageBarEndIndex = maxPageBarLength;
		}else{
			pageBarStartIndex = currentPageIndex - pageBarLength/2;
			pageBarEndIndex = currentPageIndex - pageBarLength/2 + pageBarLength-1;
		}
			
		for(;pageBarStartIndex <= pageBarEndIndex; pageBarStartIndex++)
		{
			pageBar.add(pageBarStartIndex);
		}
			
		return pageBar;
	}

	
}
