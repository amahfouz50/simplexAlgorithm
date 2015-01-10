/*
 *   I am Ahmed Reda Mahfouz
 *   Student at the Faculty of Computing and Information Menoufia University 
 *   Department of Computer Science
 *
 *   *       Please Visit us at www.github.com/amahfouz50     *
 *  This Program was Developed by www.github.com/amahfouz50 forums Team
 *  *           Please Don't Remove This Comment       *
 */
/**
 *
 * @author Ahmed Mahfouz
 */
package simplex;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class solve extends JFrame implements ActionListener {

    JButton eror = new JButton("back");
    double check1;
    JLabel k = new JLabel("object");
    JLabel k1 = new JLabel("constrain");
    JLabel k2 = new JLabel();
    Object[] non;
    JScrollPane cc = new JScrollPane();
    JScrollPane ccc = new JScrollPane();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    int U;
    double m1;
    int objective[];
    String o[];
    double table[][];
    int n = 0;
    JTextField[][] s;
    JLabel s1[][];
    JTextField[][] s2;
    JLabel s3[][];
    double h[];
    int N = 0;
    JButton x3 = new JButton("solve");
    JPanel x2 = new JPanel();
    JPanel x4 = new JPanel();
    JComboBox d[];
    JComboBox d1 = new JComboBox();
    String g[] = {">=", "<=", "="};
    String g1[] = {"ma", "mi"};
    JPanel x1 = new JPanel();
    int z, z1;
    int c;
    int v = 0;
    int D = 0;
    double cj[];
    int T = 0;
//   double R[];
    int Q;
    int flag = 0;

    public solve(int x, int y) {
        non = new Object[y];
        for (int i = 0; i < non.length; i++) {
            non[i] = "x" + (i + 1);

        }
        String ee = "";
        for (int i = 0; i < non.length; i++) {
            if (i == 0 || i == non.length - 1) {
                ee += non[i];
                if (i == 0) {
                    ee += ",";
                    flag = 1;
                }
            } else {
                if (flag == 0) {
                    ee += ",";
                }

                ee += non[i];
            }
        }
        ee += ">=0";
        k2.setText(ee);
        eror.addActionListener(this);
        panel.add(k);
        panel2.add(k1);
        h = new double[x];
        Q = y;
        o = new String[x];
        z1 = y + 2;
        c = y + 1;
        T = y;
        x1.setLayout(new GridLayout(x, (y + 1) * 2, 10, 10));
        x4.setLayout(new GridLayout(1, (y + 1) * 2, 10, 10));
        x3.addActionListener(this);
        s = new JTextField[x][y + 1];
        s1 = new JLabel[x][y + 1];
        s2 = new JTextField[1][y];
        objective = new int[y];
        s3 = new JLabel[1][y + 1];
        d = new JComboBox[x];
        z = x;
        for (int i = 0; i < 2; i++) {
            d1.addItem(g1[i]);
        }
        d1.addActionListener(this);
        for (int j = 0; j < x; j++) {
            d[j] = new JComboBox();
            d[j].addActionListener(this);
            for (int i = 0; i < 3; i++) {

                d[j].addItem(g[i]);

            }
        }
        for (int i = 0; i < x; i++) {

            for (int v = 0; v < y + 1; v++) {
                int f = v + 1;
                s[i][v] = new JTextField();

                s1[i][v] = new JLabel();
                if (v == y) {
                    x1.add(d[i]);
                } else if (v < y + 1) {
                    s1[i][v].setText("x" + f);
                    x1.add(s1[i][v]);
                }
                x1.add(s[i][v]);

            }
        }

        for (int v = 0; v < y; v++) {
            int f = v + 1;
            s2[0][v] = new JTextField();
            s3[0][v] = new JLabel();
            if (v <= y - 1) {
                s3[0][v].setText("x" + f);
                x4.add(s3[0][v]);
            }
            x4.add(s2[0][v]);

            if (v == y - 1) {
                x4.add(d1);
            }
        }

        panel3.setLayout(new BorderLayout(10, 10));
        ccc.add(panel4);
        cc.setViewportView(panel4);
        cc.add(ccc);
        x2.add(x3);
        x2.add(eror);
        panel2.add(x1);

        panel3.add(panel, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.CENTER);
        panel.add(x4);
        panel4.add(panel3);
        JPanel pan5 = new JPanel(new BorderLayout(10, 10));
        pan5.add(x2, BorderLayout.NORTH);
        pan5.add(k2, BorderLayout.SOUTH);
        panel3.add(pan5, BorderLayout.SOUTH);
        add(cc);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == x3) {

            if (d1.getSelectedItem().equals("mi")) {
                U = 0;

            } else if (d1.getSelectedItem().equals("ma")) {
                U = 1;

            }
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < Q; j++) {
                    try {
                        objective[j] = Integer.parseInt(s2[0][j].getText());
                    } catch (Exception NullPointerException) {
                    }

                }
                m1 = Math.abs(objective[0]);

                for (int j = 0; j < objective.length; j++) {
                    if (m1 < Math.abs(objective[j])) {
                        m1 = Math.abs(objective[j]);
                    }
                }

                if (d[i].getSelectedItem().equals(">=")) {
                    o[v] = ">=";
                    T += 2;
                    if (d1.getSelectedItem().equals("mi")) {
                        h[v] = Math.abs(m1) + 100000;
                        check1 = h[v];

                    } else if (d1.getSelectedItem().equals("ma")) {
                        h[v] = -(Math.abs(m1) + 100000);

                        check1 = h[v];
                    }

                    if (v < z - 1) {
                        v++;
                    }
                    n += 2;
                } else if (d[i].getSelectedItem().equals("<=")) {
                    o[v] = "<=";
                    h[v] = 0;
                    if (v < z - 1) {
                        v++;
                    }
                    T += 1;
                    n += 1;
                } else if (d[i].getSelectedItem().equals("=")) {
                    o[v] = "=";
                    if (d1.getSelectedItem().equals("mi")) {
                        h[v] = Math.abs(m1) + 100000;
                        check1 = h[v];
                    } else if (d1.getSelectedItem().equals("ma")) {
                        h[v] = -(Math.abs(m1) + 100000);
                        check1 = h[v];

                    }
                    if (v < z - 1) {
                        v++;
                    }
                    n += 1;
                    T += 1;
                }
            }
            int r;

            cj = new double[T];
            for (int i = 0; i < T; i++) {
                if (i < Q) {
                    try {
                        cj[i] = Integer.parseInt(s2[0][i].getText());
                    } catch (Exception NumberFormatException) {
                        // JOptionPane.showMessageDialog(null, "please enter number"); 
                        System.exit(3);
                    }

                } else if (i < T) {
                    if (o[D].equals(">=")) {
                        cj[i] = h[D];
                        r = D;
                        cj[i + 1] = 0;
                        i++;

                    } else if (o[D].equals("<=")) {
                        cj[i] = 0;
                    } else if (o[D].equals("=")) {
                        if (d1.getSelectedItem().equals("mi")) {
                            cj[i] = h[D];
                        } else if (d1.getSelectedItem().equals("ma")) {
                            cj[i] = h[D];

                        }

                    }

                    if (D < v + 1) {
                        D++;
                    }
                }

            }
            n += z1;
            table = new double[z][n];
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < c - 1; j++) {
                    try {
                        table[i][j] = Integer.parseInt(s[i][j].getText());
                    } catch (Exception NumberFormatExceptio) {

                        //JOptionPane.showMessageDialog(null, "please enter number"); 
                        System.exit(3);

                    }

                }

            }
            outer:
            for (int j = c - 1; j < n - 1;) {
                for (int i = 0; i < z;) {
                    if (o[i].equals(">=")) {
                        table[i][j] = 1;

                        // A[j+1]=0;
                        table[i][j + 1] = -1;
                        if (i < z) {
                            i++;
                            j += 2;
                        }
                    } else if (o[i].equals("<=")) {

                        table[i][j] = 1;
                        if (i < z) {
                            i++;
                            j++;
                        }
                    } else if (o[i].equals("=")) {
                        table[i][j] = 1;
                        if (i < z) {
                            i++;
                            j++;
                        }

                    }
                    if (i == z) {
                        break outer;
                    }
                }
            }
            for (int i = 0; i < z; i++) {

                table[i][n - 2] = h[i];

            }
            for (int i = 0; i < z; i++) {

                table[i][n - 1] = Integer.parseInt(s[i][c - 1].getText());

            }
            int flag100 = 0;
            for (int i = 0; i < table.length; i++) {
                if (table[i][table[0].length - 1] < 0) {
                    JOptionPane.showMessageDialog(rootPane, "eror ");
                    flag100 = 1;
                    setVisible(false);
                    solver solve = new solver();
                    solve.setSize(300, 200);
                    solve.setLocationRelativeTo(null);
                    solve.setDefaultCloseOperation(3);
                    solve.setVisible(true);
                }
            }
            if (flag100 == 0) {

                setVisible(false);
                solution solve = new solution(table, cj, U, check1);

                solve.setSize(600, 600);
                solve.setLocationRelativeTo(null);
                solve.setDefaultCloseOperation(3);

                solve.setVisible(true);

            }
        } else if (e.getSource() == eror) {
            setVisible(false);
            solver solve = new solver();
            solve.setSize(300, 200);
            solve.setTitle("Simplex (Ahmed Mahfouz) ");
            solve.setLocationRelativeTo(null);
            solve.setDefaultCloseOperation(3);
            solve.setVisible(true);
        }
    }
}
