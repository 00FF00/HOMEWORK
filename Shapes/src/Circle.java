
import javax.print.attribute.standard.Finishings;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 */

public class Circle {
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new circle at default position with default color.
     */

    public Circle() {
        diameter = 10;
        xPosition = 0;
        yPosition = 0;
        color = "green";
        isVisible = false;
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */

    public void makeVisible(){
        isVisible=true;
        draw();
    }

    /**
     * Make this circle invisible.If it was already invisible, do nothing.
     */

    public void makeInvisible(){
        erase();
        isVisible=false;
    }

    /**
     * Move this circle a few pixels to right.
     */
    public void moveRight(){
        moveHorizontal(40);

    }

    /**
     * Move this circle a few pixels to left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move this circle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-30);
    }

    /**
     * Move this circle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by "distance" pixels.
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition+=distance;
        draw();
    }

    /**
     * Move the circle vertically by "distance" pixels.
     */
    public  void moveVertical(int distance){
        erase();
        yPosition+=distance;
        draw();
    }
    /**
     * Slowly move the circle horizontally by "distance" pixels;
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
     * Slowly move the circle vertically by "distance" pixels;
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
    public void changeSize(int newDiameter){
        erase();
        diameter=newDiameter;
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
     * Draw the circle with a specification on the screen.If the circle is invisible, do nothing.
     */
    public  void draw(){
        if(isVisible){
            Canvas canvas=Canvas.getCanvas();
            canvas.draw(this,color,new Ellipse2D.Double(xPosition,yPosition,diameter,diameter));
            canvas.wait(10);
        }
    }
    /**
     * Erase the circle on screen.If the circle is invisible, do nothing.
     */
    public  void erase(){
        if(isVisible){
            Canvas canvas=Canvas.getCanvas();
            canvas.erase(this);
        }
    }


}