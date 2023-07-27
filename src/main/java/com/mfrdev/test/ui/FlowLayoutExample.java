package com.mfrdev.test.ui;

// import statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FlowLayoutExample
{

    JFrame frameObj;

    // constructor
    FlowLayoutExample()
    {
        // creating a frame object
        frameObj = new JFrame();
        frameObj.setSize(800, 300);
        // creating the buttons
        JButton b1 = new JButton("1");
        b1.setSize(new Dimension(30,30));
        final JLabel[] b2 = {new JLabel("This will be a header text slslslsls slsl slslks slsd s")};
        b2[0].setVerticalAlignment(JLabel.CENTER);
        double width = frameObj.getSize().getWidth();
        double b1Width = b1.getSize().getWidth();
        System.out.println("FrameWidth :: "+width);
        System.out.println("B1Width :: "+b1Width);
        int ss = (int) (width - b1Width);
        System.out.println(ss);
        b2[0].setPreferredSize(new Dimension((int) ((int)ss*0.9),20));
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("10");


        // adding the buttons to frame
        frameObj.add(b1);
     //   frameObj.add(b2);
//       frameObj.add(b3);
//        frameObj.add(b4);
//       frameObj.add(b5);
//       frameObj.add(b6);
//       frameObj.add(b7);  frameObj.add(b8);
//        frameObj.add(b9);  frameObj.add(b10);

        // parameter less constructor is used
        // therefore, alignment is center
        // horizontal as well as the vertical gap is 5 units.
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        frameObj.setLayout(flowLayout);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click B1");
                frameObj.remove(b2[0]);
                //IMPORTANT
                frameObj.revalidate();
                frameObj.repaint();
            }
        });


        frameObj.setVisible(true);

    }

    // main method
    public static void main(String argvs[])
    {
        new FlowLayoutExample();
    }
}