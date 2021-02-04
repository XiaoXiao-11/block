package com.xiao.frame;

import com.xiao.base.Block;
import com.xiao.factory.ShapeFactory;
import com.xiao.base.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class GameSurface extends JPanel {

    private Shape shape;
    private Timer timer;
    private List<Block> allBlock;
    private int panelWidth  = 600;
    private int panelHeight = 500;
    private int level ;
    private int levelCount ;

    public GameSurface(){
        level      = panelHeight / Block.height;
        levelCount = panelWidth / Block.width;
        allBlock   = new ArrayList<>();
        timer      = new Timer();
        this.setBounds(0, 0, panelWidth, panelHeight);
        this.setBackground(Color.PINK); //设置背景颜色
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(shape != null){
            shape.paint(g);
        }
        for(Block block : allBlock){
            g.fillRect(block.getX(), block.getY(), block.getWidth() - 1, block.getHeight() - 1);
        }
    }
    public void start(){
        /** 创建一个图形 */
        shape = ShapeFactory.newInstance();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bottomMove();
                repaint();
            }
        }, 0, 1000);
    }
    public void stop(){
        timer.cancel();
        timer = new Timer();
    }
    public void end(){
        shape = null;
        timer.cancel();
        timer = new Timer();
        allBlock.clear();
        repaint();
    }
    public void change(){
        shape.change();
        Block[] blocks = shape.getBlocks();
        /** 判断图形变化之后 有没有占用与其它图形的方块的位置 */
        for(Block block : blocks){
            boolean isExist = blockExist(block.getX(),block.getY());
            /** 如果图形变化之后与其它图形方块重叠，则需要还原回上一次图形 */
            if(isExist){
                shape.back();
                break;
            }
            if(block.getY() + block.getHeight() > panelHeight){
                shape.back();
                break;
            }
            if(block.getX() < 0 ){
                shape.back();
                break;
            }
            if(block.getX() + block.getWidth() > panelWidth){
                shape.back();
                break;
            }
        }
        repaint();
    }
    public void leftMove(){
        Block[] blocks = shape.getBlocks();
        for(Block block : blocks){
            boolean isExist = blockExist(block.getX() - block.getWidth(),block.getY());
            /** 判断有没有到左边缘 或 左边有没有存在的方块 */
            if(block.getX() == 0 || isExist){
                return;
            }
        }
        shape.leftMove();
        repaint();
    }
    public void rightMove(){
        Block[] blocks = shape.getBlocks();
        for(Block block : blocks){
            boolean isExist = blockExist(block.getX() + block.getWidth(),block.getY());
            /** 判断有没有到右边缘或右边是否有存在的方块 */
            if(block.getX() + block.getWidth() == panelWidth || isExist){
                return;
            }
        }
        shape.rightMove();
        repaint();
    }
    public void bottomMove(){
        Block[] blocks = shape.getBlocks();
        for(Block block : blocks){
            boolean isExist = blockExist(block.getX(),block.getY() + block.getHeight());
            /** 判断有没有到底或下面是否有存在的方块 */
            if(block.getY() + block.getHeight() == panelHeight || isExist){
                gameRule(blocks);
                return;
            }
        }
        shape.bottomMove();
        repaint();
    }
    /**
     * 游戏规则裁定
     * @return
     */
    public void gameRule(Block[] blocks){
        allBlock.addAll(Arrays.asList(blocks));
        boolean isGameOver = isGameOver();
        if(isGameOver){
            end();
            return;
        }
        /** 遍历每一层的方块 判断每层的方块是否满足清除条件 **/
        for(int i = 0;i < this.level;i++){
            int level = i * Block.getHeight();
            boolean isClear = isClearLevel(level);
            if(isClear){
                clearLevel(level);
            }
        }
        /** 产生新的方块图形 */
        shape = ShapeFactory.newInstance();
    }
    /**
     * 是否满足消除条件
     * @return
     */
    public boolean isGameOver(){
        for(Block block : allBlock){
            if(block.getY() == 0 ){
                return true;
            }
        }
        return false;
    }
    /**
     * 是否满足消除条件
     * @param level 层级
     * @return
     */
    public boolean isClearLevel(int level){
        int count = 0;
        for(Block block : allBlock){
            if(block.getY() == level){
                count++;
            }
        }
        return count == levelCount;
    }
    /**
     * 消层
     * @return
     */
    public void clearLevel(int level){
        for(Iterator<Block> iterator = allBlock.iterator();iterator.hasNext();){
            Block block = iterator.next();
            if(block.getY() == level){
                iterator.remove();
            }
        }
        /** 被消除的一层上面的方块往下落一层 */
        for(Iterator<Block> iterator = allBlock.iterator();iterator.hasNext();){
            Block block = iterator.next();
            if(block.getY() < level){
                block.setY(block.getY() + Block.getHeight());
            }
        }
    }
    /**
     * 预判断 判断x坐标和y左边上是否有方块
     * @param x
     * @param y
     * @return
     */
    public boolean blockExist(int x,int y){
        for(Block block : allBlock){
            if(x == block.getX() &&  y == block.getY()){
                return true;
            }
        }
        return false;
    }
}
