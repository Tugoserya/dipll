package sample.Controlers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class ADD {


    @FXML
    private Button addCar;

    @FXML
    private Button addDotCar;

    @FXML
    private TextField GPS;

    @FXML
    private TextField kol_avto;

    @FXML
    private TextField radius;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<String> class_dtp;

    @FXML
    private ChoiceBox<String> sost;

    @FXML
    private Button glav_2;

    @FXML
    private ImageView prog_image;

    @FXML
    private Text data_txt;

    @FXML
    void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3");
        class_dtp.setValue("1");
        class_dtp.setItems(options);
        ObservableList<String> optionss = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        sost.setValue("1");
        sost.setItems(optionss);
        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        addDotCar.setVisible(false);
        data_txt.setText("");
        try {
            querry();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addDotCar.setOnAction(event -> {

            String class_text = class_dtp.getValue().trim();
            String GPS_text = GPS.getText().trim();
            String kol_avto_text = kol_avto.getText().trim();
            String radius_text = radius.getText().trim();
            String date_text = date.getValue().toString().trim();
            String sost_text = sost.getValue().trim();

            if (!class_text.equals("")) {
                if (!GPS_text.equals("")) {
                    if (!kol_avto_text.equals("")) {
                        if (!radius_text.equals("")) {
                            if (!date_text.equals("")) {
                                if (!sost_text.equals("")) {
                                    addDtp(class_text, GPS_text, kol_avto_text, radius_text, date_text, sost_text);
                                    AddDtpCar.dtp_carr = Integer.parseInt(kol_avto_text);
                                } else {
                                    Snake snake1 = new Snake(sost);
                                    snake1.playAnim();
                                }
                            } else {
                                Snake snake2 = new Snake(date);
                                snake2.playAnim();
                            }
                        } else {
                            Snake snake3 = new Snake(radius);
                            snake3.playAnim();
                        }
                    } else {
                        Snake snake4 = new Snake(kol_avto);
                        snake4.playAnim();
                    }
                } else {
                    Snake snake5 = new Snake(GPS);
                    snake5.playAnim();
                }
            } else {
                Snake snake6 = new Snake(class_dtp);
                snake6.playAnim();
            }
        });
        addCar.setOnAction(event -> {

            String class_text = class_dtp.getValue().trim();
            String GPS_text = GPS.getText().trim();
            String kol_avto_text = kol_avto.getText().trim();
            String radius_text = radius.getText().trim();
            String sost_text = sost.getValue().trim();

            if (!class_text.equals("")) {
                if (!GPS_text.equals("")) {
                    if (!kol_avto_text.equals("")) {
                        if (!radius_text.equals("")) {
                            if (date.getValue() != null) {
                                if (!sost_text.equals("")) {
                                    String date_text = date.getValue().toString().trim();
                                    addDtp(class_text, GPS_text, kol_avto_text, radius_text, date_text, sost_text);
                                    AddDtpCar.dtp_carr = Integer.parseInt(kol_avto_text);
                                    addDtpCar();
                                } else {
                                    Snake snake1 = new Snake(sost);
                                    snake1.playAnim();
                                }
                            } else {
                                Snake snake2 = new Snake(date);
                                snake2.playAnim();
                            }
                        } else {
                            Snake snake3 = new Snake(radius);
                            snake3.playAnim();
                        }
                    } else {
                        Snake snake4 = new Snake(kol_avto);
                        snake4.playAnim();
                    }
                } else {
                    Snake snake5 = new Snake(GPS);
                    snake5.playAnim();
                }
            } else {
                Snake snake6 = new Snake(class_dtp);
                snake6.playAnim();
            }
        });
        glav_2.setOnAction(event -> {
            glav_2.getScene().getWindow().hide();
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
            stage.setMaxHeight(540);
            stage.setMaxWidth(840);
            stage.setMinHeight(540);
            stage.setMinWidth(840);
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void addDtpCar() {

        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDtp(class_dtp.getValue(), GPS.getText(), kol_avto.getText(), radius.getText(),
                date.getValue().toString(), sost.getValue());
        ResultSet resultPr = dbHandler.id_dtp();

        try {
            while (resultPr.next()) {
                Const.dtp = Integer.parseInt(resultPr.getString("id_dtp"));
            }
            addDotCar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/addDtpCar.fxml"));
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

    private void addDtp(String class_text, String GPS_text, String kol_avto_text, String radius_text, String date_text, String sost_text) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDtp(
                class_text,
                kol_avto_text,
                date_text,
                GPS_text,
                radius_text,
                sost_text);
        ResultSet resultPr = dbHandler.id_dtp();

        try {
            while (resultPr.next()) {
                Const.dtp = Integer.parseInt(resultPr.getString("id"));
            }
            addDotCar.getScene().getWindow().hide();
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