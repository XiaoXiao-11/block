package com.xiao.shape;


import com.xiao.base.Block;
import com.xiao.base.Shape;

/**
 *  反向 L形
 */
public class LLXing extends Shape {
    private int x = 0;
    private int y = 0;

    public LLXing(int x){
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
                blocks[0] = new Block((x - 1) * Block.width, (y + 1) * Block.height);
                blocks[1] = new Block(x * Block.width, (y + 1) * Block.height);
                blocks[2] = new Block(x * Block.width, y * Block.height);
                blocks[3] = new Block(x * Block.width, (y - 1) * Block.height);
                break;
            case 2:
                blocks[0] = new Block(x * Block.width, y * Block.height);
                blocks[1] = new Block(x * Block.width, (y + 1) * Block.height);
                blocks[2] = new Block((x + 1) * Block.width, (y + 1) * Block.height);
                blocks[3] = new Block((x + 2) * Block.width, (y + 1) * Block.height);
                break;
            case 3:
                blocks[0] = new Block((x + 1) * Block.width, (y + 1) * Block.height);
                blocks[1] = new Block(x * Block.width, (y + 1) * Block.height);
                blocks[2] = new Block(x * Block.width, (y + 2) * Block.height);
                blocks[3] = new Block(x * Block.width, (y + 3) * Block.height);
                break;
            case 4:
                blocks[0] = new Block(x * Block.width, (y + 2) * Block.height);
                blocks[1] = new Block(x * Block.width, (y + 1) * Block.height);
                blocks[2] = new Block((x - 1) * Block.width, (y + 1) * Block.height);
                blocks[3] = new Block((x - 2) * Block.width, (y + 1) * Block.height);
                break;
        }
    }
}
