package com.gupao.bridge;

/**
 * @Author Administrator
 * @Date 2020/4/18 19:04
 * 桥接模式
 */
public abstract class AbstractCourse implements ICourse{
    private INote note;
    private IVideo video;

    public INote getNote() {
        return note;
    }

    public void setNote(INote note) {
        this.note = note;
    }

    public IVideo getVideo() {
        return video;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }
}
