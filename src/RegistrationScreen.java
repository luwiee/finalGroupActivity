import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.plaf.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu May 05 14:17:41 SGT 2022
 */


//Hi
/**
 * @author unknown
 */
public class RegistrationScreen extends JPanel {
    public RegistrationScreen() {
        initComponents();
    }

    private void menuLoginButton(MouseEvent e) {
        // TODO add your code here
        login_form.setVisible(true);
        registration_form.setVisible(false);
    }

    private void menuRegisterButton(MouseEvent e) {
        // TODO add your code here
        registration_form.setVisible(true);
        login_form.setVisible(false);
    }

    private void loginButtonClicked(MouseEvent e) throws IOException {
        // TODO add your code here
        String username = login_username_field.getText();
        String password = String.valueOf(login_password_field.getPassword());

        login_warning_username.setText("");
        login_warning_password.setText("");

        if (username.isBlank() || password.isBlank()){
            if (username.isBlank()) login_warning_username.setText("Username cannot be empty");
            if (password.isBlank()) login_warning_password.setText("Password cannot be empty");
        }

        List<Integer> errors = Authentication.login(username,password);

        if (errors.contains(0)) {
            String account_name = Authentication.getAccountName(username);
            login_label_account_name.setText(account_name);

            dialogLoginSuccess.setVisible(true);

            login_username_field.setText("");
            login_password_field.setText("");
            login_form.setVisible(false);

        }
        if (errors.contains(1)){
            login_username_field.setText("");
            login_warning_username.setText("User does not Exist!");
        }

        if (errors.contains(2)){
            login_password_field.setText("");
            login_warning_password.setText("Password is Invalid!");
        }
    }

