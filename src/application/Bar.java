package application;

public class Bar extends Node{

Node starting_node;
Node end_node;
int material;
String identificationB;


Bar (Node noded, Node Knot, String idb, int mat) {
    this.starting_node = noded;
    this.end_node = Knot;
    this.identificationB = idb;
    this.material = mat;
}

Bar() {
    this.starting_node = new Node ();
    this.end_node = new Node ();
    this.identificationB = "Unidentified";
    this.material = 0;
}

public static String idb (int numb) {
    String idb = "N" + String.valueOf (numb);
    return (idb);
}

/* TEST Print Node
Double a = 3.0;
String name = "test";
int press = 1;
Node test = new Node (a, a, name, support);
System.out.println (test.identificationN + "coords: (" + test.abscisse + "," + test.ordinate + ") of type" + test.typeAppui);
*/
}
