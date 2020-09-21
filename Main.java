public class Main {
    public static void main(String[] args) {
        Picture picture = new Picture();
        picture.draw();
        picture.setColor();
        for(int i=0;i<=5;++i)
            picture.moveHouse();
        picture.slowlyMoveSun();
    }
}
