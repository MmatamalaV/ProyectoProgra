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
import javafx.scene.shape.VLineTo;

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
    private char ID;
    

    public NumerosYSimbolos(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
        this.puntosVisibles=puntosVisibles;
    }
    
    
    
    public Group multiplicacion() {
        ID = '*';
        //Se define el tamaño de la figura..
        size=1.2;
        //Se define el centro de la figura.
        xPoint = (200+espacio);
        yPoint = (150+superior);
        
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
        ID = '/';
        size=1.2;
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
        ID = '(';
        size=1.2;
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
        ID = ')';
        size=1.2;
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
        ID = '-';
        size=1.2;
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
        ID = '+';
        size = 1.2;
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
        ID = '0';
        size=1.28;
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
        ID = '1';
        xPoint = (215+espacio);
        yPoint = (200+superior);
        
        MoveTo p1=new MoveTo(xPoint,yPoint);
        LineTo p2= new LineTo(xPoint,yPoint-100);
        LineTo p3= new LineTo(xPoint-50,yPoint-50);
        
        pathActual.setStrokeWidth(4);
        
        pathActual.getElements().addAll(p1,p2,p3);
        
        createCircle(p1.getX(),p1.getY()+marco);
        createCircle(p2.getX(),p2.getY()+marco);
        createCircle(p3.getX(),p3.getY()+marco);
        
        circle.setVisible(puntosVisibles);
        
        Group root = new Group(pathActual, circle);
        return root;
        
    }
    
    public Group numero2() {
        ID = '2';
        xPoint = (180+espacio);
        yPoint = (125+superior);
        int x = 0;
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
        ID = '3';
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
        createCircle(arco4.getX()-7, arco4.getY()+marco);
        

        circle.setVisible(puntosVisibles);

        
        pathActual.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
        
        Group root = new Group(pathActual, circle);
        
        return root;
    }

    public Group numero4() {
        ID = '4';
        size=1.7;
        xPoint = (195+espacio);
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
    
    public Group numero5(){
        ID = '5';
        xPoint = (208+espacio);
        yPoint = (200+superior);
        
        MoveTo start5 = new MoveTo();
        start5.setX(xPoint-20);
        start5.setY(yPoint);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(xPoint-20);
        arco1.setY(yPoint);
        arco1.setControlX(xPoint-30);
        arco1.setControlY(yPoint);
        
        HLineTo base = new HLineTo();
        base.setX(xPoint);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(xPoint+20);
        arco2.setY(yPoint-30);
        arco2.setControlX(xPoint+20);
        arco2.setControlY(yPoint);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(xPoint);
        arco3.setY(yPoint-60);
        arco3.setControlX(xPoint+20);
        arco3.setControlY(yPoint-60);

        HLineTo hmid = new HLineTo();
        hmid.setX(xPoint-30);
        
        VLineTo vline = new VLineTo();
        vline.setY(yPoint-100);
        
        HLineTo htop = new HLineTo();
        htop.setX(xPoint+20);
        
        pathActual.setStrokeWidth(4);
        
        pathActual.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);
        
        createCircle(start5.getX(), start5.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(base.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(hmid.getX(), vline.getY()+marco);
        createCircle(htop.getX(), vline.getY()+marco);
        createCircle(hmid.getX(), arco3.getY()+marco);
                
        circle.setVisible(puntosVisibles);

        Group root = new Group(pathActual, circle);
        
        return root;
        
    }
    
    public Group numero6(){
        ID = '6';
        xPoint = (208+espacio);
        yPoint = (200+superior);
        
        MoveTo start6 = new MoveTo();
        start6.setX(xPoint-30);
        start6.setY(yPoint-25);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(xPoint-5);
        arco1.setY(yPoint);
        arco1.setControlX(xPoint-30);
        arco1.setControlY(yPoint);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(xPoint+20);
        arco2.setY(yPoint-25);
        arco2.setControlX(xPoint+20);
        arco2.setControlY(yPoint);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(xPoint-5);
        arco3.setY(yPoint-50);
        arco3.setControlX(xPoint+20);
        arco3.setControlY(yPoint-50);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(xPoint-30);
        arco4.setY(yPoint-25);
        arco4.setControlX(xPoint-30);
        arco4.setControlY(yPoint-50);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX(xPoint);
        arco5.setY(yPoint-100);
        arco5.setControlX(xPoint-25);
        arco5.setControlY(yPoint-90);
        
        pathActual.getElements().addAll(start6,arco1,arco2,arco3,arco4,arco5);
        
        pathActual.setStrokeWidth(4);
        
        createCircle(start6.getX(), start6.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(), arco4.getY()+marco);
        createCircle(arco5.getX(), arco5.getY()+marco);
        

        
        circle.setVisible(puntosVisibles);
        
        Group root = new Group(pathActual, circle);
        
        
        return root;
        
    }
    
    public Group numero7(){
        ID = '7';
        xPoint = (210+espacio);
        yPoint = (200+superior);
        MoveTo start7 = new MoveTo();
        start7.setX(xPoint-50);
        start7.setY(yPoint);
        
        LineTo diagonal1 = new LineTo();
        diagonal1.setX(xPoint-25);
        diagonal1.setY(yPoint-50);
        
        HLineTo hMidLine1 = new HLineTo();
        hMidLine1.setX(xPoint);
        
        HLineTo hMidLine2 = new HLineTo();
        hMidLine2.setX(xPoint-50);
        
        HLineTo hMidLine3 = new HLineTo();
        hMidLine3.setX(xPoint-25);
        
        LineTo diagonal2 = new LineTo();
        diagonal2.setX(xPoint);
        diagonal2.setY(yPoint-100);
        
        HLineTo lineaTop = new HLineTo();
        lineaTop.setX(xPoint-50);
        
        pathActual.setStrokeWidth(4);
        
        iniciateCircleMoveTo(start7);
        iniciateCircleLineTo(diagonal1);
        iniciateCircleLineTo(diagonal2);
        createCircle(hMidLine1.getX(), diagonal1.getY()+marco);
        createCircle(hMidLine2.getX(), diagonal1.getY()+marco);
        createCircle(hMidLine2.getX(), diagonal2.getY()+marco);
        
        circle.setVisible(puntosVisibles);
        
        pathActual.getElements().addAll(start7, diagonal1, hMidLine1, hMidLine2, hMidLine3, diagonal2, lineaTop);
        
        Group root = new Group(pathActual, circle);
        
        return root;
        
    }
    
    public Group numero8(){
        ID = '8';
        xPoint = (208+espacio);
        yPoint = (200+superior);
        
        MoveTo start8 = new MoveTo();
        start8.setX(xPoint-50);
        start8.setY(yPoint-25);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(xPoint-30);
        arco1.setY(yPoint);
        arco1.setControlX(xPoint-50);
        arco1.setControlY(yPoint);
        
        LineTo base = new LineTo();
        base.setX(xPoint-30);
        base.setY(yPoint);

        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(xPoint);
        arco2.setY(yPoint-25);
        arco2.setControlX(xPoint);
        arco2.setControlY(yPoint);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(xPoint-20);
        arco3.setY(yPoint-50);
        arco3.setControlX(xPoint);
        arco3.setControlY(yPoint-50);
        
        LineTo mid1 = new LineTo();
        mid1.setX(xPoint-30);
        mid1.setY(yPoint-50);

        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(xPoint-50);
        arco4.setY(yPoint-75);
        arco4.setControlX(xPoint-50);
        arco4.setControlY(yPoint-50);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX(xPoint-30);
        arco5.setY(yPoint-100);
        arco5.setControlX(xPoint-50);
        arco5.setControlY(yPoint-100);
        
        LineTo htop = new LineTo();
        htop.setX(xPoint-20);
        htop.setY(yPoint-100);
        
        QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setX(xPoint);
        arco6.setY(yPoint-75);
        arco6.setControlX(xPoint);
        arco6.setControlY(yPoint-100);
        
        QuadCurveTo arco7 = new QuadCurveTo();
        arco7.setX(xPoint-20);
        arco7.setY(yPoint-50);
        arco7.setControlX(xPoint);
        arco7.setControlY(yPoint-50);
        
        LineTo mid2 = new LineTo();
        mid2.setX(xPoint-30);
        mid2.setY(yPoint-50);

        QuadCurveTo arco8 = new QuadCurveTo();
        arco8.setX(xPoint-50);
        arco8.setY(yPoint-25);
        arco8.setControlX(xPoint-50);
        arco8.setControlY(yPoint-50);
        
        pathActual.setStrokeWidth(4);
        
        //iniciateCircleMoveTo(start8);
        //iniciateCircleLineTo(base);
        //iniciateCircleLineTo(htop);
        createCircle(mid2.getX()+5, mid2.getY()+marco);
        createCircle(arco1.getX()+5, arco1.getY()+marco);
        //createCircle(arco3.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        //createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(), arco4.getY()+marco);
        createCircle(arco5.getX()+5, arco5.getY()+marco);
        createCircle(arco6.getX(), arco6.getY()+marco);
        //createCircle(arco7.getX(), arco7.getY()+marco);
        createCircle(arco8.getX(), arco8.getY()+marco);
        
        
        
 
        circle.setVisible(puntosVisibles);
        
        pathActual.getElements().addAll(start8,arco1,base,arco2,arco3,mid1,arco4,arco5,htop,arco6,arco7,mid2,arco8);
        
        Group root = new Group(pathActual, circle);
        
        return root;
        
        
    }
    
    public Group numero9(){
        ID = '9';
        xPoint = (208+espacio);
        yPoint = (200+superior);
        
        MoveTo start9 = new MoveTo();
        start9.setX(xPoint-50);
        start9.setY(yPoint-75);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(xPoint-25);
        arco1.setY(yPoint-50);
        arco1.setControlX(xPoint-50);
        arco1.setControlY(yPoint-50);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(xPoint);
        arco2.setY(yPoint-75);
        arco2.setControlX(xPoint);
        arco2.setControlY(yPoint-50);
        
        VLineTo lineaV = new VLineTo();
        lineaV.setY(yPoint);
        
        VLineTo lineaV2 = new VLineTo();
        lineaV2.setY(yPoint-75);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(xPoint-25);
        arco3.setY(yPoint-100);
        arco3.setControlX(xPoint);
        arco3.setControlY(yPoint-100);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(xPoint-50);
        arco4.setY(yPoint-75);
        arco4.setControlX(xPoint-50);
        arco4.setControlY(yPoint-100);
        
        pathActual.setStrokeWidth(4);
        
        iniciateCircleMoveTo(start9);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(), arco4.getY()+marco);
        createCircle(arco2.getX(), lineaV.getY());
 
        circle.setVisible(puntosVisibles);

        pathActual.getElements().addAll(start9, arco1, arco2, lineaV, lineaV2, arco3, arco4);
        
        Group root = new Group(pathActual, circle);
        
        return root;
        
    }

    protected void configuraArco (Arc arc) {
        arc.setStroke(Color.BLACK);
        arc.setFill(null);
        arc.setStrokeWidth(4);
    }
    
    public Path getPath(){
        return pathActual;
    }
    
}
