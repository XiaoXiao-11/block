package com.xiao;

import com.xiao.frame.GameControl;
import com.xiao.frame.GameSurface;
import com.xiao.frame.GameWindow;

public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow   = new GameWindow();
        GameSurface gameSurface = new GameSurface();
        GameControl gameControl = new GameControl(gameSurface);
        gameWindow.getContentPane().add(gameSurface);
        gameWindow.getContentPane().add(gameControl);
        gameWindow.setVisible(true);

    }
}
