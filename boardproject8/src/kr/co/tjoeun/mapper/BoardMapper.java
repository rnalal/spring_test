package kr.co.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
  
  // content_table 에 insert 하기
  @Insert("INSERT INTO content_table(content_idx, content_subject, content_text, " +
  	      "content_file, content_writer_idx, content_board_idx, content_date) " + 
  	      "VALUES(content_seq.nextval, #{content_subject}, #{content_text}, " +
  	      "#{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
  void addContentInfo(ContentBean writeContentBean);

}
