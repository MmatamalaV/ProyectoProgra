/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionSimbolos;

import PuntosDeControlYMovimiento.Lineas;
import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Multiplicacion extends Lineas{
    private final double espacio;
    private final double superior;
    

    public Multiplicacion(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }
    
    public Group start(Path path) {
        
        double size=1.2;
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo centroMulti = new MoveTo(xPoint, yPoint);
        LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
        LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
        LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
        LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
        LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
        LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
        LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
        LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);

        path.setStrokeWidth(4*size);

        path.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);
        
        createCircle(centroMulti.getX(), centroMulti.getY()+marco);
        createCircle(line1Multi.getX(), line1Multi.getY()+marco);
        createCircle(line2Multi.getX(), line2Multi.getY()+marco);
        createCircle(line3Multi.getX(), line3Multi.getY()+marco);
        createCircle(line4Multi.getX(), line4Multi.getY()+marco);
        createCircle(line5Multi.getX(), line5Multi.getY()+marco);
        createCircle(line6Multi.getX(), line6Multi.getY()+marco);
        createCircle(line7Multi.getX(), line7Multi.getY()+marco);
        createCircle(line8Multi.getX(), line8Multi.getY()+marco);

        controlDragMouseInicial(0, centroMulti);
        controlDragMouse(1, line1Multi);
        controlDragMouse(2, line2Multi);
        controlDragMouse(3, line3Multi);
        controlDragMouse(4, line4Multi);
        controlDragMouse(5, line5Multi);
        controlDragMouse(6, line6Multi);
        controlDragMouse(7, line7Multi);
        controlDragMouse(8, line8Multi);
      
        Group root = new Group(path, circle);

        circle.setVisible(true);
        
        return root;
    }
    
}
