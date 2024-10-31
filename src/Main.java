import javax.swing.*;
import java.awt.Dimension;

public class Main implements Runnable {
    public static final String VERSION = "0.0.1";
    public static final String TITLE = "Physics Simulator " + VERSION;
    public static final Dimension SCREEN_SIZE = new Dimension(800, 600);

    public JFrame frame;
    public Renderer rend;
    public ForceList forceList;

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main).start();
    }

    public Main() {
        frame = new JFrame();
        frame.setSize(SCREEN_SIZE);
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        rend = new Renderer(frame);
        forceList = new ForceList();

        forceList.setBounds(0,0,200,580);
        frame.add(forceList);

        frame.setVisible(true);
    }

    public void run() {
        while (true) {
            rend.render();
            try {
                Thread.sleep(50); }
            catch (InterruptedException ie) { }
        }
    }
}
