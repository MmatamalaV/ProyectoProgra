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
public class Numero3 extends Lineas{
    
    
    private final double espacio;
    private final double superior;

    public Numero3(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
        this.puntosVisibles=puntosVisibles;
    }
    
    public Group start(Path path) {
        
        int xPoint = (int) (170+espacio);
        int yPoint = (int) (200+superior);
        
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
        
        path.setStrokeWidth(4);
        
        createCircle(start3.getX(), start3.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX()-5, arco4.getY()+marco);
        

        circle.setVisible(puntosVisibles);

        
        path.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
        
        Group root = new Group(path, circle);
        
        return root;
    }
}
