package com.xiao.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 游戏控制
 */
public class GameControl extends JPanel {
    private int panelWidth  = 200;
    private int panelHeight = 500;
    public GameControl(GameSurface gameSurface){
        this.setBounds(600, 0, panelWidth, panelHeight);
        this.setBackground(Color.gray); //设置背景颜色
        this.setLayout(null);//更改layout 以便添加组件

        JButton startBtn = new JButton("开始");
        startBtn.setBounds(50,300,100,30);
        startBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSurface.start();
            }
        });
        /** 开始按钮监听键盘按键 */
        startBtn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    gameSurface.change();
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    gameSurface.bottomMove();
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    gameSurface.leftMove();
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    gameSurface.rightMove();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        JButton stopBtn  = new JButton("暂停");
        stopBtn.setBounds(50,340,100,30);
        stopBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSurface.stop();
            }
        });
        JButton endBtn   = new JButton("结束");
        endBtn.setBounds(50,380,100,30);
        endBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSurface.end();
            }
        });

        this.add(startBtn);
        this.add(stopBtn);
        this.add(endBtn);
    }
}
