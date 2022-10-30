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

        myModel.addShapeToMyShapeList();

    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        if (shapeController.equals("square")) {
            context.setFill(mycolorpicker.getValue());
            context.fillRect(mouseEvent.getX(), mouseEvent.getY(), mysize.getValue(), mysize.getValue());
            myModel.myShapesList.add(new HannahsShape("square", (int) mouseEvent.getX(), (int) mouseEvent.getY(), mysize.getWidth(), mysize.getHeight(), mycolorpicker.getValue()));
        }
        if (shapeController.equals("rectangle")) {
            context.setFill(mycolorpicker.getValue());
            context.fillRect(mouseEvent.getX(), mouseEvent.getY(), mysize.getValue() * 1.5, mysize.getValue());
            myModel.myShapesList.add(new HannahsShape("rectangle", (int) mouseEvent.getX(), (int) mouseEvent.getY(), mysize.getWidth(), mysize.getHeight(), mycolorpicker.getValue()));

        }
    }

    public void onSquareButtonClicked(ActionEvent actionEvent) {

        shapeController="square";

    }

    public void onRectangleButtonClicked(ActionEvent actionEvent) {

        shapeController="rectangle";

    }
}