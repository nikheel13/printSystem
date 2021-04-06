package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    @FXML
    private Button employeeView;

    @FXML
    private Button jobView;

    @FXML
    private Button aliasView;

    @FXML
    private Button transactionView;

    @FXML
    private Button printersView;



    @FXML
    public void employeeManagementScreen(MouseEvent event) {

        if (event.getSource() == employeeView) {

            try {

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



    @FXML
    public void jobManagementScreen(MouseEvent event) {

        if (event.getSource() == jobView) {

            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setResizable(false);
                stage.close();


                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("jobMgtScreen.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }

    @FXML
    public void aliasManagementScreen(MouseEvent event) {

        if (event.getSource() == aliasView) {

            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setResizable(false);
                stage.close();


                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("aliasMgtScreen.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }


    @FXML
    public void transactionManagementScreen(MouseEvent event) {

        if (event.getSource() == transactionView) {

            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setResizable(false);
                stage.close();


                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("transactionMgtScreen.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }



    @FXML
    public void printersManagementScreen(MouseEvent event) {

        if (event.getSource() == printersView) {

            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setResizable(false);
                stage.close();


                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("printersMgtScreen.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }














    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
