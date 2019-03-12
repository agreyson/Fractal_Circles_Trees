import processing.core.PVector;

public class Line {
    private PVector start;
    private PVector end;

    public Line(PVector start, PVector end){
        this.start = start;
        this.end = end;
    }

    public void display(){
        FractalsApp app = FractalsApp.getApp();
        app.stroke(0);
        app.line(start.x, start.y, end.x, end.y);
    }
}
