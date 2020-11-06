
/**
 * This class represents a simple picture.You can draw the picture using the draw method.
 * But wait, there's more:being an electronic picture, it can be changed.
 * You can set it to black-and-white display and back to color.
 * This class wa written as an example for teaching.
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle son;

    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // Nothing to do... Instance variable are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public  void draw(){
        wall=new Square();
        wall.moveHorizontal(70);
        wall.moveVertical(100);
        wall.changeSize(100);
        wall.makeVisible();

        window=new Square();
        window.changeColor("blue");
        window.moveHorizontal(80);
        window.moveVertical(120);
        window.makeVisible();


        // This is a sun.
        son = new Circle();
        son.changeColor("yellow");
        son.moveHorizontal(300);
        son.moveVertical(20);
        son.changeSize(60);
        son.makeVisible();

        roof=new Triangle();
        roof.changeSize(50,140);
        roof.moveHorizontal(90);
        roof.moveVertical(55);
        roof.makeVisible();

    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite(){
        if(wall!=null){ // Only if it's painted already can it's color be change
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            son.changeColor("yellow");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor(){
        if(wall!=null){
            wall.changeColor("red");
            window.changeColor("blue");
            roof.changeColor("green");
            son.changeColor("yellow");
        }
    }

    /**
     * Move down the house.
     */
    public void moveHouse(){
        roof.moveDown();

        wall.moveDown();
        window.moveDown();

    }
    /**
     * Slowly move the sun.
     */
    public void slowlyMoveSun(){
        son.slowlyMoveVertically(450);
        son.moveHorizontal(-300);
        son.slowlyMoveVertically(-450);
    }

}