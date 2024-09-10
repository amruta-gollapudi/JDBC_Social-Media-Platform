import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

class Login1 extends JFrame {
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;

    Login1() {
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and set properties for the login label
        l1 = new JLabel("LOGIN");
        l1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 10, 300, 30);
        add(l1);

        // Initialize text fields for user input
        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        // Initialize buttons for Sign In and Sign Up actions
        b1 = new JButton("SignIn");
        b2 = new JButton("SignUp");

        // Set bounds for the text fields and buttons
        t1.setBounds(100, 60, 120, 30);
        t2.setBounds(100, 100, 120, 30);
        b1.setBounds(120, 140, 80, 30);
        b2.setBounds(120, 180, 80, 30);

        // Initialize and set properties for email and password labels
        l2 = new JLabel("Emailid");
        l2.setBounds(20, 60, 70, 30);
        add(l2);
        l3 = new JLabel("Password");
        l3.setBounds(20, 100, 70, 30);
        add(l3);

        // Add components to the frame
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        // Add action listener for the Sign In button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean match = false;
                // Get user input from text fields
                String Email = t1.getText().toString();
                String pwd = t2.getText().toString();
                // Database connection details
                String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
                String username = "21331A0592";
                String password = "Ktanooj_592";
                // JDBC variables for managing the connection and executing queries
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    // 1. Load the JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 2. Establish the connection
                    conn = DriverManager.getConnection(jdbcUrl, username, password);

                    // 3. Define the SQL SELECT statement
                    String selectSQL = "SELECT Emailid, Passwor FROM user";

                    // 4. Create a prepared statement
                    pstmt = conn.prepareStatement(selectSQL);

                    // 5. Execute the SELECT statement and get the result set
                    rs = pstmt.executeQuery();
                    String Emailid, Passwor;

                    // 6. Process the result set
                    while (rs.next()) {
                        // Retrieve data from the result set
                        Emailid = rs.getString(1);
                        Passwor = rs.getString(2);
                        // Check if the input matches any record in the database
                        if ((Email.equals(Emailid)) && (pwd.equals(Passwor))) {
                            match = true;
                            break;
                        }
                    }
                    // Close resources
                    pstmt.close();
                    conn.close();

                } catch (SQLException | ClassNotFoundException e) {
                    // Show error message if an exception occurs
                    JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // 7. Close the connection and resources
                    try {
                        if (rs != null) rs.close();
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException e) {
                        // Show error message if an exception occurs
                        JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // If credentials match, open the SignIn window
                if (match) {
                    dispose();
                    SignIn s = new SignIn(Email);
                    s.setVisible(true);
                    s.setBounds(400, 200, 500, 300);
                } else {
                    // Show error message if credentials do not match
                    JOptionPane.showMessageDialog(null, "Invalid User or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener for the Sign Up button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(400, 40, 400, 600);
            }
        });
    }
}
------
class Login extends JFrame {
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;

