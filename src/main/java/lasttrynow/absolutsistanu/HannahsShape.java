package lasttrynow.absolutsistanu;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class HannahsShape {

    String shape;
    double positionX, positionY;
    double width, height;
    Color color;

    public abstract boolean isShapeSelected(MouseEvent mouseEvent);

    public HannahsShape(String shape, double positionX, double positionY, double width, double height, Color color) {
        this.shape = shape;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public HannahsShape(){

    }

    public String getShape() {
        return shape;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }
    public double getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public double getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HannahsShape that = (HannahsShape) o;
        return Double.compare(that.positionX, positionX) == 0 && Double.compare(that.positionY, positionY) == 0 && Double.compare(that.width, width) == 0 && Double.compare(that.height, height) == 0 && Objects.equals(shape, that.shape) && Objects.equals(color, that.color);
    }
    @Override
    public int hashCode() {
        return Objects.hash(shape, positionX, positionY, width, height, color);
    }
    @Override
    public String toString() {
        return "HannahsShape{" +
                "shape='" + shape + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", width=" + width +
                ", height=" + height +
                ", color=" + color +
                '}';
    }
}
