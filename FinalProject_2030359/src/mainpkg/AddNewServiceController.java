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
public class AddNewServiceController implements Initializable {

    @FXML
    private DatePicker ExpireDate;
    @FXML
    private TextField DescriptionTextField;
    @FXML
    private TextField ServicePriceTextField;
    @FXML
    private TextField ServiceIDTextField;
    @FXML
    private TextField ServiceNameTextField;
    @FXML
    private ComboBox<Integer> QuantityComboBox;
    @FXML
    private Label countLabel;
    @FXML
    private Button AddServiceButton;
    @FXML
    private TextArea OutputTextField;
    @FXML
    private Button BackButton;
    @FXML
    private CheckBox TextCheckBox;
    @FXML
    private Button SaveAsTextButton;

    private ArrayList<Service> ServiceList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //create new Product class
        ServiceList = new ArrayList<Service>();

        //add option in combobox
        QuantityComboBox.getItems().addAll(2, 3, 4, 5);
        //select default value
        QuantityComboBox.setValue(1);

        countLabel.setText(" The Current Service List is Empty!!!");
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
    private void SaveAsTextButtonIsClicked(MouseEvent event) {
        if (TextCheckBox.isSelected()) {
            FileWriter fw = null;
            try {
                File f = new File("src/mainpkg/ServiceDataTextFile.txt");

                if (f.exists()) {
                    fw = new FileWriter(f, true);
                } else {
                    fw = new FileWriter("src/mainpkg/ServiceDataTextFile.txt");
                }
                String str = "";
                for (Service p : ServiceList) {
                    str += "Service ID : " + p.getServiceid() + " , Quantity : " + p.getQuantity() + " , Name : " + p.getServicename() + " , Description : " + p.getDescription() + " , Expire Date : " + p.getExpireDate() + " , Price : " + p.getPrice() + "\n";
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

    @FXML
    private void AddServiceButtonOnClicked(MouseEvent event) {
        try {
            Service s = new Service(
                    Integer.parseInt(ServiceIDTextField.getText()),
                    QuantityComboBox.getValue(),
                    ServiceNameTextField.getText(),
                    DescriptionTextField.getText(),
                    ExpireDate.getValue(),
                    Float.parseFloat(ServicePriceTextField.getText())
            );

            ServiceList.add(s);
            countLabel.setText(" After addition, there is/are TOTAL " + ServiceList.size() + " Service/s as shown below :");
            OutputTextField.appendText(s.toString());

            // Clear fields
            ServiceIDTextField.clear();
            ServiceNameTextField.clear();
            DescriptionTextField.clear();
            ServicePriceTextField.clear();
            QuantityComboBox.setValue(1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
}
