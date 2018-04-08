/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinUsoAlpha1;
import PuntosDeControlYMovimiento.Lineas;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author mario optimized by elias
 */
public class Numero4IntentoFallido1 extends Lineas{

    
    private final double espacio;
    private final double superior;

    public Numero4IntentoFallido1(double marco, double espacio, double superior) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
    }

    public Group start(Path path) {
        double size=1.7;
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);
        
        MoveTo moveTo = new MoveTo(xPoint-15*size, yPoint-30*size);
        LineTo line1 = new LineTo(xPoint-15*size, yPoint);
        LineTo line2 = new LineTo(xPoint+15*size, yPoint);
        MoveTo moveTo2 = new MoveTo(xPoint+15*size, yPoint-30*size);
        LineTo line3 = new LineTo(xPoint+15*size, yPoint+30*size);
        
        path.setStrokeWidth(4);

        path.getElements().addAll(moveTo,line1, line2,moveTo2,line3);
        
        System.out.println(lineas);

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();
        Circle c4 = new Circle();
        Circle c5 = new Circle();
        
        /*createCircle(c1, moveTo.getX(), moveTo.getY()+marco);
        createCircle(c2, line1.getX(), line1.getY()+marco);
        createCircle(c3, line2.getX(), line2.getY()+marco);
        createCircle(c4, moveTo2.getX(), moveTo2.getY()+marco);
        createCircle(c5, line3.getX(), line3.getY()+marco);
        
        controlDragMouseInicial(c1, moveTo);
        controlDragMouse(c2, line1);
        controlDragMouse(c3, line2);
        controlDragMouseFinal(c5, line3, line2);*/

        //controlDragMouse(c5, line5);

        circle.setVisible(true);
        
        Group root = new Group(path, circle);
        

        return root;
    }
    
}
