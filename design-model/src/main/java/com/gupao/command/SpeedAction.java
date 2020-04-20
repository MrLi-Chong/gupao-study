package com.gupao.command;

/**
 * @Author Administrator
 * @Date 2020/4/20 21:04
 */
public class SpeedAction implements IAtion {

    private GPlayer player;

    public SpeedAction(GPlayer player) {
        this.player = player;
    }

    @Override
    public void executeAction() {
        player.speed();
    }
}
