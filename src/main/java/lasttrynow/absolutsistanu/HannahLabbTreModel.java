package lasttrynow.absolutsistanu;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HannahLabbTreModel {
    ObjectProperty<Number> size = new SimpleObjectProperty<>(50);
    ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);
    String shapeController;
    List<HannahsShape> myShapesList = new ArrayList<>();

    private String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public String toHexString(Color value) {
        return "#" + (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()) + format(value.getOpacity()))
                .toUpperCase();
    }

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

        StringBuilder outPut= new StringBuilder();

        outPut.append("<svg version=\"1.1\" width=\"280\" height =\"260\" xmlns=\"http://www.w3.org/2000/svg\">\n");

        for (HannahsShape shape2:myShapesList){

            outPut.append("<rect x=\"").append(shape2.getPositionX());
            outPut.append("\" y=\"").append(shape2.getPositionY());
            outPut.append("\" width=\"").append(shape2.getWidth());
            outPut.append("\" height=\"").append(shape2.getHeight());
            outPut.append("\" stroke=\"").append(toHexString(shape2.getColor()));
            outPut.append("\" fill=\"").append(toHexString(shape2.getColor()));
            outPut.append("\" stroke-width=\"1\"");
            outPut.append("/>\n");
        }
        outPut.append("</svg>");
        System.out.println(outPut);

        try {
            FileWriter myWriter = new FileWriter(file);
           myWriter.write(outPut.toString());
            myWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    void changeDrawnShape(MouseEvent mouseEvent) {
        for (HannahsShape shape : myShapesList
        ) {
            if (shape.isShapeSelected(mouseEvent)) {
                if(shape instanceof Square){
                    shape.setColor(color.getValue());
                    shape.setWidth(size.get().doubleValue());
                    shape.setHeight(size.get().doubleValue());
                }
                if(shape instanceof Rectangle){
                    shape.setColor(color.getValue());
                    shape.setWidth(size.get().doubleValue()*1.5);
                    shape.setHeight(size.get().doubleValue());}
            }
        }
    }
    void buttonEvent(MouseEvent mouseEvent) {
        switch (shapeController) {
            case "square" -> createSquareShape(mouseEvent.getX(), mouseEvent.getY());
            case "rectangle" -> createRectangleShape(mouseEvent.getX(), mouseEvent.getY());
            case "isSelected" -> changeDrawnShape(mouseEvent);
        }
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
}
