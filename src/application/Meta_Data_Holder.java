package application;

public class Meta_Data_Holder {
	Trellis trellis_Data[];
	Terrain terrain_Data[];
	Node node_Data[];
	Bar bar_Data[];
	Hand hand_Data[];
	Points [] point_Data;
	Meta_Data_Holder(){
		
		//Here we will define max number of 
		/*
		Trellis trellis_Data1[] = new Trellis[2];
		Terrain terrain_Data1[]= new Terrain[1];
		Node node_Data1[]= new Node[30];
		Bar bar_Data1[]= new Bar[12];
		Hand hand_Data1[]=new Hand[1];
		
		
		//here we will generate some sample data
		 Node s1 = new Node();
		 Node s2 = new Node();
		 Node s3 = new Node();
		 
		 s1.abscissa=0.0;
		 s1.ordinate=0.0;
		 s1.identificationN = "S1_NODE";
		 s1.typeSupport = 1;
		 
		 
		 s2.abscissa=0.0;
		 s2.ordinate=2.0;
		 s2.identificationN = "S2_NODE";
		 s2.typeSupport = 1;
		 
		 s3.abscissa=1.0;
		 s3.ordinate=1.0;
		 s3.identificationN = "S3_NODE";
		 s3.typeSupport = 2;
		 
		 
		 
		 Bar b1 = new Bar();
		 Bar b2 = new Bar();
		 Bar b3 = new Bar();
		 
		 b1.starting_node = s1;
		 b1.end_node = s3;
		 b1.identificationB="BAR_1";
		 b1.material=0;
		 
		 b2.starting_node = s1;
		 b2.end_node = s2;
		 b2.identificationB="BAR_2";
		 b2.material=0;
		 
		 b3.starting_node = s2;
		 b3.end_node = s1;
		 b3.identificationB="BAR_3";
		 b3.material=0;
		 
		 
		 node_Data1[0]=s1;
		 node_Data1[1]=s2;
		 node_Data1[2]=s3;
		 
		 bar_Data1[0]=b1;
		 bar_Data1[1]=b2;
		 bar_Data1[2]=b3;
		 
		 Trellis tt1 = new Trellis();
		 tt1.setBar_data(bar_Data1);
		 tt1.setNode_data(node_Data1);
		 
		 
		 trellis_Data1[0]=tt1;
		
		
		Terrain terrain1 = new Terrain();
		
		Points [] point_Data = new Points[3] ;
		
		Points p1 = new Points();
		Points p2 = new Points();
		Points p3 = new Points();
		
		p1.setI(0.0F);
		p1.setJ(4.0F);
		
		p2.setI(-4.0F);
		p2.setJ(-2.0F);
		
		p2.setI(0.0F);
		p2.setJ(-5.0F);
		
		point_Data[0]=p1;
		point_Data[1]=p2;
		point_Data[2]=p3;
		
		
		terrain1.PT=point_Data;
		terrain1.TT="TT1";
		
		
		setTrellis_Data(trellis_Data1);
		setTerrain_Data(terrain_Data1);
		setNode_Data(node_Data1);
		setBar_Data(bar_Data1);
		setHand_Data(hand_Data1);
		
		*/
		
	}
	
	public Points[] getPoint_Data() {
		return point_Data;
	}

	public void setPoint_Data(Points[] point_Data) {
		this.point_Data = point_Data;
	}

	public Trellis[] getTrellis_Data() {
		return trellis_Data;
	}
	public void setTrellis_Data(Trellis[] trellis_Data) {
		this.trellis_Data = trellis_Data;
	}
	public Terrain[] getTerrain_Data() {
		return terrain_Data;
	}
	public void setTerrain_Data(Terrain[] terrain_Data) {
		this.terrain_Data = terrain_Data;
	}
	public Node[] getNode_Data() {
		return node_Data;
	}
	public void setNode_Data(Node[] node_Data) {
		this.node_Data = node_Data;
	}
	public Bar[] getBar_Data() {
		return bar_Data;
	}
	public void setBar_Data(Bar[] bar_Data) {
		this.bar_Data = bar_Data;
	}
	public Hand[] getHand_Data() {
		return hand_Data;
	}
	public void setHand_Data(Hand[] hand_Data) {
		this.hand_Data = hand_Data;
	}
	 
	
}
class Node_Access_Data_Holder {
	float x ,y;
	Node_Access_Data_Holder(float x ,float y){
		this.x=x;
		this.y=y;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
}
