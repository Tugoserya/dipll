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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class View {


    @FXML
    private TableView<Table_modul> table;

    @FXML
    private TableColumn<Table_modul, String> id_dtp;

    @FXML
    private TableColumn<Table_modul, String> class_dtp;

    @FXML
    private TableColumn<Table_modul, String> GPS;

    @FXML
    private TableColumn<Table_modul, String> kol_avto;

    @FXML
    private TableColumn<Table_modul, String> radius;

    @FXML
    private TableColumn<Table_modul, String> data;

    @FXML
    private TableColumn<Table_modul, String> Inspector_id;

    @FXML
    private TableColumn<Table_modul, String> sost;

    @FXML
    private Button glav;

    @FXML
    private Text name_txt;

    @FXML
    private Text l_name_txt;

    @FXML
    private Text id_card_txt;


    @FXML
    private ImageView prog_image;

    ObservableList<Table_modul> observableArray = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        if (Const.status == 2) {
            try {
                name_txt.setText("");
                l_name_txt.setText("");
                id_card_txt.setText("");
                querry();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                name_txt.setText("");
                l_name_txt.setText("");
                id_card_txt.setText("");
                querry_2();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (Const.status == 2) {
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
                stage.setScene(new Scene(root));
                stage.setMaxHeight(540);
                stage.setMaxWidth(840);
                stage.setMinHeight(540);
                stage.setMinWidth(840);
                stage.show();
            });

        } else {
            glav.setOnAction(event -> {
                glav.getScene().getWindow().hide();
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
        DayabaswHendel dayabaswHendel = new DayabaswHendel();
        ResultSet resultCheck = dayabaswHendel.DTP_ALL();
        try {
            while (resultCheck.next()) {
                observableArray.add(new Table_modul(
                        resultCheck.getInt("id_dtp"),
                        resultCheck.getString("class_dtp"),
                        resultCheck.getString("kol_avto"),
                        resultCheck.getString("data"),
                        resultCheck.getString("GPS"),
                        resultCheck.getString("radius"),
                        resultCheck.getString("sost"),
                        resultCheck.getString("Inspector_id")
                ));
            }
            id_dtp.setCellValueFactory(new PropertyValueFactory<>("id"));
            class_dtp.setCellValueFactory(new PropertyValueFactory<>("class_dtp"));
            kol_avto.setCellValueFactory(new PropertyValueFactory<>("kol_avto"));
            data.setCellValueFactory(new PropertyValueFactory<>("data"));
            GPS.setCellValueFactory(new PropertyValueFactory<>("GPS"));
            radius.setCellValueFactory(new PropertyValueFactory<>("radius"));
            sost.setCellValueFactory(new PropertyValueFactory<>("sost"));
            Inspector_id.setCellValueFactory(new PropertyValueFactory<>("Inspector_id"));

            table.setItems(observableArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clicked(javafx.scene.input.MouseEvent event) throws SQLException {
        if (event.getClickCount() == 2) {
            table.getScene().getWindow().hide();
            Table_modul table_modul = table.getSelectionModel().getSelectedItem();
            Const.car_dtp_id = table_modul.id;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/CarDTP.fxml"));
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
        name_txt.setText(name);
        l_name_txt.setText(last_name);
        id_card_txt.setText(id_card);
    }

    private void querry_2() throws SQLException {
        DayabaswHendel dbHandler = new DayabaswHendel();
        ResultSet resultSet = dbHandler.getData_2();
        String name = "";
        String last_name = "";
        String id_card = "";
        while (resultSet.next()) {
            name = resultSet.getString("name");
            last_name = resultSet.getString("last_name");
            id_card = resultSet.getString("passport");

        }
        name_txt.setText(name);
        l_name_txt.setText(last_name);
        id_card_txt.setText(id_card);
    }
}

