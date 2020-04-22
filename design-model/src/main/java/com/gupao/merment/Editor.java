package com.gupao.merment;

/**
 * @Author Administrator
 * @Date 2020/4/22 14:14
 */
public class Editor {
    private String title;
    private String content;


    public ArticleMerment saveToMerment(){
        return new ArticleMerment(title,content);
    }

    public void undoFromMerment(ArticleMerment merment){
        this.title = merment.getTitle();
        this.content = merment.getContent();
    }

    public Editor(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
