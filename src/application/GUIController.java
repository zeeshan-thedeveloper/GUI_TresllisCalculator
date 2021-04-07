package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GUIController implements Initializable{
	
	@FXML
	TextField identificationN;
	@FXML
	TextField txt_abscisse;
	@FXML
	TextField txt_ordonne;
	@FXML
	Button openFileExploral;
	@FXML 
	ComboBox<Support_Type> comboBox_support;
	public void test() {
		System.out.print("Here"+txt_abscisse.getText());
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboBox_support.setItems(FXCollections.observableArrayList(
			    new Support_Type("Pas de support"),
			    new Support_Type("Support unique"), 
			    new Support_Type("Double soutien")));

		comboBox_support.valueProperty().addListener((obs, oldVal, newVal) -> 
			    System.out.println("Selected type is :" + newVal.getType()));
	}
	
	
}

class Support_Type{
	String type;
	public Support_Type(String type) {
		// TODO Auto-generated constructor stub
		this.type=type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override

	public String toString() {
		// TODO Auto-generated method stub
		return type;
	}
}
