/*
 * BY: RUBEN PLAZA
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class START_FRAME extends JFrame implements ActionListener{

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //INITIALIZING VARIABLES
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 150;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    //NEW CONTENT PANE
    public Container contentPane = getContentPane();

    //BUTTON HEIGHT AND WIDTH
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 50;

    //THE DIFFERENT BUTTONS MADE AVAILABLE
    public JButton cancelButton;
    public JButton okButton;
    public JButton withdrawlButton;
    public JButton depositButton;
    public JButton balButton;
    public JButton homeButton;
    public JButton transButton;

    //HOME FRAME CONSTRUCTOR
    public START_FRAME(){

        //INHERITED JFRAME METHODS
        setTitle("PERSONAL BANKING");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        //COLOR
        contentPane.setBackground(customGrey);

        //LAYOUT TYPE SET
        contentPane.setLayout(new GridLayout());

        //CREATES AND PLACES TWO BUTTONS ON CONTENT PANE

        //SAVINGS BUTTON
        okButton = new JButton("SAVINGS ACCOUNT");
        okButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        okButton.setLocation(100, 100);
        contentPane.add(okButton);

        //COLOR
        okButton.setBackground(customTeal);

        //CHEQUING BUTTON
        cancelButton = new JButton("CHEQUING ACCOUNT");
        cancelButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        cancelButton.setLocation(100, 100);
        contentPane.add(cancelButton);

        cancelButton.setBackground(customTeal);

        //REGISTERING A BUTTONHANDLER AS AN ACTIONHANDLER TO THE BUTTONS
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //ACTION LISTENER METHOD
    public void actionPerformed(ActionEvent evt){

        //EVENT HANDLING STATEMENTS

        JButton clickedButton = (JButton) evt.getSource();
        if(clickedButton.equals(okButton)){//CHECKS IF OK BUTTON IS PRESSED

            this.dispose();//CLOSES FRAME
            SAVINGS_GUI sav = new SAVINGS_GUI();//MAKES NEW FRAME
            sav.setVisible(true);

        }

        if(clickedButton.equals(cancelButton)){//CHECKS IF CANCEL BUTTON IS PRESSED

            this.dispose();//CLOSES FRAME
            CHEQUING_GUI che = new CHEQUING_GUI();//MAKES NEW FRAME
            che.setVisible(true);

        }
    }

    //CREATES INITIAL FRAME
    public static void main(String [] args){
        START_FRAME frame = new START_FRAME();
        frame.setVisible(true);
        //SETS VISIBLE

    }
}
