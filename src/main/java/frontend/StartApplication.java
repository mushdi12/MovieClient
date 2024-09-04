package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    public static void startApplication() {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("start-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 693, 562);
        stage.setResizable(false);
        stage.setTitle("Movie's Application");
        stage.setScene(scene);
        stage.show();
    }



}