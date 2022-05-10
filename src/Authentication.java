import java.io.*;
import java.util.*;

public class Authentication {
    //registered
    static final String DEFAULT_FILENAME = "users_information.csv";
    static final String DEFAULT_PATH = System.getProperty("user.dir")+"/"+DEFAULT_FILENAME;

    /*
        0 - Successful
        1 - account_name invalid
        2 - username_name invalid
        3 - password confirmation not the same
     */
    public static List<Integer> register(String account_name, String username, String password, String password_confirm) throws IOException {
        Collection<User> users = Authentication.getLocalUsers();

        List<Integer> check_list = new ArrayList<Integer>();


        boolean account_name_valid = true;
        boolean username_valid = true;
        boolean password_the_same = password.compareTo(password_confirm) == 0;

        if (users.contains(new User(account_name, null, null))) {
            account_name_valid = false;
            check_list.add(1);
        }
        if (users.contains(new User(null, username, null))) {
            username_valid = false;
            check_list.add(2);
        }
        if (!password_the_same) check_list.add(3);

        if (account_name_valid && username_valid && password_the_same){
            users.add(new User(account_name, username, password));
            check_list.add(0);
        }
        // write new data
        createUsersFile(users);

        //Use toArray to print collection elements
        Object[] arr = users.toArray();//Return the elements in the collection to an obj array

        return check_list;


    }
    /*
        0 - Successful
        1 - Username not found
        2 - password incorrect
     */
    //log in
    public static List<Integer> login(String username, String password) throws IOException {

        Collection<User> users = Authentication.getLocalUsers();

        List<Integer> check_list = new ArrayList<Integer>();
        if (users.contains(new User(null,username, null))) {
            for (User u : users) {
                if (password.equals(u.getPassword())) {
                    check_list.add(0);
                }else{
                    check_list.add(2);
                }
            }
        }else{
            check_list.add(1);
        }


        return check_list;
    }

    public static String getAccountName(String username) throws IOException {
        Collection<User> users = Authentication.getLocalUsers();
        String account_name = null;
        for (User u : users) {
            if (username.equals(u.username)){
                account_name = u.account_name;
                break;
            }
        }
        return account_name;
    }



    public static Collection<User> getLocalUsers() throws IOException {
        Collection<User> users = new ArrayList<>();

        String line = "";
        String splitBy = ",";
        if (!fileExist()) createUsersFile();
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PATH));
            br.readLine();
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] users_line = line.split(splitBy);
                String account_name = users_line[0];
                String username = users_line[1];
                String password = users_line[2];

                users.add(new User(account_name,username,password));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static boolean fileExist(){
        File f = new File(DEFAULT_PATH);
        return f.exists() && !f.isDirectory();
    }

    public static void createUsersFile() throws IOException {
        FileWriter csvWriter = new FileWriter(DEFAULT_FILENAME);
        csvWriter.append("Account Name");
        csvWriter.append(",");
        csvWriter.append("Username");
        csvWriter.append(",");
        csvWriter.append("Password");
        csvWriter.append("\n");

        csvWriter.flush();
        csvWriter.close();
    }

    public static void createUsersFile(Collection<User> newData) throws IOException {
        FileWriter csvWriter = new FileWriter(DEFAULT_FILENAME);

        csvWriter.append("Account Name");
        csvWriter.append(",");
        csvWriter.append("Username");
        csvWriter.append(",");
        csvWriter.append("Password");
        csvWriter.append("\n");

        for (User userData : newData) {
            csvWriter.append(userData.account_name);
            csvWriter.append(",");
            csvWriter.append(userData.username);
            csvWriter.append(",");
            csvWriter.append(userData.password);
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
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

