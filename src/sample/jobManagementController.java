package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class jobManagementController implements Initializable {

    @FXML
    private Button returnHome;

    @FXML
    private TableView<ModelJobs> tableJobs;
    @FXML
    private TableColumn<ModelJobs, String> col_jobid;
    @FXML
    private TableColumn<ModelJobs, String> col_jobname;
    @FXML
    private TableColumn<ModelJobs, String> col_nosheets;
    @FXML
    private TableColumn<ModelJobs, String> col_nocopies;
    @FXML
    private TableColumn<ModelJobs, String> col_jobstatus;
    @FXML
    private TableColumn<ModelJobs, String> col_jobcost;











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

    ObservableList<ModelJobs> oblist = FXCollections.observableArrayList();







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("select * from printjobs");

            while (rs.next()){

                oblist.add(new ModelJobs(rs.getString("jobid"), rs.getString("jobname"),
                        rs.getString("nosheets"), rs.getString("nocopies"),
                        rs.getString("jobstatus"), rs.getString("jobcost")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_jobid.setCellValueFactory(new PropertyValueFactory<>("jobid"));
        col_jobname.setCellValueFactory(new PropertyValueFactory<>("jobname"));
        col_nosheets.setCellValueFactory(new PropertyValueFactory<>("nosheets"));
        col_nocopies.setCellValueFactory(new PropertyValueFactory<>("nocopies"));
        col_jobstatus.setCellValueFactory(new PropertyValueFactory<>("jobstatus"));
        col_jobcost.setCellValueFactory(new PropertyValueFactory<>("jobcost"));

        tableJobs.setItems(oblist);

    }
}


