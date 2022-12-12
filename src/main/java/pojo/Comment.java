package pojo;

/**
 * @author f5gua
 */
public class Comment {

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 评论者ID
     */
    private String userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 商品ID
     */
    private String pid;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 星级
     */
    private Integer rating;

    /**
     * 删除状态 0未删除 1删除
     */
    private Integer state;

    public Comment() {
    }

    public Comment(String commentId, String userId, String content, String pid, Long createTime, Long updateTime, Integer rating, Integer state) {
        this.commentId = commentId;
        this.userId = userId;
        this.content = content;
        this.pid = pid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.rating = rating;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId='" + commentId + '\'' + ", userId='" + userId + '\'' + ", content='" + content + '\'' + ", pid='" + pid + '\'' + ", createTime='" + createTime + '\'' + ", updateTime='" + updateTime + '\'' + ", rating=" + rating + ", state=" + state + '}';
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


}
