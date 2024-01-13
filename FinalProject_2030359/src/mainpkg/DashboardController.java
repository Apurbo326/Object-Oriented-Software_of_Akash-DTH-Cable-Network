/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apurb
 */
public class DashboardController implements Initializable {

    @FXML
    private Button HeadOfSalesButton;
    @FXML
    private Button FinancialManagerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void HeadOfSalesButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfSalesDashboard.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void FinancialManagerButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FinancialManagerDashboard.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

}
