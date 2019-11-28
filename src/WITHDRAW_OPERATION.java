
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WITHDRAW_OPERATION extends GLOBAL_BALANCE implements ActionListener{

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //INITIALIZING VARIABLES
    private static final int frameWidth = 400;
    private static final int frameHeight = 200;
    private static final int xPosition = 700;
    private static final int yPosition = 500;
    private int type = 0;

    //MEASUREMENTS FOR BUTTONS
    private static final int buttonWidth = 80;
    private static final int buttonHeight = 50;
    private Container withPane = getContentPane();

    private JTextField inputLine;
    private JLabel prompt;
    private JLabel prompt2;
    private JLabel prompt3;
    private JLabel prompt4;
    private JButton okButton;

    //WITHDRAWAL CONSTRUCTOR FOR CHEQUING ACCOUNT
    public WITHDRAW_OPERATION(){
        type = 0;//TYPE 0, CHEQUINGS TRANSACTION
        setTitle("CHEQUINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        prompt = new JLabel();//JLABEL
        prompt.setText("WITHDRAW FROM CHEQUING: ");
        prompt.setSize(150, 25);
        withPane.add(prompt);

        inputLine = new JTextField();//JTEXTFIELD
        inputLine.setColumns(22);
        inputLine.setFont(new Font("Arial", Font.PLAIN, 14));
        withPane.add(inputLine);

        okButton = new JButton("RETURN");//NEW JBUTTON
        okButton.setSize(buttonWidth, buttonHeight);
        okButton.setBackground(customTeal);
        withPane.add(okButton);

        prompt2 = new JLabel();//NEW JLABEL
        prompt2.setText("INSUFFICIENT FUNDS");
        prompt2.setSize(150, 25);
        withPane.add(prompt2);
        prompt2.setVisible(false);

        prompt3 = new JLabel();//NEW JLABEL
        prompt3.setText("INVALID INPUT");
        prompt3.setSize(150, 25);
        withPane.add(prompt3);
        prompt3.setVisible(false);

        prompt4 = new JLabel();//NEW JLABEL
        prompt4.setText("FUNDS WITHDRAWN FROM CHEQUINGS");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //ADDS ACTION LISTENERS
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);

    }

    //CONSTRUCTOR FOR WITHDRAWAL OF SAVINGS
    public WITHDRAW_OPERATION(String s){
        type =1;//TYPE 1, MEANING SAVINGS
        setTitle("SAVINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        prompt = new JLabel();//JLABEL
        prompt.setText("WITHDRAW FROM SAVINGS: ");
        prompt.setSize(150, 25);
        withPane.add(prompt);

        inputLine = new JTextField();//JTEXTFIELD
        inputLine.setColumns(22);
        inputLine.setFont(new Font("Arial", Font.PLAIN, 14));
        withPane.add(inputLine);

        okButton = new JButton("RETURN");//JBUTTON
        okButton.setSize(buttonWidth, buttonHeight);
        okButton.setBackground(customTeal);
        withPane.add(okButton);

        prompt2 = new JLabel();//JLABEL
        prompt2.setText("INSUFFICIENT FUNDS");
        prompt2.setSize(150, 25);
        withPane.add(prompt2);
        prompt2.setVisible(false);

        prompt3 = new JLabel();//JLABEL
        prompt3.setText("INVALID INPUT");
        prompt3.setSize(150, 25);
        withPane.add(prompt3);
        prompt3.setVisible(false);

        prompt4 = new JLabel();//CREATES JLABEL
        prompt4.setText("FUNDS WITHDRAWN FROM SAVINGS");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //ADDING ACTION LISTENERS
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);

    }

    //ACTION LISTENER METHOD
    public void actionPerformed(ActionEvent evt){
        prompt2.setVisible(false);
        prompt4.setVisible(false);
        prompt3.setVisible(false);//SETS PROMPTS TO INVISIBLE

        if(evt.getSource() instanceof JButton){//IF BUTTON PRESSED
            JButton clickedButton = (JButton) evt.getSource();
            this.dispose();//CLOSES
            START_FRAME fram = new START_FRAME();//NEW START
            fram.setVisible(true);
        }
        else{//RUNS IF ACTION IS NOT BUTTON PRESSED
            String buttonText = inputLine.getText();//GETS INPUT
            try{
                double withIn = Double.parseDouble(buttonText);//CONVERTS INPUT TO DOUBLE
                withIn = withIn *100;
                withIn = Math.round(withIn);
                withIn= withIn/100;
                if(withIn<=0){//CHECKS TO SEE IF VALID INPUT ENTERED
                    prompt3.setVisible(true);//IF INPUT NOT VALID
                }
                else{//IF VALID INPUT
                    withIn= withIn*-1;//SETS VALUE TO NEGATIVE SINCE WITHDRAW
                    boolean q = true;//NEW BOOLEAN
                    q = b.setBal(withIn, type, q);//CALLS ON BALANCE METHOD TO SET NEW METHOD

                    if(!q){//IF Q RETURNED FALSE THEN INPUT WAS INVALID AND TELLS USER
                        prompt2.setVisible(true);
                    }
                    else{
                        prompt2.setVisible(false);
                        prompt4.setVisible(true);
                    }
                }
            }
            catch(Exception e){
                prompt3.setVisible(true);
            }

        }

    }
}




