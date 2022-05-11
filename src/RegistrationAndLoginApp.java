import javax.swing.*;
import java.awt.*;

public class RegistrationAndLoginApp {
    public static void main(String[] args) {
        // Initialize A FRAME
        JFrame frame = new JFrame("Menu");
        frame.setResizable(false);
        // Set the Window Logo to SLU
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationAndLoginApp.class.getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Change the content of the frame to the AuthenticationScreen Class
        frame.getContentPane().add(new AuthenticationScreen());
        frame.pack();
        frame.setVisible(true);
    }


}


