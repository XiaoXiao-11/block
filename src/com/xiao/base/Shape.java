package com.xiao.base;

import java.awt.*;

/**
 *  形状
 */
public abstract class Shape {
    protected final Block[] blocks = new Block[4];  //方块数组，4个方块组合成一个图形;
    protected int status = 1; //方块的状态 4种状态
    public void paint(Graphics g) {
        g.setColor(Color.red);
        for(Block block : blocks){
            g.fillRect(block.getX(), block.getY(),block.getWidth() -1 , block.getHeight() -1);
        }
    }
    public abstract void back();
    public abstract void change();
    public abstract void bottomMove();
    public abstract void leftMove();
    public abstract void rightMove();
    public abstract void blockCompose(int x,int y);

    public Block[] getBlocks() {
        return blocks;
    }
}
