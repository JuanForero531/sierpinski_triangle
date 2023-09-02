package presenter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.TrianguloSierpinskiModel;
import view.TrianguloSierpinskiView;

public class TrianguloSierpinskiPresenter {

    private TrianguloSierpinskiModel model;
    private TrianguloSierpinskiView view;

    public TrianguloSierpinskiPresenter(TrianguloSierpinskiModel model, TrianguloSierpinskiView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el número de iteraciones o ingrese -1 para salir");
                int iteraciones = Integer.parseInt(input);
                if (iteraciones == -1) {
                    System.exit(0);
                }
                if (iteraciones < 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "El número de iteraciones debe ser mayor o igual a 0.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    model.setIteraciones(iteraciones);
                    view.repaint();
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Por favor, ingrese un número válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {
        TrianguloSierpinskiModel model = new TrianguloSierpinskiModel();
        TrianguloSierpinskiView view = new TrianguloSierpinskiView(model);
        TrianguloSierpinskiPresenter presenter = new TrianguloSierpinskiPresenter(model, view);

        JFrame frame = new JFrame("Triángulo de Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.add(view);
        frame.setVisible(true);

        presenter.run();
    }
}
