package com.gupao.command;

/**
 * @Author Administrator
 * @Date 2020/4/20 21:08
 * 命令模式
 */
public class Test {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        PauseAction pauseAction = new PauseAction(player);
        PlayAction playAction = new PlayAction(player);
        SpeedAction speedAction = new SpeedAction(player);
        StopAction stopAction= new StopAction(player);
        controller.add(pauseAction);
        controller.add(playAction);
        controller.add(speedAction);
        controller.add(stopAction);
        controller.executes();
    }
}
