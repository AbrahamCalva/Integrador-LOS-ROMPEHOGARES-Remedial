import javax.swing.JOptionPane;

public class circunferenciaOption {

    public static void main(String[] args) {
      // Entrada
        double x1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada x1:"));
        double y1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada y1:"));
        double r = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio r de la circunferencia:"));
        double x2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada x2 del punto T:"));
        double y2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada y2 del punto T:"));

        // Proceso
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (distancia <= r) {
            // Salida
            JOptionPane.showMessageDialog(null, "El punto T está dentro del área de la circunferencia.");
        } else {
            JOptionPane.showMessageDialog(null, "El punto T está fuera del área de la circunferencia.");
        }
    }
    
}