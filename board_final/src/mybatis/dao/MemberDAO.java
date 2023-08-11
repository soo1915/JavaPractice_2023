package mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import article.model.Article;
import article.model.ArticleContent;
import member.model.Member;

@Mapper
public interface MemberDAO {
	
	@Select("select * from member")
	List<Member> selectAll();
	
	Integer selectCount();
	
	List<Member> selectList();
	
	Member selectById(String id);
	
	void updateArticle(String title, int num);
	
	void insertArtCont(@Param("artCon") ArticleContent articleContent);
	
	void insertArticle(@Param("art") Article article);
}
