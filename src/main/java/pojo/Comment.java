package pojo;

/**
 * @author f5gua
 */
public class Comment {

    /**
     * 评论ID
     */
    private String comment_id;

    /**
     * 评论者ID
     */
    private String user_id;

    private String username;

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
    private String createtime;

    /**
     * 更新时间
     */
    private String updatetime;

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

    public Comment(String comment_id, String user_id, String username, String content, String pid, String createtime, String updatetime, Integer rating, Integer state) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.username = username;
        this.content = content;
        this.pid = pid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.rating = rating;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Comment{" + "comment_id='" + comment_id + '\'' + ", user_id='" + user_id + '\'' + ", username='" + username + '\'' + ", content='" + content + '\'' + ", pid='" + pid + '\'' + ", createtime='" + createtime + '\'' + ", updatetime='" + updatetime + '\'' + ", rating=" + rating + ", state=" + state + '}';
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
