package sample.Controlers;
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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField patronymic;

    @FXML
    private TextField passport;

    @FXML
    private Button reg_but;

    @FXML
    private Button exit;

    @FXML
    private ImageView prog_image;

    @FXML
    void initialize() {


        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);

//        Кнопка регистрации
        reg_but.setOnAction(event -> {
            String login_text = login.getText().trim();
            String name_text = name.getText().trim();
            String last_name_text = last_name.getText().trim();
            String patronymic_text = patronymic.getText().trim();
            String passport_text = passport.getText().trim();
            String pass_text = pass.getText().trim();
            int check_us = 0;
            DayabaswHendel dbHandler = new DayabaswHendel();
            ResultSet resultSet = dbHandler.check_log(login_text);
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    check_us = Integer.parseInt(resultSet.getString("id_view"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            int check_ps = 0;
            ResultSet resultSett = dbHandler.check_passp(passport_text);
            while (true) {
                try {
                    if (!resultSett.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    check_ps = Integer.parseInt(resultSett.getString("id_view"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (!login_text.equals("") && login_text.length() <= 15 && check_us == 0) {
                if (!pass_text.equals("") && pass_text.length() <= 20) {
                    if (!passport_text.equals("") && passport_text.length() == 10 && check_ps ==0) {
                        if (!patronymic_text.equals("") && patronymic_text.length() <= 20) {
                            if (!last_name_text.equals("") && last_name_text.length() <= 20) {
                                if (!name_text.equals("")) {
                                    addAcc(login_text, pass_text, passport_text, patronymic_text, last_name_text, name_text);
                                } else {
                                    Snake snake6 = new Snake(name);
                                    snake6.playAnim();
                                }
                            } else {
                                Snake snake5 = new Snake(last_name);
                                snake5.playAnim();
                            }

                        } else {
                            Snake snake4 = new Snake(patronymic);
                            snake4.playAnim();
                        }

                    } else {
                        Snake snake3 = new Snake(passport);
                        snake3.playAnim();
                    }
                } else {
                    Snake snake2 = new Snake(pass);
                    snake2.playAnim();
                }
            } else {
                Snake snake = new Snake(login);
                snake.playAnim();
            }
        });
//        Кнопка выхода
        exit.setOnAction(event -> {
            exit.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/auth_sample.fxml"));
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
    }

    private void addAcc(String login_text, String pass_text, String passport_text, String patronymic_text, String last_name_text, String name_text) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addAcc(
                login.getText(),
                pass.getText(),
                name.getText(),
                last_name.getText(),
                patronymic.getText(),
                passport.getText()
        );
        ResultSet resultSet = dbHandler.id_viewer();
        try {
            while (resultSet.next()) {
                Const.id_user = Integer.parseInt(resultSet.getString("id_view"));
            }
            reg_but.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/auth_sample.fxml"));
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
