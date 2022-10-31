package lasttrynow.absolutsistanu;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HannahLabbTreModel {

    ObjectProperty<Number> size = new SimpleObjectProperty<>(50);
    ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);


    List<HannahsShape> myShapesList = new ArrayList<>();

    public void createSquareShape(MouseEvent mouseEvent) {
        myShapesList.add(new HannahsShape("square", (int) mouseEvent.getX(), (int) mouseEvent.getY(), (Double) size.getValue(), (Double) size.getValue(), color.getValue()));

    }


}
