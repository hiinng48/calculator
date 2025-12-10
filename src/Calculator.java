//T1p t4p tjn: src/Calculator.java

//nh4p thu vjen awt vs swing
import javax.swing.*; //idk
import java.awt.*; //idk
import javax.swing.border.EmptyBorder; //style vien
import java.awt.event.*; //manage su kien cac thu
import java.text.DecimalFormat; //format so in ra man hinh

public class Calculator extends JFrame implements ActionListener {
    //m4n hjh
    JTextField screen;
    //lu01 b4n ph1m
    JPanel buttonPanel;
    //c4c nut b4m 
    JButton[] numberButtons = new JButton[10];
    JButton btnAdd, btnSub, btnMul, btnDiv, btnEqu, btnClr;
    
    //calculator's memory
    double num1 = 0;    
    double num2 = 0;    
    double result = 0;  
    char operator;      

    public Calculator() {
        //----- CU4 S0 -----
        this.setTitle("Tual's Calculator");
        this.setSize(350,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        //m4u m3 xju
        this.getContentPane().setBackground(new Color(230, 230, 230)); 

        //----- M4N HJH -----
        screen = new JTextField();
        screen.setPreferredSize(new Dimension(300, 70));
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);
        //f0nt
        screen.setFont(new Font("Arial", Font.BOLD, 40));
        screen.setBackground(Color.WHITE);
        //vien m4n hjh
        screen.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            new EmptyBorder(5, 10, 5, 10) 
        ));
        //ph4n d3m tr3n m4n hjh
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 10, 0, 10)); 
        topPanel.setBackground(new Color(230, 230, 230));
        topPanel.add(screen, BorderLayout.CENTER);
        //th3m m4n hjh v0 m4y tjh
        this.add(topPanel, BorderLayout.NORTH);
        
        //----- B4N PH1M -----
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBackground(new Color(230, 230, 230, 230));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //kh0j t4o c4c nut 
        btnAdd = createButton("+");
        btnSub = createButton("-");
        btnMul = createButton("x");
        btnDiv = createButton("/");
        btnEqu = createButton("=");
        btnClr = createButton("C");

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setForeground(Color.BLACK);
            //ngh3 n4t b4m
            numberButtons[i].addActionListener(this); 
        }
        //t0 m4u ch0 c4c nut
        btnClr.setBackground(new Color(200, 50, 50)); 
        btnClr.setForeground(Color.WHITE);
        
        Color darkGray = new Color(60, 60, 60);
        btnAdd.setBackground(darkGray); btnAdd.setForeground(Color.WHITE);
        btnSub.setBackground(darkGray); btnSub.setForeground(Color.WHITE);
        btnMul.setBackground(darkGray); btnMul.setForeground(Color.WHITE);
        btnDiv.setBackground(darkGray); btnDiv.setForeground(Color.WHITE);
        btnEqu.setBackground(darkGray); btnEqu.setForeground(Color.WHITE);

        //ngh3 n4t b4m
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEqu.addActionListener(this);
        btnClr.addActionListener(this);

        //th3m c4c nut v0 b4n ph1m
        //ROW 1: 7, 8, 9, +
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(btnAdd);

        //ROW 2: 4, 5, 6, -
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(btnSub);

        //ROW 3: 1, 2, 3, x
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(btnMul);

        //ROW 4: C, 0, =, /
        buttonPanel.add(btnClr);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(btnEqu);
        buttonPanel.add(btnDiv);

        //th3m b4n ph1m v0 m4y tjh
        this.add(buttonPanel, BorderLayout.CENTER);

        //h13n th1 m4n hjh
        this.setVisible(true);
    }

    //kh0j t4o nut b4m
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 22));
        btn.setFocusable(false);
        return btn;
    }

    //su kj3n b4m nut
    @Override
    public void actionPerformed(ActionEvent e) {
        //pressed numbers
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }

        // pressed operators
        if (e.getSource() == btnAdd) {
            num1 = Double.parseDouble(screen.getText()); //num1 gets the number on screen
            operator = '+'; //operator is remembered
            screen.setText(""); //clear screen for next number
        }
        if (e.getSource() == btnSub) {
            num1 = Double.parseDouble(screen.getText());
            operator = '-';
            screen.setText("");
        }
        if (e.getSource() == btnMul) {
            num1 = Double.parseDouble(screen.getText());
            operator = '*';
            screen.setText("");
        }
        if (e.getSource() == btnDiv) {
            num1 = Double.parseDouble(screen.getText());
            operator = '/';
            screen.setText("");
        }

        // pressed equals
        if (e.getSource() == btnEqu) {
            num2 = Double.parseDouble(screen.getText()); //num2 gets the number on screen

            // calculate result based on operator
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
                    // cant divide by 0
                    if (num2 == 0) {
                        screen.setText("Cannot divide by 0");
                        return; // dead XD
                    }
                    result = num1 / num2;
                    break;
            }

            //display result
            if (result % 1 == 0) {
                //neu ma result nguyen -> de display la int
                screen.setText(String.valueOf((int)result));
            } else {
                //con khong thi display la double
                DecimalFormat df = new DecimalFormat("#.####"); //max 4 so thap phan
                screen.setText(df.format(result));
            }
            
            //whatever the result is, it becomes num1 for next operation
            num1 = result; 
        }

        //pressed clear
        if (e.getSource() == btnClr) {
            screen.setText(""); //clear screen
            num1 = 0;
            num2 = 0;
            result = 0;
            //reset memory
        }
    }

    //h4m main
    public static void main(String[] args) {
        new Calculator();
    }
}