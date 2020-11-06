
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A square that can be manipulated and draws itself on a canvas.
 */
public class Square {
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;


    /**
     * Create a square at default position with default color.
     */
    public Square() {
        size=20;
        xPosition=20;
        yPosition=20;
        color="green";
        isVisible=false;
    }
    /**
     * Make this square visible. If it was already visible, do nothing.
     */

    public void makeVisible(){
        isVisible=true;
        draw();
    }
    /**
     * Make this square invisible.If it was already invisible, do nothing.
     */

    public void makeInvisible(){
        erase();
        isVisible=false;
    }
    /**
     * Move this square a few pixels to right.
     */
    public void moveRight(){
        moveHorizontal(40);
    }

    /**
     * Move this square a few pixels to left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move this square a few pixels up.
     */
    public void moveUp(){
        moveVertical(-30);
    }

    /**
     * Move this square  a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the square  horizontally by "distance" pixels.
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition+=distance;
        draw();
    }
    /**
     * Move the square vertically by "distance" pixels.
     */
    public  void moveVertical(int distance){
        erase();
        yPosition+=distance;
        draw();
    }

    /**
     * Slowly move the square horizontally by "distance" pixels;
     */
    public void slowlyMoveHorizontally(int distance){
        int units;
        units=1;
        if(distance<0)
        {
            units=-1;
            distance= -distance;
        }
        for(int i=1;i<distance;++i){
            xPosition+=units;
            draw();
        }

    }

    /**
     * Slowly move the  square vertically by "distance" pixels;
     */

    public void slowlyMoveVertically(int distance){
        int units;
        units=1;
        if(distance<0)
        {
            units=-1;
            distance=-distance;
        }
        for(int i=1;i<distance;++i){
            yPosition+=units;
            draw();
        }
    }

    /**
     * Change the size to the new size(in pixels). Size must be >=0
     */
    public void changeSize(int newSize){
        erase();
        size=newSize;
        draw();
    }

    /**
     * Change the color. Valid colors are only "red", "yellow", "green","blue","black" and "magenta".
     */
    public void changeColor( String newColor ){
        color=newColor;
        draw();
    }

    /**
     * Draw the square  with a specification on the screen.If the square is invisible, do nothing.
     */
    public  void draw(){
        if(isVisible){
            Canvas canvas=Canvas.getCanvas();
            canvas.draw(this,color,new Rectangle (xPosition,yPosition,size,size));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.If the square is invisible, do nothing.
     */
    public  void erase(){
        if(isVisible){
            Canvas canvas=Canvas.getCanvas();
            canvas.erase(this);
        }
    }

}