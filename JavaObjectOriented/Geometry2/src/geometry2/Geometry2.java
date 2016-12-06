package geometry2;

import java.util.Date;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class SimpleGeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public SimpleGeometricObject(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SimpleGeometricObject(String color, boolean filled, Date dateCreated) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = dateCreated;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "SimpleGeometricObject{" + "color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + '}';
    }

}

class Rectangle extends SimpleGeometricObject {

    private double width;
    private double height;
    int vertices = 4;

    public Rectangle(double width, double height, Date dateCreated) {
        super(dateCreated);
        this.width = width;
        this.height = height;

    }

    public Rectangle(double width, double height, String color, boolean filled, Date dateCreated) {
        super(color, filled, dateCreated);
        this.width = width;
        this.height = height;
    }
    
    public double RectangleArea (){
        double rectArea;
        rectArea= this.height*this.width;
        return rectArea;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color); //To change body of generated methods, choose Tools | Templates.
    }

}

public class Geometry2 {

    public static void main(String[] args) {
        //create simple object
        Date date = new Date();
        String color = "red";
        Boolean filled = true;
        System.out.println(date.toString());
        SimpleGeometricObject object;
        object = new SimpleGeometricObject(color, filled, date);
        System.out.println(object.toString());

        //create a rectangle
        double width = 43.5;
        double height = 75.6;
        Rectangle rec = new Rectangle(width, height, color, true, date);
        System.out.println(rec.toString());
        double rectArea=rec.RectangleArea();
        rec.setColor("green");
        System.out.println(rec.toString());
        System.out.printf("Rectangle Area is %.2f: %n",rectArea);
        
        

    }

}
