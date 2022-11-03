package lasttrynow.absolutsistanu;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HannahLabbTreController {
    public Button squarebutton;
    public Button rectanglebutton;
    public ColorPicker mycolorpicker;
    public Slider mysize;
    public Canvas canvas;
    public GraphicsContext context;
    String shapeController;
    public Stage stage;

    HannahLabbTreModel myModel = new HannahLabbTreModel();

    public void initialize() {
        squarebutton.fire();
        canvasShown();

        mysize.valueProperty().bindBidirectional(myModel.sizeProperty());
        mycolorpicker.valueProperty().bindBidirectional(myModel.colorProperty());

    }
    private void canvasShown() {
        context = canvas.getGraphicsContext2D();
        context.setFill(Color.SILVER);
        context.fillRect(0, 0, 280, 280);

    }

    public void onCanvasClicked(MouseEvent mouseEvent) {

        switch (shapeController) {
            case "square" -> myModel.createSquareShape(mouseEvent.getX(), mouseEvent.getY());
            case "rectangle" -> myModel.createRectangleShape(mouseEvent.getX(), mouseEvent.getY());
            case "isSelected" -> changeOfDrawnShape(mouseEvent);
        }
        drawCanvas();
    }

    private void changeOfDrawnShape(MouseEvent mouseEvent) {
        for (HannahsShape shape : myModel.myShapesList
        ) {
            if (shape.isShapeSelected(mouseEvent)) {
                if(shape instanceof Square){
                    shape.setColor(myModel.color.getValue());
                    shape.setWidth(myModel.size.get().doubleValue());
                    shape.setHeight(myModel.size.get().doubleValue());
                }
                if(shape instanceof Rectangle){
                    shape.setColor(myModel.color.getValue());
                    shape.setWidth(myModel.size.get().doubleValue()*1.5);
                    shape.setHeight(myModel.size.get().doubleValue());}
            }
        }
    }


    public void drawCanvas(){
        canvasShown();
        myModel.drawShapesonCanvas(this);
    }


    public void onSquareButtonClicked(ActionEvent actionEvent) {

        shapeController="square";
    }

    public void onRectangleButtonClicked(ActionEvent actionEvent) {

        shapeController="rectangle";
    }

    public void onSelectShape(ActionEvent actionEvent) {
        shapeController="isSelected";
    }

    public void onUnDoClicked(ActionEvent actionEvent) {
        myModel.removeLastShapeFromCanvas();
        drawCanvas();
    }

    public void onSaveButtonClicked(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as...");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));


        File file = fileChooser.showSaveDialog(stage);
        if(file !=null)
            myModel.saveToFile(file);
    }
}