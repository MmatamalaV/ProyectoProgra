/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionNumeros;

import PuntosDeControlYMovimiento.Arcos;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Numero0 extends Arcos{
    
    private final double espacio;
    private final double superior;

    public Numero0(double marco, double espacio, double superior) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
    }

    public Group start(Path path) {
        
        double size=1.28;
        double xPoint = (double) (200+espacio);
        double yPoint = (double) (177+superior);

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
        
        circle.setVisible(true);
        
        Group root = new Group(path, arcZero, arc1Zero, arc2Zero, arc3Zero, circle);

        return root;
    }
    
}
