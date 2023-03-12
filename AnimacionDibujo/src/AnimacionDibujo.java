import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AnimacionDibujo extends JFrame implements ActionListener, ChangeListener {

    private final Timer timer;
    private final ImageIcon[] imagenes;
    private final JSlider slider;
    private final JLabel imagenLabel;
    private int velocidad = 250;
    
    public AnimacionDibujo() {
        super("AnimaciónDibujo");
        this.imagenes = new ImageIcon[]{new ImageIcon("G:\\Users\\user\\GABRIELA\\TERCER SEMESTRE\\PROGRAMACION\\AnimacionDibujo/ImagenDibujo.png"), new ImageIcon("G:\\Users\\user\\GABRIELA\\TERCER SEMESTRE\\PROGRAMACION\\AnimacionDibujo/ImagenDibujo1.png"), new ImageIcon("G:\\Users\\user\\GABRIELA\\TERCER SEMESTRE\\PROGRAMACION\\AnimacionDibujo/ImagenDibujo2.png"), new ImageIcon("G:\\Users\\user\\GABRIELA\\TERCER SEMESTRE\\PROGRAMACION\\AnimacionDibujo/ImagenDibujo3.png")};

        timer = new Timer(velocidad, this);
        timer.setInitialDelay(0);
        
        slider = new JSlider(JSlider.HORIZONTAL, 60, 650, velocidad);
        slider.addChangeListener(this);

        imagenLabel = new JLabel(imagenes[0]);
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(imagenLabel, BorderLayout.CENTER);
        contentPane.add(slider, BorderLayout.SOUTH);
        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imagenLabel.setIcon(imagenes[(imagenes.length + 1 + Arrays.asList(imagenes).indexOf(imagenLabel.getIcon())) % imagenes.length]);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        velocidad = slider.getValue();
        timer.setDelay(velocidad);
    }

    public static void main(String[] args) {
        AnimacionDibujo animaciondibujo = new AnimacionDibujo();
    }
}
