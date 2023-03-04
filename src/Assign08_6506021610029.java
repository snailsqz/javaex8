import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.border.LineBorder;

public class Assign08_6506021610029 extends JFrame implements ActionListener{
    JButton Play,Stop,toRight,toLeft,toTop,toDown,Exit;
    JButton SpeedUp,SpeedDown,CBlack,CRed,CGreen,CBlue;
    JPanel panelG1,panelG2,panelG3;
    JLabel label1,label2,label3;
    Ball mBall;
    Timer swTimer;

    public Assign08_6506021610029(){
        super("Assignment #08 Control Ball to Animation");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

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
        panelG1.add(toTop);panelG1.add(toDown);panelG1.add(label2);panelG1.add(Exit);
        c.add(panelG1);

        panelG2 = new JPanel();
        panelG2.setPreferredSize(new Dimension(625, 450));
        panelG2.setBorder(new LineBorder(Color.RED, 1));
        c.add(panelG2);

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

        swTimer = new Timer(60,this);

        mBall = new Ball();
        setSize(800,600);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == Play)
            swTimer.start();
        else if(e.getSource() == Stop)
            swTimer.stop();
        mBall.setX(mBall.getX() + mBall.getSpeed());
        if(mBall.getX() == 800)
            mBall.setX(0);
    }

    public void paint(Graphics g){
        super.paint(g);
        mBall.paint(panelG2.getGraphics());
        repaint();
    }

    public static void main(String[] args) {
        new Assign08_6506021610029();
    }
}
