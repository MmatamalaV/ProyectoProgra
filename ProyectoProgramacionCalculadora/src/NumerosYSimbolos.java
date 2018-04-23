/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PuntosDeControlYMovimiento.PuntosDeControl;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author elias
 */
public class NumerosYSimbolos extends PuntosDeControl{

    private final double espacio;
    private final double superior;
    private double size;
    private double xPoint;
    private double yPoint;
    private double amountOfSymbolsDivide;
    private final Path pathActual = new Path();
    private String ID;
    

    public NumerosYSimbolos(double sizeTotal,double marco, double espacio, double superior, boolean puntosVisibles) {
        super(sizeTotal);
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
        this.puntosVisibles=puntosVisibles;
    }
    
    
    
    public Group multiplicacion() {
        //Se define el tamaño de la figura..
        size=1.2*sizeTotal;
        System.out.println(sizeTotal);
        //Se define el centro de la figura.
        xPoint = (200+espacio);
        yPoint = (150+superior);
        ID = "*";
        //Se crean las líneas de la figura.
        MoveTo centroMulti = new MoveTo(xPoint, yPoint);
        LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
        LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
        LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
        LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
        LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
        LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
        LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
        LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);

        pathActual.setStrokeWidth(4*size);
        //Se añaden las líneas de la figura a path.
        pathActual.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);
        //Se crean los círculos con la ubicación de las líneas.
        
        iniciateCircleMoveTo(centroMulti);
        iniciateCircleLineTo(line1Multi);
        iniciateCircleLineTo(line2Multi);
        iniciateCircleLineTo(line3Multi);
        iniciateCircleLineTo(line4Multi);
        iniciateCircleLineTo(line5Multi);
        iniciateCircleLineTo(line6Multi);
        iniciateCircleLineTo(line7Multi);
        iniciateCircleLineTo(line8Multi);
      
        Group root = new Group(pathActual, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group division() {
        ID = "/";
        size=1.2*sizeTotal;
        amountOfSymbolsDivide = 1*size; //Variable para cantidad de números que irán en la división
        xPoint = (200+espacio);
        yPoint = (150+superior);

        MoveTo startDivide = new MoveTo(xPoint, yPoint);
        LineTo line1Divide = new LineTo(xPoint-33*amountOfSymbolsDivide, yPoint);
        LineTo line2Divide = new LineTo(xPoint+33*amountOfSymbolsDivide, yPoint);

        pathActual.setStrokeWidth(4*size);
    
        pathActual.getElements().addAll(startDivide, line1Divide, startDivide, line2Divide);
        
        iniciateCircleMoveTo(startDivide);
        iniciateCircleLineTo(line1Divide);
        iniciateCircleLineTo(line2Divide);
        
        Group root = new Group(pathActual, circle);
        
        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group parentesis1() {
        
        size=1.2*sizeTotal;
        double amountOfSymbolsParen1 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        xPoint = (200+espacio);
        yPoint = (150+superior);

        Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
        Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);

        configuraArco(arc1Paren1);
        configuraArco(arc2Paren1);
        
        createCircle(arc1Paren1.getCenterX(), arc1Paren1.getCenterY()-42*amountOfSymbolsParen1);
        createCircle(arc2Paren1.getCenterX()-7.5*amountOfSymbolsParen1, arc2Paren1.getCenterY());
        createCircle(arc2Paren1.getCenterX(), arc2Paren1.getCenterY()+42*amountOfSymbolsParen1);

        Group root = new Group(arc1Paren1, arc2Paren1, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group parentesis2() {
        
        size=1.2*sizeTotal;
        double amountOfSymbolsParen2 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        xPoint = (200+espacio);
        yPoint = (150+superior);

        Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
        Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);

        configuraArco(arc1Paren2);
        configuraArco(arc2Paren2);
        
        createCircle(arc1Paren2.getCenterX(), arc1Paren2.getCenterY()-42*amountOfSymbolsParen2);
        createCircle(arc2Paren2.getCenterX()+7.5*amountOfSymbolsParen2, arc2Paren2.getCenterY());
        createCircle(arc2Paren2.getCenterX(), arc2Paren2.getCenterY()+42*amountOfSymbolsParen2);

        Group root = new Group(arc1Paren2, arc2Paren2, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group resta() {
        
        size=1.2*sizeTotal;
        xPoint = (200+espacio);
        yPoint = (150+superior);

        MoveTo startMinus = new MoveTo(xPoint, yPoint);
        LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
        LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);

        pathActual.setStrokeWidth(4*size);
        
        pathActual.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);

        iniciateCircleMoveTo(startMinus);
        iniciateCircleLineTo(line1Minus);
        iniciateCircleLineTo(line2Minus);
      
        Group root = new Group(pathActual, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group suma() {
        
        size = 1.2*sizeTotal;
        xPoint = (200+espacio);
        yPoint = (150+superior);

        MoveTo startPlus = new MoveTo(xPoint, yPoint);
        LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
        LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
        LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
        LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

        pathActual.setStrokeWidth(4*size);

        pathActual.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);
       
        iniciateCircleMoveTo(startPlus);
        iniciateCircleLineTo(line1Plus);
        iniciateCircleLineTo(line2Plus);
        iniciateCircleLineTo(line3Plus);
        iniciateCircleLineTo(line4Plus);

        Group root = new Group(pathActual, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
    public Group numero0() {
        
        size=1.28*sizeTotal;
        xPoint = (200+espacio);
        yPoint = (150+superior);

        Arc arcZero = new Arc(xPoint, yPoint,25*size,40*size,90,90);
        Arc arc1Zero = new Arc(xPoint, yPoint,25*size,40*size,180,90);
        Arc arc2Zero = new Arc(xPoint, yPoint,25*size,40*size,270,90);
        Arc arc3Zero = new Arc(xPoint, yPoint,25*size,40*size,360,90);
        
        configuraArco(arcZero);
        configuraArco(arc1Zero);
        configuraArco(arc2Zero);
        configuraArco(arc3Zero);
        
        createCircle(arcZero.getCenterX(), arcZero.getCenterY()-40*size);
        createCircle(arc1Zero.getCenterX()+25*size, arc1Zero.getCenterY());
        createCircle(arc2Zero.getCenterX(), arc2Zero.getCenterY()+40*size);
        createCircle(arc3Zero.getCenterX()-25*size, arc3Zero.getCenterY());
        
        circle.setVisible(puntosVisibles);
        
        Group root = new Group(arcZero, arc1Zero, arc2Zero, arc3Zero, circle);

        return root;
    }
    
    public Group numero1(){
        
        xPoint = (215+espacio);
        yPoint = (200+superior);
        
        MoveTo p1=new MoveTo(xPoint,yPoint);
        LineTo p2= new LineTo(xPoint,yPoint-100);
        LineTo p3= new LineTo(xPoint-50,yPoint-50);
        
        pathActual.setStrokeWidth(4);
        
        pathActual.getElements().addAll(p1,p2,p3);
        
        iniciateCircleMoveTo(p1);
        iniciateCircleLineTo(p2);
        iniciateCircleLineTo(p3);
        
        circle.setVisible(puntosVisibles);
        
        Group root = new Group(pathActual, circle);
        return root;
        
    }
    
    public Group numero2() {
        
        xPoint = (180+espacio);
        yPoint = (125+superior);
        
        MoveTo start2 = new MoveTo();
        start2.setX(xPoint);
        start2.setY(yPoint);
        
        HLineTo base = new HLineTo();
        base.setX(xPoint+50);
        
        LineTo diagonal = new LineTo();
        diagonal.setX(xPoint);
        diagonal.setY(yPoint+75);
        
        QuadCurveTo primerArco = new QuadCurveTo();
        primerArco.setX(xPoint+25);
        primerArco.setY(yPoint-25);
        primerArco.setControlX(xPoint);
        primerArco.setControlY(yPoint-25);
        
        
        QuadCurveTo segundoArco = new QuadCurveTo();
        segundoArco.setX(xPoint+50);
        segundoArco.setY(yPoint);
        segundoArco.setControlX(xPoint+50);
        segundoArco.setControlY(yPoint-25);
        
        pathActual.setStrokeWidth(4);
        
        createCircle(start2.getX(), start2.getY()+marco);
        createCircle(primerArco.getX(), primerArco.getY()+marco);
        createCircle(segundoArco.getX(), segundoArco.getY()+marco);
        createCircle(diagonal.getX(), diagonal.getY()+marco);
        createCircle(base.getX(),yPoint+75+marco);

        circle.setVisible(puntosVisibles);

        
        pathActual.getElements().addAll(start2,primerArco,segundoArco,diagonal,base);
        
        Group root = new Group(pathActual, circle);
        
        return root;
    }
    
    public Group numero3() {
        
        xPoint = (180+espacio);
        yPoint = (200+superior);
        
        MoveTo start3 = new MoveTo();
        start3.setX(xPoint);
        start3.setY(yPoint);
        
        HLineTo base = new HLineTo();
        base.setX(xPoint+10);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(xPoint+40);
        arco1.setY(yPoint-25);
        arco1.setControlX(xPoint+40);
        arco1.setControlY(yPoint);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(xPoint+10);
        arco2.setY(yPoint-50);
        arco2.setControlX(xPoint+40);
        arco2.setControlY(yPoint-50);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(xPoint+40);
        arco3.setY(yPoint-75);
        arco3.setControlX(xPoint+40);
        arco3.setControlY(yPoint-50);
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(xPoint+10);
        arco4.setY(yPoint-100);
        arco4.setControlX(xPoint+40);
        arco4.setControlY(yPoint-100);
        
        HLineTo htop = new HLineTo();
        htop.setX(xPoint);
        
        pathActual.setStrokeWidth(4);
        
        createCircle(start3.getX(), start3.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX()-5, arco4.getY()+marco);
        

        circle.setVisible(puntosVisibles);

        
        pathActual.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
        
        Group root = new Group(pathActual, circle);
        
        return root;
    }

    public Group numero4() {
        size=1.7;
        xPoint = (200+espacio);
        yPoint = (150+superior);
        
        MoveTo moveTo = new MoveTo(xPoint-15*size, yPoint-30*size);
        LineTo line1 = new LineTo(xPoint-15*size, yPoint);
        LineTo line2 = new LineTo(xPoint+15*size, yPoint);
        MoveTo moveTo2 = new MoveTo(xPoint+15*size, yPoint-30*size);
        LineTo line3 = new LineTo(xPoint+15*size, yPoint+30*size);
        
        pathActual.setStrokeWidth(4);

        pathActual.getElements().addAll(moveTo,line1, line2,moveTo2,line3);
        
        iniciateCircleMoveTo(moveTo);
        iniciateCircleLineTo(line1);
        iniciateCircleLineTo(line2);
        iniciateCircleMoveTo(moveTo2);
        iniciateCircleLineTo(line3);
        
        circle.setVisible(puntosVisibles);
        
        Group root = new Group(pathActual, circle);
        
        return root;

    }

    protected void configuraArco (Arc arc) {
        arc.setStroke(Color.BLACK);
        arc.setFill(null);
        arc.setStrokeWidth(4*sizeTotal);
    }
    
    public Path getPath(){
        return pathActual;
    }
    
}
