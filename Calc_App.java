import javax.swing.*;
import javax.swing.border.Border;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;

public class Calc_App extends JFrame implements ActionListener, KeyListener {

    JButton[] num = new JButton[10];
    JButton[] function = new JButton[14];
    JButton add, sub, multi, div, equ, neg, dec, del, clr, mod, sqr, rt, half, clral;
    JPanel panel;
    JPanel background;
    JTextField equation;
    JTextField input;

    char ope;
    double num1, num2, ans;

    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
    Border be = BorderFactory.createLineBorder(Color.BLACK);
    Font myfont = new Font(Font.SERIF, Font.BOLD, 25);
    Font myfonte = new Font(Font.SERIF, Font.BOLD, 20);

    Calc_App() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(370, 500);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.addKeyListener(this);
        this.setTitle("Calculator");

        background = new JPanel();
        background.setBounds(0, 0, 370, 500);
        background.setBackground(Color.BLACK);

        input = new JTextField("0");
        input.setBounds(10, 33, 335, 60);
        input.setFont(myfont);
        input.setEditable(false);
        input.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        input.setBackground(Color.BLACK);
        input.setForeground(Color.WHITE);
        input.setBorder(border);
        input.addKeyListener(this);

        equation = new JTextField();
        equation.setBounds(10, 10, 335, 20);
        equation.setFont(myfonte);
        equation.setEditable(false);
        equation.setBorder(be);
        equation.setBackground(Color.BLACK);
        equation.setForeground(Color.WHITE);
        equation.addKeyListener(this);

        add = new JButton("+");
        sub = new JButton("-");
        multi = new JButton("×");
        div = new JButton("÷");
        equ = new JButton("=");
        neg = new JButton("+/-");
        dec = new JButton(".");
        del = new JButton("⌫");
        clr = new JButton("C");
        mod = new JButton("%");
        sqr = new JButton("x²");
        rt = new JButton("²√x");
        half = new JButton("1/x");
        clral = new JButton("CE");

        function[0] = add;
        function[1] = sub;
        function[2] = multi;
        function[3] = div;
        function[4] = equ;
        function[5] = neg;
        function[6] = dec;
        function[7] = del;
        function[8] = clr;
        function[9] = mod;
        function[10] = sqr;
        function[11] = rt;
        function[12] = half;
        function[13] = clral;

