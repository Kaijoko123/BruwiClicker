import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class BruwiClicker extends JFrame {
    private int bruwis = 0;
    private int HuLevel = 0;
    private int danceClubLevel = 0;
    private int haamanLevel = 0;
    private int rothaarLevel = 0;

    
    private int whooshLevel = 0;
    private int gradeALevel = 0;

    private JLabel bruwisLabel;
    private JLabel huLabel;
    private JLabel danceClubLabel;
    private JLabel haamanLabel;
    private JLabel redHeadLabel;
    
    private JLabel gradeALabel;
    private JLabel whooshLabel;

    private Preferences preferences;

    public BruwiClicker() {
        setTitle("Bruwi Clicker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        preferences = Preferences.userNodeForPackage(BruwiClicker.class);

        initUI();
        loadGame();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Header
        JLabel headerLabel = new JLabel("Bruwi Clicker");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(headerLabel, gbc);

        // bruwis
        bruwisLabel = new JLabel("bruwis: 0", JLabel.CENTER);
        bruwisLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(bruwisLabel, gbc);

        // Hu
        huLabel = new JLabel("Hu´s : 0", JLabel.CENTER);
        huLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 2;
        add(huLabel, gbc);

        // Concordia
        danceClubLabel = new JLabel("Tanzclubs : 0", JLabel.CENTER);
        danceClubLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 3;
        add(danceClubLabel, gbc);

        // Haaman
        haamanLabel = new JLabel("Haamans : 0", JLabel.CENTER);
        haamanLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 4;
        add(haamanLabel, gbc);

        // Rothaar
        redHeadLabel = new JLabel("Rothaars Anschiss : 0", JLabel.CENTER);
        redHeadLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 5;
        add(redHeadLabel, gbc);

        // Whoosh
        whooshLabel = new JLabel("Wusch Wusch  : 0", JLabel.CENTER);
        whooshLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 6;
        add(whooshLabel, gbc);

        // gradeA
        gradeALabel = new JLabel("GradeA : 0", JLabel.CENTER);
        gradeALabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 7;
        add(gradeALabel, gbc);



        // Buttons
        gbc.gridwidth = 1;

        JButton clickButton = new JButton(new ImageIcon(BruwiClicker.class.getResource("Bruwi.png")));
        clickButton.setFont(new Font("Arial", Font.BOLD, 16));
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCookie();
            }
        });
        gbc.gridy = 8;
        add(clickButton, gbc);

        JButton buyHu = new JButton(new ImageIcon(BruwiClicker.class.getResource("hu.jpg")));
        buyHu.setFont(new Font("Arial", Font.PLAIN, 14));
        buyHu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bHu();
            }
        });
        gbc.gridx = 1;
        add(buyHu, gbc);

        JButton buyDanceClub = new JButton(new ImageIcon(BruwiClicker.class.getResource("Concordia.jpg")));
        buyDanceClub.setFont(new Font("Arial", Font.PLAIN, 14));
        buyDanceClub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bDanceClub();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(buyDanceClub, gbc);

        JButton buyHaaman = new JButton(new ImageIcon(BruwiClicker.class.getResource("Haaman.jpg")));
        buyHaaman.setFont(new Font("Arial", Font.PLAIN, 14));
        buyHaaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bHaaman();
            }
        });
        gbc.gridx = 1;
        add(buyHaaman, gbc);

        JButton buyRedHead = new JButton(new ImageIcon(BruwiClicker.class.getResource("RedHead.jpg")));
        buyRedHead.setFont(new Font("Arial", Font.PLAIN, 14));
        buyRedHead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bRedHead();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(buyRedHead, gbc);

        JButton buyWhoosh = new JButton(new ImageIcon(BruwiClicker.class.getResource("Whoosh.jpg")));
        buyWhoosh.setFont(new Font("Arial", Font.PLAIN, 14));
        buyWhoosh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bWhoosh();
            }
        });
        gbc.gridx = 1;
        add(buyWhoosh, gbc);

        JButton buyGradeA = new JButton(new ImageIcon(BruwiClicker.class.getResource("GradeA.jpg")));
        buyGradeA.setFont(new Font("Arial", Font.PLAIN, 14));
        buyGradeA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bGradeA();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(buyGradeA, gbc);

        JButton saveButton = new JButton("Save Game");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 14));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });
        gbc.gridx = 1;
        add(saveButton, gbc);

        // Timer for Hu
        Timer huTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HuClick();
            }
        });
        huTimer.start();

        // Timer for DanceClub
        Timer danceClubTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danceProduce();
            }
        });
        danceClubTimer.start();

        // Timer for Haaman
        Timer haamanTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                haamanProduce();
            }
        });
        haamanTimer.start();

        // Timer for redHead
        Timer redHeadTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redHeadProduce();
            }
        });
        redHeadTimer.start();

        // Timer for Whoosh

        Timer whooshTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                whooshProduce();
            }
        });
        whooshTimer.start();

        // Timer for Grade A

        Timer gradeATimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradeAProduce();
            }
        });
        gradeATimer.start();
    }

    private void clickCookie() {
        bruwis++;
        updateUI();
    }

    private void bHu() {
        int huCost = 50;
        if (bruwis >= huCost) {
            bruwis= bruwis-50;
            HuLevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy an Hu!");
        }
    }

    private void bDanceClub() {
        int danceClubCost = 100;
        if (bruwis >= danceClubCost) {
            bruwis = bruwis-100;
            danceClubLevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy a Tanzclub!");
        }
    }

    private void bHaaman() {
        int haamanCost = 250;
        if (bruwis >= haamanCost) {
            bruwis = bruwis-250;
            haamanLevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy Haaman!");
        }
    }

    private void bRedHead() {
        int redHeadCost = 500;
        if (bruwis >= redHeadCost) {
            bruwis = bruwis-500;
            rothaarLevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy a Rothaar!");
        }
    }

    private void bWhoosh() {
        int whooshCost = 1000;
        if (bruwis >= whooshCost) {
            bruwis = bruwis-1000;
            
            whooshLevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy a Whoosh!");
        }
    }

    private void bGradeA() {
        int gradeACost = 2500;
        if (bruwis >= gradeACost) {
            bruwis = bruwis-2500;
            
            gradeALevel++;
            updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "Not enough bruwis to buy a Grade A!");
        }
    }

    private void HuClick() {
        bruwis += HuLevel;
        updateUI();
    }

    private void danceProduce() {
        int danceProduction = 2 * danceClubLevel;
        bruwis += danceProduction;
        updateUI();
    }

    private void haamanProduce() {
        int haamanProduction = 5 * haamanLevel;
        bruwis += haamanProduction;
        updateUI();
    }

    private void redHeadProduce() {
        int redHeadProduction = 10 * rothaarLevel;
        bruwis += redHeadProduction;
        updateUI();
    }


    private void whooshProduce() {
        int whooshProduction = 20 * whooshLevel;
        bruwis += whooshProduction;
        updateUI();
    }

    private void gradeAProduce() {
        int gradeAProduction = 50 * gradeALevel;
        bruwis += gradeAProduction;
        updateUI();
    }

    private void updateUI() {
        bruwisLabel.setText("Bruwis: " + bruwis);
        huLabel.setText("Hu (Cost: 50): " + HuLevel);
        danceClubLabel.setText("Concordia Tanzclub (Cost: 100): " + danceClubLevel);
        haamanLabel.setText("Herr Haaman (Cost: 250): " + haamanLevel);
        redHeadLabel.setText("Anschiss von Rothaar (Cost: 500): " + rothaarLevel);
        whooshLabel.setText("Wusch Wusch und fertig(Cost: 1000): " + whooshLevel);
        gradeALabel.setText("1 in Mathe(Cost: 2500): " + gradeALevel);
    }

    private void saveGame() {
        preferences.putInt("bruwis", bruwis);
        preferences.putInt("huLevel", HuLevel);
        preferences.putInt("danceClubLevel", danceClubLevel);
        preferences.putInt("haamanLevel", haamanLevel);
        preferences.putInt("rothaarLevel", rothaarLevel);
        preferences.putInt("whooshLevel", whooshLevel);
        preferences.putInt("gradeALevel", gradeALevel);

        JOptionPane.showMessageDialog(this, "Game saved successfully!");
    }

    private void loadGame() {
        bruwis = preferences.getInt("bruwis", 0);
        HuLevel = preferences.getInt("HuLevel", 0);
        danceClubLevel = preferences.getInt("danceClubLevel", 0);
        haamanLevel = preferences.getInt("haamanLevel", 0);
        rothaarLevel = preferences.getInt("rothaarLevel", 0);
        whooshLevel = preferences.getInt("whooshLevel", 0);
        gradeALevel = preferences.getInt("gradeALevel", 0);

        updateUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BruwiClicker sbcc = new BruwiClicker();
                sbcc.setVisible(true);
            }
        });
    }
}
