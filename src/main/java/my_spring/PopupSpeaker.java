package my_spring;

import javax.swing.*;


public class PopupSpeaker implements my_spring.Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
