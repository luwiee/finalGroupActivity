import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

//Hi
public class RegistrationAndLoginApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationAndLoginApp.class.getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new RegistrationScreen());

        frame.pack();
        frame.setVisible(true);

        Collection<User> users = new ArrayList<>();

        users.add(new User("Lawrence T. Miguel", "luwie", "pyy"));

        while (true){
            choose(users);
        }

    }

    //registered
    public static void register(Collection<User> users) {

        boolean flag = true;
        while (flag) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Please enter the registered account name:");
            String account_name = sc1.nextLine();
            System.out.println("Please enter the registered username:");
            String id = sc1.nextLine();//Prompt for a registered account

            //At the time of judgment, the user does not have a code, so the created user code is null
            if (users.contains(new User(account_name, null, null))) {//Determine whether the entered account user exists or not. The comparison here is the user ID because we rewrite the equals method of the class
                System.out.println("The account name you entered already exists! Please re-enter!");
            } else if (users.contains(new User(null, id, null))) {//Determine whether the entered account user exists or not. The comparison here is the user ID because we rewrite the equals method of the class
                System.out.println("The username you entered already exists! Please re-enter!");
            } else {
                //You can continue to enter the password if the account does not exist
                System.out.println("Please enter the registration password:");
                Scanner sc2 = new Scanner(System.in);
                String code = sc2.nextLine();

                //You can add the user to the collection if you have the account and password
                users.add(new User(account_name, id, code));

                flag = false;
                System.out.println("Congratulations on your successful registration!");

                //Use toArray to print collection elements
                Object[] arr = users.toArray();//Return the elements in the collection to an obj array
                System.out.println("All successfully registered users are:" + Arrays.toString(arr));
            }
        }

    }

    //log in
    public static void login(Collection<User> users) {

        boolean flag = true;
        while (flag) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Please enter the username:");
            String id = sc1.next();

            //First determine if the user id does not exist, login directly is not allowed
            if (users.contains(new User(null,id, null))) {

                System.out.println("Please enter the login password:");
                Scanner sc2 = new Scanner(System.in);
                String code = sc2.nextLine();

                //Traverse the collection to determine the password
                for (User u : users) {
                    if (code.equals(u.getPassword())) {
                        flag = false;
                        System.out.println("Successful login, welcome to the world of magic domain!");
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Wrong password, please re-enter!");
                }

            } else {
                System.out.println("The user does not exist, please re-enter!");
            }
        }
    }

    //Prompt function
    public static void choose(Collection<User> users) {

        boolean flag = true;
        while (flag) {

            System.out.println("Select function: A: Register B: Login");
            Scanner sc = new Scanner(System.in);
            String c = sc.nextLine();

            if ("A".equalsIgnoreCase(c)) {
                flag = false;
                //Registration method
                register(users);
            } else if ("B".equalsIgnoreCase(c)) {
                flag = false;
                //Login method
                login(users);
            } else {
                System.out.println("Selection error, please select again!");
            }
        }
    }
}


class User {
    String account_name;
    String username;
    String password;


    public User(String account_name, String id, String code) {
        this.account_name = account_name;
        this.username = id;
        this.password = code;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{Account name:" + this.account_name + "; Username:" + this.username + "; Password:" + this.password + "}";
    }

    public boolean equals(Object obj) {
        User u = (User) obj;
        if (this.username == null) return (this.account_name.equals(u.account_name));
        if (this.account_name == null) return (this.username.equals(u.username));
        return (this.username.equals(u.username) || this.account_name.equals(u.account_name));
    }

}

