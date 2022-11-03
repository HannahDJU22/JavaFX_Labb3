package lasttrynow.absolutsistanu;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HannahLabbTreModel {

    ObjectProperty<Number> size = new SimpleObjectProperty<>(50);
    ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);

    List<HannahsShape> myShapesList = new ArrayList<>();

    public Square createSquareShape(double positionX, double positionY) {
        Square mySquareShape = new Square("square", positionX, positionY, size.getValue(), size.getValue(), color.getValue());
        myShapesList.add(mySquareShape);
        return mySquareShape;

    }
    public Rectangle createRectangleShape(double positionX, double positionY){
        Rectangle myRectShape = new Rectangle("rectangle", positionX, positionY, size.getValue(), size.getValue(), color.getValue());
        myShapesList.add(myRectShape);
        return myRectShape;

    }

    public void removeLastShapeFromCanvas(){
        myShapesList.remove(myShapesList.size()-1);
    }


    public Number getSize() {
        return size.get();
    }

    public ObjectProperty<Number> sizeProperty() {
        return size;
    }

    public void setSize(Number size) {
        this.size.set(size);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    void drawShapesonCanvas(HannahLabbTreController hannahLabbTreController) {
        for (HannahsShape shape: myShapesList) {
            if(shape.getClass().equals(Square.class)){
                hannahLabbTreController.context.setFill(shape.getColor());
                hannahLabbTreController.context.fillRect(shape.getPositionX(), shape.getPositionY(),shape.getWidth(), shape.getHeight());}
            if(shape.getClass().equals(Rectangle.class)){
                hannahLabbTreController.context.setFill(shape.getColor());
                hannahLabbTreController.context.fillRect(shape.getPositionX(), shape.getPositionY(), shape.getWidth(), shape.getHeight());}
            }
    }

    public void saveToFile(File file){
        //här ska all kod in för att göra om till SVG, när det är klart, då kan metoden köras och fil kan sparas

    }
}
