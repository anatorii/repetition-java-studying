import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Repetition {
    static int width = 1200;
    static int height = 600;
    static JFrame frame;


    public static void main(String[] args) throws IOException {
        frame = new JFrame("repetition");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension(Repetition.width, Repetition.height));
        frame.setLocation((d.width - Repetition.width) / 2, (d.height - Repetition.height) / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.orange);
        frame.pack();

        frame.setVisible(true);

        BufferedImage grass = ImageIO.read(new File("green-grass-texture-50.jpg"));

        JLabel grassLabel;
        for (int row = 0; row < Math.ceil((double) Repetition.height / grass.getHeight()); row++) {
            for (int col = 0; col < Math.ceil((double) Repetition.width / grass.getWidth()); col++) {
                grassLabel = new JLabel(new ImageIcon(grass));
                frame.add(grassLabel);
                grassLabel.setBounds(col * grass.getWidth(), row * grass.getHeight(), grass.getWidth(), grass.getHeight());
            }
        }

        System.out.println("Frame's been visible");
    }
}
