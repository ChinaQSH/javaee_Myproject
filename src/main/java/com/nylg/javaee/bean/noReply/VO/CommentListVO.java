package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 17:32
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.User;

/**
 *@Description:
 *
 */
public class CommentListVO {
    private GetUserNameVO user=new GetUserNameVO();
    private Integer score;
    private Integer id;
    private String specName;
    private String comment;
    private String time;
    private Integer userId;
    private String nickname;

    public void setNickname(String nickname) {
        user.setNickname(nickname);
    }

    public GetUserNameVO getUser() {
        return user;
    }

    public void setUser(GetUserNameVO user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