    private void registerButtonClicked(MouseEvent e) throws IOException {
        // TODO add your code here
        String account_name = register_account_name.getText();
        String username = register_username_field.getText();
        String password = String.valueOf(register_password_field.getPassword());
        String password_confirm = String.valueOf(register_password_confirm_field.getPassword());

        // Reset Warning Labels to Blank
        register_warning_account_name.setText("");
        register_warning_username.setText("");
        register_warning_password.setText("");
        register_warning_password_confirm.setText("");



        if (account_name.isBlank() || username.isBlank() || password.isBlank() || password_confirm.isBlank()){
            if (account_name.isBlank()) register_warning_account_name.setText("Account Name cannot be empty!");
            if (username.isBlank()) register_warning_username.setText("Username cannot be empty!");
            if (password.isBlank()) register_warning_password.setText("Password cannot be empty!");
            return;
        }

        List<Integer> errors = Authentication.register(account_name,username,password,password_confirm);

        if (errors.contains(0)){
            register_label_account_name.setText(account_name);
            dialogRegistrationSuccess.setVisible(true);
            // Close Window for Registering
            registration_form.setVisible(false);

            // Reset Fields to Blank
            register_account_name.setText("");
            register_username_field.setText("");
            register_password_field.setText("");
            register_password_confirm_field.setText("");

        }
        if (errors.contains(1)){
            register_warning_account_name.setText("Account Name already exists!");
            register_account_name.setText("");
        }
        if (errors.contains(2)){
            register_warning_username.setText("Username already exists!");
            register_username_field.setText("");
        }
        if (errors.contains(3)){
            register_warning_password.setText("Passwords are not the same!");
            register_warning_password_confirm.setText("Passwords are not the same!");
            register_password_field.setText("");
            register_password_confirm_field.setText("");
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menu = new JPanel();
        TitlePanel = new JPanel();
        menu_title = new JLabel();
        MembersPanel = new JPanel();
        label_slu_logo = new JLabel();
        label_group6 = new JLabel();
        label_members = new JLabel();
        label_javier = new JLabel();
        label_miguel = new JLabel();
        label_natividad = new JLabel();
        label_tadeo = new JLabel();
        panel5 = new JPanel();
        label_login_label = new JLabel();
        label_register_label = new JLabel();
        menu_button_register = new JButton();
        menu_login_button = new JButton();
        login_form = new JFrame();
        panel4 = new JPanel();
        label_login_title = new JLabel();
        label_username = new JLabel();
        login_username_field = new JTextField();
        label13 = new JLabel();
        login_password_field = new JPasswordField();
        loginButton = new JButton();
        login_warning_username = new JLabel();
        login_warning_password = new JLabel();
        dialogLoginSuccess = new JDialog();
        panel6 = new JPanel();
        label14 = new JLabel();
        label15 = new JLabel();
        login_label_account_name = new JLabel();
        registration_form = new JFrame();
        panel7 = new JPanel();
        label_register = new JLabel();
        register_title_account_name = new JLabel();
        register_account_name = new JTextField();
        label17 = new JLabel();
        register_password_field = new JPasswordField();
        loginButton2 = new JButton();
        register_label_username = new JLabel();
        register_username_field = new JTextField();
        register_password_confirm_field = new JPasswordField();
        label18 = new JLabel();
        register_warning_account_name = new JLabel();
        register_warning_username = new JLabel();
        register_warning_password = new JLabel();
        register_warning_password_confirm = new JLabel();
        dialogRegistrationSuccess = new JDialog();
        panel8 = new JPanel();
        label19 = new JLabel();
        label20 = new JLabel();
        register_label_account_name = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.white);
        setMaximumSize(new Dimension(482, 297));

        //======== TitlePanel ========
        {
            TitlePanel.setBackground(new Color(255, 102, 153));

            //---- menu_title ----
            menu_title.setText("Login and Registration Form");
            menu_title.setFont(new Font("JetBrains Mono", Font.BOLD, 18));
            menu_title.setForeground(Color.white);
            menu_title.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout TitlePanelLayout = new GroupLayout(TitlePanel);
            TitlePanel.setLayout(TitlePanelLayout);
            TitlePanelLayout.setHorizontalGroup(
                TitlePanelLayout.createParallelGroup()
                    .addGroup(TitlePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menu_title, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                        .addContainerGap())
            );
            TitlePanelLayout.setVerticalGroup(
                TitlePanelLayout.createParallelGroup()
                    .addComponent(menu_title)
            );
        }

        //======== MembersPanel ========
        {
            MembersPanel.setBackground(Color.white);

            //---- label_slu_logo ----
            label_slu_logo.setIcon(new ImageIcon(getClass().getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")));

            //---- label_group6 ----
            label_group6.setText("GROUP 6");
            label_group6.setFont(new Font("JetBrains Mono", Font.BOLD, 37));
            label_group6.setForeground(new Color(51, 0, 51));
            label_group6.setHorizontalAlignment(SwingConstants.LEFT);

            //---- label_members ----
            label_members.setText("MEMBERS");
            label_members.setFont(new Font("JetBrains Mono", Font.BOLD, 23));
            label_members.setForeground(new Color(51, 0, 51));
            label_members.setHorizontalAlignment(SwingConstants.LEFT);

            //---- label_javier ----
            label_javier.setText("Javier, Aliyah Jenelle\n\n");
            label_javier.setBackground(Color.white);
            label_javier.setForeground(new Color(51, 0, 51));
            label_javier.setFont(new Font("JetBrains Mono ExtraLight", Font.BOLD, 13));
            label_javier.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label_miguel ----
            label_miguel.setText("Miguel, Lawrence II");
            label_miguel.setBackground(Color.white);
            label_miguel.setForeground(new Color(51, 0, 51));
            label_miguel.setFont(new Font("JetBrains Mono ExtraLight", Font.BOLD, 13));
            label_miguel.setHorizontalAlignment(SwingConstants.LEFT);

            //---- label_natividad ----
            label_natividad.setText("Natividad, Rhyen Jan O");
            label_natividad.setBackground(Color.white);
            label_natividad.setForeground(new Color(51, 0, 51));
            label_natividad.setFont(new Font("JetBrains Mono ExtraLight", Font.BOLD, 13));
            label_natividad.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label_tadeo ----
            label_tadeo.setText("Tadeo, Eduard Nicolai  ");
            label_tadeo.setBackground(Color.white);
            label_tadeo.setForeground(new Color(51, 0, 51));
            label_tadeo.setFont(new Font("JetBrains Mono ExtraLight", Font.BOLD, 13));
            label_tadeo.setHorizontalAlignment(SwingConstants.LEFT);

            GroupLayout MembersPanelLayout = new GroupLayout(MembersPanel);
            MembersPanel.setLayout(MembersPanelLayout);
            MembersPanelLayout.setHorizontalGroup(
                MembersPanelLayout.createParallelGroup()
                    .addGroup(MembersPanelLayout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(MembersPanelLayout.createParallelGroup()
                            .addGroup(MembersPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(label_javier, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_natividad, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(MembersPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label_miguel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tadeo, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(MembersPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(label_slu_logo)
                        .addGroup(MembersPanelLayout.createParallelGroup()
                            .addGroup(MembersPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(label_members, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MembersPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_group6)))
                        .addContainerGap(148, Short.MAX_VALUE))
            );
            MembersPanelLayout.setVerticalGroup(
                MembersPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, MembersPanelLayout.createSequentialGroup()
                        .addGroup(MembersPanelLayout.createParallelGroup()
                            .addGroup(MembersPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_slu_logo))
                            .addGroup(MembersPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(label_group6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label_members)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(MembersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_javier)
                            .addComponent(label_miguel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MembersPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_natividad)
                            .addComponent(label_tadeo))
                        .addGap(20, 20, 20))
            );
        }

        //======== panel5 ========
        {
            panel5.setBackground(new Color(255, 102, 153));

            //---- label_login_label ----
            label_login_label.setText("Already Have an Account?");
            label_login_label.setForeground(Color.white);
            label_login_label.setBackground(Color.white);

            //---- label_register_label ----
            label_register_label.setText("Don't Have an Account?");
            label_register_label.setBackground(Color.white);
            label_register_label.setForeground(Color.white);

            //---- menu_button_register ----
            menu_button_register.setText("Register");
            menu_button_register.setBackground(Color.black);
            menu_button_register.setForeground(Color.white);
            menu_button_register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    menuRegisterButton(e);
                }
            });

            //---- menu_login_button ----
            menu_login_button.setText("Login");
            menu_login_button.setBackground(Color.black);
            menu_login_button.setForeground(Color.white);
            menu_login_button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    menuLoginButton(e);
                }
            });

            GroupLayout panel5Layout = new GroupLayout(panel5);
            panel5.setLayout(panel5Layout);
            panel5Layout.setHorizontalGroup(
                panel5Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panel5Layout.createParallelGroup()
                            .addComponent(label_login_label)
                            .addComponent(menu_login_button, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(panel5Layout.createParallelGroup()
                            .addComponent(menu_button_register, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_register_label))
                        .addGap(53, 53, 53))
            );
            panel5Layout.setVerticalGroup(
                panel5Layout.createParallelGroup()
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addComponent(label_login_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menu_login_button))
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addComponent(label_register_label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menu_button_register)))
                        .addGap(0, 7, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(MembersPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TitlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(TitlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(MembersPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //======== login_form ========
        {
            login_form.setBackground(Color.white);
            login_form.setResizable(false);
            login_form.setIconImage(new ImageIcon(getClass().getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")).getImage());
            var login_formContentPane = login_form.getContentPane();

            //======== panel4 ========
            {
                panel4.setBackground(Color.white);

                //---- label_login_title ----
                label_login_title.setText("LOGIN");
                label_login_title.setFont(new Font("Fira Code", Font.BOLD, 20));
                label_login_title.setForeground(new Color(51, 51, 51));

                //---- label_username ----
                label_username.setText("Username");
                label_username.setFont(new Font("Arial", Font.BOLD, 15));
                label_username.setForeground(new Color(102, 102, 102));

                //---- login_username_field ----
                login_username_field.setForeground(Color.black);
                login_username_field.setBackground(Color.white);
                login_username_field.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));

                //---- label13 ----
                label13.setText("Password");
                label13.setFont(new Font("Arial", Font.BOLD, 15));
                label13.setForeground(new Color(102, 102, 102));

                //---- login_password_field ----
                login_password_field.setBackground(Color.white);
                login_password_field.setForeground(Color.black);

                //---- loginButton ----
                loginButton.setText("LOGIN");
                loginButton.setBackground(new Color(255, 51, 153));
                loginButton.setForeground(Color.white);
                loginButton.setBorder(null);
                loginButton.setAutoscrolls(true);
                loginButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            loginButtonClicked(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                //---- login_warning_username ----
                login_warning_username.setFont(new Font("Arial", Font.BOLD, 9));
                login_warning_username.setForeground(new Color(255, 51, 51));
                login_warning_username.setBackground(new Color(255, 0, 51));

                //---- login_warning_password ----
                login_warning_password.setFont(new Font("Arial", Font.BOLD, 9));
                login_warning_password.setForeground(new Color(255, 51, 51));
                login_warning_password.setBackground(new Color(255, 0, 51));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(panel4Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(label_username)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(login_warning_username)
                                            .addContainerGap(269, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(GroupLayout.Alignment.LEADING, panel4Layout.createSequentialGroup()
                                                    .addComponent(label13)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(login_warning_password)
                                                    .addGap(0, 235, Short.MAX_VALUE))
                                                .addComponent(login_password_field, GroupLayout.Alignment.LEADING)
                                                .addComponent(login_username_field, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                                .addComponent(loginButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                                            .addGap(32, 32, 32))))
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addComponent(label_login_title)
                                    .addContainerGap(300, Short.MAX_VALUE))))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label_login_title)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label_username)
                                .addComponent(login_warning_username))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(login_username_field, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label13)
                                .addComponent(login_warning_password))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(login_password_field, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(61, Short.MAX_VALUE))
                );
            }

            GroupLayout login_formContentPaneLayout = new GroupLayout(login_formContentPane);
            login_formContentPane.setLayout(login_formContentPaneLayout);
            login_formContentPaneLayout.setHorizontalGroup(
                login_formContentPaneLayout.createParallelGroup()
                    .addComponent(panel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            login_formContentPaneLayout.setVerticalGroup(
                login_formContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, login_formContentPaneLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            login_form.pack();
            login_form.setLocationRelativeTo(login_form.getOwner());
        }

        //======== dialogLoginSuccess ========
        {
            var dialogLoginSuccessContentPane = dialogLoginSuccess.getContentPane();

            //======== panel6 ========
            {
                panel6.setBackground(Color.white);

                //---- label14 ----
                label14.setText("Login is Successful");
                label14.setForeground(new Color(51, 102, 0));
                label14.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label14.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label15 ----
                label15.setText("Account Name");
                label15.setForeground(new Color(51, 51, 51));
                label15.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label15.setHorizontalAlignment(SwingConstants.CENTER);

                //---- login_label_account_name ----
                login_label_account_name.setText("Lawrence T. Miguel");
                login_label_account_name.setForeground(new Color(51, 51, 51));
                login_label_account_name.setFont(new Font("Segoe UI", Font.BOLD, 14));
                login_label_account_name.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addComponent(login_label_account_name, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(label14, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(label15, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label14)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label15)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(login_label_account_name)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout dialogLoginSuccessContentPaneLayout = new GroupLayout(dialogLoginSuccessContentPane);
            dialogLoginSuccessContentPane.setLayout(dialogLoginSuccessContentPaneLayout);
            dialogLoginSuccessContentPaneLayout.setHorizontalGroup(
                dialogLoginSuccessContentPaneLayout.createParallelGroup()
                    .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            dialogLoginSuccessContentPaneLayout.setVerticalGroup(
                dialogLoginSuccessContentPaneLayout.createParallelGroup()
                    .addGroup(dialogLoginSuccessContentPaneLayout.createSequentialGroup()
                        .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            dialogLoginSuccess.pack();
            dialogLoginSuccess.setLocationRelativeTo(dialogLoginSuccess.getOwner());
        }

        //======== registration_form ========
        {
            registration_form.setBackground(Color.white);
            registration_form.setResizable(false);
            registration_form.setIconImage(new ImageIcon(getClass().getResource("/images/Saint_Louis_University_(Baguio)_logo.jpg")).getImage());
            var registration_formContentPane = registration_form.getContentPane();

            //======== panel7 ========
            {
                panel7.setBackground(Color.white);

                //---- label_register ----
                label_register.setText("REGISTER");
                label_register.setFont(new Font("Fira Code", Font.BOLD, 20));
                label_register.setForeground(new Color(51, 51, 51));

                //---- register_title_account_name ----
                register_title_account_name.setText("Account Name");
                register_title_account_name.setFont(new Font("Arial", Font.BOLD, 15));
                register_title_account_name.setForeground(new Color(102, 102, 102));

                //---- register_account_name ----
                register_account_name.setForeground(Color.black);
                register_account_name.setBackground(Color.white);
                register_account_name.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));

                //---- label17 ----
                label17.setText("Password");
                label17.setFont(new Font("Arial", Font.BOLD, 15));
                label17.setForeground(new Color(102, 102, 102));

                //---- register_password_field ----
                register_password_field.setBackground(Color.white);
                register_password_field.setForeground(Color.black);

                //---- loginButton2 ----
                loginButton2.setText("REGISTER");
                loginButton2.setBackground(new Color(255, 51, 153));
                loginButton2.setForeground(Color.white);
                loginButton2.setBorder(null);
                loginButton2.setAutoscrolls(true);
                loginButton2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            registerButtonClicked(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                //---- register_label_username ----
                register_label_username.setText("Username");
                register_label_username.setFont(new Font("Arial", Font.BOLD, 15));
                register_label_username.setForeground(new Color(102, 102, 102));

                //---- register_username_field ----
                register_username_field.setForeground(Color.black);
                register_username_field.setBackground(Color.white);
                register_username_field.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));

                //---- register_password_confirm_field ----
                register_password_confirm_field.setBackground(Color.white);
                register_password_confirm_field.setForeground(Color.black);

                //---- label18 ----
                label18.setText("Password");
                label18.setFont(new Font("Arial", Font.BOLD, 15));
                label18.setForeground(new Color(102, 102, 102));

                //---- register_warning_account_name ----
                register_warning_account_name.setFont(new Font("Arial", Font.BOLD, 9));
                register_warning_account_name.setForeground(new Color(255, 51, 51));
                register_warning_account_name.setBackground(new Color(255, 0, 51));

                //---- register_warning_username ----
                register_warning_username.setFont(new Font("Arial", Font.BOLD, 9));
                register_warning_username.setForeground(new Color(255, 51, 51));
                register_warning_username.setBackground(new Color(255, 0, 51));

                //---- register_warning_password ----
                register_warning_password.setFont(new Font("Arial", Font.BOLD, 9));
                register_warning_password.setForeground(new Color(255, 51, 51));
                register_warning_password.setBackground(new Color(255, 0, 51));

                //---- register_warning_password_confirm ----
                register_warning_password_confirm.setFont(new Font("Arial", Font.BOLD, 9));
                register_warning_password_confirm.setForeground(new Color(255, 51, 51));
                register_warning_password_confirm.setBackground(new Color(255, 0, 51));

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(panel7Layout.createParallelGroup()
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(label_register)
                                    .addContainerGap())
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(register_title_account_name)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(register_warning_account_name)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(register_password_field, GroupLayout.Alignment.LEADING)
                                                .addComponent(register_account_name, GroupLayout.Alignment.LEADING)
                                                .addComponent(register_username_field, GroupLayout.Alignment.LEADING)
                                                .addGroup(panel7Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(loginButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                                            .addComponent(label17)
                                                            .addGap(43, 43, 43)
                                                            .addComponent(register_warning_password))
                                                        .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                                            .addComponent(label18)
                                                            .addGap(46, 46, 46)
                                                            .addComponent(register_warning_password_confirm))
                                                        .addComponent(register_password_confirm_field, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(32, 32, 32))
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(register_label_username)
                                            .addGap(39, 39, 39)
                                            .addComponent(register_warning_username)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label_register)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(register_title_account_name)
                                .addComponent(register_warning_account_name))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(register_account_name, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(register_label_username)
                                .addComponent(register_warning_username))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(register_username_field, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label17)
                                .addComponent(register_warning_password))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(register_password_field, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label18)
                                .addComponent(register_warning_password_confirm))
                            .addGap(6, 6, 6)
                            .addComponent(register_password_confirm_field, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loginButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(78, Short.MAX_VALUE))
                );
            }

            GroupLayout registration_formContentPaneLayout = new GroupLayout(registration_formContentPane);
            registration_formContentPane.setLayout(registration_formContentPaneLayout);
            registration_formContentPaneLayout.setHorizontalGroup(
                registration_formContentPaneLayout.createParallelGroup()
                    .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            registration_formContentPaneLayout.setVerticalGroup(
                registration_formContentPaneLayout.createParallelGroup()
                    .addGroup(registration_formContentPaneLayout.createSequentialGroup()
                        .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            registration_form.pack();
            registration_form.setLocationRelativeTo(registration_form.getOwner());
        }

        //======== dialogRegistrationSuccess ========
        {
            var dialogRegistrationSuccessContentPane = dialogRegistrationSuccess.getContentPane();

            //======== panel8 ========
            {
                panel8.setBackground(Color.white);

                //---- label19 ----
                label19.setText("Registration Successful");
                label19.setForeground(new Color(51, 102, 0));
                label19.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label19.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label20 ----
                label20.setText("Account Name");
                label20.setForeground(new Color(51, 51, 51));
                label20.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label20.setHorizontalAlignment(SwingConstants.CENTER);

                //---- register_label_account_name ----
                register_label_account_name.setText("Lawrence T. Miguel");
                register_label_account_name.setForeground(new Color(51, 51, 51));
                register_label_account_name.setFont(new Font("Segoe UI", Font.BOLD, 14));
                register_label_account_name.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout panel8Layout = new GroupLayout(panel8);
                panel8.setLayout(panel8Layout);
                panel8Layout.setHorizontalGroup(
                    panel8Layout.createParallelGroup()
                        .addComponent(register_label_account_name, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(label19, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(label20, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                );
                panel8Layout.setVerticalGroup(
                    panel8Layout.createParallelGroup()
                        .addGroup(panel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label19)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label20)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(register_label_account_name)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout dialogRegistrationSuccessContentPaneLayout = new GroupLayout(dialogRegistrationSuccessContentPane);
            dialogRegistrationSuccessContentPane.setLayout(dialogRegistrationSuccessContentPaneLayout);
            dialogRegistrationSuccessContentPaneLayout.setHorizontalGroup(
                dialogRegistrationSuccessContentPaneLayout.createParallelGroup()
                    .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            dialogRegistrationSuccessContentPaneLayout.setVerticalGroup(
                dialogRegistrationSuccessContentPaneLayout.createParallelGroup()
                    .addGroup(dialogRegistrationSuccessContentPaneLayout.createSequentialGroup()
                        .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            dialogRegistrationSuccess.pack();
            dialogRegistrationSuccess.setLocationRelativeTo(dialogRegistrationSuccess.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel menu;
    private JPanel TitlePanel;
    private JLabel menu_title;
    private JPanel MembersPanel;
    private JLabel label_slu_logo;
    private JLabel label_group6;
    private JLabel label_members;
    private JLabel label_javier;
    private JLabel label_miguel;
    private JLabel label_natividad;
    private JLabel label_tadeo;
    private JPanel panel5;
    private JLabel label_login_label;
    private JLabel label_register_label;
    private JButton menu_button_register;
    private JButton menu_login_button;
    private JFrame login_form;
    private JPanel panel4;
    private JLabel label_login_title;
    private JLabel label_username;
    private JTextField login_username_field;
    private JLabel label13;
    private JPasswordField login_password_field;
    private JButton loginButton;
    private JLabel login_warning_username;
    private JLabel login_warning_password;
    private JDialog dialogLoginSuccess;
    private JPanel panel6;
    private JLabel label14;
    private JLabel label15;
    private JLabel login_label_account_name;
    private JFrame registration_form;
    private JPanel panel7;
    private JLabel label_register;
    private JLabel register_title_account_name;
    private JTextField register_account_name;
    private JLabel label17;
    private JPasswordField register_password_field;
    private JButton loginButton2;
    private JLabel register_label_username;
    private JTextField register_username_field;
    private JPasswordField register_password_confirm_field;
    private JLabel label18;
    private JLabel register_warning_account_name;
    private JLabel register_warning_username;
    private JLabel register_warning_password;
    private JLabel register_warning_password_confirm;
    private JDialog dialogRegistrationSuccess;
    private JPanel panel8;
    private JLabel label19;
    private JLabel label20;
    private JLabel register_label_account_name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
