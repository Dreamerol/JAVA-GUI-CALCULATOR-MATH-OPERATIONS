import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton mulbutton, divbutton, addbutton, subbutton;
	JButton decbutton, equbutton, delbutton, clrbutton, negbutton;
	JPanel panel;
	
	Font myfont = new Font("Ink free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);
        
        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        decbutton = new JButton(".");
        clrbutton = new JButton("Clr");
        equbutton = new JButton("=");
        delbutton = new JButton("Del");
        negbutton = new JButton("(-)");
        
        functionButtons[0] = addbutton;
        functionButtons[1] = subbutton;
        functionButtons[2] = mulbutton;
        functionButtons[3] = divbutton;
        functionButtons[4] = decbutton;
        functionButtons[5] = equbutton;
        functionButtons[6] = delbutton;
        functionButtons[7] = clrbutton;
        functionButtons[8] = negbutton;
        
        for(int i = 0;i<9;i++) {
        	functionButtons[i].addActionListener(this);
        	functionButtons[i].setFont(myfont);
        	functionButtons[i].setFocusable(false);
        }
        
        for(int i = 0;i<10;i++) {
        	numberButtons[i] = new JButton(String.valueOf(i));
        	numberButtons[i].addActionListener(this);
        	numberButtons[i].setFont(myfont);
        	numberButtons[i].setFocusable(false);
        }
        
        negbutton.setBounds(50, 430, 100, 50);
        delbutton.setBounds(150, 430, 100, 50);
        clrbutton.setBounds(250, 430, 100, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.green);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addbutton);
        
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subbutton);
        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulbutton);
        
        panel.add(decbutton);
        panel.add(numberButtons[0]);
        panel.add(equbutton);
        panel.add(divbutton);
        
        frame.add(panel);
        frame.add(negbutton);
        frame.add(delbutton);
        frame.add(clrbutton);
        frame.add(textfield);
        frame.setVisible(true);
    }
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decbutton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
			
		}
		if(e.getSource() == subbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
			
		}
		if(e.getSource() == mulbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
			
		}
		if(e.getSource() == divbutton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
			
		}
		if(e.getSource() == equbutton) {
			num2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+': result = num1 + num2;break;
			case '-': result = num1 - num2;break;
			case '*': result = num1 * num2;break;
			case '/': result = num1/num2;break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
	}
		if(e.getSource() == clrbutton) {
			textfield.setText("");
		}
		if(e.getSource() == delbutton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0;i<string.length() - 1;i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if(e.getSource() == negbutton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
}
	}
