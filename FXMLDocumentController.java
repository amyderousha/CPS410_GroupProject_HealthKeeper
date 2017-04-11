/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthkeeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

/**
 *
 * @author heilg
 */
public class FXMLDocumentController implements Initializable {
   
    
    BACHandler handler = new BACHandler();
    
    @FXML // fx:id="txtDrinkSize;
    private TextField txtDrinkSize;
    @FXML
    private TextField txtDrinkPerc;
    @FXML
    private TextField bacTotal;
    @FXML
    private ListView drinkList;
    
    private ObservableList<String> underlyingDrinkList;
    
    
    @FXML
    private void addDrink() {
                
        float size = Float.parseFloat(txtDrinkSize.getText());
        float  percentage = Float.parseFloat(txtDrinkPerc.getText());
        handler.addDrink(size, percentage);
        bacTotal.setText(String.format("%.3f",handler.calculateBAC()/100) + "%");
        System.out.println(handler.calculateBAC());
        
        addToList(size, percentage);
    }
    
    @FXML
    private void removeDrink(){
        MultipleSelectionModel selectedItems = drinkList.getSelectionModel();
        
        int drinkIndex = selectedItems.getSelectedIndex();
       
        System.out.println("The index to be removed is: " + drinkIndex);
        
        if(drinkIndex >= 0){
            underlyingDrinkList.remove(drinkIndex);
            handler.removeDrink(drinkIndex);
            bacTotal.setText(String.format("%.3f",handler.calculateBAC()/100) + "%");
        }
    }
    
    //add drinks to list
    private void addToList(float size, float percentage){
        underlyingDrinkList = drinkList.getItems();
        underlyingDrinkList.add("Size: " + size + ", Percentage: " + percentage + "%");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }    
    
}