    Login() {
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and set properties for the login label
        l1 = new JLabel("LOGIN");
        l1.setFont(new Font("Times new Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 10, 300, 30);
        add(l1);

        // Initialize text fields for user input
        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        // Initialize buttons for Sign In and Sign Up actions
        b1 = new JButton("SignIn");
        b2 = new JButton("SignUp");

        // Set bounds for the text fields and buttons
        t1.setBounds(100, 60, 120, 30);
        t2.setBounds(100, 100, 120, 30);
        b1.setBounds(120, 140, 80, 30);
        b2.setBounds(120, 180, 80, 30);

        // Initialize and set properties for username and password labels
        l2 = new JLabel("UserName");
        l2.setBounds(20, 60, 70, 30);
        add(l2);
        l3 = new JLabel("Password");
        l3.setBounds(20, 100, 70, 30);
        add(l3);

        // Add components to the frame
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        // Add action listener for the Sign In button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean match = false;
                // Get user input from text fields
                String User = t1.getText().toString();
                String pwd = t2.getText().toString();
                // Database connection details
                String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
                String username = "21331A0592";
                String password = "Ktanooj_592";
                // JDBC variables for managing the connection and executing queries
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    // 1. Load the JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 2. Establish the connection
                    conn = DriverManager.getConnection(jdbcUrl, username, password);

                    // 3. Define the SQL SELECT statement
                    String selectSQL = "SELECT Userid, Passwor FROM user u1 JOIN User_Profile u2 ON u1.Emailid = u2.Emailid";

                    // 4. Create a prepared statement
                    pstmt = conn.prepareStatement(selectSQL);

                    // 5. Execute the SELECT statement and get the result set
                    rs = pstmt.executeQuery();
                    String Userid, Passwor;

                    // 6. Process the result set
                    while (rs.next()) {
                        // Retrieve data from the result set
                        Userid = rs.getString(1);
                        Passwor = rs.getString(2);
                        // Check if the input matches any record in the database
                        if ((User.equals(Userid)) && (pwd.equals(Passwor))) {
                            match = true;
                            break;
                        }
                    }
                    // Close resources
                    pstmt.close();
                    conn.close();

                } catch (SQLException | ClassNotFoundException e) {
                    // Show error message if an exception occurs
                    JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // 7. Close the connection and resources
                    try {
                        if (rs != null) rs.close();
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException e) {
                        // Show error message if an exception occurs
                        JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // If credentials match, open the SignIn window
                if (match) {
                    dispose();
                    SignIn s = new SignIn(User);
                    s.setVisible(true);
                    s.setBounds(400, 200, 500, 300);
                } else {
                    // Show error message if credentials do not match
                    JOptionPane.showMessageDialog(null, "Invalid User or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener for the Sign Up button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(400, 40, 400, 600);
            }
        });
    }
}
-----------

class SignIn extends JFrame {
    JButton b1, b2, b3, b4, back, lg;
    JLabel l1;
    String Emailid, UserId;

    SignIn(String Email) {
        Emailid = Email;
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize buttons with action labels
        b1 = new JButton("Posts");
        b2 = new JButton("Messages");
        b3 = new JButton("Notifications");
        b4 = new JButton("Friends");
        back = new JButton("Back");
        lg = new JButton("Logout");

        // Set bounds for buttons
        b1.setBounds(170, 70, 120, 30);
        b2.setBounds(170, 110, 120, 30);
        b3.setBounds(170, 150, 120, 30);
        b4.setBounds(170, 190, 120, 30);
        back.setBounds(10, 10, 70, 30);
        lg.setBounds(380, 10, 90, 30);

        // Add buttons to the frame
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(back);
        add(lg);

        // Database connection details
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
        String dbUsername = "21331A0592";
        String dbPassword = "Ktanooj_592";
        // JDBC variables for managing the connection and executing queries
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // 3. Define the SQL SELECT statement
            String selectSQL = "SELECT Emailid, Userid FROM User_Profile";

            // 4. Create a prepared statement
            pstmt = conn.prepareStatement(selectSQL);

            // 5. Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();
            String mail, Userid;
            // 6. Process the result set
            while (rs.next()) {
                // Retrieve data from the result set
                mail = rs.getString(1);
                Userid = rs.getString(2);
                // Check if the email matches
                if (Emailid.equals(mail)) {
                    UserId = Userid;
                    break;
                }
            }
            // Close resources
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            // Show error message if an exception occurs
            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 7. Close the connection and resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // Show error message if an exception occurs
                JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initialize and set properties for user ID label
        l1 = new JLabel(UserId);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(180, 10, 400, 30);
        add(l1);

        // Add action listeners to buttons
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Posts i = new Posts(UserId);
                i.setBounds(370, 150, 700, 500);
                i.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Messages r = new Messages(UserId);
                r.setBounds(400, 200, 400, 300);
                r.setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Notifications r = new Notifications(UserId);
                r.setBounds(370, 150, 700, 500);
                r.setVisible(true);
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Friends r = new Friends(UserId);
                r.setBounds(350, 50, 700, 650);
                r.setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Login r = new Login();
                r.setBounds(400, 200, 400, 300);
                r.setVisible(true);
            }
        });

