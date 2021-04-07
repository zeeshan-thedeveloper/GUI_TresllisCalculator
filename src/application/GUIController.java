package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GUIController implements Initializable{
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		
		// TODO Auto-generated method stub
		comboBox_support.setItems(FXCollections.observableArrayList(
			    new Support_Type("Pas de support"),
			    new Support_Type("Support unique"), 
			    new Support_Type("Double soutien")));
		comboBox_support.valueProperty().addListener((obs, oldVal, newVal) -> 
			    selectedChoice =  newVal.getType());
	}
	
	// Variables and code for NODE Segment.
	
	
	private static String selectedChoice;
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
	@FXML
	ListView<Node_DataHolder> node_list;
	
	
	
	@FXML
	public void create_node() {
	
		int choice =-1;
		if(selectedChoice.equals("Support unique"))
		{
			choice=0;
		}
		else if(selectedChoice.equals("Double soutien"))
		{
			choice=1;
		}
		else {
			choice =2;
		}
		
		//This method will create an object will store in the list.
		node_list.getItems().add(new Node_DataHolder(identificationN.getText(),txt_abscisse.getText(),txt_ordonne.getText(), choice));
	
	}
	
	
	//Code and variables for Point segment.
	
	@FXML
	TextField txt_point_abscisse;
	@FXML
	TextField txt_point_ordonne;
	@FXML
	Button create_point_btn;
	@FXML
	ListView<Point_DataHolder> points_list;
	
	
	@FXML 
	public void create_point()
	{
		points_list.getItems().add(new Point_DataHolder(txt_point_abscisse.getText(),txt_point_ordonne.getText()));
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
class Node_DataHolder
{
	
	String identificationN,txt_abscisse,txt_ordonne;
	int type_support;
	public Node_DataHolder(String identificationN, String txt_abscisse,String txt_ordonne,int type_support) {
		// TODO Auto-generated constructor stub
		this.identificationN=identificationN;
		this.txt_abscisse=txt_abscisse;
		this.txt_ordonne=txt_abscisse;
		this.type_support=type_support;
	}
	public String getIdentificationN() {
		return identificationN;
	}
	public void setIdentificationN(String identificationN) {
		this.identificationN = identificationN;
	}
	public String getTxt_abscisse() {
		return txt_abscisse;
	}
	public void setTxt_abscisse(String txt_abscisse) {
		this.txt_abscisse = txt_abscisse;
	}
	public String getTxt_ordonne() {
		return txt_ordonne;
	}
	public void setTxt_ordonne(String txt_ordonne) {
		this.txt_ordonne = txt_ordonne;
	}
	public int getType_support() {
		return type_support;
	}
	public void setType_support(int type_support) {
		this.type_support = type_support;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ty = "";
		if(type_support==0)
		{
			ty="Support unique";
		}
		else if(type_support==1)
		{
			ty="Double soutien";
		}
		else
		{
			ty = "Pas de support";
		}
		
		return identificationN+" | x :"+txt_abscisse+" | y :"+txt_ordonne+" | type : "+ty; 
	}
	
	
}

class Point_DataHolder
{
	String i,j;
	public Point_DataHolder(String i,String j) {
		// TODO Auto-generated constructor stub
		this.i=i;
		this.j=j;
	}
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " P "+" with i: "+i+" and j:"+j ;
	}
	
}