        for (int i = 0; i < 14; i++) {
            function[i].addActionListener(this);
            function[i].setFont(myfont);
            function[i].setFocusable(false);
            function[i].setBackground(Color.DARK_GRAY);
            function[i].setForeground(Color.WHITE);
            function[i].setBorder(border);
            function[i].setOpaque(true);
            function[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    for (int i = 0; i < 14; i++) {
                        if (evt.getSource() == function[4]) {
                            function[4].setBackground(Color.CYAN);
                        } else if (evt.getSource() == function[i]) {
                            function[i].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }

                public void mouseExited(MouseEvent evt) {
                    for (int i = 0; i < 14; i++) {
                        if (evt.getSource() == function[4]) {
                            function[4].setBackground(Color.BLUE);
                        } else if (evt.getSource() == function[5]) {
                            function[5].setBackground(Color.GRAY);
                        } else if (evt.getSource() == function[6]) {
                            function[6].setBackground(Color.GRAY);
                        } else if (evt.getSource() == function[i]) {
                            function[i].setBackground(Color.DARK_GRAY);
                        }
                    }
                }

                public void mousePressed(MouseEvent evt) {
                    for (int i = 0; i < 14; i++) {
                        if (evt.getSource() == function[4]) {
                            function[4].setBackground(Color.WHITE);
                            function[4].setBackground(Color.CYAN);
                        } else if (evt.getSource() == function[i]) {
                            function[i].setBackground(Color.WHITE);
                            function[i].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(this);
            num[i].setFont(myfont);
            num[i].setFocusable(false);
            num[i].setBackground(Color.GRAY);
            num[i].setForeground(Color.WHITE);
            num[i].setBorder(border);
            num[i].setOpaque(true);
            num[i].addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent evt) {
                    for (int i = 0; i < 10; i++) {
                        if (evt.getSource() == num[i]) {
                            num[i].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }

                public void mouseExited(MouseEvent evt) {
                    for (int i = 0; i < 10; i++) {
                        if (evt.getSource() == num[i]) {
                            num[i].setBackground(Color.GRAY);
                        }
                    }
                }

                public void mousePressed(MouseEvent evt) {
                    for (int i = 0; i < 10; i++) {
                        if (evt.getSource() == num[i]) {
                            num[i].setBackground(Color.WHITE);
                            num[i].setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }

            });
        }

        dec.setBackground(Color.GRAY);
        neg.setBackground(Color.GRAY);
        equ.setBackground(Color.BLUE);

        panel = new JPanel();
        panel.setBounds(10, 100, 335, 350);
        panel.setLayout(new GridLayout(6, 4, 1, 1));
        panel.setBackground(Color.BLACK);

        panel.add(mod);
        panel.add(clral);
        panel.add(clr);
        panel.add(del);
        panel.add(half);
        panel.add(sqr);
        panel.add(rt);
        panel.add(div);
        panel.add(num[7]);
        panel.add(num[8]);
        panel.add(num[9]);
        panel.add(multi);
        panel.add(num[4]);
        panel.add(num[5]);
        panel.add(num[6]);
        panel.add(sub);
        panel.add(num[1]);
        panel.add(num[2]);
        panel.add(num[3]);
        panel.add(add);
        panel.add(neg);
        panel.add(num[0]);
        panel.add(dec);
        panel.add(equ);

        this.add(equation);
        this.add(input);
        this.add(panel);
        this.add(background);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Calc_App();
    }

    public void actionPerformed(ActionEvent e) {
        int k = 0;
        double temp;
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == num[i]) {
                temp = Double.parseDouble(input.getText());
                if (temp == 0) {
                    input.setText(String.valueOf(i));
                } else {
                    input.setText(input.getText().concat(String.valueOf(i)));
                }
            }
        }
        if (e.getSource() == dec) {
            input.setText(input.getText().concat("."));
        } else if (e.getSource() == add) {
            k++;
            ope = '+';
            if (k == 1) {
                num1 = Double.parseDouble(input.getText());
                equation.setText(num1 + " + ");
                k++;
            } else if (k == 2) {
                temp = Double.parseDouble(input.getText());
                num1 += temp;
                equation.setText(equation.getText().concat(temp + " + "));
                k--;
            }
            input.setText("0");
        } else if (e.getSource() == sub) {
            k++;
            ope = '-';
            if (k == 1) {
                num1 = Double.parseDouble(input.getText());
                equation.setText(num1 + " - ");
                k++;
            } else if (k == 2) {
                temp = Double.parseDouble(input.getText());
                num1 -= temp;
                equation.setText(equation.getText().concat(temp + " - "));
                k--;
            }
            input.setText("0");
        } else if (e.getSource() == multi) {
            k++;
            ope = '*';
            if (k == 1) {
                num1 = Double.parseDouble(input.getText());
                equation.setText(num1 + " × ");
                k++;
            } else if (k == 2) {
                temp = Double.parseDouble(input.getText());
                num1 *= temp;
                equation.setText(equation.getText().concat(temp + " × "));
                k--;
            }
            input.setText("0");
        } else if (e.getSource() == div) {
            k++;
            ope = '/';
            if (k == 1) {
                num1 = Double.parseDouble(input.getText());
                equation.setText(num1 + " ÷ ");
                k++;
            } else if (k == 2) {
                temp = Double.parseDouble(input.getText());
                num1 /= temp;
                equation.setText(equation.getText().concat(temp + " ÷ "));
                k--;
            }
            input.setText("0");
        } else if (e.getSource() == mod) {
            k++;
            ope = '%';
            if (k == 1) {
                num1 = Double.parseDouble(input.getText());
                equation.setText(num1 + " % ");
                k++;
            } else if (k == 2) {
                temp = Double.parseDouble(input.getText());
                num1 %= temp;
                equation.setText(equation.getText().concat(temp + " % "));
                k--;
            }
            input.setText("0");
        } else if (e.getSource() == equ) {
            num2 = Double.parseDouble(input.getText());
            equation.setText(equation.getText().concat(num2 + " ="));
            if (ope == '+' || ope == '/' || ope == '-' || ope == '*' || ope == '%') {
                switch (ope) {
                    case '+':
                        ans = num1 + num2;
                        break;
                    case '-':
                        ans = num1 - num2;
                        break;
                    case '*':
                        ans = num1 * num2;
                        break;
                    case '/':
                        ans = num1 * num2;
                        break;
                    case '%':
                        ans = num1 % num2;
                        break;
                }
            } else {
                ans = Double.parseDouble(input.getText());
            }
            input.setText(String.valueOf(ans));
            num1 = ans;
            k = 0;
        } else if (e.getSource() == clr) {
            input.setText("0");
        } else if (e.getSource() == del) {
            String str = input.getText();
            input.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                input.setText(input.getText() + str.charAt(i));
            }
        } else if (e.getSource() == neg) {
            temp = Double.parseDouble(input.getText());
            temp *= -1;
            input.setText(String.valueOf(temp));
        } else if (e.getSource() == clral) {
            input.setText("0");
            equation.setText("");
            num1 = 0;
            num2 = 0;
            ope = 0;
            k = 1;
        } else if (e.getSource() == sqr) {
            temp = Double.parseDouble(input.getText());
            equation.setText(temp + "²");
            temp *= temp;
            input.setText(String.valueOf(temp));
        } else if (e.getSource() == rt) {
            temp = Double.parseDouble(input.getText());
            equation.setText("²√" + temp);
            temp = Math.sqrt(temp);
            input.setText(String.valueOf(temp));
        } else if (e.getSource() == half) {
            temp = Double.parseDouble(input.getText());
            equation.setText("1 /" + temp);
            temp = 1 / temp;
            input.setText(String.valueOf(temp));
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // NONE
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // NONE
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = 0;
        double temp = Double.parseDouble(input.getText());

        if (temp == 0) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_0:
                    input.setText(input.getText().concat("0"));
                    break;
                case KeyEvent.VK_1:
                    input.setText("1");
                    break;
                case KeyEvent.VK_2:
                    input.setText("2");
                    break;
                case KeyEvent.VK_3:
                    input.setText("3");
                    break;
                case KeyEvent.VK_4:
                    input.setText("4");
                    break;
                case KeyEvent.VK_5:
                    input.setText("5");
                    break;
                case KeyEvent.VK_6:
                    input.setText("6");
                    break;
                case KeyEvent.VK_7:
                    input.setText("7");
                    break;
                case KeyEvent.VK_8:
                    input.setText("8");
                    break;
                case KeyEvent.VK_9:
                    input.setText("9");
                    break;

            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_0:
                    input.setText(input.getText().concat("0"));
                    break;
                case KeyEvent.VK_1:
                    input.setText(input.getText().concat("1"));
                    break;
                case KeyEvent.VK_2:
                    input.setText(input.getText().concat("2"));
                    break;
                case KeyEvent.VK_3:
                    input.setText(input.getText().concat("3"));
                    break;
                case KeyEvent.VK_4:
                    input.setText(input.getText().concat("4"));
                    break;
                case KeyEvent.VK_5:
                    input.setText(input.getText().concat("5"));
                    break;
                case KeyEvent.VK_6:
                    input.setText(input.getText().concat("6"));
                    break;
                case KeyEvent.VK_7:
                    input.setText(input.getText().concat("7"));
                    break;
                case KeyEvent.VK_8:
                    input.setText(input.getText().concat("8"));
                    break;
                case KeyEvent.VK_9:
                    input.setText(input.getText().concat("9"));
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    String str = input.getText();
                    input.setText("");
                    for (int i = 0; i < str.length() - 1; i++) {
                        input.setText(input.getText() + str.charAt(i));
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    input.setText("0");
                    equation.setText("");
                    num1 = 0;
                    num2 = 0;
                    ope = 0;
                    k = 1;
                    break;
            }
        }
        switch (e.getKeyChar()) {
            case '+':
                ope = '+';
                k++;
                if (k == 1) {
                    num1 = Double.parseDouble(input.getText());
                    equation.setText(num1 + " + ");
                    k++;
                } else if (k == 2) {
                    temp = Double.parseDouble(input.getText());
                    num1 += temp;
                    equation.setText(equation.getText().concat(temp + " + "));
                    k--;
                }
                input.setText("0");
                break;
            case '-':
                ope = '-';
                k++;
                if (k == 1) {
                    num1 = Double.parseDouble(input.getText());
                    equation.setText(num1 + " - ");
                    k++;
                } else if (k == 2) {
                    temp = Double.parseDouble(input.getText());
                    num1 -= temp;
                    equation.setText(equation.getText().concat(temp + " - "));
                    k--;
                }
                input.setText("0");
                break;
            case '*':
                ope = '*';
                k++;
                if (k == 1) {
                    num1 = Double.parseDouble(input.getText());
                    equation.setText(num1 + " × ");
                    k++;
                } else if (k == 2) {
                    temp = Double.parseDouble(input.getText());
                    num1 *= temp;
                    equation.setText(equation.getText().concat(temp + " × "));
                    k--;
                }
                input.setText("0");
                break;
            case '/':
                k++;
                ope = '/';
                if (k == 1) {
                    num1 = Double.parseDouble(input.getText());
                    equation.setText(num1 + " ÷ ");
                    k++;
                } else if (k == 2) {
                    temp = Double.parseDouble(input.getText());
                    num1 /= temp;
                    equation.setText(equation.getText().concat(temp + " ÷ "));
                    k--;
                }
                input.setText("0");
                break;
            case '%':
                k++;
                ope = '%';
                if (k == 1) {
                    num1 = Double.parseDouble(input.getText());
                    equation.setText(num1 + " % ");
                    k++;
                } else if (k == 2) {
                    temp = Double.parseDouble(input.getText());
                    num1 %= temp;
                    equation.setText(equation.getText().concat(temp + " % "));
                    k--;
                }
                input.setText("0");
                break;
            case '=':
            case KeyEvent.VK_ENTER:
                num2 = Double.parseDouble(input.getText());
                equation.setText(equation.getText().concat(num2 + " = "));
                if (ope == '+' || ope == '/' || ope == '-' || ope == '*' || ope == '%') {
                    switch (ope) {
                        case '+':
                            ans = num1 + num2;
                            break;
                        case '-':
                            ans = num1 - num2;
                            break;
                        case '*':
                            ans = num1 * num2;
                            break;
                        case '/':
                            ans = num1 / num2;
                            break;
                        case '%':
                            ans = num1 % num2;
                            break;
                    }
                } else {
                    ans = Double.parseDouble(input.getText());
                }
                input.setText(String.valueOf(ans));
                num1 = ans;
                k = 0;
                break;
           case KeyEvent.VK_PERIOD:
                input.setText(input.getText().concat("."));
                break;
        }
    }
}
