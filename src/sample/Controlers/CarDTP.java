package sample.Controlers;
import java.io.IOException;
import java.sql.ResultSet;
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
import javafx.stage.Stage;
import sample.connection_sql.Const;
import sample.connection_sql.DayabaswHendel;

public class CarDTP {

    @FXML
    private TableColumn<Car, String> id_car;

    @FXML
    private TableView<Car> table;

    @FXML
    private TableColumn<Car, String> gos_nomer;

    @FXML
    private TableColumn<Car, String> vin;


    @FXML
    private TableColumn<Car, String> marca;

    @FXML
    private TableColumn<Car, String> dtp_col;

    @FXML
    private Button glav;

    @FXML
    private Button back;

    @FXML
    private ImageView prog_image;

    ObservableList<Car> observableArray = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        Image image = new Image("file:\\" + "C:\\Users\\Egor Cvetkov\\IdeaProjects\\Bruh\\resources\\pngegg.png");
        prog_image.setImage(image);
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/View.fxml"));
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

        DayabaswHendel dayabaswHendel = new DayabaswHendel();
        ResultSet resultCheck = dayabaswHendel.Car_dtp();
        try {
            while (resultCheck.next()) {
                Const.vin = resultCheck.getInt("vin");
                observableArray.add(new Car(
                        resultCheck.getInt("id_car"),
                        resultCheck.getString("gos_nomer"),
                        resultCheck.getString("vin"),
                        resultCheck.getString("marca"),
                        resultCheck.getInt("dtp_col")
                ));
            }
            id_car.setCellValueFactory(new PropertyValueFactory<>("id"));
            gos_nomer.setCellValueFactory(new PropertyValueFactory<>("gos_nomer"));
            vin.setCellValueFactory(new PropertyValueFactory<>("vin"));
            marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            dtp_col.setCellValueFactory(new PropertyValueFactory<>("dtp_col"));
            table.setItems(observableArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
