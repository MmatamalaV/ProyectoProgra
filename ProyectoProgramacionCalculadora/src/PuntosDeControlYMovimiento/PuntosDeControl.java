/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuntosDeControlYMovimiento;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

/**
 *
 * @author elias
 */
public class PuntosDeControl{
    protected Group circle=new Group(); //Grupo donde se almacenarán los Circle que se irán creando.
    protected double marco; 
    protected boolean puntosVisibles;
    
    
    protected void iniciateCircleLineTo(LineTo line) {
        createCircle(line.getX(), line.getY()+marco);
    }
    
    protected void iniciateCircleMoveTo(MoveTo move) {
        createCircle(move.getX(), move.getY()+marco);
    }
    
    //Método que crea los círculos y los añade al Group "circle".
    protected void createCircle(double centerX, double centerY) {
        Circle circulo = new Circle();
        circulo.setCenterX(centerX);
        circulo.setCenterY(centerY);
        circulo.setRadius(6);
        circulo.setCache(true);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(Color.WHITE);
        circulo.setStrokeWidth(2);
        circle.getChildren().add(circulo);
    }
    
    public void visibleCircle(Boolean visible) {
        circle.setVisible(visible);
    }
    
    //Método que remueve elementos duplicados de una lista.
    protected void remueveDuplicados(List list){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
    }
}
