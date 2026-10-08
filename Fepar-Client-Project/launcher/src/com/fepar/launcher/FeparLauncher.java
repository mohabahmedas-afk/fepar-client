package com.fepar.launcher;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FeparLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fepar Launcher");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 560);
            frame.setLocationRelativeTo(null);

            JPanel root = new JPanel(new BorderLayout(20, 20));
            root.setBackground(new Color(8, 9, 13));
            root.setBorder(BorderFactory.createEmptyBorder(35, 40, 35, 40));

            JLabel logo = new JLabel("FEPAR");
            logo.setForeground(Color.WHITE);
            logo.setFont(new Font("SansSerif", Font.BOLD, 30));

            JLabel version = new JLabel("Minecraft 1.21.11");
            version.setForeground(new Color(160, 165, 180));

            JPanel top = new JPanel(new BorderLayout());
            top.setOpaque(false);
            top.add(logo, BorderLayout.WEST);
            top.add(version, BorderLayout.EAST);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(new Color(16, 18, 24));
            panel.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));

            JLabel title = new JLabel("Play Minecraft with Fepar.");
            title.setForeground(Color.WHITE);
            title.setFont(new Font("SansSerif", Font.BOLD, 34));
            title.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel info = new JLabel("<html>Fepar Launcher starter build.<br>Client features will load from your Fepar installation.</html>");
            info.setForeground(new Color(175, 180, 195));
            info.setFont(new Font("SansSerif", Font.PLAIN, 16));
            info.setAlignmentX(Component.LEFT_ALIGNMENT);

            JButton launch = new JButton("LAUNCH FEPAR");
            launch.setAlignmentX(Component.LEFT_ALIGNMENT);
            launch.addActionListener(e -> launchMinecraft());

            JButton folder = new JButton("OPEN FEPAR FOLDER");
            folder.setAlignmentX(Component.LEFT_ALIGNMENT);
            folder.addActionListener(e -> openFolder());

            panel.add(title);
            panel.add(Box.createVerticalStrut(15));
            panel.add(info);
            panel.add(Box.createVerticalGlue());
            panel.add(launch);
            panel.add(Box.createVerticalStrut(10));
            panel.add(folder);

            root.add(top, BorderLayout.NORTH);
            root.add(panel, BorderLayout.CENTER);
            frame.setContentPane(root);
            frame.setVisible(true);
        });
    }

    private static void launchMinecraft() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "start", "", "minecraft://").start();
            } else {
                JOptionPane.showMessageDialog(null, "Install the official Minecraft Launcher, then start Fepar.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Minecraft Launcher could not be opened.");
        }
    }

    private static void openFolder() {
        File folder = new File(System.getProperty("user.home"), ".fepar");
        folder.mkdirs();
        try { Desktop.getDesktop().open(folder); }
        catch (Exception ex) { JOptionPane.showMessageDialog(null, folder.getAbsolutePath()); }
    }
}
