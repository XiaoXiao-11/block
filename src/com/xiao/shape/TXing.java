package com.xiao.shape;


import com.xiao.base.Block;
import com.xiao.base.Shape;

/**
 * 方形
 */
public class TXing extends Shape {
    private int x = 0;
    private int y = 0;

    public TXing(int x){
        this.x = x;
        blockCompose(x,y);
    }
    @Override
    public void change(){
        status = status == 4 ? 1 : status + 1;
        blockCompose(x,y);
    }
    @Override
    public void back(){
        status = status == 1 ? 4 : status - 1;
        blockCompose(x,y);
    }
    @Override
    public void rightMove() {
        x++;
        blockCompose(x,y);
    }

    @Override
    public void bottomMove() {
        y++;
        blockCompose(x,y);
    }

    @Override
    public void leftMove() {
        x--;
        blockCompose(x,y);
    }

    @Override
    public void blockCompose(int x,int y){
        switch (status){
            case 1:
                blocks[0] = new Block(x, y);
                blocks[1] = new Block(x, y + 1);
                blocks[2] = new Block(x - 1, y + 1);
                blocks[3] = new Block(x + 1, y + 1);
                break;
            case 2:
                blocks[0] = new Block(x + 1, y + 1);
                blocks[1] = new Block(x, y + 1);
                blocks[2] = new Block(x, y);
                blocks[3] = new Block(x, y + 2);
                break;
            case 3:
                blocks[0] = new Block(x, y + 2);
                blocks[1] = new Block(x, y + 1);
                blocks[2] = new Block(x + 1, y + 1);
                blocks[3] = new Block(x - 1, y + 1);
                break;
            case 4:
                blocks[0] = new Block(x - 1, y + 1);
                blocks[1] = new Block(x, y + 1);
                blocks[2] = new Block(x, y + 2);
                blocks[3] = new Block(x, y);
                break;
        }
    }
}
