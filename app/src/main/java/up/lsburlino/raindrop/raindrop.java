package up.lsburlino.raindrop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/*
    Luca Sburlino
    CS 301
    Raindrop Class. This class holds the value of a raindrop and has a function to print itself
    to the screen.
 */
public class raindrop {
    protected int x; // x-coord
    protected int y; // y-coord
    protected int size = 30; // all spots are size 30
    protected Paint dropPaint; // how the spot is drawn
    protected Random gen = new Random(); //initialize random generator

    //generates random color for each spot
    protected void setRandomPaint() {
        int color = Color.rgb(gen.nextInt(256),
                gen.nextInt(256),
                gen.nextInt(256));
        dropPaint = new Paint();
        dropPaint.setColor(color);
    }

    //Raindrop constructor that asigns random Xval Yval and paint color when called
    public raindrop(){
        //places spot randomly from 0-800 x and y
        this.x = gen.nextInt(800) + 5;
        this.y = gen.nextInt(800) + 5;
        setRandomPaint();
    }

    //Draws raindrop on canvas when called
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, size, dropPaint);
    }
}

/**
 External Citation
 Date:     2/11/2025
 Problem:  Used to build class system
 Resource:
 https://learning.up.edu/course/view.php?id=41675
 */