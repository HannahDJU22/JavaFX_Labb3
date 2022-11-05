package lasttrynow.absolutsistanu;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableStringValue;
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

    public Stage stage;
    public Button savebutton;

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

        myModel.buttonEvent(mouseEvent);
        drawCanvas();
    }


    public void drawCanvas(){
        canvasShown();
        myModel.drawShapesonCanvas(this);
    }


    public void onSquareButtonClicked(ActionEvent actionEvent) {

        myModel.shapeController="square";
    }

    public void onRectangleButtonClicked(ActionEvent actionEvent) {

        myModel.shapeController="rectangle";
    }

    public void onSelectShape(ActionEvent actionEvent) {
        myModel.shapeController="isSelected";
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
        fileChooser.setInitialFileName("LookAtThis");
        File filepath = fileChooser.showSaveDialog(stage);

        //File file = fileChooser.showSaveDialog(stage);
        if(filepath !=null){
            //java.nio.file.Path path = java.nio.file.Path.of(filepath.toURI());
           // myModel.saveToFile(path);

            myModel.saveToFile(filepath.toPath());
        }

    }
}