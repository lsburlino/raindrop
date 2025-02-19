package up.lsburlino.raindrop;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import android.widget.SeekBar;


/**
 @author Luca Sburlino
 CS 301
 Left/Right controller class. Controls up down movement and combining drops
 */

public class rainLRController implements SeekBar.OnSeekBarChangeListener{
    private rainView rainview;

    //calculate distance between 2 points
    private double distance(int x1, int y1, int x2, int y2){
        return sqrt(pow(x1-x2,2) + pow(y1-y2,2));
    }
    public rainLRController (rainView rainview){
        this.rainview = rainview;
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.rainview.theDrop.changeX(progress);

        //check if the drop has touched any of the other drops
        int i = 0;
        while(i < this.rainview.drops.size()) {

            //pythagrian theorum so it maps a circle not a square
            double dist = distance(this.rainview.drops.get(i).getX(),this.rainview.drops.get(i).getY(),this.rainview.theDrop.getX(),this.rainview.theDrop.getY());
            if (dist<60){

                //convert color of the drop to average color between it and the other raindrop
                //then remove the other drop
                int col = (this.rainview.drops.get(i).dropPaint.getColor() + this.rainview.theDrop.dropPaint.getColor()) / 2;
                this.rainview.theDrop.dropPaint.setColor(col);
                this.rainview.drops.remove(i);

            } else {
                i++;
            }
        }
        this.rainview.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
