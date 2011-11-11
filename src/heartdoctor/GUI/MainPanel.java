package heartdoctor.GUI;

import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class MainPanel extends JPanel {

    private JPanel leftPanel;
    private JPanel contentPanel;

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 550;

    public MainPanel() {
        setLayout(null);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        if (this.contentPanel != null) {
            remove(this.contentPanel);
        }
        this.contentPanel = contentPanel;
        contentPanel.setBounds(250, 0, 500, WINDOW_HEIGHT);
        add(contentPanel);

        revalidate();
        repaint();
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        if (this.leftPanel != null) {
            remove(this.leftPanel);
        }
        this.leftPanel = leftPanel;
        leftPanel.setBounds(0, 0, 200, WINDOW_HEIGHT);
        add(leftPanel);
        revalidate();
        repaint();
    }
}
