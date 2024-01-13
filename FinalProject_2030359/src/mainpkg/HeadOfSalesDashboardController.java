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
public class HeadOfSalesDashboardController implements Initializable {

    @FXML
    private Button BackButton;
    @FXML
    private Button AddNewProductButton;
    @FXML
    private Button AddNewServiceButton;
    @FXML
    private Button OfferProductsForSaleButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void BackButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Dashboard.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void AddNewProductButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddNewProduct.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void AddNewServiceButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddNewService.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void OfferProductsForSaleButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OfferProductsForSales.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);
                       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }
    
}
