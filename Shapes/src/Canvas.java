
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.HashMap;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose canvas, specially made for the BLUEJ "shapes".
 */
public class Canvas {

    private static  Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */

    public static Canvas getCanvas(){
        if(canvasSingleton==null) {
            canvasSingleton = new Canvas("BlueJ Shapes Demo", 400, 400, Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;

    }

    // ------instance part -------
    private  JFrame frame;
    private CanvasPane canvas;
    private  Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap <Object,ShapeDescription>shapes;


    /**
     * Create a new canvas.
     */
    private Canvas(String title,int width, int height,Color bgColor){
        frame=new JFrame();
        canvas=new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width,height));
        backgroundColor=bgColor;
        frame.pack();
        objects=new ArrayList<Object>();
        shapes=new HashMap<Object, ShapeDescription>();
    }
    /**
     * Set the canvas visibility and bring canvas to the front of the screen when made visible.
     *This method can also be used to bring an already visible canvas to the front of other windows.
     */

    public void setVisible(boolean visible){
        if(graphic==null){
            // First time: instantiate the offscreen image and fill it with the background colour.
            Dimension size=canvas.getSize();
            canvasImage=canvas.createImage(size.width,size.height);
            graphic=(Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0,0,size.width,size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     */
    public  void draw(Object referenceObject, String color, Shape shape){
        objects.remove(referenceObject);    // Just in case it was already there
        objects.add(referenceObject);       // Add at the end
        shapes.put(referenceObject,new ShapeDescription(shape ,color));
        redraw();
    }

    /**
     * Erase a given shape from the screen
     */
    public  void erase(Object referenceObject){
        objects.remove(referenceObject);   // Just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground colour of the Canvas.
     */

    public  void setForegroundColor(String colorString ){
        if(colorString.equals("red"))
            graphic.setColor(Color.red);
        else if(colorString.equals("black"))
            graphic.setColor(Color.black);
        else if(colorString.equals("blue"))
            graphic.setColor(Color.blue);
        else if(colorString.equals("yellow"))
            graphic.setColor(Color.yellow);
        else if(colorString.equals("green"))
            graphic.setColor(Color.green);
        else if(colorString.equals("magenta"))
            graphic.setColor(Color.magenta);
        else if(colorString.equals("white"))
            graphic.setColor(Color.white);
        else
            graphic.setColor(Color.black);

    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be used when producing animations.
     */

    public  void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }
        catch(Exception e){
            // ignoring exception at the moment
        }

    }
    /**
     * Redraw ell shapes currently on the Canvas
     */
    private void redraw(){
        erase();
        for(Iterator i=objects.iterator();i.hasNext();){
            ((ShapeDescription)shapes.get(i.next())).draw(graphic);
        }
        canvas.repaint();
    }
    /**
     * Erase the whole canvas. (Dose not repaint.)
     */
    private void erase()
    {
        Color original=graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size =canvas.getSize();
        graphic.fill(new Rectangle(0,0,size.width,size.height));
        graphic.setColor (original);
    }

    /************************************************************************************
     * Inner class CanvasPane-the actual canvas component contained in the Canvas frame.
     * This is essentially a JPanel with added capability to refresh the image down on it.
     */

    private  class CanvasPane extends JPanel{
        public  void paint(Graphics g){
            g.drawImage(canvasImage,0,0,null);
        }
    }
    /************************************************************************************
     * Inner class CanvasPane-the actual canvas component contained in the Canvas frame.
     * This is essentially a JPanel with added capability to refresh the image down on it.
     */

    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;
        public ShapeDescription(Shape shape,String color){
            this.shape=shape;
            colorString=color;
        }
        public  void draw(Graphics2D graphic){
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }



}
