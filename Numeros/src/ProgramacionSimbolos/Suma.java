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
public class Suma {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Suma(double marco, double espacio, double superior) {
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

        MoveTo startPlus = new MoveTo(xPoint, yPoint);
        LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
        LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
        LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
        LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

        path.setStrokeWidth(4*size);

        path.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);

        //path.setStrokeWidth(4); //grisor de la linea


        //Adding all the elements to the path 
        //path.getElements().add(moveTo); 
        //path.getElements().addAll(line4,line1, line2, line3);        
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Plus = new Circle();
        c1Plus.setCenterX(startPlus.getX());
        c1Plus.setCenterY(startPlus.getY()+marco);
        c1Plus.setRadius(circleRadius);
        c1Plus.setCache(true);
        c1Plus.setStroke(Color.RED);
        c1Plus.setStrokeWidth(circleStrokeWidth);

        Circle c2Plus = new Circle();
        c2Plus.setCenterX(line1Plus.getX());
        c2Plus.setCenterY(line1Plus.getY()+marco);
        c2Plus.setRadius(circleRadius);
        c2Plus.setCache(true);
        c2Plus.setStroke(Color.RED);
        c2Plus.setStrokeWidth(circleStrokeWidth);

        Circle c3Plus = new Circle();
        c3Plus.setCenterX(line2Plus.getX());
        c3Plus.setCenterY(line2Plus.getY()+marco);
        c3Plus.setRadius(circleRadius);
        c3Plus.setCache(true);
        c3Plus.setStroke(Color.RED);
        c3Plus.setStrokeWidth(circleStrokeWidth);

        Circle c4Plus = new Circle();
        c4Plus.setCenterX(line3Plus.getX());
        c4Plus.setCenterY(line3Plus.getY()+marco);
        c4Plus.setRadius(circleRadius);
        c4Plus.setCache(true);
        c4Plus.setStroke(Color.RED);
        c4Plus.setStrokeWidth(circleStrokeWidth);

        Circle c5Plus = new Circle();
        c5Plus.setCenterX(line4Plus.getX());
        c5Plus.setCenterY(line4Plus.getY()+marco);
        c5Plus.setRadius(circleRadius);
        c5Plus.setCache(true);
        c5Plus.setStroke(Color.RED);
        c5Plus.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path);
        circle.getChildren().addAll(c1Plus, c2Plus, c3Plus, c4Plus, c5Plus);
        root.getChildren().addAll(circle);

        circle.setVisible(true);

        c1Plus.setOnMousePressed(pressMouse(c1Plus));
        c1Plus.setOnMouseDragged(dragMouseInicial(c1Plus, startPlus));
        c2Plus.setOnMousePressed(pressMouse(c2Plus));
        c2Plus.setOnMouseDragged(dragMouse(c2Plus, line1Plus));
        c3Plus.setOnMousePressed(pressMouse(c3Plus));
        c3Plus.setOnMouseDragged(dragMouse(c3Plus, line2Plus));
        c4Plus.setOnMousePressed(pressMouse(c4Plus));
        c4Plus.setOnMouseDragged(dragMouse(c4Plus, line3Plus));
        c5Plus.setOnMousePressed(pressMouse(c5Plus));
        c5Plus.setOnMouseDragged(dragMouse(c5Plus, line4Plus));
      
    
        return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}
