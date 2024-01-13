/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apurb
 */
public class AddNewProductController implements Initializable {

    @FXML
    private Button BackButton;
    @FXML
    private DatePicker ExpireDate;
    @FXML
    private TextField DescriptionTextField;
    @FXML
    private TextField ProductPriceTextField;
    @FXML
    private TextField ProductIDTextField;
    @FXML
    private TextField ProductNameTextField;
    @FXML
    private ComboBox<Integer> QuantityComboBox;
    @FXML
    private Label countLabel;
    @FXML
    private Button AddProductButton;
    @FXML
    private TextArea OutputTextField;

    private ArrayList<Product> ProductList;
    @FXML
    private CheckBox TextCheckBox;
    @FXML
    private Button SaveAsTextButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //create new Product class
        ProductList = new ArrayList<Product>();

        //add option in combobox
        QuantityComboBox.getItems().addAll(2, 3, 4, 5);
        //select default value
        QuantityComboBox.setValue(1);

        countLabel.setText(" The Current Product List is Empty!!!");
    }

    @FXML
    private void BackButtonOnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfSalesDashboard.fxml"));
        Parent personViewParent = loader.load();

        Scene personViewScene = new Scene(personViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void AddProductButtonOnClicked(MouseEvent event) {
        try {
            Product p = new Product(
                    Integer.parseInt(ProductIDTextField.getText()),
                    QuantityComboBox.getValue(),
                    ProductNameTextField.getText(),
                    DescriptionTextField.getText(),
                    ExpireDate.getValue(),
                    Float.parseFloat(ProductPriceTextField.getText())
            );

            ProductList.add(p);
            countLabel.setText(" After addition, there is/are TOTAL " + ProductList.size() + " product/s as shown below :");
            OutputTextField.appendText(p.toString());

            // Clear fields
            ProductIDTextField.clear();
            ProductNameTextField.clear();
            DescriptionTextField.clear();
            ProductPriceTextField.clear();
            QuantityComboBox.setValue(1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void SaveAsTextButtonIsClicked(MouseEvent event) {
        if (TextCheckBox.isSelected()) {
            FileWriter fw = null;
            try {
                File f = new File("src/mainpkg/ProductDataTextFile.txt");

                if (f.exists()) {
                    fw = new FileWriter(f, true);
                } else {
                    fw = new FileWriter("src/mainpkg/ProductDataTextFile.txt");
                }
                String str = "";
                for (Product p : ProductList) {
                    str += "Product ID : " + p.getProductid() + " , Quantity : " + p.getQuantity() + " , Name : " + p.getProductname() + " , Description : " + p.getDescription() + " , Expire Date : " + p.getExpireDate() + " , Price : " + p.getPrice() + "\n";
                }
                fw.write(str);
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
}
