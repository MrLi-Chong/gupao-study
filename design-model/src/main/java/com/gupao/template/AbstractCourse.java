package com.gupao.template;

/**
 * @Author Administrator
 * @Date 2020/4/19 15:37
 */
public abstract class AbstractCourse {
    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    public void createCourse(){
        //1.预习资料
        preResource();
        //2.制作PPT
        createPPT();
        //3.直播
        liveVideo();
        //4.上传课后资料
        postResource();
        //5.布置作业
        preHomework();
        if(needCheckHomeWork()){
            checkHomeWork();
        }
    }

    private void checkHomeWork() {
        System.out.println("检查作业");
    }

    protected abstract boolean needCheckHomeWork();

    private void preHomework() {
        System.out.println("布置作业");
    }

    private void postResource() {
        System.out.println("上传课后资料");
    }

    private void liveVideo() {
        System.out.println("直播");
    }

    private void createPPT() {
        System.out.println("制作PPT");
    }

    private void preResource() {
        System.out.println("预习资料");
    }
}
