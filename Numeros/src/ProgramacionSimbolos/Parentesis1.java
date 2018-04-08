/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionSimbolos;

import PuntosDeControlYMovimiento.Arcos;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Parentesis1 extends Arcos{
    private final double espacio;
    private final double superior;
    

    public Parentesis1(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }

    public Group start(Path path) {
        
        double size=1.2;
        double amountOfSymbolsParen1 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (170+superior);

        Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
        Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);

        configuraArco(arc1Paren1);
        configuraArco(arc2Paren1);
        
        createCircle(arc1Paren1.getCenterX(), arc1Paren1.getCenterY()-42*amountOfSymbolsParen1);
        createCircle(arc2Paren1.getCenterX()-7.5*amountOfSymbolsParen1, arc2Paren1.getCenterY());
        createCircle(arc2Paren1.getCenterX(), arc2Paren1.getCenterY()+42*amountOfSymbolsParen1);

        Group root = new Group(path, arc1Paren1, arc2Paren1, circle);

        circle.setVisible(true);
        
        return root;
    }
    
}
