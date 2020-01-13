package at.fhj.msd.swdesign.mvc;

public class CircleModel {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double GetPerimeter() {
        return 2 * radius * Math.PI;
    }

    public String getCircleCalc() {
        return "Circle: area=" + getArea() + ", perimeter:" + GetPerimeter();
    }
}
