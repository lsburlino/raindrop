package up.lsburlino.raindrop;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

/**
    @author Luca Sburlino
    CS 301
    rainView Class. This class creates the rainView subclass of surfaceview.
    This class uses raindrops to create a picture.
 */
public class rainView extends SurfaceView {

    public ArrayList<raindrop> drops = new ArrayList<>(); //arraylist to store raindrops
    public raindrop theDrop;
    protected Random gen = new Random(); //rng for num of drops

    public rainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        //generates the dot that will move
        theDrop = new raindrop();
        //generates bounds between 5 and 11
        int size = 5 + this.gen.nextInt(7);
        for (int i = 0; i < size; i++) {
            drops.add(new raindrop());
        }

    }

    //draw drops
    @Override
    public void onDraw(Canvas canvas) {
        for(raindrop drop : drops) {
            drop.draw(canvas);
        }
        this.theDrop.draw(canvas);
    }
}

/**
 External Citation
 Date:     2/11/2025
 Problem:  Used to build class system
 Resource:
 https://learning.up.edu/course/view.php?id=41675
 */