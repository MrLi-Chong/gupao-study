package com.gupao.merment;

/**
 * @Author Administrator
 * @Date 2020/4/22 14:17
 */
public class ArticleMerment {
    private String title;
    private String content;

    public ArticleMerment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleMerment{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
