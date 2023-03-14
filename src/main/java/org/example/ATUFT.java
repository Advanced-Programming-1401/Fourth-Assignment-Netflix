package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATUFT {
    private NetflixService netflix;

    public ATUFT(NetflixService netflix) {
        this.netflix = netflix;

        String title = JOptionPane.showInputDialog(null, "ENTER TITLE");

        if (netflix.doesTVShowExist(title)) {
            if (!netflix.getCurrentUser().doesTVShowExist(title)) {
                netflix.getCurrentUser().addToFavorites(NetflixService.getASingleTVShow(title));
                JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY ADDED TO YOUR FAVORITES", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "USER HAS ALREADY HAVE THIS TV-SHOW IN HIS FAVORITES", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "THIS TV-SHOW DOESN'T EXIST IN SITE", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
        }
    }
}
