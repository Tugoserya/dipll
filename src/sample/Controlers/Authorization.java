package sample.Controlers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class Authorization {
    public boolean Auth = false;

    @FXML
    private Button auth_button;

    @FXML
    private Button reg_button;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password_auth;

    @FXML
    private ImageView prog_image;

    @FXML
    void initialize() {

        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);

        //Кнопка, перекидывающая на регистрацию
        reg_button.setOnAction(actionEvent -> {
            reg_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/reg.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Система контроля дорожной обстановки");
            stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
            stage.setScene(new Scene(root));
            stage.setMaxHeight(540);
            stage.setMaxWidth(840);
            stage.setMinHeight(540);
            stage.setMinWidth(840);
            stage.show();
        });

        //Проверка на пустоту вводимых значений
        auth_button.setOnAction(event -> {
            String login_text = login.getText().trim();
            String password_text = password_auth.getText().trim();

            if (!login_text.equals("") && !password_text.equals("")) {
                loginUser(login_text, password_text);
            } else {
                System.out.println("Пустое поле");
                Snake snake = new Snake(login);
                Snake snake2 = new Snake(password_auth);
                snake.playAnim();
                snake2.playAnim();
            }
        });

    }

    //Авторизация пользователя с передачей ID

    private void loginUser(String login_text, String password_text) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        ResultSet resultSet = dbHandler.getUser(login.getText(), password_auth.getText());
        ResultSet resultSett = dbHandler.getViewer(login.getText(), password_auth.getText());
        String pas = null;
        String log = null;

        try {
            while (resultSet.next()) {
                // Получаем id пользователей инспектор
                Const.id_user = Integer.parseInt(resultSet.getString("id_ins"));
                pas = resultSet.getString("pass");
                log = resultSet.getString("login");

                Const.status = 2;
            }
            if (login_text.equals(log) && pas.equals(password_text)) {

                Perehod();

            } else {
                while (true) {
                    try {

                        if (!resultSett.next()) break;
                        else {
                            // Получаем id пользователей наблюдатель
                            Const.id_user = Integer.parseInt(resultSett.getString("id_view"));
                            pas = resultSett.getString("pass");
                            log = resultSett.getString("login");

                            Const.status = 1;
                            if (login_text.equals(log) && pas.equals(password_text)) {
                                Perehod_2();
                            } else {
                                Snake snake = new Snake(login);
                                Snake snake2 = new Snake(password_auth);
                                snake.playAnim();
                                snake2.playAnim();
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                Snake snake = new Snake(login);
                Snake snake2 = new Snake(password_auth);
                snake.playAnim();
                snake2.playAnim();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void Perehod() {
        auth_button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/FXML/lk_sample.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Система контроля дорожной обстановки");
        stage.getIcons().add(new Image(("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png")));
        stage.setScene(new Scene(root));
        stage.setMaxHeight(540);
        stage.setMaxWidth(840);
        stage.setMinHeight(540);
        stage.setMinWidth(840);
        stage.show();
    }

    private void Perehod_2() {
        auth_button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
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
        stage.setScene(new Scene(root));
        stage.setMaxHeight(540);
        stage.setMaxWidth(840);
        stage.setMinHeight(540);
        stage.setMinWidth(840);
        stage.show();
    }
}
