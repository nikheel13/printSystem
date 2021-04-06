package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class empManagementController implements Initializable {

    @FXML
    private Button returnHome;
    @FXML
    private Button btnAddEmp;
    @FXML
    private StackPane parentContainer;

    @FXML
    private TableView<ModelEmployee> tableEmployee;
    @FXML
    private TableColumn<ModelEmployee, String> col_id;
    @FXML
    private TableColumn<ModelEmployee, String> col_firstname;
    @FXML
    private TableColumn<ModelEmployee, String> col_lastname;
    @FXML
    private TableColumn<ModelEmployee, String> col_username;
    @FXML
    private TableColumn<ModelEmployee, String> col_phone;
    @FXML
    private TableColumn<ModelEmployee, String> col_position;



    @FXML
    public void addEmpButton(MouseEvent event) {

        if (event.getSource() == btnAddEmp) {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("newEmployer.fxml"));
                Scene scene = btnAddEmp.getScene();

                root.translateYProperty().set(scene.getHeight());
                parentContainer.getChildren().add(root);

                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }











    @FXML
    public void backToHome(MouseEvent event) {

        if (event.getSource() == returnHome) {

            try{

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setResizable(false);
                stage.close();


                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }

    ObservableList<ModelEmployee> oblist = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("select * from employee");

            while (rs.next()){

                oblist.add(new ModelEmployee(rs.getString("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"),
                        rs.getString("phone"), rs.getString("position")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_position.setCellValueFactory(new PropertyValueFactory<>("position"));

        tableEmployee.setItems(oblist);

    }




    }











