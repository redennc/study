package cn.pro.Domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int startIndex = 1;  //当前页数
	private int pageSize = 5;
	private int recordCount = 0;
	private int displayPageNums = 5; //页条 最多显示多少 页
	//private int currentPageIndex = 1;
	private List list;
	private List<Integer> pageBar = new ArrayList<Integer>();
	

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	public List<Integer> getPageBar() {
		int maxPage=0;
		if(recordCount % pageSize != 0)
			maxPage = recordCount / pageSize + 1;
		else
			maxPage = recordCount / pageSize;
		//this.list = list;
		int endDisplayPageNum = 0;
		int startDisplayPageNum = 0;
		
		
		if((startIndex - displayPageNums/2) <=0)
		{
			startDisplayPageNum = 1;
			endDisplayPageNum = displayPageNums;
		}else if((startIndex - displayPageNums/2 + displayPageNums -1)>maxPage){
			endDisplayPageNum = maxPage;
			startDisplayPageNum = endDisplayPageNum - displayPageNums + 1;
		}else{
			startDisplayPageNum = startIndex - displayPageNums/2;
			endDisplayPageNum = startIndex - displayPageNums/2 + displayPageNums - 1;
		}

		
		for(;startDisplayPageNum<=endDisplayPageNum; startDisplayPageNum++)
			pageBar.add(startDisplayPageNum);
		
		return pageBar;
	}
}
