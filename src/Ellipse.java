public class Ellipse {
    private float x;
    private float y;
    private float diameter;

    public Ellipse(float x, float y, float diameter){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    public void display(){
        FractalsApp app = FractalsApp.getApp();

        // cosmetic
        app.stroke(0);
        app.noFill();

        app.ellipse(x, y, diameter, diameter);
    }
}
