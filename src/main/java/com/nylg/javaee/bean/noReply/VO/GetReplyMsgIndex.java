package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 16:59
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class GetReplyMsgIndex {
    private Integer id;
    private String content;
    private String asker;
    private String time;
    private Reply reply=new Reply();
    private String replyContent;
    private String replytime;

    public void setReplytime(String replytime) {
        reply.setTime(replytime);
    }

    public void setReplyContent(String replyContent) {
        reply.setContent(replyContent);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    @Override
    public String toString() {
        return "GetReplyMsgIndex{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", asker='" + asker + '\'' +
                ", time='" + time + '\'' +
                ", reply=" + reply +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }
}
