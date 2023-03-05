/*
 * Id   : 65-060216-1002-9
 * Name : Pawee Indulakshana
 * Room : IT-1RA
 * File Name : Ball.java
 */

import java.awt.*;
import javax.swing.JFrame;

public class Ball extends JFrame{
    private int x = 100;
    private int y = 100;
    private int diameter = 20;
    private Color color = Color.BLACK;
    private int direction = 0;
    private int speed = 1;

    public Ball(){
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setDiameter(int diameter){
        this.diameter = diameter;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }



    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getDiameter(){
        return this.diameter;
    }

    public Color getColor(){
        return this.color;
    }

    public int getDirection(){
        return this.direction;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getDiameter(), getDiameter());
    }

    public String toString(){
        String str = "Status : X = " + getX() + ", Y = " + getY() + ", Diameter = " + getDiameter();
        str += ", Color = " + getColor() + ", Direction = " + getDirection() + ", Speed = " + getSpeed();
        return str; 
    }
}   