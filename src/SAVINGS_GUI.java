import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SAVINGS_GUI extends GLOBAL_BALANCE implements ActionListener{

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //INITIALIZES VARIABLES FOR FRAME MEASURES
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 125;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static int test =0;
    private static int temp =0;

    //MEASURES FOR BUTTONS
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 50;

    public JButton cancelButton;
    public JButton okButton;
    public JButton withdrawlButton;
    public JButton depositButton;
    public JButton balButton;
    public JButton homeButton;
    public JButton transButton;

    //CONSTRUCTOR FOR SAVINGS TAB
    public SAVINGS_GUI(){

        Container savingsPane = getContentPane();

        ///INITIALIZES FRAME
        setTitle("SAVINGS");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        savingsPane.setBackground(customGrey);

        //MAKES LAYOUT MANAGER FOR BUTTON LAYOUT
        savingsPane.setLayout(new FlowLayout());

        //MAKES AND PLACES BUTTON ON SAVINGS CONTENT PANE
        withdrawlButton = new JButton("WITHDRAW");
        withdrawlButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        withdrawlButton.setLocation(100, 100);
        savingsPane.add(withdrawlButton);
        withdrawlButton.setBackground(customTeal);

        depositButton = new JButton("DEPOSIT");
        depositButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        depositButton.setLocation(100, 100);
        savingsPane.add(depositButton);
        depositButton.setBackground(customTeal);

        transButton = new JButton("TRANSFER");
        transButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        transButton.setLocation(100, 100);
        savingsPane.add(transButton);
        transButton.setBackground(customTeal);

        balButton = new JButton("BALANCE");
        balButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        balButton.setLocation(100, 100);
        savingsPane.add(balButton);
        balButton.setBackground(customTeal);

        homeButton = new JButton("HOME");
        homeButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        homeButton.setLocation(100, 100);
        savingsPane.add(homeButton);
        homeButton.setBackground(customTeal);



        savingsPane.setVisible(true);

        //SETS BUTTONS WITH ACTIONLISTENER
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
        if(clickedButton.equals(homeButton)){//IF HOME PRESSED
            this.dispose();//CLOSES CURRENT TAB
            START_FRAME fram = new START_FRAME();//CREATES NEW START FRAME
            fram.setVisible(true);

        }
        if(clickedButton.equals(depositButton)){//IF DEPOSIT
            this.dispose();//CLOSES TAB
            String q = "s";
            DEPOSIT_OPERATION dep = new DEPOSIT_OPERATION(q);//MAKES NEW DEPOSIT FRAME WITH PARAMETER
            dep.setVisible(true);

        }
        if(clickedButton.equals(transButton)){//IF TRANSFER
            String s ="s";
            this.dispose();//CLOSES CURRENT
            TRANSFER_OPERATION tra = new TRANSFER_OPERATION(s);//CREATES NEW TRANSFER FRAME WITH PARAMETER
            tra.setVisible(true);

        }

        if(clickedButton.equals(balButton)){//IF BALANCE
            String s ="s";
            this.dispose();//CLOSES
            BALANCE_OPERATION bal = new BALANCE_OPERATION(s);//NEW BAL WITH PARA
            bal.setVisible(true);

        }

        if(clickedButton.equals(withdrawlButton)){//IF WITHDRAWAL
            String s ="s";
            this.dispose();//CLOSES
            WITHDRAW_OPERATION with = new WITHDRAW_OPERATION(s);//NEW WITHDRAWAL WITH PARA
            with.setVisible(true);

        }
    }
}