Ejercicio-2

    public static void main(String[] args) {
    float a = Float.parseFloat(JOptionPane.showInputDialog("Ingresa coeficiente respecto al parámetro \"a\""));
        float b = Float.parseFloat(JOptionPane.showInputDialog("Ingresa coeficiente respecto al parámetro \"b\""));
        float c = Float.parseFloat(JOptionPane.showInputDialog("Ingresa coeficiente respecto al parámetro \"c\""));

        double discriminante = Math.pow(b, 2) - (4 * a * c);

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

            JOptionPane.showMessageDialog(null, "La solución tiene dos soluciones sobre el conjunto de los números reales:\n" +
                    "x1 = " + x1 + "\n" +
                    "x2 = " + x2);
        } else {
            if (discriminante == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "La ecuación solo tiene una solución sobre el conjunto de los números reales:\n" +
                        "x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "La ecuación no tiene una solución en el conjunto de los números reales, se encuentra en los números complejos");
            }
        }
    }
    
}
    

