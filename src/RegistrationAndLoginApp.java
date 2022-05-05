import javax.swing.*;
import java.awt.*;

public class RegistrationAndLoginApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame( "Menu" );
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationAndLoginApp.class.getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")));
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        frame.getContentPane().add( new RegistrationScreen() );

        frame.pack();
        frame.setVisible( true );
    }
}
