package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class addEmployeeController implements Initializable {



    @FXML
    private Button btnRegister;

    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField uName;

    @FXML
    private PasswordField txtPass;

    @FXML
    private PasswordField txtPassVal;

    @FXML
    private TextField txtPos;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Label emailError;

    @FXML
    private Label passValError;

    @FXML
    private Label fnError;

    @FXML
    private Label lnError;

    @FXML
    private Label passError;

    @FXML
    private Label labelExit;

    @FXML
    private TableView<ModelEmployee> tableEmployee;





    PreparedStatement preparedStatement;
    Connection con;


    @FXML
    private void close(MouseEvent event){

            if (event.getSource() == labelExit) {

                try{

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setResizable(false);
                    stage.close();


                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("empMgtScreen.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }


        }










    public addEmployeeController(){

        con = ConnectionUtil.getConnection();


    }



    @Override

    public void initialize (URL url, ResourceBundle rb){

        //TO DO!!!

    }


    public void refreshTable(){




    }



    @FXML
    private void addUserButtonAction (MouseEvent event){

        String firstname = fName.getText();
        String lastname = lName.getText();
        String username = uName.getText();
        String password = String.valueOf(txtPass.getText());
        String position = txtPos.getText();
        String phone = phoneNumber.getText();


        if(fName.equals("")){

            fnError.setTextFill(Color.TOMATO);
            fnError.setText("*");

        } else if(lName.equals("")){

            lnError.setTextFill(Color.TOMATO);
            lnError.setText("*");

        } else if(uName.equals("")){

            emailError.setTextFill(Color.TOMATO);
            emailError.setText("*");

        } else if(password.equals("")){

            passError.setTextFill(Color.TOMATO);
            passError.setText("*");

        } else if(!password.equals(txtPassVal)) {

            passValError.setTextFill(Color.GREEN);
            passValError.setText("User ADDED!");
        }





        String query = "INSERT INTO nmasodia_print.employee(firstname,lastname,username,password,position,phone) VALUES (?,?,?,?,?,?)";


        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,position);
            preparedStatement.setString(6,phone);

            preparedStatement.executeUpdate();








        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}


