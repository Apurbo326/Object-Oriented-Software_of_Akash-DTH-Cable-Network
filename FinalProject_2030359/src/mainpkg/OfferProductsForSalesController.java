/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apurb
 */
public class OfferProductsForSalesController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button ShowInventoryButton;
    @FXML
    private TextField ProductIDTextField;
    @FXML
    private CheckBox SaveTextFileCheckBox;
    @FXML
    private Button ShowOfferProductButton;
    @FXML
    private TextArea InventoryTextFileOutputArea;

    @FXML
    private Button ShowSelectedProductButton;
    @FXML
    private TextArea SelectProductOutputTextField;
    @FXML
    private TextArea OfferedProductListOutputTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //To Do
    }

    @FXML
    private void backButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfSalesDashboard.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void ShowInventoryButtonOnClicked(MouseEvent event) {
        //use BufferedReader OR Scanner
        File file = new File("src/mainpkg/ProductDataTextFile.txt");
        Scanner sc;
        String str = null;
        try {
            sc = new Scanner(file);
            InventoryTextFileOutputArea.setText(null);
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                String[] tokens;
                tokens = str.split(",");
                str = tokens[0] + tokens[1] + tokens[2] + tokens[3] + tokens[4] + tokens[5];
                InventoryTextFileOutputArea.appendText(str + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OfferProductsForSalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void IsSaveTextFileCheckboxClicked(ActionEvent event) {
        if (SaveTextFileCheckBox.isSelected()) {
            FileWriter fw = null;
            try {
                File f = new File("src/mainpkg/OfferProductListDataTextFile.txt");

                if (f.exists()) {
                    fw = new FileWriter(f, true);
                } else {
                    fw = new FileWriter("src/mainpkg/OfferProductListDataTextFile.txt");
                }

                String productIdToMatch = ProductIDTextField.getText();
                String str = showProductDetails(productIdToMatch);
                fw.write(str+"\n");
                fw.close();
            } catch (IOException ex) {
                //fw.close();
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddNewProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }



    @FXML
    public void ShowSelectedProductButtonOnClicked(MouseEvent event) {
        String productIdToMatch = ProductIDTextField.getText();
        showProductDetails(productIdToMatch);
    }

    private String showProductDetails(String productIdToMatch) {
        File file = new File("src/mainpkg/ProductDataTextFile.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] tokens = str.split(" ");

                // Check if the current line's product ID matches the desired product ID
                if (tokens.length > 0 && tokens[3].equals(productIdToMatch)) {
                    // Display the entire product details
                    String productDetails = String.join(" ", tokens);
                    SelectProductOutputTextField.setText(productDetails);
                    return String.join(" ", tokens); // Exit the method after finding the match
                }
            }

            // If no match is found, you can display a message or take appropriate action
            SelectProductOutputTextField.setText("Product with ID " + productIdToMatch + " not found");
            return "Product with ID " + productIdToMatch + " not found";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OfferProductsForSalesController.class.getName()).log(Level.SEVERE, null, ex);
        // Return an error message if an exception occurs
        return "An error occurred while processing the request";
        }
    }

    @FXML
    private void ShowOfferProductButtonOnClicked(MouseEvent event) {
        //use BufferedReader OR Scanner
        File file = new File("src/mainpkg/OfferProductListDataTextFile.txt");
        Scanner sc;
        String str = null;
        try {
            sc = new Scanner(file);
            OfferedProductListOutputTextArea.setText(null);
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                String[] tokens;
                tokens = str.split(",");
                str = tokens[0] + tokens[1] + tokens[2] + tokens[3] + tokens[4] + tokens[5];
                OfferedProductListOutputTextArea.appendText(str + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OfferProductsForSalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
