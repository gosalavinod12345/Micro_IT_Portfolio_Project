package buy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class SimpleCalculator extends JFrame implements ActionListener {
        private JTextField textField;
        private JButton[] numberButtons;
        private JButton[] functionButtons;
        private JPanel panel;
        private double num1 = 0, num2 = 0, result = 0;
        private char operator;
        SimpleCalculator() {
            setTitle("Calculator");
            setSize(300, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(240, 240, 240));

            textField = new JTextField();
            textField.setBounds(30, 25, 240, 50);
            textField.setFont(new Font("Arial", Font.BOLD, 30));
            textField.setEditable(false);
            panel.add(textField);

            numberButtons = new JButton[10];
            for (int i = 0; i < 10; i++) {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
                numberButtons[i].setBackground(new Color(190, 190, 190));
                numberButtons[i].addActionListener(this);
            }

            functionButtons = new JButton[8];
            functionButtons[0] = new JButton("+");
            functionButtons[1] = new JButton("-");
            functionButtons[2] = new JButton("*");
            functionButtons[3] = new JButton("/");
            functionButtons[4] = new JButton(".");
            functionButtons[5] = new JButton("=");
            functionButtons[6] = new JButton("<=");
            functionButtons[7] = new JButton("Clear");

            for (JButton button : functionButtons) {
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setBackground(new Color(255, 200, 100));
                button.addActionListener(this);
            }

            int buttonX = 30;
            int buttonY = 90;
            for (int i = 0; i < 7; i++) {
                functionButtons[i].setBounds(buttonX, buttonY, 60, 40);
                panel.add(functionButtons[i]);
                buttonX += 70;
                if (buttonX >= 190) {
                    buttonX = 30;
                    buttonY += 50;
                }
            }

            int numberX = 30;
            int numberY = 200;
            for (int i = 1; i <= 9; i++) {
                if (i == 4 || i == 7) {
                    numberX = 30;
                    numberY += 50;
                }
                numberButtons[i].setBounds(numberX, numberY, 60, 40);
                panel.add(numberButtons[i]);
                numberX += 70;
            }
            numberButtons[0].setBounds(100, 350, 60, 40);
            panel.add(numberButtons[0]);

            functionButtons[6].setBounds(170, 350, 60, 40); // Adjusted size of "Delete" button
            panel.add(functionButtons[6]);

            getContentPane().add(panel);
            setVisible(true);
        }

        public static void main(String[] args) {
            new SimpleCalculator();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == functionButtons[4]) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == functionButtons[0]) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == functionButtons[1]) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (e.getSource() == functionButtons[2]) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (e.getSource() == functionButtons[3]) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (e.getSource() == functionButtons[5]) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0)
                            result = num1 / num2;
                        else
                            textField.setText("Error");
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == functionButtons[7]) {
                textField.setText("");
            }
            if (e.getSource() == functionButtons[6]) {
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }
        }
    }
