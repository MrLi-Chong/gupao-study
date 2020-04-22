package com.gupao.merment;

/**
 * @Author Administrator
 * @Date 2020/4/22 14:33
 * 备忘录设计模式
 */
public class Test {
    public static void main(String[] args) {
        DraftBox box = new DraftBox();

        Editor editor = new Editor("1","test1");

        ArticleMerment articleMerment = editor.saveToMerment();
        box.addMerment(articleMerment);

        System.out.println("标题："+editor.getTitle()+"\n"+"内容："+editor.getContent());

        System.out.println("第一次修改");
        editor.setTitle("2");
        editor.setContent("test2");
        System.out.println("第一次修改完成");
        System.out.println("完成信息："+editor.toString());

        articleMerment = editor.saveToMerment();
        box.addMerment(articleMerment);
        System.out.println("保存到草稿箱");

        System.out.println("第2次修改");
        editor.setTitle("3");
        editor.setContent("test3");
        System.out.println("完成信息："+editor.toString());
        System.out.println("第2次修改完成");

        System.out.println("第一次撤销回退");
        articleMerment = box.getMerment();
        editor.undoFromMerment(articleMerment);
        System.out.println(editor);

        System.out.println("第2次撤销回退");
        articleMerment = box.getMerment();
        editor.undoFromMerment(articleMerment);
        System.out.println(editor);
    }
}
