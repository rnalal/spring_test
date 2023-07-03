package kr.co.tjoeun.bean;

import lombok.Getter;

@Getter
public class PageBean {
  
  // 최소 페이지 번호
  private int min;
  
  // 최대 페이지 번호
  private int max;
  
  // 이전 버튼의 페이지 번호
  private int prevPage;
  
  // 다음 버튼의 페이지 번호
  private int nextPage;
  
  // 전체 페이지 개수
  private int pageCnt;
  
  // 현재 페이지 번호
  private int currentPage;
  
  

  // 생성자의 parameter
  // 전체글 개수, 현재 페이지 번호, 페이지당 글개수, 페이지 버튼 개수
  // contentCnt   currentPage       contentPageCnt     paginationCnt 
  public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
	
	// 현재 페이지 번호
	this.currentPage = currentPage;
	
	// 전체 페이지 개수 = 전체 글 개수 / 페이지당 글 개수
	this.pageCnt = contentCnt / contentPageCnt;
	// 125 / 10 <-- 12...5 : 125 % 10 <-- 5 > 0
	if (contentCnt % contentPageCnt > 0) {
	  this.pageCnt += 1;
	}
	
	/*          min   max
	    0 ~ 9  :  1,  10 
	   10 ~ 19 : 11,  20 
	   20 ~ 29 : 21,  30 	 
	*/
	min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
	max = min + paginationCnt - 1;
	
	if(max > pageCnt) {
	  max = pageCnt;
	}
	
	prevPage = min - 1;
	nextPage = max + 1;
	
	if(nextPage > pageCnt) {
	  nextPage = pageCnt;
	}
	
	
  } // 생성자
  

}