        lg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Login r = new Login();
                r.setBounds(400, 200, 400, 300);
                r.setVisible(true);
            }
        });
    }
}
-------------

class Posts extends JFrame {
    DefaultTableModel model;
    JPanel p1;
    JTable table;
    JScrollPane sp;
    JButton b2;
    String UserIdnty;

    Posts(String UserId) {
        UserIdnty = UserId;
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and position the 'Back' button
        b2 = new JButton("Back");
        b2.setBounds(10, 10, 70, 20);
        add(b2);

        // Add action listener to the 'Back' button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignIn f = new SignIn(UserId);
                f.setVisible(true);
                f.setBounds(400, 200, 500, 300);
            }
        });

        // Initialize and position the JPanel for table display
        p1 = new JPanel();
        p1.setBounds(50, 60, 500, 300);
        add(p1);

        // Database connection details
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
        String username = "21331A0592";
        String password = "Ktanooj_592";
        // JDBC variables for managing the connection and executing queries
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL SELECT statement
            String selectSQL = "SELECT A.postid, caption, COUNT(lstatus) AS Reactions, COUNT(ctype) AS Comments " +
                               "FROM post AS A " +
                               "LEFT JOIN post_contains_likes B ON A.postid = B.postid " +
                               "LEFT JOIN post_contains_comments C ON A.postid = C.postid " +
                               "GROUP BY A.postid;";

            // 4. Create a prepared statement
            pstmt = conn.prepareStatement(selectSQL);

            // 5. Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();

            // Initialize table model and set column names
            table = new JTable();
            model = (DefaultTableModel) table.getModel();
            String[] colName = {"postid", "caption", "Reactions", "Comments"};
            model.setColumnIdentifiers(colName);

            // 6. Process the result set and populate the table model
            while (rs.next()) {
                String postid = rs.getString(1);
                String caption = rs.getString(2);
                String reactions = rs.getString(3);
                String comments = rs.getString(4);
                String[] row = {postid, caption, reactions, comments};
                model.addRow(row);
            }
            // Close resources
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            // Show error message if an exception occurs
            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 7. Close the connection and resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // Show error message if an exception occurs
                JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initialize JScrollPane to hold the table and set its properties
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(450, 250));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add JScrollPane to the JPanel
        p1.add(sp);
    }
}

--------------

class Messages extends JFrame {
    JButton b1, b2, b3;
    JLabel l1;
    String UserIdnty;

    Messages(String UserId) {
        UserIdnty = UserId;
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and position the 'Send' button
        b1 = new JButton("Send");
        b1.setBounds(120, 90, 100, 30);
        add(b1);

        // Initialize and position the 'Read' button
        b2 = new JButton("Read");
        b2.setBounds(120, 130, 100, 30);
        add(b2);

        // Initialize and position the 'Back' button
        b3 = new JButton("Back");
        b3.setBounds(10, 10, 60, 20);
        add(b3);

        // Initialize and position the label to display the User ID
        l1 = new JLabel(UserIdnty);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(150, 10, 400, 30);
        add(l1);

        // Add action listener for the 'Back' button
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignIn f = new SignIn(UserIdnty);
                f.setVisible(true);
                f.setBounds(400, 200, 400, 300);
            }
        });

        // Add action listener for the 'Send' button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                send f = new send(UserIdnty);
                f.setVisible(true);
                f.setBounds(400, 35, 600, 600);
            }
        });

        // Add action listener for the 'Read' button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                read f = new read(UserIdnty);
                f.setVisible(true);
                f.setBounds(370, 150, 700, 500);
            }
        });
    }
}

------------------------

class send extends JFrame {
    JLabel l1, l2;
    JTextField t1;
    TextArea t2;
    JButton b1, back;
    String UserIdnty;

