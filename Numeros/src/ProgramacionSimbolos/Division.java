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
public class Division extends Lineas{
    private final double espacio;
    private final double superior;
    

    public Division(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }

    public Group start(Path path) {
        
        double size=1.2;
        double amountOfSymbolsDivide = 1*size; //Variable para cantidad de números que irán en la división
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo startDivide = new MoveTo(xPoint, yPoint);
        LineTo line1Divide = new LineTo(xPoint-33*amountOfSymbolsDivide, yPoint);
        LineTo line2Divide = new LineTo(xPoint+33*amountOfSymbolsDivide, yPoint);

        path.setStrokeWidth(4*size);
    
        path.getElements().addAll(startDivide, line1Divide, startDivide, line2Divide);
        
        createCircle(startDivide.getX(), startDivide.getY()+marco);
        createCircle(line1Divide.getX(), line1Divide.getY()+marco);
        createCircle(line2Divide.getX(), line2Divide.getY()+marco);
        
        controlDragMouseInicial(0, startDivide);
        controlDragMouse(1, line1Divide);
        controlDragMouse(2, line2Divide);
        
        Group root = new Group(path, circle);
        
        circle.setVisible(true);
        
        return root;
    }
    
}
