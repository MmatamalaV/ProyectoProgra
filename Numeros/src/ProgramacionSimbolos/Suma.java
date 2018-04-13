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
public class Suma extends Lineas {
    private final double espacio;
    private final double superior;

    public Suma(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
        this.puntosVisibles=puntosVisibles;
    }

    public Group start(Path path) {
        
        double size=1.2;
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo startPlus = new MoveTo(xPoint, yPoint);
        LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
        LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
        LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
        LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

        path.setStrokeWidth(4*size);

        path.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);
       
        createCircle(startPlus.getX(), startPlus.getY()+marco);
        createCircle(line1Plus.getX(), line1Plus.getY()+marco);
        createCircle(line2Plus.getX(), line2Plus.getY()+marco);
        createCircle(line3Plus.getX(), line3Plus.getY()+marco);
        createCircle(line4Plus.getX(), line4Plus.getY()+marco);

        controlDragMouseInicial(0, startPlus);
        controlDragMouse(1, line1Plus);
        controlDragMouse(2, line2Plus);
        controlDragMouse(3, line3Plus);
        controlDragMouse(4, line4Plus);

        Group root = new Group(path, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
}