    send(String UserId) {
        UserIdnty = UserId;
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and position the labels
        l1 = new JLabel("UserId");
        l2 = new JLabel("Message");
        l1.setBounds(30, 60, 100, 30);
        l2.setBounds(30, 100, 100, 30);
        add(l1);
        add(l2);

        // Initialize and position the text fields
        t1 = new JTextField(20);
        t2 = new TextArea();
        t2.setBounds(130, 100, 300, 300);
        t1.setBounds(130, 60, 100, 30);
        add(t1);
        add(t2);

        // Initialize and position the buttons
        b1 = new JButton("Send");
        b1.setBounds(170, 440, 100, 30);
        add(b1);

        back = new JButton("Back");
        back.setBounds(10, 10, 70, 20);
        add(back);

        // Add action listener for the 'Back' button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Messages f = new Messages(UserIdnty);
                f.setVisible(true);
                f.setBounds(400, 200, 400, 300);
            }
        });

        // Add action listener for the 'Send' button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Check if fields are empty
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill all the Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    // JDBC URL, username, and password of MySQL server
                    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
                    String username = "21331A0592";
                    String password = "Ktanooj_592";
                    // JDBC variables for managing the connection and executing queries
                    Connection conn = null;
                    PreparedStatement pstmt = null;

                    try {
                        // 1. Load the JDBC driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // 2. Establish the connection
                        conn = DriverManager.getConnection(jdbcUrl, username, password);

                        // 3. Define the SQL insert statement
                        String insertSQL = "INSERT INTO User_messages(Userid, Mtype, receiver) VALUES (?, ?, ?)";

                        // 4. Create a prepared statement
                        pstmt = conn.prepareStatement(insertSQL);

                        // 5. Set the values for the placeholders in the SQL statement
                        pstmt.setString(1, UserIdnty); // Sender ID
                        pstmt.setString(2, t2.getText().toString()); // Message content
                        pstmt.setString(3, t1.getText().toString()); // Receiver ID

                        // 6. Execute the insert statement
                        int rowsInserted = pstmt.executeUpdate();

                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Your message has been sent successfully");
                            // Clear the fields
                            t1.setText("");
                            t2.setText("");
                        }

                    } catch (SQLException | ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        // 7. Close the connection and resources
                        try {
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
}
-------------------

class read extends JFrame {
    DefaultTableModel model;
    JPanel p1;
    JTable table;
    JScrollPane sp;
    JButton b2;
    String UserIdnty;

    read(String UserId) {
        UserIdnty = UserId;
        // Set the layout manager to null for absolute positioning
        setLayout(null);
        // Ensure the application exits when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize and position the 'Back' button
        b2 = new JButton("Back");
        b2.setBounds(10, 10, 70, 20);
        add(b2);

        // Add action listener for the 'Back' button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignIn f = new SignIn(UserId);
                f.setVisible(true);
                f.setBounds(400, 200, 500, 300);
            }
        });

        // Initialize and position the panel for the table
        p1 = new JPanel();
        p1.setBounds(90, 50, 500, 300);
        add(p1);

        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
        String username = "21331A0592";
        String password = "Ktanooj_592";

        // JDBC variables for managing the connection and executing queries
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL SELECT statement
            String selectSQL = "SELECT * FROM User_messages;";

            // 4. Create a prepared statement
            pstmt = conn.prepareStatement(selectSQL);

            // 5. Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();

            // Initialize the table and model
            table = new JTable(model);
            model = (DefaultTableModel) table.getModel();
            String[] colName = {"Sender", "Message"};
            model.setColumnIdentifiers(colName);

            // 6. Process the result set
            String Sender, Message, receiver;
            while (rs.next()) {
                // Retrieve data from the result set
                Sender = rs.getString(1);
                Message = rs.getString(2);
                receiver = rs.getString(3);
                
                // Display only messages for the current user
                if (UserIdnty.equals(receiver)) {
                    String[] row = {Sender, Message};
                    model.addRow(row);
                }
            }

            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 7. Close the connection and resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initialize and position the scroll pane for the table
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(450, 250));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
    }
}

--------------------------

class Notifications extends JFrame {
    DefaultTableModel model;
    JPanel p1;
    JTable table;
    JScrollPane sp;
    JButton b2;
    String UserIdnty;

