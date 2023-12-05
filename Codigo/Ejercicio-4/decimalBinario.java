import javax.swing.JOptionPane;

public class decimalBinario {

    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Ingrese un número decimal:");
        try {
            int numeroDecimal = Integer.parseInt(numero);
            String numeroBinario = "";

            if (numeroDecimal == 0) {
                numeroBinario = "0";
            } else if(numeroDecimal > 0){
                while (numeroDecimal > 0) {
                    int residuo = numeroDecimal % 2;
                    numeroBinario = residuo + numeroBinario;
                    numeroDecimal = numeroDecimal / 2;
                }
            }else 
            //Numeros enteros negativos
            if(numeroDecimal < 0){
                StringBuilder binarioNegativo = new StringBuilder();
                int num = Math.abs(numeroDecimal);
                
                while (num > 0) {
                    binarioNegativo.insert(0, num % 2);
                    num /= 2;
                }
                
                for (int i = 0; i < binarioNegativo.length(); i++) {
                char bit = binarioNegativo.charAt(i);
                binarioNegativo.setCharAt(i, (bit == '0') ? '1' : '0');
            }

            int comparar = 1;
            for (int i = binarioNegativo.length() - 1; i >= 0; i--) {
                char bit = binarioNegativo.charAt(i);
                if (bit == '0' && comparar == 1) {
                    binarioNegativo.setCharAt(i, '1');
                    comparar = 0;
                } else if (bit == '1' && comparar == 1) {
                    binarioNegativo.setCharAt(i, '0');
                    comparar = 1;
                }
            }
            if (comparar == 1) {
                binarioNegativo.insert(0, '1');
            }
                JOptionPane.showMessageDialog(null, "El número binario equivalente es: " + binarioNegativo.toString());
                return;
            }

            JOptionPane.showMessageDialog(null, "El número binario equivalente es: " + numeroBinario);

        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "El número ingresado tiene punto decimal y no puede ser evaluado.");
        }
    }

}