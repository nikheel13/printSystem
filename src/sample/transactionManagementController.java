package sample;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class transactionManagementController implements Initializable {

    @FXML
    private Button returnHome;
    @FXML
    private Button btnAddEmp;
    @FXML
    private StackPane parentContainer;

    @FXML
    private TableView<ModelMoney> tableTransactions;
    @FXML
    private TableColumn<ModelMoney, String> col_workid;
    @FXML
    private TableColumn<ModelMoney, String> col_aliasname;
    @FXML
    private TableColumn<ModelMoney, String> col_workname;
    @FXML
    private TableColumn<ModelMoney, String> col_numbsheets;
    @FXML
    private TableColumn<ModelMoney, String> col_numbcopies;
    @FXML
    private TableColumn<ModelMoney, String> col_worktype;
    @FXML
    private TableColumn<ModelMoney, String> col_workstatus;
    @FXML
    private TableColumn<ModelMoney, String> col_workcost;






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











    ObservableList<ModelMoney> view = FXCollections.observableArrayList();







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM nmasodia_print.transaction ");

            while (rs.next()){

                view.add(new ModelMoney(rs.getString("workid"), rs.getString("aliasname"),
                        rs.getString("workname"), rs.getString("numbsheets"),
                        rs.getString("numbcopies"), rs.getString("worktype"),
                        rs.getString("workstatus"), rs.getString("workcost")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_workid.setCellValueFactory(new PropertyValueFactory<>("workid"));
        col_aliasname.setCellValueFactory(new PropertyValueFactory<>("aliasname"));
        col_workname.setCellValueFactory(new PropertyValueFactory<>("workname"));
        col_numbsheets.setCellValueFactory(new PropertyValueFactory<>("numbsheets"));
        col_numbcopies.setCellValueFactory(new PropertyValueFactory<>("numbcopies"));
        col_worktype.setCellValueFactory(new PropertyValueFactory<>("worktype"));
        col_workstatus.setCellValueFactory(new PropertyValueFactory<>("workstatus"));
        col_workcost.setCellValueFactory(new PropertyValueFactory<>("workcost"));


        tableTransactions.setItems(view);

    }






}

