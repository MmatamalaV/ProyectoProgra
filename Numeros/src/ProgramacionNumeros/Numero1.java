/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionNumeros;

import PuntosDeControlYMovimiento.Lineas;
import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author mario
 */
public class Numero1 extends Lineas{
    private final double espacio;
    private final double superior;
    
    public Numero1(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }
    
    public Group start(Path path){
        
        int xPoint = (int) (215+espacio);
        int yPoint = (int) (200+superior);
        
        MoveTo p1=new MoveTo(xPoint,yPoint);
        LineTo p2= new LineTo(xPoint,yPoint-100);
        LineTo p3= new LineTo(xPoint-50,yPoint-50);
        
        path.setStrokeWidth(4);
        
        path.getElements().addAll(p1,p2,p3);
        
        createCircle(p1.getX(),p1.getY()+marco);
        createCircle(p2.getX(),p2.getY()+marco);
        createCircle(p3.getX(),p3.getY()+marco);
    
        controlDragMouseInicial(0, p1);
        controlDragMouse(1, p2);
        controlDragMouse(2, p3);
        
        Group root= new Group(path,circle);
        return root;
        
    }
}
