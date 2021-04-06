package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class printerManagementController implements Initializable {

    @FXML
    private Button returnHome;
    @FXML
    private TextField printerName;
    @FXML
    private TextField printerType;
    @FXML
    private TextField printerStatus;
    @FXML
    private TextField printerId;


    @FXML
    private TableView<ModelPrinters> tablePrinter;
    @FXML
    private TableColumn<ModelPrinters, String> col_printerid;
    @FXML
    private TableColumn<ModelPrinters, String> col_printername;
    @FXML
    private TableColumn<ModelPrinters, String> col_printertype;
    @FXML
    private TableColumn<ModelAlias, String> col_printerstatus;












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

    PreparedStatement preparedStatement;
    Connection con;

    ObservableList<ModelPrinters> oblist = FXCollections.observableArrayList();







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Connection con = ConnectionUtil.getConnection();
        try {

            ResultSet rs = con.createStatement().executeQuery("select * from printers");

            while (rs.next()){

                oblist.add(new ModelPrinters(rs.getString("printerid"), rs.getString("printername"),
                        rs.getString("printertype"), rs.getString("printerstatus")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_printerid.setCellValueFactory(new PropertyValueFactory<>("printerid"));
        col_printername.setCellValueFactory(new PropertyValueFactory<>("printername"));
        col_printertype.setCellValueFactory(new PropertyValueFactory<>("printertype"));
        col_printerstatus.setCellValueFactory(new PropertyValueFactory<>("printerstatus"));


        tablePrinter.setItems(oblist);

    }


    @FXML
    private void addPrinterButtonAction (MouseEvent event){

        String printername = printerName.getText();
        String printertype = printerType.getText();
        String printerstatus = printerStatus.getText();








        String query = "INSERT INTO nmasodia_print.printers(printername,printertype,printerstatus) VALUES (?,?,?)";


        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1,printername);
            preparedStatement.setString(2,printertype);
            preparedStatement.setString(3,printerstatus);

            preparedStatement.executeUpdate();










        } catch (SQLException e) {
            e.printStackTrace();
        }

        refreshTable();


    }


    public void refreshTable(){

        oblist.clear();

        Connection con = ConnectionUtil.getConnection();

        try {

            ResultSet rs = con.createStatement().executeQuery("select * from printers");

            while (rs.next()){

                oblist.add(new ModelPrinters(rs.getString("printerid"), rs.getString("printername"),
                        rs.getString("printertype"), rs.getString("printerstatus")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_printerid.setCellValueFactory(new PropertyValueFactory<>("printerid"));
        col_printername.setCellValueFactory(new PropertyValueFactory<>("printername"));
        col_printertype.setCellValueFactory(new PropertyValueFactory<>("printertype"));
        col_printerstatus.setCellValueFactory(new PropertyValueFactory<>("printerstatus"));


        tablePrinter.setItems(oblist);

    }










    @FXML
    private void editPrinterButtonAction (){



        String query = "update nmasodia_print.printers set printername=?,printertype=?,printerstatus=? where printername='"+ printerName.getText()+"' ";


        try {
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
            preparedStatement.setString(1,printerName.getText());
            preparedStatement.setString(2,printerType.getText());
            preparedStatement.setString(3,printerStatus.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Printers are updated!");
            alert.showAndWait();


            preparedStatement.execute();
            preparedStatement.close();










        } catch (SQLException e) {
            e.printStackTrace();
        }

        refreshTable();


    }





}




