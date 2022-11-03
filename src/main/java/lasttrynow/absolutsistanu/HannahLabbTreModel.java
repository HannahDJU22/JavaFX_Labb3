package lasttrynow.absolutsistanu;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

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


}
