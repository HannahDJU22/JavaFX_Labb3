package lasttrynow.absolutsistanu;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HannahLabbTreController {
    public Button squarebutton;
    public Button rectanglebutton;
    public ColorPicker mycolorpicker;
    public Slider mysize;
    public Canvas canvas;
    public GraphicsContext context;

    String shapeController;

    HannahLabbTreModel myModel = new HannahLabbTreModel();

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        context.setFill(Color.SILVER);
        context.fillRect(0, 0, 280, 280);

        mysize.valueProperty().bindBidirectional(myModel.size);
        mycolorpicker.valueProperty().bindBidirectional(myModel.color);

    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        switch (shapeController) {
            case "square":
                myModel.createSquareShape(mouseEvent);

                break;
            case "rectangle":
                myModel.createRectangleShape(mouseEvent);

                break;
            case "isSelected":
                for (HannahsShape shape : myModel.myShapesList
                ) {
                    if (shape.isShapeSelected(mouseEvent)) {

                        //här behöver jag få in om det är en kvadrat eller rektangel
                        //nu ritar den kvadrat när jag ändrar rektangel

                        shape.setColor(myModel.color.getValue());
                        shape.setWidth(myModel.size.get().doubleValue());
                        shape.setHeight(myModel.size.get().doubleValue());
                    }
                }

                break;
        }
        drawCanvas();
    }

    //flytta denna till Shape, sen skriva rätt typ av ritning i resp shape-klass/sub
    //här ska endast drawCanvas finnas som hämtar från Shape
    public void drawCanvas(){
        context.clearRect(0, 0, 280, 280);
        context.setFill(Color.SILVER);
        context.fillRect(0, 0, 280, 280);
        for (HannahsShape shape: myModel.myShapesList) {
            if(shape.getClass().equals(Square.class)){
                context.setFill(shape.getColor());
                context.fillRect(shape.getPositionX(), shape.getPositionY(),shape.getWidth(), shape.getHeight());}
            if(shape.getClass().equals(Rectangle.class)){
                context.setFill(shape.getColor());
                context.fillRect(shape.getPositionX(), shape.getPositionY(), shape.getWidth(), shape.getHeight());}
            }
        }


    public void onSquareButtonClicked(ActionEvent actionEvent) {

        shapeController="square";
        //actionEvent.equals(squarebutton);

    }

    public void onRectangleButtonClicked(ActionEvent actionEvent) {

        shapeController="rectangle";

    }

    public void onSelectShape(ActionEvent actionEvent) {
        shapeController="isSelected";
    }
}