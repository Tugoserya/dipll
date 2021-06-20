package sample.Controlers;

import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;
import javafx.scene.text.Text;

public class LK {


    @FXML
    private Button view;

    @FXML
    private Button add;

    @FXML
    private Button vihod;

    @FXML
    private Text data_txt;

    @FXML
    private ImageView prog_image;

    @FXML
    void initialize() {
        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        data_txt.setText("");
        try {
            querry();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (Const.status == 1){
            add.setVisible(false);
        }
        vihod.setOnAction(event -> {
            vihod.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/auth_sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setMaxHeight(540);
            stage.setMaxWidth(840);
            stage.setMinHeight(540);
            stage.setMinWidth(840);
            stage.setScene(new Scene(root));
            stage.show();

        });
        view.setOnAction(event -> {
            view.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setMaxHeight(540);
            stage.setMaxWidth(840);
            stage.setMinHeight(540);
            stage.setMinWidth(840);
            stage.setScene(new Scene(root));
            stage.show();
        });
        add.setOnAction(event -> {

            add.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/addDtp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setMaxHeight(540);
            stage.setMaxWidth(840);
            stage.setMinHeight(540);
            stage.setMinWidth(840);
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    private void querry() throws SQLException {
        DayabaswHendel dbHandler = new DayabaswHendel();
        ResultSet resultSet = dbHandler.getData();
        String name = "";
        String last_name = "";
        String id_card = "";
        while (resultSet.next()) {
            name = resultSet.getString("name");
            last_name = resultSet.getString("last_name");
            id_card = resultSet.getString("id_card");

        }
        data_txt.setText(last_name + " " + name + " " + id_card);
    }

}

