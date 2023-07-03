package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
  
  /*
      content_table 에 insert 하기 #{content_file, jdbcType=VARCHAR}
  	     ㄴ 이미지를 추가 하지 않으면 content_file 에 들어오는 값이 null 이 되는데 
  	        이 때, null 값이 들어와도 오류가 발생하지 않게 하려면 
  	        jdbcType=VARCHAR 를 설정함 
	    
	    현재 sequence 값을 가져와서  
	    SELECT content_seq.nextval FROM DUAL	    
	    ContentBean 객체의 멤버변수 content_idx에 할당한 후,
	    insert 문을 실행함
	    VALUES(content_seq.nextval, ...) -> VALUES(#{content_idx}, ...) 으로 변경함
	    	
   */
  // 현재 sequence 값 가져오기
  @SelectKey(statement="SELECT content_seq.nextval FROM DUAL",
	         keyProperty="content_idx", before=true, resultType=int.class)
  // content_table 에 insert 하기
  @Insert("INSERT INTO content_table(content_idx, content_subject, content_text, " +
  	      "content_file, content_writer_idx, content_board_idx, content_date) " + 
  	      "VALUES(#{content_idx}, #{content_subject}, #{content_text}, " +
  	      "#{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
  void addContentInfo(ContentBean writeContentBean);
  
  // 게시판 index 로 게시판 이름 가져오기(조회하기)  <-- SELECT
  @Select("SELECT board_info_name " + 
  	      "FROM board_info_table " + 
  	      "WHERE board_info_idx=#{board_info_idx}")
  String getBoardInfoName(int board_info_idx);
  
  // 게시글 리스트 가져오기
  @Select("SELECT c.content_idx, c.content_subject, u.user_name content_writer_name, " +
  	      "TO_CHAR(c.content_date, 'YYYY-MM-DD') content_date " + 
  	      "FROM content_table c, user_table u " + 
  	      "WHERE c.content_writer_idx = u.user_idx " +
  	      "AND c.content_board_idx = #{c.board_info_idx} " +
  	      "ORDER BY c.content_idx desc")  
  ArrayList<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);
  
  // 상세페이지에 출력할 데이터 가져오기
  // 작성자(이름)-user_name(content_writer_name), 
  // 작성날짜-content_date, 제목-content_subject, 
  // 내용-cotent.text, 첨부이미지-content_file
  @Select("SELECT u.user_name content_writer_name, " + 
  	      "TO_CHAR(content_date, 'YYYY-MM-DD') content_date, " + 
  	      "c.content_subject, c.content_text, c.content_file, c.content_writer_idx " + 
  	      "FROM content_table c, user_table u " + 
  	      "WHERE c.content_writer_idx = u.user_idx " + 
  	      "AND c.content_idx = ${content_idx}")
  ContentBean getContentInfo(int content_idx);
  
  // 수정 페이지에서 게시글 수정하기
  @Update("UPDATE content_table " + 
  	      "SET content_subject = #{content_subject}, content_text=#{content_text}, " +
  	      "content_file=#{content_file, jdbcType=VARCHAR} " + 
  	      "WHERE content_idx = #{content_idx}")
  void modifyContentInfo(ContentBean modifyContentBean);
  
  // 게시글 삭제하기
  @Delete("DELETE FROM content_table " + 
  	      "WHERE content_idx = #{content_idx}")
  void deleteContentInfo(int content_idx);
  
  // 게시글 전체 개수 가져오기
  @Select("SELECT count(*) FROM content_table " + 
  	      "WHERE content_board_idx = #{content_board_idx}")
  int getContentCnt(int content_board_idx);
  
}








