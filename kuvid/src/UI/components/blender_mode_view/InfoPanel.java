package UI.components.blender_mode_view;

import UI.views.GameView;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private JLabel multiplyLabel1;
    private JLabel gammaAtomLabel3;
    private JLabel sigmaAtomLabel3;
    private JLabel betaAtomLabel1;
    private JLabel eqLabel1;
    private JLabel alphaAtomLabel1;
    private JLabel gammaAtomLabel1;
    private JLabel alphaAtomLabel2;
    private JLabel eqLabel2;
    private JLabel multiplyLabel2;
    private JLabel eqLabel3;
    private JLabel sigmaAtomLabel1;
    private JLabel multiplyLabel3;
    private JLabel alphaAtomLabel3;
    private JLabel gammaAtomLabel2;
    private JLabel eqLabel4;
    private JLabel multiplyLabel4;
    private JLabel betaAtomLabel2;
    private JLabel sigmaAtomLabel2;
    private JLabel eqLabel5;
    private JLabel betaAtomLabel3;
    private JLabel multiplyLabel5;
    private JLabel multiplyLabel6;
    private JLabel eqLabel6;
    private JLabel gammaAtomIconLabel3;
    private JLabel gammaAtomIconLabel2;
    private JLabel gammaAtomIconLabel1;
    private JLabel sigmaAtomIconLabel3;
    private JLabel sigmaAtomIconLabel2;
    private JLabel sigmaAtomIconLabel1;
    private JLabel betaAtomIconLabel3;
    private JLabel betaAtomIconLabel2;
    private JLabel betaAtomIconLabel1;
    private JLabel alphaAtomIconLabel3;
    private JLabel alphaAtomIconLabel2;
    private JLabel alphaAtomIconLabel1;

    public InfoPanel() {
        setAtomIcons();
        setEquationLabels1();
        setEquationLabels2();
        setEquationLabels3();
        setEquationLabels4();
        setEquationLabels5();
        setEquationLabels6();
        setLayout();
    }

    private void setEquationLabels6() {
        gammaAtomLabel3 = new JLabel("Gamma");
        gammaAtomLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        gammaAtomLabel3.setFont(new Font("Open Sans", Font.BOLD, 14));

        sigmaAtomLabel3 = new JLabel("Sigma");
        sigmaAtomLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaAtomLabel3.setFont(new Font("Open Sans", Font.BOLD, 14));

        eqLabel6 = new JLabel("=");
        eqLabel6.setFont(new Font("Open Sans", Font.BOLD, 18));

        multiplyLabel6 = new JLabel("2 x");
        multiplyLabel6.setFont(new Font("Open Sans", Font.BOLD, 18));
    }

    private void setEquationLabels5() {
        multiplyLabel5 = new JLabel("3 x");
        multiplyLabel5.setFont(new Font("Open Sans", Font.BOLD, 18));

        betaAtomLabel3 = new JLabel("Beta");
        betaAtomLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        betaAtomLabel3.setFont(new Font("Open Sans", Font.BOLD, 14));

        eqLabel5 = new JLabel("=");
        eqLabel5.setFont(new Font("Open Sans", Font.BOLD, 18));

        sigmaAtomLabel2 = new JLabel("Sigma");
        sigmaAtomLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaAtomLabel2.setFont(new Font("Open Sans", Font.BOLD, 14));
    }

    private void setEquationLabels4() {
        betaAtomLabel2 = new JLabel("Beta");
        betaAtomLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        betaAtomLabel2.setFont(new Font("Open Sans", Font.BOLD, 14));

        multiplyLabel4 = new JLabel("2 x");
        multiplyLabel4.setFont(new Font("Open Sans", Font.BOLD, 18));

        eqLabel4 = new JLabel("=");
        eqLabel4.setFont(new Font("Open Sans", Font.BOLD, 18));

        gammaAtomLabel2 = new JLabel("Gamma");
        gammaAtomLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        gammaAtomLabel2.setFont(new Font("Open Sans", Font.BOLD, 14));
    }

    private void setEquationLabels3() {
        alphaAtomLabel3 = new JLabel("Alpha");
        alphaAtomLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        alphaAtomLabel3.setFont(new Font("Open Sans", Font.BOLD, 14));

        multiplyLabel3 = new JLabel("4 x");
        multiplyLabel3.setFont(new Font("Open Sans", Font.BOLD, 18));

        sigmaAtomLabel1 = new JLabel("Sigma");
        sigmaAtomLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaAtomLabel1.setFont(new Font("Open Sans", Font.BOLD, 14));

        eqLabel3 = new JLabel("=");
        eqLabel3.setFont(new Font("Open Sans", Font.BOLD, 18));
    }

    private void setEquationLabels2() {
        multiplyLabel2 = new JLabel("3 x");
        multiplyLabel2.setFont(new Font("Open Sans", Font.BOLD, 18));

        eqLabel2 = new JLabel("=");
        eqLabel2.setFont(new Font("Open Sans", Font.BOLD, 18));

        alphaAtomLabel2 = new JLabel("Alpha");
        alphaAtomLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        alphaAtomLabel2.setFont(new Font("Open Sans", Font.BOLD, 14));

        gammaAtomLabel1 = new JLabel("Gamma");
        gammaAtomLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        gammaAtomLabel1.setFont(new Font("Open Sans", Font.BOLD, 14));
    }

    private void setEquationLabels1() {
        multiplyLabel1 = new JLabel("2 x");
        multiplyLabel1.setFont(new Font("Open Sans", Font.BOLD, 18));

        alphaAtomLabel1 = new JLabel("Alpha");
        alphaAtomLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        alphaAtomLabel1.setFont(new Font("Open Sans", Font.BOLD, 14));

        eqLabel1 = new JLabel("=");
        eqLabel1.setFont(new Font("Open Sans", Font.BOLD, 18));

        betaAtomLabel1 = new JLabel("Beta");
        betaAtomLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        betaAtomLabel1.setFont(new Font("Open Sans", Font.BOLD, 14));
    }

    private void setAtomIcons() {
        alphaAtomIconLabel1 = new JLabel("");
        ImageIcon alphaAtomIcon1 = new ImageIcon(GameView.class.getResource("/alpha_atom.png"));
        Image alphaAtomIconImage1 = alphaAtomIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        alphaAtomIcon1 = new ImageIcon(alphaAtomIconImage1);
        alphaAtomIconLabel1.setIcon(alphaAtomIcon1);

        alphaAtomIconLabel2 = new JLabel("");
        alphaAtomIconLabel2.setIcon(alphaAtomIcon1);

        alphaAtomIconLabel3 = new JLabel("");
        alphaAtomIconLabel3.setIcon(alphaAtomIcon1);

        betaAtomIconLabel1 = new JLabel("");
        ImageIcon betaAtomIcon1 = new ImageIcon(GameView.class.getResource("/beta_atom.png"));
        Image betaAtomIconImage1 = betaAtomIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        betaAtomIcon1 = new ImageIcon(betaAtomIconImage1);
        betaAtomIconLabel1.setIcon(betaAtomIcon1);

        betaAtomIconLabel2 = new JLabel("");
        betaAtomIconLabel2.setIcon(betaAtomIcon1);

        betaAtomIconLabel3 = new JLabel("");
        betaAtomIconLabel3.setIcon(betaAtomIcon1);

        sigmaAtomIconLabel1 = new JLabel("");
        ImageIcon sigmaAtomIcon1 = new ImageIcon(GameView.class.getResource("/sigma_atom.png"));
        Image sigmaAtomIconImage1 = sigmaAtomIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        sigmaAtomIcon1 = new ImageIcon(sigmaAtomIconImage1);
        sigmaAtomIconLabel1.setIcon(sigmaAtomIcon1);

        sigmaAtomIconLabel2 = new JLabel("");
        sigmaAtomIconLabel2.setIcon(sigmaAtomIcon1);

        sigmaAtomIconLabel3 = new JLabel("");
        sigmaAtomIconLabel3.setIcon(sigmaAtomIcon1);

        gammaAtomIconLabel1 = new JLabel("");
        ImageIcon gammaAtomIcon1 = new ImageIcon(GameView.class.getResource("/gamma_atom.png"));
        Image gammaAtomIconImage1 = gammaAtomIcon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        gammaAtomIcon1 = new ImageIcon(gammaAtomIconImage1);
        gammaAtomIconLabel1.setIcon(gammaAtomIcon1);

        gammaAtomIconLabel2 = new JLabel("");
        gammaAtomIconLabel2.setIcon(gammaAtomIcon1);

        gammaAtomIconLabel3 = new JLabel("");
        gammaAtomIconLabel3.setIcon(gammaAtomIcon1);
    }

    private void setLayout() {
        GroupLayout gl_infoPanel = new GroupLayout(this);
        gl_infoPanel.setHorizontalGroup(
                gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_infoPanel.createSequentialGroup()
                                .addGap(20)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(multiplyLabel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(alphaAtomLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(alphaAtomIconLabel3)))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(eqLabel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(betaAtomIconLabel3))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(betaAtomLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(multiplyLabel2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(alphaAtomLabel2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(alphaAtomIconLabel1)))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(gammaAtomLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(gammaAtomIconLabel3))
                                                        .addComponent(eqLabel2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(alphaAtomLabel3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(alphaAtomIconLabel2))
                                                        .addComponent(multiplyLabel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(eqLabel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(sigmaAtomLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(sigmaAtomIconLabel3))))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(betaAtomLabel2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(multiplyLabel4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(betaAtomIconLabel1)))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(eqLabel4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(gammaAtomLabel2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(gammaAtomIconLabel1))))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(multiplyLabel5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(betaAtomLabel3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(betaAtomIconLabel2)))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(eqLabel5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(sigmaAtomLabel2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(sigmaAtomIconLabel1))))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(gammaAtomLabel3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(multiplyLabel6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(35)
                                                                .addComponent(gammaAtomIconLabel2)))
                                                .addGap(2)
                                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(sigmaAtomLabel3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(sigmaAtomIconLabel2))
                                                        .addComponent(eqLabel6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
        );
        gl_infoPanel.setVerticalGroup(
                gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_infoPanel.createSequentialGroup()
                                .addGap(20)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(alphaAtomLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(alphaAtomIconLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(betaAtomIconLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(betaAtomLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                                .addGap(9)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(alphaAtomLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(alphaAtomIconLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(gammaAtomLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(gammaAtomIconLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
                                .addGap(9)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(alphaAtomLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(alphaAtomIconLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(sigmaAtomLabel1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(sigmaAtomIconLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(9)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(betaAtomLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(betaAtomIconLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(gammaAtomLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(gammaAtomIconLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(9)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(betaAtomLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(betaAtomIconLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(sigmaAtomLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(sigmaAtomIconLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(9)
                                .addGroup(gl_infoPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(gammaAtomLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(multiplyLabel6, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(gammaAtomIconLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(45)
                                                .addComponent(sigmaAtomLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(sigmaAtomIconLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_infoPanel.createSequentialGroup()
                                                .addGap(20)
                                                .addComponent(eqLabel6, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
        );
        this.setLayout(gl_infoPanel);
    }
}
