package sample.Controlers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.animaion.Snake;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;
import javafx.scene.text.Text;

public class AddDtpCar {

    @FXML
    private Button addCar;

    @FXML
    private Text data_txt;


    @FXML
    private Button glav;

    @FXML
    private TextField gosNomer;

    @FXML
    private TextField vin;

    @FXML
    private TextField marca;

    @FXML
    private ImageView prog_image;

    public static int dtp_carr;

    @FXML
    void initialize() {
        AtomicInteger col_dtpp = new AtomicInteger();


        System.out.println(dtp_carr);
        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        data_txt.setText("");
        try {
            querry();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        addCar.setOnAction(event -> {
            Const.vin = Integer.parseInt(vin.getText().trim());
            DayabaswHendel dayabaswHendel = new DayabaswHendel();
            ResultSet resultSet = dayabaswHendel.Dtp_col();
            while (true) {

                try {
                    if (!resultSet.next()) break;
                    else {
                        col_dtpp.set(resultSet.getInt("dtp_col"));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            int result = col_dtpp.intValue();
            String gosNomer_text = gosNomer.getText().trim();
            result++;
            String vin_text = vin.getText().trim();
            String marca_text = marca.getText().trim();
            dtp_carr--;
            System.out.println(dtp_carr);
            if (dtp_carr == 0) {

                addCar.getScene().getWindow().hide();
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
                stage.setMaxHeight(540);
                stage.setMaxWidth(840);
                stage.setMinHeight(540);
                stage.setMinWidth(840);
                stage.setScene(new Scene(root));
                stage.show();
            }

            if (!gosNomer_text.equals("") && gosNomer_text.length() <= 9 && gosNomer_text.length() >= 8) {
                if (!vin_text.equals("")) {
                    if (!marca_text.equals("") && marca_text.length() <= 20) {
                        addDopCar(gosNomer_text, vin_text, marca_text, result);
                        ocist();
                    } else {
                        Snake snake6 = new Snake(marca);
                        snake6.playAnim();
                    }
                } else {
                    Snake snake8 = new Snake(vin);
                    snake8.playAnim();
                }
            } else {
                Snake snake7 = new Snake(gosNomer);
                snake7.playAnim();
            }

        });
        glav.setOnAction(event -> {
            glav.getScene().getWindow().hide();
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

    private void addDopCar(String gosNomer_text, String vin_text, String marca_text, int result) {
        DayabaswHendel dbHandler = new DayabaswHendel();
        dbHandler.addDopCar(
                gosNomer_text,
                vin_text,
                marca_text,
                result);

        ResultSet resultSet = dbHandler.Car_dtp();

        try {
            while (resultSet.next()) {
                Const.id_user = Integer.parseInt(resultSet.getString("id_car"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void ocist() {
        gosNomer.clear();
        vin.clear();
        marca.clear();
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

