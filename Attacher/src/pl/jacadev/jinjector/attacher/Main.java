package pl.jacadev.jinjector.attacher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("res/attacher.fxml"));
        primaryStage.setTitle("JInjector");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String... args) throws InterruptedException {
        launch();
    }

}

