/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinUsoAlpha1;

import ProgramacionNumeros.*;
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
public class Numero0V2 {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Numero0V2(double marco, double espacio, double superior) {
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
        int yPoint = (int) (170+superior);

        Arc arcZero = new Arc(xPoint, yPoint,25*size,40*size,90,90);
        Arc arc1Zero = new Arc(xPoint, yPoint,25*size,40*size,180,90);
        Arc arc2Zero = new Arc(xPoint, yPoint,25*size,40*size,270,90);
        Arc arc3Zero = new Arc(xPoint, yPoint,25*size,40*size,360,90);
        
        

        arcZero.setStroke(Color.BLACK);
        arcZero.setFill(null);

        arc1Zero.setStroke(Color.BLACK);
        arc1Zero.setFill(null);

        arc2Zero.setStroke(Color.BLACK);
        arc2Zero.setFill(null);

        arc3Zero.setStroke(Color.BLACK);
        arc3Zero.setFill(null);

        arcZero.setStrokeWidth(4);
        arc1Zero.setStrokeWidth(4);
        arc2Zero.setStrokeWidth(4);
        arc3Zero.setStrokeWidth(4);
        
       
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Zero = new Circle();
        c1Zero.setCenterX(arcZero.getCenterX());
        c1Zero.setCenterY(arcZero.getCenterY()-40*size);
        c1Zero.setRadius(circleRadius);
        c1Zero.setCache(true);
        c1Zero.setStroke(Color.RED);
        c1Zero.setStrokeWidth(circleStrokeWidth);

        Circle c2Zero = new Circle();
        c2Zero.setCenterX(arc1Zero.getCenterX()+25*size);
        c2Zero.setCenterY(arc1Zero.getCenterY());
        c2Zero.setRadius(circleRadius);
        c2Zero.setCache(true);
        c2Zero.setStroke(Color.RED);
        c2Zero.setStrokeWidth(circleStrokeWidth);

        Circle c3Zero = new Circle();
        c3Zero.setCenterX(arc2Zero.getCenterX());
        c3Zero.setCenterY(arc2Zero.getCenterY()+40*size);
        c3Zero.setRadius(circleRadius);
        c3Zero.setStroke(Color.RED);
        c3Zero.setStrokeWidth(circleStrokeWidth);

        Circle c4Zero = new Circle();
        c4Zero.setCenterX(arc3Zero.getCenterX()-25*size);
        c4Zero.setCenterY(arc3Zero.getCenterY());
        c4Zero.setRadius(circleRadius);
        c4Zero.setStroke(Color.RED);
        c4Zero.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path, arcZero, arc1Zero, arc2Zero, arc3Zero);
        circle.getChildren().addAll(c1Zero,c2Zero,c3Zero,c4Zero);
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
