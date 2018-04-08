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
 * @author mario optimized by elias
 */
public class Numero4 extends Lineas{

    
    private final double espacio;
    private final double superior;

    public Numero4(double marco, double espacio, double superior) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
    }

    public Group start(Path path) {
        double size=1.7;
        int xPoint = (int) (215+espacio);
        int yPoint = (int) (200+superior);
        
        MoveTo moveTo=new MoveTo(xPoint, yPoint);
        LineTo line1 = new LineTo(xPoint, yPoint-100);
        LineTo line2 = new LineTo(xPoint-50, yPoint-50);
        LineTo line3 = new LineTo(xPoint, yPoint-50);
        LineTo line4 = new LineTo(xPoint, yPoint-50);
        path.setStrokeWidth(4);

        path.getElements().add(moveTo); 
        path.getElements().addAll(line4,line1, line2, line3);
        
        createCircle(moveTo.getX(), moveTo.getY()+marco);
        createCircle(line1.getX(), line1.getY()+marco);
        createCircle(line2.getX(), line2.getY()+marco);
        createCircle(line3.getX(), line3.getY()+marco);
        
        controlDragMouseInicial(0, moveTo);
        controlDragMouse(1, line1);
        controlDragMouse(2, line2);
        controlDragMouseFinal(3, line3, line4);

        circle.setVisible(true);
        
        Group root = new Group(path, circle);

        return root;
    }
    
}
