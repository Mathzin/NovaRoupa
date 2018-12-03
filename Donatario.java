package model;

import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Donatario extends Pessoa{	

	public String nome, senha;
	public int tipoPessoa, verificado, cont=0, aux;
	public static int limite, pecasTotal, limiteDinheiro;
	public int verifica=0;
	public int prioridade;
	public int pedidoRoupa;
	public double pedidoDinheiro;
        public static int contRecebidos=0;
        public static int msg;
        
        private final int LIMITE_ROUPAS_P1 = 5;
        private final int LIMITE_ROUPAS_P2 = 5000;
        private final int LIMITE_DIN_P1 = 500;
        private final int LIMITE_DIN_P2 = 10000;
   
        
       public static List<Integer> recebidas = new ArrayList<>();
       public static List<Double> recebidasDin = new ArrayList<>();
	
        //CONSTRUTOR
	public Donatario(String nome, String senha, int tipoPessoa, String funcao) {
		super(nome, senha, tipoPessoa, "Donatario");
               
	}
        public Donatario(){
            
        }
        
	//AÇÕES
	public void receberDinheiro(Double dinheiro) {
            
               if(loginDonaPessoa.get(posicao)==1){
                   if(dinheiro>0) {
			if(dinheiro<=LIMITE_DIN_P1) {
				if(Pessoa.dinheiroDoado!=0) {
					if (Pessoa.dinheiroDoado>=dinheiro) {
						if(recebidasDin.get(posicao)+dinheiro<=LIMITE_DIN_P1) {
				
						Math.abs(Pessoa.dinheiroDoado = Pessoa.dinheiroDoado-dinheiro); 
						msg=0;
                                                
						recebidasDin.set(posicao, (recebidasDin.get(posicao)+dinheiro));
                                                
						try{
					         FileOutputStream fos= new FileOutputStream("C:/Projeto/bancodinheiro.txt");
					         ObjectOutputStream oos= new ObjectOutputStream(fos);
					         oos.writeObject(dinheiroDoado);
					         oos.close();
					         fos.close();
					       }catch(IOException ioe){
					            ioe.printStackTrace();
					        }
					try
			        {
			            FileInputStream fis = new FileInputStream("C:/Projeto/bancodinheiro.txt");
			            ObjectInputStream ois = new ObjectInputStream(fis);
			            dinheiroDoado = (double) ois.readObject();
			            ois.close();
			            fis.close();
			         }catch(IOException ioe){
			             ioe.printStackTrace();
			             return;
			          }catch(ClassNotFoundException c){
			             System.out.println("Class not found");
			             c.printStackTrace();
			             return;
			          }
			}
				else {
                                      msg=1;
                                                    
					}
					}
					else {
                                            msg=2;        
			}
		}
		else {
                                    msg=3;
                      
		}
		}
			else {
                            msg=1;
                            
			}
		}
		else {
                       msg=4;
                   
		}
               }
                if(loginDonaPessoa.get(posicao)==2){
                     if(dinheiro>0) {
			if(dinheiro<=LIMITE_DIN_P2) {
				if(Pessoa.dinheiroDoado!=0) {
					if (Pessoa.dinheiroDoado>=dinheiro) {
						if(recebidasDin.get(posicao)+dinheiro<=LIMITE_DIN_P2) {
				
						Math.abs(Pessoa.dinheiroDoado = Pessoa.dinheiroDoado-dinheiro); 
						msg=0;
						recebidasDin.set(posicao,recebidasDin.get(posicao)+dinheiro);
                                                
						try{
					         FileOutputStream fos= new FileOutputStream("C:/Projeto/bancodinheiro.txt");
					         ObjectOutputStream oos= new ObjectOutputStream(fos);
					         oos.writeObject(dinheiroDoado);
					         oos.close();
					         fos.close();
					       }catch(IOException ioe){
					            ioe.printStackTrace();
					        }
					try
			        {
			            FileInputStream fis = new FileInputStream("C:/Projeto/bancodinheiro.txt");
			            ObjectInputStream ois = new ObjectInputStream(fis);
			            dinheiroDoado = (double) ois.readObject();
			            ois.close();
			            fis.close();
			         }catch(IOException ioe){
			             ioe.printStackTrace();
			             return;
			          }catch(ClassNotFoundException c){
			             System.out.println("Class not found");
			             c.printStackTrace();
			             return;
			          }
			}
						else {
                                                    msg=1;
						}
					}
					else {
                                            msg=2;
			}
		}
		else {
                      msg=3;
		}
		}
			else {
                            msg=1;
			}
		}
		else {
                    msg=4;
		}
                }
           }
	
	public void receberRoupas(int tipoRoupa, int quant){
            
           if(loginDonaPessoa.get(posicao)==1){
            for(int i=0;i<bancoRoupas2.size();i++){ 
                if(tipoRoupa==i){
                    if(quant<=Pessoa.bancoRoupas2.get(i)){
                        if ((recebidas.get(Pessoa.posicao)+quant)<=LIMITE_ROUPAS_P1){
                        Pessoa.bancoRoupas2.set(i, bancoRoupas2.get(i)-quant);
                        
                        
                        try{
					         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupa.txt"));
					         oos.writeObject(Pessoa.bancoRoupas2);
					         oos.close();
					         //fos.close();
					       }catch(IOException ioe){
					            ioe.printStackTrace();
					        }
						try
				        {
				            //FileInputStream fis = new FileInputStream("myfile");
				            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupa.txt"));
				            (Pessoa.bancoRoupas2) = (ArrayList) ois.readObject();
				            ois.close();
				           // fis.close();
				         }catch(IOException ioe){
				             ioe.printStackTrace();
				             return;
				          }catch(ClassNotFoundException c){
				             System.out.println("Class not found");
				             c.printStackTrace();
				             return;
				          }
                       JOptionPane.showMessageDialog(null, "Peça Recebida com Sucesso!", "Recebimento efetivado", WIDTH);
			recebidas.set(Pessoa.posicao, recebidas.get(Pessoa.posicao)+quant);
                    }
                        else{
                        JOptionPane.showMessageDialog(null, "Valor inserido acima do permitido!", "Recebimento não efetivado", WIDTH);
                        }
                        }
                    else{
                    JOptionPane.showMessageDialog(null, "Não há peças suficientes!", "Recebimento não efetivado", WIDTH);
                
                    }
                }
            }
           }
               else if(loginDonaPessoa.get(posicao)==2){
                for(int i=0;i<bancoRoupas2.size();i++){ 
                if(tipoRoupa==i){
                    if(quant<=Pessoa.bancoRoupas2.get(i)){
                        if ((recebidas.get(Pessoa.posicao)+quant)<=LIMITE_ROUPAS_P2){
                        Pessoa.bancoRoupas2.set(i, bancoRoupas2.get(i)-quant);
                        try{
					         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupa.txt"));
					         oos.writeObject(Pessoa.bancoRoupas2);
					         oos.close();
					         //fos.close();
					       }catch(IOException ioe){
					            ioe.printStackTrace();
					        }
						try
				        {
				            //FileInputStream fis = new FileInputStream("myfile");
				            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupa.txt"));
				            (Pessoa.bancoRoupas2) = (ArrayList) ois.readObject();
				            ois.close();
				           // fis.close();
				         }catch(IOException ioe){
				             ioe.printStackTrace();
				             return;
				          }catch(ClassNotFoundException c){
				             System.out.println("Class not found");
				             c.printStackTrace();
				             return;
				          }
                       JOptionPane.showMessageDialog(null, "Peça Recebida com Sucesso!", "Recebimento efetivado", WIDTH);
			recebidas.set(Pessoa.posicao, recebidas.get(Pessoa.posicao)+quant);
                        
                    }
                        else{
                      JOptionPane.showMessageDialog(null, "Valor inserido acima do permitido!", "Recebimento não efetivado", WIDTH);
                    }
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Não há peças suficientes!", "Recebimento não efetivado", WIDTH);
                }
                }
            }
                
            }
        }
        
        public void receberRoupas(String nome, String senha,int quant){
            verificaLogin(nome, senha);
            recebidas.set(Pessoa.posicao, recebidas.get(Pessoa.posicao)+quant);
        }
        
        public int verTotalRoupasRecebidas(int posicao){
            return recebidas.get(posicao);
        }
        
        public double verDinheiroRecebido(int posicao) {
            return recebidasDin.get(posicao);
	}
       //SERIALIZAÇÕES E DESSERIALIZAÇÕES
        public void serializaRecebidas(){
            try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/roupasRecebidas.txt"));
	         oos.writeObject(recebidas);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
        public void desserializaRecebidas(){
            try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/roupasRecebidas.txt"));
	        recebidas = (ArrayList) ois.readObject();
	        ois.close();
	     }catch(IOException ioe){
	         //ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c){
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
}
          public void serializaRecebidasDin(){
            try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/dinheiroRecebido.txt"));
	         oos.writeObject(recebidasDin);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
        public void desserializaRecebidasDin(){
            try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/dinheiroRecebido.txt"));
	        recebidasDin = (ArrayList) ois.readObject();
	        ois.close();
	     }catch(IOException ioe){
	         //ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c){
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
}
        public void serializaContRecebidos(){
             try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/contRecebidos.txt"));
	         oos.writeObject(contRecebidos);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
        }
        public void desserializaContRecebidos(){
            try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/contRecebidos.txt"));
		        contRecebidos = (int) ois.readObject();
		        ois.close();
		     }catch(IOException ioe){
		         //ioe.printStackTrace();
		         return;
		      }catch(ClassNotFoundException c){
		         System.out.println("Class not found");
		         c.printStackTrace();
		         return;
		      }
        }
        
        //AÇÕES NA LISTA DE ESPERA
        

}
        
       
       

