
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TRANSFER_OPERATION extends GLOBAL_BALANCE implements ActionListener {

    Color customTeal = new Color(95, 158, 160);
    Color customGrey = new Color(119,136,153);

    private static final int frameWidth = 400;
    private static final int frameHeight = 200;
    private static final int xPosition = 700;
    private static final int yPosition = 500;
    private int type = 0;

    private static final int buttonWidth = 80;
    private static final int buttonHeight = 50;
    private Container withPane = getContentPane();

    private JTextField inputLine;
    private JLabel prompt;
    private JLabel prompt2;
    private JButton okButton;
    private JLabel prompt3;
    private JLabel prompt4;

    //CONSTRUCTOR FOR CHEQUING
    public TRANSFER_OPERATION(){
        type =0;//MEANING CHEQUING
        setTitle("CHEQUINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        prompt = new JLabel();//JLABEL
        prompt.setText("TRANSFER TO SAVINGS: ");
        prompt.setSize(150, 25);
        withPane.add(prompt);

        inputLine = new JTextField();//TEXTFIELD
        inputLine.setColumns(22);
        inputLine.setFont(new Font("Arial", Font.PLAIN, 14));
        withPane.add(inputLine);

        okButton = new JButton("RETURN");//BUTTON
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

        prompt4 = new JLabel();//JLABEL
        prompt4.setText("FUNDS TRANSFERRED TO CHEQUING");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //ACTION LISTENERS
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);
    }

    //CONSTRUCTOR FOR SAVINGS
    public TRANSFER_OPERATION(String s){
        type =1;//TYPE TO 1, SAVINGS ACCOUNT
        setTitle("SAVINGS");
        setSize(frameWidth, frameHeight);
        setLocation(150, 250);
        setResizable(false);

        //LAYOUT
        withPane.setLayout(new FlowLayout());

        //COLOR
        withPane.setBackground(customGrey);

        prompt = new JLabel();//JLABEL
        prompt.setText("TRANSFER TO CHEQUING: ");//new jlabel
        prompt.setSize(150, 25);
        withPane.add(prompt);

        inputLine = new JTextField();//TEXT FIELD
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

        prompt4 = new JLabel();//JLABEL
        prompt4.setText("FUNDS TRANSFERRED TO CHEQUING");
        prompt4.setSize(150, 25);
        withPane.add(prompt4);
        prompt4.setVisible(false);

        //NEW ACTION LISTENERS
        okButton.addActionListener(this);
        inputLine.addActionListener(this);
        withPane.setVisible(true);

    }

    //METHOD FOR ACTION LISTENERS
    public void actionPerformed(ActionEvent evt){
        prompt3.setVisible(false);
        prompt4.setVisible(false);
        prompt2.setVisible(false);

        //BUTTON EVENT CHECK
        if(evt.getSource() instanceof JButton){
            JButton clickedButton = (JButton) evt.getSource();
            this.dispose();//CLOSES
            START_FRAME fram = new START_FRAME();
            fram.setVisible(true);
        }
        else{//RUNS IF EVENT WAS NOT A BUTTON PRESS
            String buttonText = inputLine.getText();//RETRIEVES INPUT
            try{
                double withIn = Double.parseDouble(buttonText);//CONVERTS INPUT TO DOUBLE
                withIn = withIn *100;
                withIn = Math.round(withIn);
                withIn= withIn/100;
                if(withIn<=0){//CHECKS TO SEE IF VALUE BELOW ZERO
                    prompt3.setVisible(true);//GIVES THEM A PROMPT IF INVALID INPUT
                }
                else{//IF VALID INPUT
                    boolean q;
                    q = b.transfer(withIn, type);//CALLS TRANSFER METHOD FROM BALANCE

                    if(!q){
                        prompt2.setVisible(true);//SETS PROMPT 2 IF INSUFFICIENT FUNDS
                    }
                    else{
                        prompt2.setVisible(false);//SETS PROMPT 2 TO INVISIBLE
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
