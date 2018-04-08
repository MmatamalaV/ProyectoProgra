/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinUsoAlpha1;

import ProgramacionSimbolos.*;
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
public class Multiplicacion {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Multiplicacion(double marco, double espacio, double superior) {
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

        MoveTo centroMulti = new MoveTo(xPoint, yPoint);
        LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
        LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
        LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
        LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
        LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
        LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
        LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
        LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);

        path.setStrokeWidth(4*size);

        path.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);

        //path.setStrokeWidth(4); //grisor de la linea


        //Adding all the elements to the path 
        //path.getElements().add(moveTo); 
        //path.getElements().addAll(line4,line1, line2, line3);        
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Multi = new Circle();
        c1Multi.setCenterX(centroMulti.getX());
        c1Multi.setCenterY(centroMulti.getY()+marco);
        c1Multi.setRadius(circleRadius);
        c1Multi.setCache(true);
        c1Multi.setStroke(Color.RED);
        c1Multi.setStrokeWidth(circleStrokeWidth);

        Circle c2Multi = new Circle();
        c2Multi.setCenterX(line1Multi.getX());
        c2Multi.setCenterY(line1Multi.getY()+marco);
        c2Multi.setRadius(circleRadius);
        c2Multi.setStroke(Color.RED);
        c2Multi.setStrokeWidth(circleStrokeWidth);

        Circle c3Multi = new Circle();
        c3Multi.setCenterX(line2Multi.getX());
        c3Multi.setCenterY(line2Multi.getY()+marco);
        c3Multi.setRadius(circleRadius);
        c3Multi.setCache(true);
        c3Multi.setStroke(Color.RED);
        c3Multi.setStrokeWidth(circleStrokeWidth);

        Circle c4Multi = new Circle();
        c4Multi.setCenterX(line3Multi.getX());
        c4Multi.setCenterY(line3Multi.getY()+marco);
        c4Multi.setRadius(circleRadius);
        c4Multi.setStroke(Color.RED);
        c4Multi.setStrokeWidth(circleStrokeWidth);

        Circle c5Multi = new Circle();
        c5Multi.setCenterX(line4Multi.getX());
        c5Multi.setCenterY(line4Multi.getY()+marco);
        c5Multi.setRadius(circleRadius);
        c5Multi.setCache(true);
        c5Multi.setStroke(Color.RED);
        c5Multi.setStrokeWidth(circleStrokeWidth);

        Circle c6Multi = new Circle();
        c6Multi.setCenterX(line5Multi.getX());
        c6Multi.setCenterY(line5Multi.getY()+marco);
        c6Multi.setRadius(circleRadius);
        c6Multi.setStroke(Color.RED);
        c6Multi.setStrokeWidth(circleStrokeWidth);

        Circle c7Multi = new Circle();
        c7Multi.setCenterX(line6Multi.getX());
        c7Multi.setCenterY(line6Multi.getY()+marco);
        c7Multi.setRadius(circleRadius);
        c7Multi.setCache(true);
        c7Multi.setStroke(Color.RED);
        c7Multi.setStrokeWidth(circleStrokeWidth);

        Circle c8Multi = new Circle();
        c8Multi.setCenterX(line7Multi.getX());
        c8Multi.setCenterY(line7Multi.getY()+marco);
        c8Multi.setRadius(circleRadius);
        c8Multi.setStroke(Color.RED);
        c8Multi.setStrokeWidth(circleStrokeWidth);

        Circle c9Multi = new Circle();
        c9Multi.setCenterX(line8Multi.getX());
        c9Multi.setCenterY(line8Multi.getY()+marco);
        c9Multi.setRadius(circleRadius);
        c9Multi.setStroke(Color.RED);
        c9Multi.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path);
        circle.getChildren().addAll(c1Multi, c2Multi, c3Multi, c4Multi, c5Multi, c6Multi, c7Multi, c8Multi, c9Multi);
        root.getChildren().addAll(circle);

        circle.setVisible(true);

        c1Multi.setOnMousePressed(pressMouse(c1Multi));
        c1Multi.setOnMouseDragged(dragMouseInicial(c1Multi, centroMulti));
        c2Multi.setOnMousePressed(pressMouse(c2Multi));
        c2Multi.setOnMouseDragged(dragMouse(c2Multi, line1Multi));
        c3Multi.setOnMousePressed(pressMouse(c3Multi));
        c3Multi.setOnMouseDragged(dragMouse(c3Multi, line2Multi));
        c4Multi.setOnMousePressed(pressMouse(c4Multi));
        c4Multi.setOnMouseDragged(dragMouse(c4Multi, line3Multi));
        c5Multi.setOnMousePressed(pressMouse(c5Multi));
        c5Multi.setOnMouseDragged(dragMouse(c5Multi, line4Multi));
        c6Multi.setOnMousePressed(pressMouse(c6Multi));
        c6Multi.setOnMouseDragged(dragMouse(c6Multi, line5Multi));
        c7Multi.setOnMousePressed(pressMouse(c7Multi));
        c7Multi.setOnMouseDragged(dragMouse(c7Multi, line6Multi));
        c8Multi.setOnMousePressed(pressMouse(c8Multi));
        c8Multi.setOnMouseDragged(dragMouse(c8Multi, line7Multi));
        c9Multi.setOnMousePressed(pressMouse(c9Multi));
        c9Multi.setOnMouseDragged(dragMouse(c9Multi, line8Multi));
      
    
        return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}
