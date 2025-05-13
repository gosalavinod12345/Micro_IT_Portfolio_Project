package buy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
    public class StopwatchClockApp extends JFrame {
        private JLabel clockLabel, stopwatchLabel;
        private JButton startButton, stopButton, resetButton;
        private Timer clockTimer, stopwatchTimer;
        private long startTime = 0;
        private long elapsed = 0;
        private boolean running = false;
        public StopwatchClockApp() {
            setTitle("Stopwatch and Clock");
            setSize(500, 300);
            setLayout(new GridLayout(3, 1));
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            clockLabel = new JLabel("", SwingConstants.CENTER);
            clockLabel.setFont(new Font("Verdana", Font.BOLD, 20));
            add(clockLabel);
            startClock();

            stopwatchLabel = new JLabel("00:00:00", SwingConstants.CENTER);
            stopwatchLabel.setFont(new Font("Verdana", Font.BOLD, 24));
            add(stopwatchLabel);

            JPanel panel = new JPanel();
            startButton = new JButton("Start");
            stopButton = new JButton("Stop");
            resetButton = new JButton("Reset");
            panel.add(startButton);
            panel.add(stopButton);
            panel.add(resetButton);
            add(panel);

            startButton.addActionListener(e -> startStopwatch());
            stopButton.addActionListener(e -> stopStopwatch());
            resetButton.addActionListener(e -> resetStopwatch());
            setVisible(true);
        }

        private void startClock() {
            clockTimer = new Timer(1000, e -> {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                clockLabel.setText("Current Time: " + time);
            });
            clockTimer.start();
        }
        private void startStopwatch() {
            if (!running) {
                running = true;
                startTime = System.currentTimeMillis() - elapsed;
                stopwatchTimer = new Timer(100, e -> {
                    elapsed = System.currentTimeMillis() - startTime;
                    stopwatchLabel.setText(formatTime(elapsed));
                });
                stopwatchTimer.start();
            }
        }

        private void stopStopwatch() {
            if (running) {
                running = false;
                stopwatchTimer.stop();
            }
        }
        private void resetStopwatch() {
            running = false;
            if (stopwatchTimer != null) stopwatchTimer.stop();
            elapsed = 0;
            stopwatchLabel.setText("00:00:00");
        }
        private String formatTime(long ms) {
            long seconds = ms / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            return String.format("%02d:%02d:%02d", hours % 24, minutes % 60, seconds % 60);
        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(StopwatchClockApp::new);
        }
    }