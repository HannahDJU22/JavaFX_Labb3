package lasttrynow.absolutsistanu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HannahLabbTreApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HannahLabbTreApplication.class.getResource("labbtre-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        HannahLabbTreController controller = fxmlLoader.getController();
        controller.stage=stage;

        stage.setTitle("Please draw a shape!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}