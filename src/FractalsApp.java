import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class FractalsApp extends PApplet {
    private static FractalsApp app;
    private ArrayList<Ellipse> ellipses; // for makeCircles
    private ArrayList<Line> lines; // for makeBranches
    private int nextIndex;

    public static void main(String[] args){
        PApplet.main("FractalsApp");
    }

    public FractalsApp(){
        app = this;
        ellipses = new ArrayList<Ellipse>();
        lines = new ArrayList<Line>();
        nextIndex = 0;
    }

    public void settings(){
        size(1000, 500);
    }

    public void setup(){
        background(255);
        makeCircles(width/2, height/2, 200);

        stroke(0);
        //makeBranches(width/2, height, width/2, height - 100);
    }

    public void draw(){
//        // ellipses
        if (nextIndex < ellipses.size()){
            ellipses.get(nextIndex).display();
            nextIndex++;
        }

        // trees
//        if (nextIndex < lines.size()){
//            lines.get(nextIndex).display();
//            nextIndex++;
//        }
    }

    private void makeCircles(float x, float y, float diameter){
        ellipses.add(new Ellipse(x, y, diameter));
        if (diameter > 2){
            makeCircles(x + diameter/2, y, diameter/2);
            makeCircles(x - diameter/2, y, diameter/2);
        }
    }


    public void makeBranches(float x1, float y1, float x2, float y2){
        float theta = random(0, PI/3);

        // add the line to the array list
        PVector start = new PVector(x1, y1);
        PVector end = new PVector(x2, y2);
        Line line = new Line(start, end);
        lines.add(line);

        // set up for calculating branches

        // calculating length of new line
        PVector newGrowth = PVector.sub(end, start); // pVectorObject.sub(otherPVector);
        newGrowth.mult((float) 0.66);

        if (newGrowth.mag() > 2){
            newGrowth.rotate(theta);
            PVector rightBranch = PVector.add(end, newGrowth);
            makeBranches(end.x, end.y, rightBranch.x, rightBranch.y);

            newGrowth.rotate(-2 * theta);
            PVector leftBranch = PVector.add(end, newGrowth);
            makeBranches(end.x, end.y, leftBranch.x, leftBranch.y);
        }
    }

    public static FractalsApp getApp(){
        return app;
    }
}
