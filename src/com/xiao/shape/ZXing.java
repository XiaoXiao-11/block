package com.xiao.shape;


import com.xiao.base.Block;
import com.xiao.base.Shape;

/**
 * 方形
 */
public class ZXing extends Shape {
    private int x = 0;
    private int y = 0;

    public ZXing(int x){
        this.x = x;
        blockCompose(x,y);
    }
    @Override
    public void change(){
        status = status == 2 ? 1 : status + 1;
        blockCompose(x,y);
    }
    @Override
    public void back(){
        status = status == 1 ? 2 : status - 1;
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
                blocks[0] = new Block(x * Block.width, y * Block.height);
                blocks[1] = new Block((x + 1) * Block.width, y * Block.height);
                blocks[2] = new Block((x + 1) * Block.width, (y + 1) * Block.height);
                blocks[3] = new Block((x + 2) * Block.width, (y + 1) * Block.height);
                break;
            case 2:
                blocks[0] = new Block((x + 1) * Block.width, (y - 1) * Block.height);
                blocks[1] = new Block((x + 1) * Block.width, y * Block.height);
                blocks[2] = new Block(x * Block.width, y * Block.height);
                blocks[3] = new Block(x * Block.width, (y + 1) * Block.height);
                break;
        }
    }
}
