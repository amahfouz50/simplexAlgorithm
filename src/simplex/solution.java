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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class solution extends JFrame implements ActionListener {

    public int pivoter(double E[]) {
        double z = E[0];
        int pivote = 0;
        for (int i = 0; i < E.length; i++) {
            if ((z > E[i] || z < 0) && E[i] > 0) {
                z = E[i];
                pivote = i;
            }
        }

        return pivote;
    }

    public double[] computecjzj(double a[], double b[]) {
        double x[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = a[i] - b[i];
        }
        return x;
    }

    public double[] computezj(double a[][]) {
        double x[] = new double[a[0].length - 2];
        double z = 0.0;
        for (int i = 0; i < a[0].length - 2; i++) {
            for (int j = 0; j < a.length; j++) {
                z += a[j][i] * a[j][a[0].length - 2];
            }
            x[i] = z;

            z = 0.0;

        }
        return x;
    }

    public double[] computetheata(double a[][]) {
        double x[] = new double[a.length];
        for (int j = 0; j < a.length; j++) {

            try {
                x[j] = a[j][a[0].length - 1] / a[j][pivotcolum];
            } catch (Exception ArithmeticException) {
            }

        }
        return x;
    }

    public double[][] changtab(double a[][], double copyofmaintable[][], double s[], int pivotcolum, int pivoterow) {
        double x[][] = new double[a.length][a[0].length];
        x[pivoterow][a[0].length - 2] = s[pivotcolum];
        for (int i = 0; i < a.length; i++) {
            if (i != pivoterow) {
                x[i][a[0].length - 2] = a[i][a[0].length - 2];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (j < a[0].length - 2 || j == a[0].length - 1) {
                    if (i == pivoterow) {
                        try {
                            x[i][j] = copyofmaintable[i][j] / copyofmaintable[pivoterow][pivotcolum];
                        } catch (Exception ArithmeticException) {
                        }

                    } else {
                        try {

                            x[i][j] = ((copyofmaintable[i][j] * copyofmaintable[pivoterow][pivotcolum]) - (copyofmaintable[i][pivotcolum] * copyofmaintable[pivoterow][j])) / (copyofmaintable[pivoterow][pivotcolum]);

                        } catch (Exception ArithmeticException) {
                        }

                    }

                }

            }
        }
        return x;
    }

    public boolean unbounded(int flag1, int flag2) {
        boolean f = true;
        if (flag1 == 0 && flag2 == 1) {
            f = false;
        }
        return f;
    }

    public boolean infeas(double check, Object a[][]) {
        int flag3 = 0;
        for (int i = 2; i < maintable.length - 2; i++) {
            if (check == (Double) a[i][0]) {
                flag3 = 1;
            }
        }

        boolean f = true;
        if (flag3 == 1 && check != 0) {
            x50.setText("optimal solution : infeasable solution");
            f = false;
        }
        return f;

    }

    public boolean altrenate(double check[], double a[][]) {
        boolean f = true;
        int F = 0;
        for (int i = 0; i < a.length; i++) {

            F++;
        }
        int cc = 0;
        for (int i = 0; i < suncjzj.length; i++) {
            if (suncjzj[i] == 0.0) {
                cc++;
            }
            if (cc > F) {
                f = false;
            }
        }

        return f;

    }
    JTextArea x45 = new JTextArea();
    JButton x501 = new JButton("return");
    JButton x40 = new JButton("close");
    JPanel panel1 = new JPanel();
    JTable printtable[];
    Object ta[][][];
    Object ta1[][][];
    JPanel panel2 = new JPanel();
    Object cj[];
    double cj1[];
    double z = 0.0;
    double suncjzj[];
    String xb[];
    String X[];
    Object maintable[][];
    int r = 0;
    int f = 0;

    int H = 0;
    int Y = 0;
    int F = 0;
    int S = 0;
    int I = 0;
    int pivoterow;
    int B = 0;
    int flag = 0;
    JLabel x50 = new JLabel();
    JScrollPane cc = new JScrollPane();
    JScrollPane ccc = new JScrollPane();
    int pivotcolum;
    JPanel R = new JPanel();
    double copyofmaintable[][];

    int f10;
    int xg = 0;
    int numbr = 0;
    String st = "";
    String f12 = "";
    double check1 = 0.0;

    public solution(double a[][], double s[], int U, double check) {

        // x45.setColumns(20);
        x40.addActionListener(this);
        ta = new Object[a.length + 130][a.length + 4][a[0].length + 2];

        cj = new Object[s.length];
        for (int i = 0; i < cj.length; i++) {
            if (s[i] == check && check != 0) {
                if (U == 1) {
                    cj[i] = "-m";
                } else if (U == 0) {
                    cj[i] = "m";
                }
            } else {
                cj[i] = s[i];
            }
        }

        check1 = check;
        copyofmaintable = new double[a.length][a[0].length];

        maintable = new Object[a.length + 4][a[0].length + 2];
        X = new String[a[0].length - 2];
        xb = new String[a.length];
        for (int i = 0; i < X.length; i++) {
            int y = i + 1;
            X[i] = "x" + y;
        }
        st += "object" + "\n";
        for (int i = 0; i < cj.length; i++) {
            if (i == 0 && U == 0) {
                st += "min" + "z" + "=";
            } else if (i == 0 && U == 1) {
                st += "max" + "z" + "=";
            }
            st += f12 + cj[i] + X[i];
            if (i + 1 == cj.length) {
                break;
            }
            if (s[i + 1] == check && check != 0 && U == 1) {
                f12 = "";

            } else {
                f12 = "+";
            }
        }

        st += "\n" + "st" + "\n";
        for (int i = 0; i < a.length; i++) {
            f12 = "";
            for (int j = 0; j < a[0].length - 2; j++) {

                st += f12 + a[i][j] + X[j];
                if (j + 1 < a[0].length - 2) {
                    if (a[i][j + 1] >= 0.0) {
                        f12 = "+";
                    } else {
                        f12 = "";
                    }
                }
                if (j == a[i].length - 3) {
                    st += "=" + a[i][a[i].length - 1];
                }

            }
            st += "\n";
        }
        for (int i = 0; i < X.length; i++) {
            st += X[i];
            if (i < X.length - 1) {
                st += ",";
            }
        }
        st += ">=0";
        st += "\n";

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (a[i][a[0].length - 2] == s[j]) {
                    if (xg == 0) {
                        f10 = j;
                        xg = 1;
                    } else {
                        if (f10 < s.length - 1) {

                            f10++;
                            for (int vv = 0; vv < a.length; vv++) {
                                if (a[vv][f10] == -1.0) {
                                    f10++;
                                    break;
                                }
                            }

                        }
                    }
                    xb[i] = X[f10];
                    break;
                }
            }
        }

        while (true) {
            r = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    copyofmaintable[i][j] = a[i][j];
                }
            }
            f = 0;
            H = 0;
            Y = 0;
            F = 0;
            S = 0;

            B = 0;

            for (int i = 0; i < maintable.length - 2; i++) {
                if (i == 0) {
                    maintable[i][0] = "  ";
                } else if (i == 1) {
                    maintable[i][0] = "CB";
                } else {
                    maintable[i][0] = copyofmaintable[r][a[0].length - 2];
                    r++;
                }
            }
            r = 0;
            for (int i = 0; i < maintable.length; i++) {
                if (i == 0) {
                    maintable[i][1] = "Cj";
                } else if (i == 1) {
                    maintable[i][1] = "Xb";
                } else if (i >= 2 && i < maintable.length - 2) {
                    maintable[i][1] = xb[r];
                    if (r < xb.length - 1) {
                        r++;
                    }

                } else if (i == maintable.length - 2) {
                    maintable[i][1] = "Zj";
                } else {
                    maintable[i][1] = "Cj-zj";
                }
            }
            for (int i = 0; i <= maintable.length - 3; i++) {
                for (int j = 2; j < maintable[0].length; j++) {
                    if (j > maintable[0].length - 2 && j < maintable[0].length && i <= 1) {
                        maintable[i][j] = " ";
                    } else if (i == 0 && j == maintable[0].length - 2) {
                        maintable[i][j] = " ";
                    } else if (i == 0) {
                        maintable[i][j] = cj[f];
                        if (f < s.length - 1) {
                            f++;
                        }
                    } else if (i == 1 && j <= maintable[0].length - 3) {
                        maintable[i][j] = X[Y];
                        Y++;
                    } else if (i >= 2) {
                        maintable[i][j] = copyofmaintable[S][H];
                        if (H < a[0].length - 2) {
                            H++;
                        }
                    }
                }
                if (S < a.length - 1 && i >= 2) {
                    S++;
                    H = 0;
                }
            }
            F = 0;
            for (int i = 1; i < maintable.length - 2; i++) {
                if (i == 1) {
                    maintable[i][maintable[0].length - 2] = "b";
                } else if (i > 1) {
                    maintable[i][maintable[0].length - 2] = copyofmaintable[F][a[0].length - 1];
                    if (F < a.length - 1) {
                        F++;
                    }
                }
            }
            maintable[1][maintable[0].length - 1] = "thita";

            cj1 = new double[a[0].length - 2];
            suncjzj = new double[a[0].length - 2];
            cj1 = computezj(a);

            int M = 0;
            for (int j = 2; j < maintable[0].length - 2; j++) {
                maintable[maintable.length - 2][j] = cj1[M];
                M++;
            }

            suncjzj = computecjzj(s, cj1);

            Object W[] = new Object[maintable[0].length];
            for (int j = 0; j < maintable[0].length; j++) {
                W[j] = maintable[1][j];
            }

            int M1 = 0;
            for (int j = 2; j < maintable[0].length - 2; j++) {
                maintable[maintable.length - 1][j] = suncjzj[M1];
                M1++;

            }
            int RR = 0;
            if (U == 1) {
                double G = 0.0;
                for (int i = 0; i < suncjzj.length; i++) {
                    if (G < suncjzj[i] && suncjzj[i] != 0 && suncjzj[i] != Double.POSITIVE_INFINITY) {
                        G = suncjzj[i];
                        flag = 1;
                        pivotcolum = i;
                        RR = 1;
                    }
                }

            } else if (U == 0) {
                double G = 0.0;
                for (int i = 0; i < suncjzj.length; i++) {
                    if (G > suncjzj[i] && suncjzj[i] != 0 && suncjzj[i] != Double.NEGATIVE_INFINITY) {
                        flag = 1;
                        G = suncjzj[i];

                        pivotcolum = i;
                        RR = 1;
                    }
                }

            }
            double E[] = new double[a.length];

            E = computetheata(a);
            int flag2 = 0;
            for (int i = 0; i < E.length; i++) {
                if (E[i] > 0.0 && E[i] != Double.POSITIVE_INFINITY) {
                    flag2 = 1;

                }
            }

            pivoterow = 0;
            pivoterow = pivoter(E);

            int Q = 0;

            for (int j = 2; j < maintable.length - 2; j++) {

                maintable[j][maintable[0].length - 1] = E[Q];
                Q++;
            }

            for (int i = 0; i < maintable.length; i++) {
                for (int j = 0; j < maintable[0].length; j++) {

                    ta[numbr][i][j] = maintable[i][j];
                }

            }

            numbr++;
            if (numbr == ta.length) {
                ta1 = new Object[numbr][a.length + 4][a[0].length + 2];
                for (int i = 0; i < ta.length; i++) {
                    for (int j = 0; j < ta[0].length; j++) {
                        for (int hh = 0; hh < ta[0][0].length; hh++) {
                            ta1[i][j][hh] = ta[i][j][hh];
                        }
                    }
                }
                ta = new Object[numbr + 130][a.length + 4][a[0].length + 2];
                for (int i = 0; i < numbr; i++) {
                    for (int j = 0; j < ta[0].length; j++) {
                        for (int hh = 0; hh < ta[0][0].length; hh++) {
                            ta[i][j][hh] = ta1[i][j][hh];
                        }
                    }
                }
            }

            boolean flag4 = unbounded(flag2, RR);
            if (flag4 == false) {
                x50.setText("optimal solution : unbounded solution");
                break;
            }
            if (flag == 1) {
                flag = 0;

                xb[pivoterow] = X[pivotcolum];
                a = changtab(a, copyofmaintable, s, pivotcolum, pivoterow);
            } else if (flag == 0) {

                boolean flag20 = altrenate(suncjzj, a);
                boolean flag10 = infeas(check1, maintable);
                if (flag20 == false && flag10 == true) {
                    x50.setText("optimal solution : altenate optimal");
                } else if (flag10 == true) {
                    double optimal = 0.0;
                    for (int i = 2; i < maintable.length - 2; i++) {
                        optimal += ((Double) maintable[i][0]) * ((Double) maintable[i][maintable[0].length - 2]);
                    }
                    x50.setText("optimal solution:" + Math.abs(optimal));

                }
                break;
            }

        }
        panel1.setLayout(new BorderLayout(10, 10));
        panel2.setLayout(new GridLayout(numbr + 1, 1, 10, 10));
        ccc.add(panel1);
        cc.setViewportView(panel1);
        cc.add(ccc);
        printtable = new JTable[numbr];
        panel1.add(x45, BorderLayout.CENTER);
        for (int i = 0; i < numbr; i++) {
            printtable[i] = new JTable(ta[i], maintable[0]);
            printtable[i].setEnabled(false);
            panel2.add(printtable[i]);
        }
        x45.setText(st);
        x45.setEditable(false);
        JPanel button = new JPanel();
        button.add(x40);
        button.add(x501);
        x501.addActionListener(this);
        panel2.add(x50);
        panel1.add(panel2, BorderLayout.NORTH);
        // panel1.add(x40,BorderLayout.CENTER);
        panel1.add(button, BorderLayout.SOUTH);
        add(cc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == x40) {
            setVisible(false);

       //design_by();
        } else if (e.getSource() == x501) {
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
