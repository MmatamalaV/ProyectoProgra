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
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Resta {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Resta(double marco, double espacio, double superior) {
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
        
        double size=1.2;
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo startMinus = new MoveTo(xPoint, yPoint);
        LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
        LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);

        path.setStrokeWidth(4*size);
        
        path.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);

        //path.setStrokeWidth(4); //grisor de la linea


        //Adding all the elements to the path 
        //path.getElements().add(moveTo); 
        //path.getElements().addAll(line4,line1, line2, line3);        
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Minus = new Circle();
        c1Minus.setCenterX(startMinus.getX());
        c1Minus.setCenterY(startMinus.getY()+marco);
        c1Minus.setRadius(circleRadius);
        c1Minus.setCache(true);
        c1Minus.setStroke(Color.RED);
        c1Minus.setStrokeWidth(circleStrokeWidth);

        Circle c2Minus = new Circle();
        c2Minus.setCenterX(line1Minus.getX());
        c2Minus.setCenterY(line1Minus.getY()+marco);
        c2Minus.setRadius(circleRadius);
        c2Minus.setCache(true);
        c2Minus.setStroke(Color.RED);
        c2Minus.setStrokeWidth(circleStrokeWidth);

        Circle c3Minus = new Circle();
        c3Minus.setCenterX(line2Minus.getX());
        c3Minus.setCenterY(line2Minus.getY()+marco);
        c3Minus.setRadius(circleRadius);
        c3Minus.setCache(true);
        c3Minus.setStroke(Color.RED);
        c3Minus.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path);
        circle.getChildren().addAll(c1Minus, c2Minus, c3Minus);
        root.getChildren().addAll(circle);

        circle.setVisible(true);

        c1Minus.setOnMousePressed(pressMouse(c1Minus));
        c1Minus.setOnMouseDragged(dragMouseInicial(c1Minus, startMinus));
        c2Minus.setOnMousePressed(pressMouse(c2Minus));
        c2Minus.setOnMouseDragged(dragMouse(c2Minus, line1Minus));
        c3Minus.setOnMousePressed(pressMouse(c3Minus));
        c3Minus.setOnMouseDragged(dragMouse(c3Minus, line2Minus));
      
    
        return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}

