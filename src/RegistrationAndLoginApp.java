import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

//Hi
public class RegistrationAndLoginApp {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Menu");
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationAndLoginApp.class.getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new RegistrationScreen());
        frame.pack();
        frame.setVisible(true);
    }


}


