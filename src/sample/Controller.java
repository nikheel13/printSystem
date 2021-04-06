package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class Controller implements Initializable {



    @FXML
    private TextField userName;

    @FXML
    private PasswordField passCode;

    @FXML
    private Button signIn;

    @FXML
    private Label wrongInfo;


    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == signIn) {
            //login here

            if (logIn().equals("Success")) {

                try {

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


    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public Controller() {

        con = ConnectionUtil.getConnection();

        // if you remove this the null becomes active below.
        // Also this is the method which gives the connection to the database.
    }

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    //will use string to know the status.


    private String logIn() {

        String username = userName.getText();
        String password = passCode.getText();


        String sql = "SELECT * FROM nmasodia_print.employee WHERE username =? AND password =?";

        try {

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {

                wrongInfo.setTextFill(Color.RED);
                wrongInfo.setText("Please enter the correct credentials.");
                System.err.println("Wrong Credentials");
                return "Error";


            } else {


                wrongInfo.setTextFill(Color.GREEN);
                wrongInfo.setText("Successful Log in");
                System.out.println("Successful");
                return "Success";

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }

}
