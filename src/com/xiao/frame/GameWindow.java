package com.xiao.frame;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏主窗口
 */
public class GameWindow extends JFrame {
    public GameWindow(){
        Dimension frameSize = new Dimension(800, 530);
        this.setSize(frameSize);//设置窗口大小
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        if (frameSize.width > displaySize.width){
            frameSize.width = displaySize.width;           // 窗口的宽度不能大于显示器的宽度
        }
        this.setLocation((displaySize.width - frameSize.width) / 2,
                (displaySize.height - frameSize.height) / 2); // 设置窗口居中显示器显示
        this.setLayout(null);//更改layout 以便添加组件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口的状态
        this.setResizable(false);//窗口不可以改变大小
        this.setTitle("我的俄罗斯方块");
    }
}
