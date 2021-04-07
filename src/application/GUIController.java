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
	
	
	//Code and variables for bars.
	
			@FXML 
			ComboBox<Node_ForCombox_DataHolder> comboStartingNode;
			@FXML 
			ComboBox<Node_ForCombox_DataHolder> comboEndingNode;
			Node_ForCombox_DataHolder selectedStrtingNode,selectedEndingNode;
			
			
			
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
		
		comboStartingNode.valueProperty().addListener((obs, oldVal, newVal) -> 
	    selectedStrtingNode =  newVal);
		comboEndingNode.valueProperty().addListener((obs, oldVal, newVal) -> 
	    selectedEndingNode =  newVal);
		

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
		comboStartingNode.getItems().add(new Node_ForCombox_DataHolder(identificationN.getText(),txt_abscisse.getText(),txt_ordonne.getText(), choice));
		comboEndingNode.getItems().add(new Node_ForCombox_DataHolder(identificationN.getText(),txt_abscisse.getText(),txt_ordonne.getText(), choice));
		
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

	
	//Code and variables for bars.
	
	@FXML 
	TextField material;
	@FXML 
	TextField identificationB;
	@FXML 
	TextField min_bar;
	@FXML 
	TextField max_bar;
	@FXML
	ListView<Bar_DataHolder>  bar_list;
	
	@FXML
	public void create_bar()
	{
		bar_list.getItems().add(new Bar_DataHolder(selectedStrtingNode, selectedEndingNode, identificationB.getText(), min_bar.getText(),max_bar.getText(),Integer.parseInt(material.getText()) ));
	}
	
	//Methods for making data able to be use.
	
	@FXML
	public void saveSolutionFile() {
		// TODO Auto-generated method stub

	}
	@FXML
	public void openFile() {
		// TODO Auto-generated method stub

	}
	@FXML
	private void solve() {
		// TODO Auto-generated method stub
		Trellis trellis_Data1[] = new Trellis[2];
		Terrain terrain_Data1[]= new Terrain[1];
		Node node_Data1[]= new Node[30];
		Bar bar_Data1[]= new Bar[12];
		Hand hand_Data1[]=new Hand[1];
		
		Points [] point_Data = new Points[3] ;
		
		
		//here we will generate some sample data
		 Node s1 = new Node();
		 
		 
		 //Setting nodes
		 
		 int index_node=0;
		 for(Node_DataHolder node : node_list.getItems())
		 {
			 try {
				 
				 Node s = new Node();
				 s.abscissa=Double.parseDouble(node.getTxt_abscisse());
				 s.ordinate=Double.parseDouble(node.getTxt_ordonne());
				 s.identificationN =node.identificationN;
				 s.typeSupport = node.getType_support();
				 node_Data1[index_node] = s;
				 index_node++;
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println(e.getMessage());
			}
			 
			 
		 }
		 
		 
		 //Setting bars
		 int index_bar=0;
		 for(Bar_DataHolder bar : bar_list.getItems())
		 {
			 try {
				 
				 Bar b = new Bar();
				 
				 Node startingNode = new Node();
				 startingNode.abscissa=Double.parseDouble(bar.getStartingNode().getTxt_abscisse());
				 startingNode.ordinate=Double.parseDouble(bar.getStartingNode().getTxt_ordonne());
				 startingNode.identificationN =bar.getStartingNode().identificationN;
				 startingNode.typeSupport = bar.getStartingNode().getType_support();
				 
				 b.starting_node = startingNode;
				 
				 Node endingNode = new Node();
				 endingNode.abscissa=Double.parseDouble(bar.getEndingNode().getTxt_abscisse());
				 endingNode.ordinate=Double.parseDouble(bar.getEndingNode().getTxt_ordonne());
				 endingNode.identificationN =bar.getEndingNode().identificationN;
				 endingNode.typeSupport = bar.getEndingNode().getType_support();
				 
				 b.end_node = endingNode;
				 b.identificationB=bar.getIdentificationB();
				 b.material=bar.getMatrial();
				 
				 bar_Data1[index_bar]=b;
				 index_bar++;
			 }catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Error  "+e.getMessage());
			}
			
		 }
		 
		 Trellis tt1 = new Trellis();
		 
		 tt1.setBar_data(bar_Data1);
		 tt1.setNode_data(node_Data1);
		 
		 trellis_Data1[0]=tt1;
		
		 Terrain terrain1 = new Terrain();
		 
		 
		 //setting out points
		 int index_point=0;
		 for(Point_DataHolder point : points_list.getItems())
		 {
			 Points p = new Points();
				p.setI(Float.parseFloat(point.getI()));
				p.setJ(Float.parseFloat(point.getJ()));
				point_Data[index_point]=p;
				index_point++;
				
		 }
		 
		 terrain1.PT=point_Data;
		 terrain1.TT="TT1";
		
	Matrix.meta_Data_Holder.setTrellis_Data(trellis_Data1);
	Matrix.meta_Data_Holder.setTerrain_Data(terrain_Data1);
	Matrix.meta_Data_Holder.setNode_Data(node_Data1);
	Matrix.meta_Data_Holder.setBar_Data(bar_Data1);
	Matrix.meta_Data_Holder.setHand_Data(hand_Data1);
	
	System.out.println("BAR  "+Matrix.meta_Data_Holder.getBar_Data()[0].starting_node.identificationN);
	
	}
	
	
	
	
}

class Support_Type
{
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

class Node_ForCombox_DataHolder
{
	
	String identificationN,txt_abscisse,txt_ordonne;
	int type_support;
	public Node_ForCombox_DataHolder(String identificationN, String txt_abscisse,String txt_ordonne,int type_support) {
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
		
		return identificationN; 
	}
	
	
}

class Bar_DataHolder
{
	Node_ForCombox_DataHolder startingNode,endingNode;
	String identificationB,min,max;
	int matrial;
	public Bar_DataHolder(Node_ForCombox_DataHolder startingNode, Node_ForCombox_DataHolder endingNode,String identificationB,String min,String max,int matrial) {
		// TODO Auto-generated constructor stub
		this.endingNode=endingNode;
		this.startingNode=startingNode;
		this.min=min;
		this.max=max;
		this.matrial=matrial;
		this.identificationB=identificationB;
	}
	public Node_ForCombox_DataHolder getStartingNode() {
		return startingNode;
	}
	public void setStartingNode(Node_ForCombox_DataHolder startingNode) {
		this.startingNode = startingNode;
	}
	public Node_ForCombox_DataHolder getEndingNode() {
		return endingNode;
	}
	public void setEndingNode(Node_ForCombox_DataHolder endingNode) {
		this.endingNode = endingNode;
	}
	public String getIdentificationB() {
		return identificationB;
	}
	public void setIdentificationB(String identificationB) {
		this.identificationB = identificationB;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public int getMatrial() {
		return matrial;
	}
	public void setMatrial(int matrial) {
		this.matrial = matrial;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return identificationB+" Starting Node : "+startingNode.getIdentificationN()+" Ending node: "+endingNode.getIdentificationN();
	}
}



