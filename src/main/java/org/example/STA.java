package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class STA {
    private NetflixService netflix;

    public STA(NetflixService netflix){
        this.netflix = netflix;

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setIconImage(new ImageIcon("Netflix Icon.png").getImage());
        frame.setLayout(null);

        //North panel including : SITE TITLE & CURRENT USER
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setBounds(0, 0, 600, 100);
        panel1.setLayout(new GridLayout(2, 1));

        //Central panel including : OPTION MENUS
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setBounds(0, 100, 600, 500);
        panel2.setLayout(new GridLayout(3, 1));

        //SITE TITLE
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("netflix main.jpg"));
        label1.setHorizontalAlignment(JLabel.CENTER);

        //CURRENT USER
        JLabel label2 = new JLabel();
        label2.setText("CURRENT USER: " + netflix.getCurrentUser().getUserName().toUpperCase());
        label2.setHorizontalAlignment(JLabel.CENTER);

        JButton button1 = new JButton("SEARCH BY TITLE");
        button1.setFocusable(false);
        button1.setForeground(Color.RED);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1){

                   String title = JOptionPane.showInputDialog(null, "ENTER THE TITLE");
                    JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                   netflix.showList(netflix.searchByTitle(title));
                }
            }
        });
        JButton button2 = new JButton("SEARCH BY GENRE");
        button2.setFocusable(false);
        button2.setForeground(Color.RED);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String genre = JOptionPane.showInputDialog(null, "ENTER THE GENRE");
                JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                netflix.showList(netflix.searchByGenre(genre));
            }
        });
        JButton button3 = new JButton("SEARCH BY RELEASE YEAR");
        button3.setFocusable(false);
        button3.setForeground(Color.RED);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int releaseYear = Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER THE RELEASE YEAR"));
                JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                netflix.showList(netflix.searchByReleaseYear(releaseYear));
            }
        });
        panel1.add(label1);
        panel1.add(label2);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }
}
