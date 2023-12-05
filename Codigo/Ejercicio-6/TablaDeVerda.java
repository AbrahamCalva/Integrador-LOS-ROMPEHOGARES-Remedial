import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class Ejer {

    public static void main(String[] args) {
         Set<Integer> filasCambiar = new HashSet<>();

        String numBitsStr = JOptionPane.showInputDialog("Ingrese el Número de Bits que deberá ser la Tabla de Verdad:");
        int numBits = Integer.parseInt(numBitsStr);

        StringBuilder encabezados = new StringBuilder();
        for (int i = 0; i < numBits; i++) {
            encabezados.append((char) ('A' + i)).append("\t");
        }
        encabezados.append("Resultado");
        System.out.println(encabezados);

        for (int i = 0; i < Math.pow(2, numBits); i++) {
            imprimirFilaTabla(i, numBits);
            System.out.println("0");
        }

        String filaStr = JOptionPane.showInputDialog("Ingrese los números de las filas que desea cambiar el resultado a 1 separados por comas (del 1 al " + (int) Math.pow(2, numBits) + ")");
        String[] filas = filaStr.split(",");
        for (String fila : filas) {
            int filaNum = Integer.parseInt(fila.trim());
            if (filaNum == 0) {
                break;
            }

            if (filaNum < 1 || filaNum > Math.pow(2, numBits)) {
                JOptionPane.showMessageDialog(null, "Número de fila inválido. Debe estar entre 1 y " + (int) Math.pow(2, numBits) + ".");
                continue;
            }

            filasCambiar.add(filaNum);
            imprimirTablaActualizada(filasCambiar, numBits);
        }

        System.out.println("Expresiones booleanas al finalizar:");
        filasCambiar.forEach(fila -> System.out.println(generarExpresionBooleana(fila, numBits)));
        System.out.println("Expresión booleana final: " + generarExpresionFinal(filasCambiar, numBits));
    }

    private static void imprimirFilaTabla(int valor, int numBits) {
        StringBuilder fila = new StringBuilder();
        for (int j = numBits - 1; j >= 0; j--) {
            fila.append(((valor >> j) & 1)).append("\t");
        }
        System.out.print(fila);
    }

    private static void imprimirTablaActualizada(Set<Integer> filasCambiar, int numBits) {
        System.out.println("Tabla de verdad actualizada:");
        for (int i = 0; i < Math.pow(2, numBits); i++) {
            imprimirFilaTabla(i, numBits);
            boolean resultado = filasCambiar.contains(i + 1);
            System.out.println(resultado ? "1" : "0");
        }
    }

    private static String generarExpresionBooleana(int fila, int numBits) {
        StringBuilder expresion = new StringBuilder();
        for (int i = 0; i < numBits; i++) {
            expresion.append(((fila - 1) >> (numBits - 1 - i) & 1) == 1 ? (char) ('A' + i) : (char) ('A' + i) + "'");
            if (i < numBits - 1) {
                expresion.append(" + ");
            }
        }
        return expresion.toString();
    }

    private static String generarExpresionFinal(Set<Integer> filasCambiar, int numBits) {
        StringBuilder expresionesConcatenadas = new StringBuilder();
        filasCambiar.forEach(fila -> {
            String expresion = generarExpresionBooleana(fila, numBits);
            if (expresionesConcatenadas.length() > 0) {
                expresionesConcatenadas.append(" + ");
            }
            expresionesConcatenadas.append("(").append(expresion).append(")");
        });
        return expresionesConcatenadas.toString();
    }
}