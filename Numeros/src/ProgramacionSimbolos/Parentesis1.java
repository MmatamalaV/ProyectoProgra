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
public class Parentesis1 {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Parentesis1(double marco, double espacio, double superior) {
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
        double amountOfSymbolsParen1 = (double) (1.5*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (170+superior);

        Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
        Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);

        arc1Paren1.setStroke(Color.BLACK);
        arc1Paren1.setFill(null);

        arc2Paren1.setStroke(Color.BLACK);
        arc2Paren1.setFill(null);

        arc1Paren1.setStrokeWidth(4*size);
        arc2Paren1.setStrokeWidth(4*size);
        
       
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Paren1 = new Circle();
        c1Paren1.setCenterX(arc1Paren1.getCenterX());
        c1Paren1.setCenterY(arc1Paren1.getCenterY()-42*amountOfSymbolsParen1);
        c1Paren1.setRadius(circleRadius);
        c1Paren1.setCache(true);
        c1Paren1.setStroke(Color.RED);
        c1Paren1.setStrokeWidth(circleStrokeWidth);

        Circle c2Paren1 = new Circle();
        c2Paren1.setCenterX(arc2Paren1.getCenterX()-7.5*amountOfSymbolsParen1);
        c2Paren1.setCenterY(arc2Paren1.getCenterY());
        c2Paren1.setRadius(circleRadius);
        c2Paren1.setCache(true);
        c2Paren1.setStroke(Color.RED);
        c2Paren1.setStrokeWidth(circleStrokeWidth);

        Circle c3Paren1 = new Circle();
        c3Paren1.setCenterX(arc2Paren1.getCenterX());
        c3Paren1.setCenterY(arc2Paren1.getCenterY()+42*amountOfSymbolsParen1);
        c3Paren1.setRadius(circleRadius);
        c3Paren1.setCache(true);
        c3Paren1.setStroke(Color.RED);
        c3Paren1.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path, arc1Paren1, arc2Paren1);
        circle.getChildren().addAll(c1Paren1, c2Paren1, c3Paren1);
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
