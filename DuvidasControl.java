
package controller;

import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Duvidas;

public class DuvidasControl {
    private static Duvidas duv = new Duvidas();
    
    //Baixar os arquivos sobre o programa
    public static void downloadSobreNos() throws IOException{
        duv.downloadSobreNos();
        JOptionPane.showMessageDialog(null, "Download de 'NovaRoupa - Sobre Nós' Concluído com sucesso", "Download Sucesso", WIDTH);
    }
    
    public static void downloadPSI() throws IOException{
        duv.downloadPSI();
         JOptionPane.showMessageDialog(null, "Download de 'NovaRoupa - PSI' Concluído com sucesso", "Download Sucesso", WIDTH);
    }
    
    
}
