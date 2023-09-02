package view;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.TrianguloSierpinskiModel;

public class TrianguloSierpinskiView extends JPanel {

    private TrianguloSierpinskiModel model;

    public TrianguloSierpinskiView(TrianguloSierpinskiModel model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int iteraciones = model.getIteraciones();

        if (iteraciones > 11) {
            JOptionPane.showMessageDialog(
                    null,
                    "El número de iteraciones es muy alto para visualizar. Máximo 11.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        dibujarTrianguloSierpinski(g, 0, 0, getWidth(), iteraciones);
    }

    private void dibujarTrianguloSierpinski(Graphics g, int x, int y, int lado, int nivel) {
        if (nivel == 0) {
            int[] xPoints = {x, x + lado, x + lado / 2};
            int[] yPoints = {y + lado, y + lado, y};
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            int nuevoLado = lado / 2;
            dibujarTrianguloSierpinski(g, x, y, nuevoLado, nivel - 1);
            dibujarTrianguloSierpinski(g, x + nuevoLado, y, nuevoLado, nivel - 1);
            dibujarTrianguloSierpinski(g, x + nuevoLado / 2, y + nuevoLado, nuevoLado, nivel - 1);
        }
    }
}
