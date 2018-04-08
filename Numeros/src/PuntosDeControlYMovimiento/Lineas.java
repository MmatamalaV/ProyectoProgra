/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuntosDeControlYMovimiento;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

/**
 *
 * @author elias based in mario method
 */
public class Lineas extends PuntosDeControl{
    private double m_nX = 0;
    private double m_nY = 0;
    private double m_nMouseX = 0;
    private double m_nMouseY = 0;
    protected List lineas = new ArrayList();

    protected EventHandler<MouseEvent> pressMouse(Circle c) {
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
    protected EventHandler<MouseEvent> dragMouseInicial(Circle c, MoveTo l) {
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

    protected EventHandler<MouseEvent> dragMouse(Circle c, LineTo l) {
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

    protected EventHandler<MouseEvent> dragMouseFinal(Circle c, LineTo l1, LineTo l2) {
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
    
    /*protected void lineaMovible(Boolean dragMouseFinal){
        remueveDuplicados(lineas);
        int cantidadCirculos=circle.getChildren().size()-1;
        for (int x=0; x<=cantidadCirculos; x++) {
            if (x==0) {
                circle.getChildren().get(x).setOnMousePressed(pressMouse((Circle) circle.getChildren().get(x)));
                circle.getChildren().get(x).setOnMouseDragged(dragMouseInicial((Circle) circle.getChildren().get(x), (MoveTo) lineas.get(x)));
            }
            
            if (x>0 && x!=cantidadCirculos || x>0 && dragMouseFinal==false) {
                circle.getChildren().get(x).setOnMousePressed(pressMouse((Circle) circle.getChildren().get(x)));
                circle.getChildren().get(x).setOnMouseDragged(dragMouse((Circle) circle.getChildren().get(x), (LineTo) lineas.get(x)));
            
            }
            
            if (x==circle.getChildren().size() && dragMouseFinal==true) {
                circle.getChildren().get(x).setOnMousePressed(pressMouse((Circle) circle.getChildren().get(x)));
                circle.getChildren().get(x).setOnMouseDragged(dragMouseFinal((Circle) circle.getChildren().get(x), (LineTo) lineas.get(x-1), (LineTo) lineas.get(x)));
            }

        }
        lineas.clear();
    }*/
    
    protected void controlDragMouseInicial (int x, MoveTo moveTo) {
        ((Circle) circle.getChildren().get(x)).setOnMousePressed(pressMouse((Circle) circle.getChildren().get(x)));
        ((Circle) circle.getChildren().get(x)).setOnMouseDragged(dragMouseInicial(((Circle) circle.getChildren().get(x)), moveTo));
    }
    
    protected void controlDragMouse(int x, LineTo lineTo) {
        ((Circle) circle.getChildren().get(x)).setOnMousePressed(pressMouse(((Circle) circle.getChildren().get(x))));
        ((Circle) circle.getChildren().get(x)).setOnMouseDragged(dragMouse(((Circle) circle.getChildren().get(x)), lineTo));
    }
    
    protected void controlDragMouseFinal (int x, LineTo lineTo1, LineTo lineTo2) {
        ((Circle) circle.getChildren().get(x)).setOnMousePressed(pressMouse(((Circle) circle.getChildren().get(x))));
        ((Circle) circle.getChildren().get(x)).setOnMouseDragged(dragMouseFinal(((Circle) circle.getChildren().get(x)), lineTo1, lineTo2));
    }
    
    
}
