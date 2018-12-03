package model;



import controller.DonatarioControl;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Doador extends Pessoa implements  Serializable {

private int pecasTotal=0;
private Donatario dona;
	
//ONSTRUTORES
public Doador(String nome, String senha, int tipoPessoa, String funcao){
	super(nome,senha,tipoPessoa,"Doador");
	
	}
public Doador(){
    
}

//AÇÕES
public void doacaoDinheiro(Double dinheiro) {
        bancoDinheiroSave();
        Pessoa.dinheiroDoado = dinheiro+Pessoa.dinheiroDoado;
        JOptionPane.showMessageDialog(null, dinheiro+" reais foram doados com sucesso! O mundo agradesce!");
	try{
        FileOutputStream fos= new FileOutputStream("C:/Projeto/bancodinheiro.txt");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(Pessoa.dinheiroDoado);
        oos.close();
        fos.close();
      }catch(IOException ioe){
           ioe.printStackTrace();
       }
try
{
   FileInputStream fis = new FileInputStream("C:/Projeto/bancodinheiro.txt");
   ObjectInputStream ois = new ObjectInputStream(fis);
   Pessoa.dinheiroDoado = (double) ois.readObject();
   ois.close();
   fis.close();
}catch(IOException ioe){
    //ioe.printStackTrace();
    return;
 }catch(ClassNotFoundException c){
    System.out.println("Class not found");
    c.printStackTrace();
    return;
 }
       }



//banco roupas pessoais
public void doarRoupa(int tipo, int quant) {
	for (int j =0; j < bancoRoupas.length; j++) {
		if (bancoRoupas[j].equals(bancoRoupas[tipo])) {
					Pessoa.bancoRoupas2.set(j, (quant+bancoRoupas2.get(j)));
						//Pessoa.bancoRoupas2[j] += quant;
                                                JOptionPane.showMessageDialog(null, quant+" Peças de "+bancoRoupas[j]+" doadas com sucesso!");
						pecasTotal=pecasTotal+quant;
				
	
		 try{
		         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupa.txt"));
		         oos.writeObject(Pessoa.bancoRoupas2);
		         oos.close();
		       }catch(IOException ioe){
		            ioe.printStackTrace();
		        }
		 try
	        {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupa.txt"));
	            (Pessoa.bancoRoupas2) = (ArrayList) ois.readObject();
	            ois.close();
	         }catch(IOException ioe){
	            // ioe.printStackTrace();
	             return;
	          }catch(ClassNotFoundException c){
	             System.out.println("Class not found");
	             c.printStackTrace();
	             return;
	          }
			 
}
}
}

public int getPecasTotal(){
    return pecasTotal;
}
}


