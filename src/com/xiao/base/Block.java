package com.xiao.base;

/**
 * 方块
 */
public class Block {
    private int y;
    private int x;
    public final static int width  = 20;
    public final static int height = 20;

    public Block( int x,int y) {
        this.y = y * Block.width;
        this.x = x * Block.height;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