    Notifications(String UserId) {
        UserIdnty = UserId;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b2 = new JButton("Back");
        b2.setBounds(10, 10, 70, 20);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignIn f = new SignIn(UserId);
                f.setVisible(true);
                f.setBounds(400, 200, 500, 300);
            }
        });

        p1 = new JPanel();
        p1.setBounds(90, 50, 500, 300);
        add(p1);

        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
        String username = "21331A0592";
        String password = "Ktanooj_592";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL SELECT statement
            String selectSQL = "SELECT un.Userid, n.content, un.Time_stamp, un.status FROM Notifications n NATURAL JOIN User_Notify un;";

            // 4. Create a prepared statement
            pstmt = conn.prepareStatement(selectSQL);

            // 5. Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();

            // Initialize table and model
            table = new JTable(model);
            model = (DefaultTableModel) table.getModel();
            String[] colName = {"Notifications", "Time", "Status"};
            model.setColumnIdentifiers(colName);

            // 6. Process the result set
            while (rs.next()) {
                // Retrieve data from the result set
                String Userid = rs.getString(1);
                String Notifications = rs.getString(2);
                String Time = rs.getString(3);
                String Status = rs.getString(4);
                if (UserIdnty.equals(Userid)) {
                    String[] row = {Notifications, Time, Status};
                    model.addRow(row);
                }
            }

            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 7. Close the connection and resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initialize and add scroll pane
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(450, 250));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp);
    }
}
-------------------------

class Friends extends JFrame {
    DefaultTableModel model1, model2;
    JPanel p1, p2;
    JTable table1, table2;
    JScrollPane sp1, sp2;
    JButton b2;
    String UserIdnty;

    Friends(String UserId) {
        UserIdnty = UserId;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b2 = new JButton("Back");
        b2.setBounds(10, 10, 70, 20);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignIn f = new SignIn(UserId);
                f.setVisible(true);
                f.setBounds(400, 200, 500, 300);
            }
        });

        p1 = new JPanel();
        p1.setBounds(90, 50, 500, 200);
        add(p1);
        p2 = new JPanel();
        p2.setBounds(90, 350, 500, 200);
        add(p2);

        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
        String username = "21331A0592";
        String password = "Ktanooj_592";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. Define the SQL SELECT statement
            String selectSQL = "SELECT * FROM User_Manage_Friendlist;";

            // 4. Create a prepared statement
            pstmt = conn.prepareStatement(selectSQL);

            // 5. Execute the SELECT statement and get the result set
            rs = pstmt.executeQuery();

            // Initialize tables and models
            table1 = new JTable(model1);
            model1 = (DefaultTableModel) table1.getModel();
            String[] colName1 = {"Friends"};
            model1.setColumnIdentifiers(colName1);

            table2 = new JTable(model2);
            model2 = (DefaultTableModel) table2.getModel();
            String[] colName2 = {"Friends", "Status"};
            model2.setColumnIdentifiers(colName2);

            // 6. Process the result set
            String Accept = "Accepted";
            String NotAccept = "Not Accepted";
            while (rs.next()) {
                // Retrieve data from the result set
                String Userid = rs.getString(1);
                String Friends = rs.getString(2);
                String Status = rs.getString(3);
                if (UserIdnty.equals(Userid)) {
                    if (Accept.equals(Status)) {
                        String[] row1 = {Friends};
                        model1.addRow(row1);
                    } else if (NotAccept.equals(Status)) {
                        String[] row2 = {Friends, Status};
                        model2.addRow(row2);
                    }
                }
            }

            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 7. Close the connection and resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initialize and add scroll panes
        sp1 = new JScrollPane(table1);
        sp1.setPreferredSize(new Dimension(450, 180));
        sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(sp1);

        sp2 = new JScrollPane(table2);
        sp2.setPreferredSize(new Dimension(450, 180));
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p2.add(sp2);
    }
}

-----------------


