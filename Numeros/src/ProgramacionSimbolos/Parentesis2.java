/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionSimbolos;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Parentesis2 {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Parentesis2(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }
    
     EventHandler<MouseEvent> pressMouse(Circle c) {
     EventHandler<MouseEvent> mousePressHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // get the current mouse coordinates according to the scene.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();

                 // get the current coordinates of the draggable node.
                 m_nX = c.getLayoutX();
                 m_nY = c.getLayoutY();
             }
         }
     };
     return mousePressHandler;
    }

    //dragMouse y dragMouseInicial son lo mismo pero uno es para el moveto que es el punto inicial y el otro para el lineto que son el resto de puntos
    EventHandler<MouseEvent> dragMouseInicial(Circle c, MoveTo l) {
     EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // find the delta coordinates by subtracting the new mouse
                 // coordinates with the old.
                 double deltaX = event.getSceneX() - m_nMouseX;
                 double deltaY = event.getSceneY() - m_nMouseY;

                 // add the delta coordinates to the node coordinates.
                 m_nX += deltaX;
                 m_nY += deltaY;

                 // set the layout for the draggable node.
                 c.setLayoutX(m_nX);
                 c.setLayoutY(m_nY);
                 l.setX(event.getSceneX());
                 l.setY(event.getSceneY()-marco);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    EventHandler<MouseEvent> dragMouse(Circle c, LineTo l) {
     EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // find the delta coordinates by subtracting the new mouse
                 // coordinates with the old.
                 double deltaX = event.getSceneX() - m_nMouseX;
                 double deltaY = event.getSceneY() - m_nMouseY;

                 // add the delta coordinates to the node coordinates.
                 m_nX += deltaX;
                 m_nY += deltaY;

                 // set the layout for the draggable node.
                 c.setLayoutX(m_nX);
                 c.setLayoutY(m_nY);
                 l.setX(event.getSceneX());
                 l.setY(event.getSceneY()-marco);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    EventHandler<MouseEvent> dragMouseFinal(Circle c, LineTo l1, LineTo l2) {
     EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // find the delta coordinates by subtracting the new mouse
                 // coordinates with the old.
                 double deltaX = event.getSceneX() - m_nMouseX;
                 double deltaY = event.getSceneY() - m_nMouseY;

                 // add the delta coordinates to the node coordinates.
                 m_nX += deltaX;
                 m_nY += deltaY;

                 // set the layout for the draggable node.
                 c.setLayoutX(m_nX);
                 c.setLayoutY(m_nY);
                 l1.setX(event.getSceneX());
                 l1.setY(event.getSceneY()-marco);
                 l2.setX(event.getSceneX());
                 l2.setY(event.getSceneY()-marco);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    public Group start(Path path) {
        
        double size=1;
        double amountOfSymbolsParen2 = (double) (1.5*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (170+superior);

        Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
        Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);

        arc1Paren2.setStroke(Color.BLACK);
        arc1Paren2.setFill(null);

        arc2Paren2.setStroke(Color.BLACK);
        arc2Paren2.setFill(null);

        arc1Paren2.setStrokeWidth(4*size);
        arc2Paren2.setStrokeWidth(4*size);
        
       
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Paren2 = new Circle();
        c1Paren2.setCenterX(arc1Paren2.getCenterX());
        c1Paren2.setCenterY(arc1Paren2.getCenterY()-42*amountOfSymbolsParen2);
        c1Paren2.setRadius(circleRadius);
        c1Paren2.setCache(true);
        c1Paren2.setStroke(Color.RED);
        c1Paren2.setStrokeWidth(circleStrokeWidth);

        Circle c2Paren2 = new Circle();
        c2Paren2.setCenterX(arc2Paren2.getCenterX()+7.5*amountOfSymbolsParen2);
        c2Paren2.setCenterY(arc2Paren2.getCenterY());
        c2Paren2.setRadius(circleRadius);
        c2Paren2.setCache(true);
        c2Paren2.setStroke(Color.RED);
        c2Paren2.setStrokeWidth(circleStrokeWidth);

        Circle c3Paren2 = new Circle();
        c3Paren2.setCenterX(arc2Paren2.getCenterX());
        c3Paren2.setCenterY(arc2Paren2.getCenterY()+42*amountOfSymbolsParen2);
        c3Paren2.setRadius(circleRadius);
        c3Paren2.setCache(true);
        c3Paren2.setStroke(Color.RED);
        c3Paren2.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path, arc1Paren2, arc2Paren2);
        circle.getChildren().addAll(c1Paren2, c2Paren2, c3Paren2);
        root.getChildren().addAll(circle);

        circle.setVisible(true);

        //se toma la posicion del circulo al cl1ckearlo
        /*c1.setOnMousePressed(pressMouse(c1));
        //se ejecuta la accion de mover
        c1.setOnMouseDragged(dragMouseInicial(c1, moveTo));

        c2.setOnMousePressed(pressMouse(c2));
        c2.setOnMouseDragged(dragMouse(c2, line1));
        c3.setOnMousePressed(pressMouse(c3));
        c3.setOnMouseDragged(dragMouse(c3, line2));
        c4.setOnMousePressed(pressMouse(c4));
        c4.setOnMouseDragged(dragMouseFinal(c4, line3, line4));*/


        return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}
