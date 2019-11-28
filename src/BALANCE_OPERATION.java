
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
public class BALANCE_OPERATION extends JFrame implements ActionListener {

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //BALANCE VARS, COUNTERS, MEASUREMENTS
    public static double BAL = 0;//balance for chequings
    public static double SBAL = 0;//balance for savings
    private static int scounter= 0;//counter for tax on savings
    private static int ccounter= 10;//counter for tax on chequings
    private static final int frameWidth = 400;
    private static final int frameHeight = 200;

    private static final int xPosition = 700;
    private static final int yPosition = 500;

    //BUTTON MEASUREMENTS
    private static final int buttonWidth = 80;
    private static final int buttonHeight = 50;
    private Container balPane = getContentPane();
    private JLabel prompt;
    private JLabel prompt2;
    private JButton homeButton;
    private DecimalFormat df = new DecimalFormat("0.00");

    //CONSTRUCTOR FOR CHEQUINGS
    public BALANCE_OPERATION(){

        //CREATING BALANCE FRAME FOR CHEQUING
        setTitle("CHEQUINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        balPane.setLayout(new FlowLayout());

        //COLOR
        balPane.setBackground(customGrey);

        prompt = new JLabel();
        String balOut = Double.toString(BAL);
        prompt.setText("BALANCE: " + balOut + "                                          ");
        prompt.setSize(150, 25);
        balPane.add(prompt);

        homeButton = new JButton("HOME");
        homeButton.setSize( buttonWidth, buttonHeight);//NEW JBUTTON
        homeButton.setLocation(100, 300);
        homeButton.setBackground(customTeal);
        balPane.add(homeButton);

        homeButton.addActionListener(this);//ACTION LISTENER
    }

    //CONSTRUCTOR FOR SAVINGS BALANCE
    public BALANCE_OPERATION(String s){

        //FRAME SET
        setTitle("SAVINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT MANAGER
        balPane.setLayout(new FlowLayout());

        //COLOR
        balPane.setBackground(customGrey);

        prompt = new JLabel();
        String balOut = Double.toString(SBAL);
        prompt.setText("BALANCE: " + balOut + "                                          ");
        prompt.setSize(150, 25);
        balPane.add(prompt);

        homeButton = new JButton("HOME");
        homeButton.setSize( buttonWidth, buttonHeight);
        homeButton.setLocation(100, 300);
        homeButton.setBackground(customTeal);
        balPane.add(homeButton);

        homeButton.addActionListener(this);//ACTION LISTENER
    }

    //ACTION LISTENER METHOD
    public void actionPerformed(ActionEvent evt){

        //EVENT HANDLING STATEMENTS
        JButton clickedButton = (JButton) evt.getSource();
        if(clickedButton.equals(homeButton)){//IF HOME
            this.dispose();//CLOSES
            START_FRAME fram = new START_FRAME();//NEW HOME FRAME
            fram.setVisible(true);

        }
    }

    //METHOD FOR TRANSFER FUNDS
    public boolean transfer(double n, int type){

        if(n>BAL && type ==0){//CHECK FOR TYPE AND SUFFICIENT FUNDS, RETURNS FALSE IF NOT
            return false;
        }
        if(n>SBAL && type ==1){//CHECK FOR TYPE AND SUFFICIENT FUNDS, RETURNS FALSE IF NOT
            return false;
        }
        if(type ==0){//TYPE CHECK
            SBAL= SBAL +n;//NEW BAL
            BAL = BAL - n;
        }
        if(type ==1){//TYPE CHECK
            BAL = BAL +n;//NEW BAL
            SBAL = SBAL - n;
        }
        return true;//RETURNS TRUE IF FUNDS TRANSFERRED SUCCESSFULLY
    }

    public boolean setBal(double n, int type, boolean with){//method to set balance

        if(type==0){//checks to see type of account
            ccounter--;//lowers counter by 1
            BAL = BAL + n;//sets bal
        }
        else{
            scounter++;//adds counter by 1
            SBAL = SBAL + n;//sets s bal
        }
        if(ccounter>0 && type ==0 && with){//checks for type, that it is a withdrawal, and if ccounter is less than 0
            BAL=BAL-0.50;//decreases bal by 0.5
        }
        if(scounter>4 && with){//checks to see if it is a withdrawal and if counter is greater than 4
            SBAL=SBAL-1;//decreases sbal by 1
        }

        if(BAL<0){
            BAL = BAL + n *-1;//if funds are insufficient sets bal to original value, and returns false
            BAL = BAL + 0.5;
            ccounter++;
            return false;
        }
        else if(SBAL<0){
            SBAL = SBAL + n *-1;//if funds are insufficient sets sbal to original value, and returns false
            if(scounter>4){
                SBAL = SBAL + 1;
            }
            scounter--;
            return false;
        }
        return true;//returns true
    }
}



