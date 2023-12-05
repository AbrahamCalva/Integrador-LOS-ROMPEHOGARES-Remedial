
import javax.swing.JOptionPane;


public class binarioOption {

    
    public static void main(String[] args) {
    
        String numeroBin = JOptionPane.showInputDialog("Ingresa un numero binario");
        int longitud = numeroBin.length();
        int numeroDecimal = 0;
        
        for (int i = 0; i < longitud; i++) {
            
            char digito = numeroBin.charAt(i);
            
            if (digito == '0') {
                numeroDecimal *= 2;
            } else if(digito == '1') {
                numeroDecimal = (numeroDecimal * 2) + 1;
            } else {
                JOptionPane.showMessageDialog(null, "El numero binario ingresado no es valido");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El numero decimal equivalente es " + numeroDecimal);

    }
    
}