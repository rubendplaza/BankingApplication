import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CHEQUING_GUI extends GLOBAL_BALANCE implements ActionListener{

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //INITIALIZES ALL THE VARIABLES FOR FRAME
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 125;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    //VARIABLE MEASUREMENTS FOR BUTTONS
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 50;

    public JButton cancelButton;
    public JButton okButton;
    public JButton withdrawlButton;
    public JButton depositButton;
    public JButton balButton;
    public JButton homeButton;
    public JButton transButton;

    //CHEQUING CONSTRUCTOR
    public CHEQUING_GUI(){

        //CREATES CHEQUING CONTENT PANE
        Container cheqPane = getContentPane();

        setTitle("CHEQUINGS");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        //COLOR
        cheqPane.setBackground(customGrey);

        //SETS LAYOUT MANAGER FOR CHEQUING TAB
        cheqPane.setLayout(new FlowLayout());

        //CREATES AND PLACES THOSE BUTTONS WITHIN CHEQUING
        withdrawlButton = new JButton("WITHDRAW");
        withdrawlButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        withdrawlButton.setLocation(100, 100);
        cheqPane.add(withdrawlButton);
        withdrawlButton.setBackground(customTeal);

        depositButton = new JButton("DEPOSIT");
        depositButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        depositButton.setLocation(100, 100);
        cheqPane.add(depositButton);
        depositButton.setBackground(customTeal);

        transButton = new JButton("TRANSFER");
        transButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        transButton.setLocation(100, 100);
        cheqPane.add(transButton);
        transButton.setBackground(customTeal);

        balButton = new JButton("BALANCE");
        balButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        balButton.setLocation(100, 100);
        cheqPane.add(balButton);
        balButton.setBackground(customTeal);

        homeButton = new JButton("HOME");
        homeButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        homeButton.setLocation(100, 100);
        cheqPane.add(homeButton);
        homeButton.setBackground(customTeal);



        //CREATES ACTION LISTENERS FOR THESE OBJECTS
        cheqPane.setVisible(true);//MAKES VISIBLE
        homeButton.addActionListener(this);
        withdrawlButton.addActionListener(this);
        transButton.addActionListener(this);
        balButton.addActionListener(this);
        depositButton.addActionListener(this);

    }

    //METHOD FOR ACTION LISTENER
    public void actionPerformed(ActionEvent evt){

        //EVENT HANDLING STATEMENTS
        JButton clickedButton = (JButton) evt.getSource();
        if(clickedButton.equals(homeButton)){//CHECKS IF PRESSED
            this.dispose();
            START_FRAME fram = new START_FRAME();//BACK TO START FRAME
            fram.setVisible(true);

        }
        if(clickedButton.equals(depositButton)){//IF DEPOSIT PRESSED
            this.dispose();
            DEPOSIT_OPERATION dep = new DEPOSIT_OPERATION();//MAKES NEW DEPOSIT FRAME
            dep.setVisible(true);

        }
        if(clickedButton.equals(transButton)){//IF TRANSFER PRESSED
            this.dispose();
            TRANSFER_OPERATION tra = new TRANSFER_OPERATION();//MAKES NEW TRANSFER FRAME
            tra.setVisible(true);

        }
        if(clickedButton.equals(withdrawlButton)){//IF WITHDRAW PRESSED
            this.dispose();
            WITHDRAW_OPERATION with = new WITHDRAW_OPERATION();//MAKES NEW WITHDRAW FRAME
            with.setVisible(true);

        }
        if(clickedButton.equals(balButton)){//IF BALANCE PRESSED
            this.dispose();
            BALANCE_OPERATION bal = new BALANCE_OPERATION();//NEW BALANCE FRAME
            bal.setVisible(true);
        }
    }
}