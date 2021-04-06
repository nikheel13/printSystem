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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class aliasManagementController implements Initializable {

    @FXML
    private Button returnHome;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userName;
    @FXML
    private TextField emailAddress;


    @FXML
    private TableView<ModelAlias> tableAlias;
    @FXML
    private TableColumn<ModelAlias, String> col_studentid;
    @FXML
    private TableColumn<ModelAlias, String> col_firstname;
    @FXML
    private TableColumn<ModelAlias, String> col_lastname;
    @FXML
    private TableColumn<ModelAlias, String> col_username;
    @FXML
    private TableColumn<ModelAlias, String> col_email;











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

    ObservableList<ModelAlias> oblist = FXCollections.observableArrayList();

    PreparedStatement preparedStatement;
    Connection con;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("select * from students");

            while (rs.next()){

                oblist.add(new ModelAlias(rs.getString("studentid"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"),
                        rs.getString("email")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableAlias.setItems(oblist);

    }

    @FXML
    private void addAliasButtonAction (MouseEvent event){

        String firstname = firstName.getText();
        String lastname = lastName.getText();
        String username = userName.getText();
        String email = emailAddress.getText();








        String query = "INSERT INTO nmasodia_print.students(firstname,lastname,username,email) VALUES (?,?,?,?,)";


        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,email);

            preparedStatement.executeUpdate();










        } catch (SQLException e) {
            e.printStackTrace();
        }

        refreshTable();


    }

    public void refreshTable(){

        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("select * from students");

            while (rs.next()){

                oblist.add(new ModelAlias(rs.getString("studentid"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"),
                        rs.getString("email")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableAlias.setItems(oblist);

    }

    public void deleteEmployee() {



        try {

            String query = "delete from nmasodia_print.students Where studentid= ? ";
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1, firstName.getText());
            preparedStatement.executeUpdate();

            preparedStatement.close();


        } catch (SQLException ex) {
            Logger.getLogger(aliasManagementController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }


    }











