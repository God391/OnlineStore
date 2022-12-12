package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Category;
import pojo.Comment;

/**
 * @author f5gua
 */
@Mapper
public interface CommentMapper {


    void addComment(Comment comment);
}
