package application;
// ============ CLASS NODE =============
//
// Associate values ​​with a node according to its coordinates and its type of support (represented by an int (1) simple, (2) double, (3) without support).
//
// =======================================



public class Node {
    Double abscissa;
    Double ordinate;
    int typeSupport; // (1) simple (tangential tranlation), (2) double (blocked in translation), (3) without support 
    String identificationN; // node name

    Node (Double abs, Double ord, String idn, int support) {
        this.abscissa = abs;
        this.ordinate = ord;
        this.identificationN = idn;
        this.typeSupport = support;
    }
    Node () {
        this.abscissa = 0.0;
        this.ordinate = 0.0;
        this.identificationN = "Unidentified";
        this.typeSupport = 0;
    }
}