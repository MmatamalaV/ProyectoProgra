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
public class Parentesis2 extends Arcos{
    private final double espacio;
    private final double superior;
    

    public Parentesis2(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
        this.puntosVisibles=puntosVisibles;
    }

    public Group start(Path path) {
        
        double size=1.2;
        double amountOfSymbolsParen2 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (170+superior);

        Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
        Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);

        configuraArco(arc1Paren2);
        configuraArco(arc2Paren2);
        
        createCircle(arc1Paren2.getCenterX(), arc1Paren2.getCenterY()-42*amountOfSymbolsParen2);
        createCircle(arc2Paren2.getCenterX()+7.5*amountOfSymbolsParen2, arc2Paren2.getCenterY());
        createCircle(arc2Paren2.getCenterX(), arc2Paren2.getCenterY()+42*amountOfSymbolsParen2);

        Group root = new Group(path, arc1Paren2, arc2Paren2, circle);

        circle.setVisible(puntosVisibles);
        
        return root;
    }
    
}