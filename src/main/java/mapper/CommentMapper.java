package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Category;
import pojo.Comment;

import java.util.List;

/**
 * @author f5gua
 */
@Mapper
public interface CommentMapper {


    void addComment(Comment comment);

    List<Comment> queryByPid(String pid);

    Comment queryByCommentId(String commentId);

    void deleteBycommentId(String commentId);

    void updateComment(Comment comment);
}
