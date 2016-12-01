package geometry;

/* Laurian Staicu 1696177
 * IPD 9 
 */
class GeoObj {

    private String color;

    public void setColor(String color) {
        if(color.matches("[A-Z][a-z]{1}"));
        this.color = color;
    }

    public double getSurface() {
        throw new UnsupportedOperationException("getSurface not working");
    }

    public double getCircumPerim() {
        throw new UnsupportedOperationException("getCircumPerim not working");

    }

    public int getVertices() {
        throw new UnsupportedOperationException("getVertices not working");
    }

    public int getEdges() {
        throw new UnsupportedOperationException("getEdges not working");
    }

    public void print() {
        throw new UnsupportedOperationException("print not working");

    }
}

class Point extends GeoObj {
   
}


class Rectangle extends GeoObj {
    private double hight ;
    private double lenght;
    
    public double getCircumPerim() {};
    
    
  @Override  
    public void print(){
        System.out.println("override print");
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    

    
}

class Square extends Rectangle {

}

class Circle extends GeoObj{

}

class Sphere extends GeoObj{

}

class Hexagon extends GeoObj{

}

public class Geometry {

    public static void main(String[] args) {

    }

}
