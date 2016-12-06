package geometry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;


/* Laurian Staicu 1696177
 * IPD 9 
 */
class GeoObj {

    private String color;

    public GeoObj(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        if (color.length() < 1 || color == "" || color == null) {
            throw new IllegalArgumentException("color must not be empty");
        };
        this.color = color;
    }

    public double getSurface() {
        throw new UnsupportedOperationException("getSurface not working");
    }

    public double getCircumPerim() {
        throw new UnsupportedOperationException("getCircumPerim not working");
    }

    public int getVerticesCount() {
        throw new UnsupportedOperationException("getVertices not working");
    }

    public int getEdgesCount() {
        throw new UnsupportedOperationException("getEdges not working");
    }

    public void print() {
        throw new UnsupportedOperationException("print not working");

    }

    public String getColor() {
        return color;
    }
}

class Point extends GeoObj {

    private int vertices;

    public Point(String color) {
        super(color);
        setVertices(1);
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

}

class Rectangle extends GeoObj {

    private double height;
    private double width;

    public Rectangle(String color, double widht, double height) {
        super(color);
        setHight(height);
        setWidth(width);
    }

    @Override
    public double getSurface() {
        return width * height;
    }

    @Override
    public double getCircumPerim() {
        return 2 * width + 2 * height;
    }

    @Override
    public int getVerticesCount() {
        return 4;
    }

    @Override
    public int getEdgesCount() {
        return 4;
    }

    @Override
    public void print() {
        System.out.println("The color of the Rectangle is " + getColor());
    }

    double getHight() {
        return height;
    }

    public void setHight(double hight) {
        if (hight < 0) {
            throw new IllegalArgumentException("hight must be greater than 0");
        }
        this.height = hight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("width must be greater than 0");
        }
        this.width = width;
    }

}

class Square extends Rectangle {

    public Square(String color, double edgeLen) {
        super(color, edgeLen, edgeLen);
    }

    @Override
    public void print() {
        System.out.printf("The color of Square is %s", getColor());
    }

}

class Circle extends GeoObj {

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getCircumPerim() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int getVerticesCount() {
        return 0;
    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public void print() {
        System.out.printf("The color of Circle is %s", getColor());
    }
}

class Sphere extends GeoObj {

    Sphere(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    private double radius;

    @Override
    public double getSurface() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getCircumPerim() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int getVerticesCount() {
        return 0;
    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public void print() {
        System.out.printf("The color of Sphere is %s", getColor());
    }
}

//class Hexagon extends GeoObj {
//}
public class Geometry {

    static ArrayList<GeoObj> geoList = new ArrayList<>();
    static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {

        // 1. Parse input.txt file and add to geoList
        try {
            Scanner fileInput = new Scanner(new File(FILE_NAME));
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                
                System.out.println("Processing line: " + line);
                String[] data = line.split(";");
                // TODO: review conditional expression at home                
                String color = (data.length == 1) ? "" : data[1];

                switch (data[0]) {
                    case "Rectangle":
                        if (data.length != 4) {
                            System.out.println("Warning: Invalid number of data in line " + line);
                            break;
                        }
                        geoList.add(new Rectangle(color, Double.parseDouble(data[2]), Double.parseDouble(data[2])));
                        break;
                    case "Square":
                        if (data.length != 3) {
                            System.out.println("Warning: Invalid number of data in line " + line);
                            break;
                        }
                        // FIXME: parse error here must NOT exit the loop
                        // but continue to the next line
                        double edge = Double.parseDouble(data[2]);
                        geoList.add(new Square(color, edge));
                        break;
                    case "Circle":
                        if (data.length != 3) {
                            System.out.println("Warning: Invalid number of data in line :" + line);
                            break;
                        }

                        double radius = Double.parseDouble(data[2]);
                        geoList.add(new Circle(color, radius));
                        break;
                    case "Sphere":
                        try {
                            Double.parseDouble(data[2]);

                                } catch (NumberFormatException e) {
                            System.out.println("string cannot be cast into double");
                            break;
                        }
                        double radiusS = Double.parseDouble(data[2]);
                        geoList.add(new Sphere(color, radiusS));

                        break;
                    case "Point":
                        break;
                    default:
                        System.out.println("Warning: invalid data in line " + line);
                }
            }
            fileInput.close();
        } catch (IOException e) {
            System.err.println("Error reading file");
        } catch (InputMismatchException e) {
            System.err.println("Error: file contents mismatch");
        }

        // 2. print them out
        for (GeoObj g : geoList) {
            g.print();
            System.out.println();
        }

    }

}