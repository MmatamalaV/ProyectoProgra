/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionNumeros;

import PuntosDeControlYMovimiento.Lineas;
import javafx.scene.Group;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author elias
 */
public class Numero2 extends Lineas{
    
    
    private final double espacio;
    private final double superior;

    public Numero2(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
        this.puntosVisibles=puntosVisibles;
    }
    
    public Group start(Path path) {
        
        int xPoint = (int) (170+espacio);
        int yPoint = (int) (125+superior);
        
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
        
        path.setStrokeWidth(4);
        
        createCircle(start2.getX(), start2.getY()+marco);
        createCircle(primerArco.getX(), primerArco.getY()+marco);
        createCircle(segundoArco.getX(), segundoArco.getY()+marco);
        createCircle(diagonal.getX(), diagonal.getY()+marco);
        createCircle(base.getX(),yPoint+75+marco);

        circle.setVisible(puntosVisibles);

        
        path.getElements().addAll(start2,primerArco,segundoArco,diagonal,base);
        
        Group root = new Group(path, circle);
        
        return root;
    }
}
