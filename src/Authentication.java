import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication {
    //registered
    static final String DEFAULT_FILENAME = "users_information.csv";
    static final String DEFAULT_PATH = System.getProperty("user.dir") + "/" + DEFAULT_FILENAME;

    /**
     * Register the user's account if there are no errors in checks
     * @param account_name Name of the user
     * @param username Username of the user
     * @param password Password of the user
     * @param password_confirm Retyped password of the user
     * @return List of integer: 0 if Successful, 1 if account_name is invalid, 2 if username_name is invalid, and 3 if password confirmation is not the same
     * @throws IOException
     */
    public static List<Integer> register(String account_name, String username, String password, String password_confirm) throws IOException {
        Collection<User> users = Authentication.getLocalUsers();

        List<Integer> check_list = new ArrayList<>();


        boolean account_name_valid = true;
        boolean username_valid = true;
        boolean password_the_same = password.compareTo(password_confirm) == 0;

        if (users.contains(new User(account_name, null, null))) {
            account_name_valid = false;
            check_list.add(1);
        }
        if (users.contains(new User(null, username, null)) || !isValid(username)) {
            username_valid = false;
            check_list.add(2);
        }
        if (!password_the_same) check_list.add(3);

        if (account_name_valid && username_valid && password_the_same) {
            users.add(new User(account_name, username, password));
            check_list.add(0);
        }
        // write new data
        createUsersFile(users);

        return check_list;


    }


    /**
     *Checks if the given username and password exist and matches the data in the local database
     * @param username username of the user
     * @param password password of the user
     * @return list of integer: 0 if successful, 1 if username is not found, and 2 if password is incorrect
     * @throws IOException
     */
    public static List<Integer> login(String username, String password) throws IOException {

        Collection<User> users = Authentication.getLocalUsers();

        List<Integer> check_list = new ArrayList<>();
        if (users.contains(new User(null, username, null))) {
            for (User u : users) {
                if (password.equals(u.getPassword()) && u.username.equals(username)) {
                    check_list.add(0);
                } else {
                    check_list.add(2);
                }
            }
        } else {
            check_list.add(1);
        }


        return check_list;
    }

    /**
     * Gets the Name of an existing user
     * @param username Username of the user
     * @return Name of the user
     * @throws IOException
     */
    public static String getAccountName(String username) throws IOException {
        Collection<User> users = Authentication.getLocalUsers();
        String account_name = null;
        for (User u : users) {
            if (username.equals(u.username)) {
                account_name = u.account_name;
                break;
            }
        }
        return account_name;
    }

    /**
     * Gets the data of the User object existing in the local database
     * @return Collection of the User object
     * @throws IOException
     */
    public static Collection<User> getLocalUsers() throws IOException {
        Collection<User> users = new ArrayList<>();

        String line;
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

                users.add(new User(account_name, username, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Checks if a file exist
     * @return True if the file exist, False if not
     */
    public static boolean fileExist() {
        File f = new File(DEFAULT_PATH);
        return f.exists() && !f.isDirectory();
    }

    /**
     * Creates local database of the users if none exist
     * @throws IOException
     */
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

    /**
     * Updates the data in the existing local database
     * @param newData Collection of the User object that contains the data of the users
     * @throws IOException
     */
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



    public static boolean isValid(final String username) {
        final String USERNAME_PATTERN =
                "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

        final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}

class User {
    String account_name;
    String username;
    String password;

    /**
     * Creates a new User
     * @param account_name Name of the user
     * @param id username of the user
     * @param code password of the user
     */
    public User(String account_name, String id, String code) {
        this.account_name = account_name;
        this.username = id;
        this.password = code;
    }

    /**
     *Gets the password of a user
     * @return password of a user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Shows the data of a user
     * @return data of the user containing account name, username, and password
     */
    @Override
    public String toString() {
        return "{Account name:" + this.account_name + "; Username:" + this.username + "; Password:" + this.password + "}";
    }

    /**
     * Checks if the given object is equal to this user object
     * @param obj Object
     * @return true if the given object is equal to this user object, false otherwise
     */
    public boolean equals(Object obj) {
        User u = (User) obj;
        if (this.username == null) return (this.account_name.equals(u.account_name));
        if (this.account_name == null) return (this.username.equals(u.username));
        return (this.username.equals(u.username) || this.account_name.equals(u.account_name));
    }

}

