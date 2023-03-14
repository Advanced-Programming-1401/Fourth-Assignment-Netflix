package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener{
    private JFrame menuFrame;
    private NetflixService netflix;

    public MainMenu(NetflixService netflix){
        this.netflix = netflix;
        this.menuFrame = new JFrame();

        //Making up menu frame
        this.menuFrame.setSize(600, 600);
        this.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.menuFrame.setLayout(null);
        this.menuFrame.setIconImage(new ImageIcon("Netflix Icon.png").getImage());

        //North panel including : current user & site title
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBounds(0, 0, 600, 100);
        panel1.setBackground(Color.BLACK);

        //Central panel including : menu options
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1, 0, 10));
        panel2.setBounds(0, 100, 600, 500);
        panel2.setBackground(Color.BLACK);

        //making up north panel components
        JLabel userLabel = new JLabel();
        JLabel siteImage  = new JLabel();
        ImageIcon netflixImage = new ImageIcon("netflix main.jpg");
        siteImage.setIcon(netflixImage);
        if (netflix.getCurrentUser() != null){
            userLabel.setText("CURRENT USER: " + netflix.getCurrentUser().getUserName());
        }
        else {
            userLabel.setText("CURRENT USER: NULL");
        }
        userLabel.setForeground(Color.RED);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        siteImage.setHorizontalAlignment(JLabel.CENTER);


        //Making up central panel components
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        button1.setText("CREATE AN ACCOUNT");
        button2.setText("LOGIN AS USER");
        button3.setText("EXIT");
        button1.setBackground(Color.red);
        button2.setBackground(Color.red);
        button3.setBackground(Color.red);
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if user clicked CREATE AN ACCOUNT button then :
                if (e.getSource() == button1){

                    menuFrame.dispose();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if user clicked LOGIN AS USER button then :
                if (e.getSource() == button2){

                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if user clicked LOGIN AS USER button then :
                if (e.getSource() == button2){

                }
            }
        });

        //adding components to north panel
        panel1.add(siteImage);
        panel1.add(userLabel);

        //adding components to central panel
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        //adding panels to main frame
        this.menuFrame.add(panel1);
        this.menuFrame.add(panel2);
        this.menuFrame.setVisible(true);
    }

}
