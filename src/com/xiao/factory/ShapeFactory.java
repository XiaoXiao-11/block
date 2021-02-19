package com.xiao.factory;

import com.xiao.base.Shape;
import com.xiao.shape.*;

import java.util.Random;

/**
 * 图形工厂
 */
public final class ShapeFactory {
    public static Shape newInstance(){
        Shape shape = null;
        int randowInt = new Random().nextInt(7) + 1;
        int x = new Random().nextInt(25) + 2;
        switch (randowInt){
            case 1:
                shape = new LXing(x);
                break;
            case 2:
                shape = new JXing(x);
                break;
            case 3:
                shape = new OXing(x);
                break;
            case 4:
                shape = new TXing(x);
                break;
            case 5:
                shape = new IXing(x);
                break;
            case 6:
                shape = new ZXing(x);
                break;
            case 7:
                shape = new SXing(x);
                break;
        }

        return shape;
    }
}
