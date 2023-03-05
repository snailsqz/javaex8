/*
 * Id   : 65-060216-1002-9
 * Name : Pawee Indulakshana
 * Room : IT-1RA
 * File Name : Assign08_6506021610029.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Assign08_6506021610029 extends JFrame implements ActionListener{
    JButton Play,Stop,toRight,toLeft,toTop,toDown,Exit;
    JButton SpeedUp,SpeedDown,CBlack,CRed,CGreen,CBlue;
    JPanel panelG1,panelG2,panelG3,panelG4;
    JLabel label1,label2,label3,Text;
    Ball mBall;
    Timer swTimer;
    int Direction = 0;
    boolean start = false;
    

    public Assign08_6506021610029(){
        super("Assignment #08 Control Ball to Animation");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        mBall = new Ball();
        swTimer = new Timer(30,this);
        
        upbutton(c);
        ballzone(c);
        sidebutton(c);
        description(c);
        setSize(800,600);
        setVisible(true);

    }

    private void upbutton(Container c) {
        Play = new JButton("Play");
        Play.addActionListener(this);

        Stop = new JButton("Stop");
        Stop.addActionListener(this);

        label1 = new JLabel("|");
        label2 = new JLabel("|");

        toRight = new JButton("to Right");
        toRight.addActionListener(this);

        toLeft = new JButton("to Left");
        toLeft.addActionListener(this);

        toTop = new JButton("to Top");
        toTop.addActionListener(this);

        toDown = new JButton("to Down");
        toDown.addActionListener(this);

        Exit = new JButton("Exit");
        Exit.addActionListener(this);

        panelG1 = new JPanel();
        panelG1.setPreferredSize(new Dimension(770, 40));
        panelG1.setBorder(new LineBorder(Color.RED, 1));
        panelG1.add(Play);panelG1.add(Stop);panelG1.add(label1);panelG1.add(toRight);panelG1.add(toLeft);
        panelG1.add(toDown);panelG1.add(toTop);panelG1.add(label2);panelG1.add(Exit);
        c.add(panelG1);
    }

    private void ballzone(Container c) {
        panelG2 = new JPanel();
        panelG2.setPreferredSize(new Dimension(625, 450));
        panelG2.setBorder(new LineBorder(Color.RED, 1));
        c.add(panelG2);
    }

    private void sidebutton(Container c) {
        SpeedUp = new JButton("Speed Up");
        SpeedUp.addActionListener(this);
        
        SpeedDown = new JButton("Speed Down");
        SpeedDown.addActionListener(this);

        label3 = new JLabel("------");

        CBlack = new JButton("Black");
        CBlack.addActionListener(this);

        CRed = new JButton("Red");
        CRed.addActionListener(this);

        CGreen = new JButton("Green");
        CGreen.addActionListener(this);

        CBlue = new JButton("Blue");
        CBlue.addActionListener(this);

        SpeedUp.setPreferredSize(new Dimension(120,30));
        SpeedDown.setPreferredSize(new Dimension(120,30));
        label3.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        CBlack.setPreferredSize(new Dimension(120,30));
        CRed.setPreferredSize(new Dimension(120,30));
        CGreen.setPreferredSize(new Dimension(120,30));
        CBlue.setPreferredSize(new Dimension(120,30));

        panelG3 = new JPanel();
        panelG3.setPreferredSize(new Dimension(140, 450));
        panelG3.setBorder(new LineBorder(Color.RED, 1));
        panelG3.add(SpeedUp);panelG3.add(SpeedDown);panelG3.add(label3);panelG3.add(CBlack);
        panelG3.add(CRed);panelG3.add(CGreen);panelG3.add(CBlue);
        c.add(panelG3);
    }

    private void description(Container c) {
        Text = new JLabel(mBall.toString());
        panelG4 = new JPanel();
        panelG4.setPreferredSize(new Dimension(770, 40));
        panelG4.add(Text);
        c.add(panelG4);
    }

    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == Play){
            swTimer.start();
            Play.setEnabled(false);
            start = true;
        }
        else if(e.getSource() == Stop){
            swTimer.stop();
            Play.setEnabled(true);
            start = false;
        }
        else if(e.getSource() == toRight)
            mBall.setDirection(0);
        else if(e.getSource() == toLeft)
            mBall.setDirection(1);
        else if(e.getSource() == toDown)
            mBall.setDirection(2);
        else if(e.getSource() == toTop)
            mBall.setDirection(3);
        else if(e.getSource() == Exit)
            System.exit(0);

        if(start){
            if(mBall.getDirection() == 0) mBall.setX(mBall.getX() + mBall.getSpeed());
            else if(mBall.getDirection() == 1) mBall.setX(mBall.getX() - mBall.getSpeed());
            else if(mBall.getDirection() == 2) mBall.setY(mBall.getY() + mBall.getSpeed());
            else if(mBall.getDirection() == 3) mBall.setY(mBall.getY() - mBall.getSpeed());
        }

        if(mBall.getX() >= 630)
            mBall.setX(-5);
        else if(mBall.getX() <= -6)
            mBall.setX(629);
        else if(mBall.getY() >= 455)
            mBall.setY(-5);
        else if(mBall.getY() <= -6)
            mBall.setY(454);     
            
        if(e.getSource() == SpeedUp)
            if(mBall.getSpeed() < 5)
                mBall.setSpeed(mBall.getSpeed() + 1);
        if(e.getSource() == SpeedDown)
            if(mBall.getSpeed() > 1)
                mBall.setSpeed(mBall.getSpeed() - 1);

        if(e.getSource() == CBlack)
            mBall.setColor(Color.black);
        else if(e.getSource() == CRed)
            mBall.setColor(Color.red);
        else if(e.getSource() == CGreen)
            mBall.setColor(Color.green);
        else if(e.getSource() == CBlue)
            mBall.setColor(Color.blue);

        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        mBall.paint(panelG2.getGraphics());
        mBall.getColor();
        Text.setText(mBall.toString());
    }

    public static void main(String[] args) {
        new Assign08_6506021610029();
    }
}
