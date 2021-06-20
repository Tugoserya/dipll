package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/auth_sample.fxml"));
        primaryStage.setTitle("Система контроля дорожной обстановки");
        primaryStage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
        primaryStage.setMaxHeight(540);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(540);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
