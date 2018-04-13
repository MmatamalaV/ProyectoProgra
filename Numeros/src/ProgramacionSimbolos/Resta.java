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
public class Resta extends Lineas{
    private final double espacio;
    private final double superior;
    

    public Resta(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
        this.puntosVisibles=puntosVisibles;
    }

    public Group start(Path path) {
        
        double size=1.2;
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo startMinus = new MoveTo(xPoint, yPoint);
        LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
        LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);

        path.setStrokeWidth(4*size);
        
        path.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);

        createCircle(startMinus.getX(), startMinus.getY()+marco);
        createCircle(line1Minus.getX(), line1Minus.getY()+marco);
        createCircle(line2Minus.getX(), line2Minus.getY()+marco);

        controlDragMouseInicial(0, startMinus);
        controlDragMouse(1, line1Minus);
        controlDragMouse(2, line2Minus);
      
        Group root = new Group(path, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
}

