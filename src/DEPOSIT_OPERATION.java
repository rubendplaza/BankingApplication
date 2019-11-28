
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DEPOSIT_OPERATION extends GLOBAL_BALANCE implements ActionListener {

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    //INITIALIZING VARIABLES
    private static final int frameWidth = 400;
    private static final int frameHeight = 200;
    private static final int xPosition = 700;
    private static final int yPosition = 500;
    private int type = 0;

    //BUTTON STUFF
    private static final int buttonWidth = 80;
    private static final int buttonHeight = 50;
    private Container withPane = getContentPane();

    private JTextField inputLine;
    private JLabel prompt;
    private JLabel prompt2;
    private JButton okButton;
    private JLabel prompt3;
    private JLabel prompt4;

    //CONSTRUCTOR FOR CHEQUINGS
    public DEPOSIT_OPERATION(){

        type = 0;//SET TYPE TO 0, = CHEQUING ACCOUNT
        setTitle("CHEQUINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        //NEW JLABEL
        prompt = new JLabel();
        prompt.setText("DEPOSIT INTO CHEQUINGS: ");
        prompt.setSize(150, 25);
        withPane.add(prompt);

        //NEW TEXT FIELD
        inputLine = new JTextField();
        inputLine.setColumns(22);
        inputLine.setFont(new Font("Arial", Font.PLAIN, 14));
        withPane.add(inputLine);

        //NEW OKAY BUTTON
        okButton = new JButton("RETURN");
        okButton.setSize(buttonWidth, buttonHeight);
        okButton.setBackground(customTeal);
        withPane.add(okButton);

        //NEW JLABEL
        prompt3 = new JLabel();
        prompt3.setText("INVALID INPUT");
        prompt3.setSize(150, 25);
        withPane.add(prompt3);
        prompt3.setVisible(false);

        //NEW JLABEL
        prompt4 = new JLabel();
        prompt4.setText("FUNDS DEPOSITED IN CHEQUING");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //ACTION LISTENER SET
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);

    }

    //CONSTRUCTOR FOR SAVINGS
    public DEPOSIT_OPERATION(String s){
        type = 1;//SET TYPE 1, = SAVINGS TRANSACTION
        setTitle("SAVINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //SET LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        //NEW JLABEL
        prompt = new JLabel();
        prompt.setText("DEPOSIT INTO SAVINGS: ");
        prompt.setSize(150, 25);
        withPane.add(prompt);

        //NEW TEXTFIELD
        inputLine = new JTextField();
        inputLine.setColumns(22);
        inputLine.setFont(new Font("Arial", Font.PLAIN, 14));
        withPane.add(inputLine);

        //NEW JBUTTON
        okButton = new JButton("RETURN");
        okButton.setSize(buttonWidth, buttonHeight);
        okButton.setBackground(customTeal);
        withPane.add(okButton);

        //JLABEL
        prompt3 = new JLabel();
        prompt3.setText("INVALID INPUT");
        prompt3.setSize(150, 25);
        withPane.add(prompt3);
        prompt3.setVisible(false);

        //NEW JLABEL
        prompt4 = new JLabel();
        prompt4.setText("FUNDS DEPOSITED IN SAVINGS");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //ACTION LISTENER
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);

    }

    //METHOD FOR ACTION LISTENER
    public void actionPerformed(ActionEvent evt){

        prompt3.setVisible(false);
        prompt4.setVisible(false);

        if(evt.getSource() instanceof JButton){
            JButton clickedButton = (JButton) evt.getSource();
            this.dispose();//CLOSES
            START_FRAME fram = new START_FRAME();//NEW START
            fram.setVisible(true);
        }
        else{
            try{
                String buttonText = inputLine.getText();//GETS INPUT
                double withIn = Double.parseDouble(buttonText);//CONVERTS INPUT TO DOUBLE
                withIn = withIn *100;
                withIn = Math.round(withIn);
                withIn= withIn/100;
                if(withIn<=0){
                    prompt3.setVisible(true);
                }
                else{
                    boolean q = false;
                    q = b.setBal(withIn, type, q);//CALLS METHOD TO SET BALANCE
                    if(q){
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