class SignUp extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b1, b2;

    SignUp() {
        // Set layout manager and close operation for the JFrame
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and set properties for the "Create Account" label
        l9 = new JLabel("Create Account");
        l9.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l9.setForeground(Color.BLUE);
        l9.setBounds(30, 40, 450, 30);
        add(l9);

        // Create and set properties for labels
        l1 = new JLabel("Name");
        l2 = new JLabel("Age");
        l3 = new JLabel("DOB");
        l4 = new JLabel("Emailid");
        l5 = new JLabel("Password"); // Fixed the typo "Passwor" to "Password"
        l6 = new JLabel("PhoneNumber");
        l7 = new JLabel("Gender");
        l8 = new JLabel("Location");

        // Set positions and sizes for labels
        l1.setBounds(100, 80, 100, 30);
        l2.setBounds(100, 120, 100, 30);
        l3.setBounds(100, 160, 100, 30);
        l4.setBounds(100, 200, 100, 30);
        l5.setBounds(100, 240, 100, 30);
        l6.setBounds(100, 280, 100, 30);
        l7.setBounds(100, 320, 100, 30);
        l8.setBounds(100, 360, 100, 30);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);

        // Create and set properties for text fields
        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);
        t4 = new JTextField(30);
        t5 = new JTextField(30);
        t6 = new JTextField(30);
        t7 = new JTextField(30);
        t8 = new JTextField(30);

        // Set positions and sizes for text fields
        t1.setBounds(200, 80, 100, 30);
        t2.setBounds(200, 120, 100, 30);
        t3.setBounds(200, 160, 100, 30);
        t4.setBounds(200, 200, 100, 30);
        t5.setBounds(200, 240, 100, 30);
        t6.setBounds(200, 280, 100, 30);
        t7.setBounds(200, 320, 100, 30);
        t8.setBounds(200, 360, 100, 30);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(t8);

        // Create and set properties for the "Submit" button
        b1 = new JButton("Submit");
        b1.setBounds(160, 420, 100, 30);
        add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Check if required fields are empty
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill all the Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    // JDBC URL, username, and password of MySQL server
                    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/pbl";
                    String username = "21331A0592";
                    String password = "Ktanooj_592";

                    // JDBC variables for managing the connection and executing queries
                    Connection conn = null;
                    PreparedStatement pstmt = null;

                    try {
                        // 1. Load the JDBC driver
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        // 2. Establish the connection
                        conn = DriverManager.getConnection(jdbcUrl, username, password);

                        // 3. Define the SQL insert statement
                        String insertSQL = "INSERT INTO user(Name, Age, DOB, Emailid, password, PhoneNumber, Gender, Location) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                        // 4. Create a prepared statement
                        pstmt = conn.prepareStatement(insertSQL);

                        // 5. Set the values for the placeholders in the SQL statement
                        pstmt.setString(1, t1.getText()); // Name
                        pstmt.setString(2, t2.getText()); // Age
                        pstmt.setString(3, t3.getText()); // DOB
                        pstmt.setString(4, t4.getText()); // Emailid
                        pstmt.setString(5, t5.getText()); // Password
                        pstmt.setString(6, t6.getText()); // PhoneNumber
                        pstmt.setString(7, t7.getText()); // Gender
                        pstmt.setString(8, t8.getText()); // Location

                        // 6. Execute the insert statement
                        int rowsInserted = pstmt.executeUpdate();

                        if (rowsInserted > 0) {
                            // Show success message and clear text fields
                            JOptionPane.showMessageDialog(null, "Inserted Successfully");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            t6.setText("");
                            t7.setText("");
                            t8.setText("");
                        }

                    } catch (SQLException | ClassNotFoundException e) {
                        // Show error message
                        JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        // 7. Close the connection and resources
                        try {
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            // Show error message
                            JOptionPane.showMessageDialog(null, "Verify the Data", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        // Create and set properties for the "Back" button
        b2 = new JButton("Back");
        b2.setBounds(10, 10, 80, 20);
        add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Close current frame and open Login frame
                dispose();
                Login f = new Login();
                f.setVisible(true);
                f.setBounds(400, 200, 400, 300);
            }
        });
    }
}

public class dbms extends JFrame {
    public static void main(String[] args) {
        // Create and display the Login frame
        Login f = new Login();
        f.setVisible(true);
        f.setBounds(400, 100, 320, 300);
    }
}

