package tablasdeverdadgrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TablasDeVerdadGrafica {
    //fonts
    Font font_formula = new Font ("Verdana", 1, 20);
    Font font_boton = new Font ("Arial", 1, 18);
    Font font_resultado_1 = new Font ("Monospaced", 1, 25);
    Font font_resultado_2 = new Font ("Monospaced", 1, 20);
    Font font_resultado_3 = new Font ("Monospaced", 1, 15);
    Font font_resultado_4 = new Font ("Monospaced", 1, 10);
        
    //Colores
    Color redd = new Color (255, 82, 82);
    Color natura = new Color (13, 255, 159);
    Color dkCyan = new Color (20, 235, 235);
    Color bootonf = new Color (233, 177, 15);
    Color bootonF = new Color (238, 238, 238);
    
    static script script = new script();
    
    public static void main(String[] args) {
        TablasDeVerdadGrafica ventana = new TablasDeVerdadGrafica();
    }
    
    public TablasDeVerdadGrafica(){
        JFrame marco = new JFrame();
    
        //Configuracuón de la ventana
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.pack();
        marco.setSize(800, 500);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setTitle("Resolutor de Tablas de Verdad");

        //Componentes del panel
        JTextField input = nuevoField(150,120,500,30,font_formula,dkCyan,"");
        input.setHorizontalAlignment(JTextField.CENTER);
        
        ImageIcon image = new ImageIcon(this.getClass().getResource("/sources/logo.png"));
        JLabel logo = new JLabel(image);
        logo.setBounds(0, 0, 800, 125);
        
        JButton info = nuevoButon(10,410,80,50,font_boton,bootonf,"Info");
        JButton hacer = nuevoButon(110,410,100,50,font_boton,bootonf,"Hacer");
        JButton aumentar = nuevoButon(230,410,50,50,font_boton,bootonf,"+");
        JButton reducir = nuevoButon(290,410,50,50,font_boton,bootonf,"-");
        
        JLabel resultado = nuevoLabel(400,100,200,50,font_resultado_2,Color.cyan,"");
        resultado.setHorizontalAlignment(JTextField.CENTER);
        resultado.setVerticalAlignment(JTextField.TOP);
        
        //añadir elementos
        marco.add(input);
        marco.add(logo);
        marco.add(info);
        marco.add(hacer);
        marco.add(aumentar);
        marco.add(reducir);
        marco.add(resultado);
        
        marco.setVisible(true);
        
        info.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              resultado.setFont(font_resultado_2);
                resultado.setText("<html><div align='center'><br><br><br><br><br><br>Introduce los operadores no lógicos con letras minusculas y los lógicos segun lo siguiente: c"
                + "<br>∧ Conjuntor: exponente '^'"
                + "<br>∨ Disyuntor: uve mayscula 'V'"
                + "<br>➡ Implicador: gion '-'"
                + "<br>↔ Coimplicador: gion bajo '_'"
                + "<br>¬ Negador: exclamación cerrada '!'"
                + "<br>La formula ha de estar lista para operar con ella. No dejes espacios.</div></html>");
          }
        });
        hacer.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              resultado.setFont(font_resultado_2);
                resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),2));
          }
        });
        aumentar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
            if (resultado.getFont() == font_resultado_2){
                resultado.setFont(font_resultado_1);
                resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),1));
            }else{
                if (resultado.getFont() == font_resultado_3){
                    resultado.setFont(font_resultado_2);
                    resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),2));
                }else{
                    if (resultado.getFont() == font_resultado_4){
                        resultado.setFont(font_resultado_3);
                        resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),3));
                    }
                }
            }
          }
        });
        reducir.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              if (resultado.getFont() == font_resultado_1){
                resultado.setFont(font_resultado_2);
                resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),2));
            }else{
                if (resultado.getFont() == font_resultado_2){
                    resultado.setFont(font_resultado_3);
                    resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),3));
                }else{
                    if (resultado.getFont() == font_resultado_3){
                        resultado.setFont(font_resultado_4);
                        resultado.setText(imprimir(input.getText(), script.hacedorTablaSeccionSecuenciada(input.getText()), input.getText().length(), (int)Math.pow(2,script.getNvariables(input.getText())),4));
                    }
                }
            }
          }
        });
    }
    
    private JLabel nuevoLabel(int bound1, int bound2, int bound3, int bound4,Font fuente, Color color,String texto){
        JLabel label = new JLabel();
        label.setBounds(bound1, bound2, bound3, bound4);
        label.setFont(fuente);
        label.setBackground(color);
        label.setText(texto);
        return label;
    }
    
    private JTextField nuevoField(int bound1, int bound2, int bound3, int bound4,Font fuente, Color color,String texto){
        JTextField field = new JTextField();
        field.setBounds(bound1, bound2, bound3, bound4);
        field.setFont(fuente);
        field.setBackground(color);
        field.setText(texto);
        return field;
    }
    
    private JButton nuevoButon(int bound1, int bound2, int bound3, int bound4,Font fuente, Color color,String texto){
        JButton boton = new JButton();
        boton.setBounds(bound1, bound2, bound3, bound4);
        boton.setFont(fuente);
        boton.setBackground(color);
        boton.setText(texto);
        return boton;
    }
    
    private JTextArea nuevoText(int bound1, int bound2, int bound3, int bound4,Font fuente, Color color,String texto){
        JTextArea text = new JTextArea();
        text.setBounds(bound1, bound2, bound3, bound4);
        text.setFont(fuente);
        text.setBackground(color);
        text.setText(texto);
        return text;
    }
    
    private static String imprimir(String seccion ,char[][] array, int long1, int long2,int number){
        StringBuilder resultado = new StringBuilder();
        char[] spacedFormula = new char[(seccion.length()*2)];
        int k = 0;
        for (int i = 0; i < spacedFormula.length; i++) {
            if(i%2==0){
                spacedFormula[i] = seccion.charAt(k);
                k++;
            }else{
                spacedFormula[i] = ' ';
            }
        }
        switch(number){
            case 1:
                resultado.append("<html><br><br><br><br><br>"+String.valueOf(spacedFormula)+"<br>");
                break;
            case 2:
                resultado.append("<html><br><br><br><br><br><br>"+String.valueOf(spacedFormula)+"<br>");
                break;
            case 3:
                resultado.append("<html><br><br><br><br><br><br><br>"+String.valueOf(spacedFormula)+"<br>");
                break;
            case 4:
                resultado.append("<html><br><br><br><br><br><br><br><br><br><br><br>"+String.valueOf(spacedFormula)+"<br>");
                break;
        }
        for (int x = 0; x < long2; x++) {
           for (int y = 0; y < long1; y++) {
               
               if(array[y][x] == ' '){
                   resultado.append("&nbsp ");
               }else{
                   resultado.append(array[y][x]+" ");
               }
           }
           resultado.append("<br>"); 
       }
        resultado.append("</html>");
       return resultado.toString();
   }
}
