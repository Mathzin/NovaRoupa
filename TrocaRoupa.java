package model;


import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TrocaRoupa implements Serializable {

	static List<String> pessoaNome = new ArrayList<String>();
	static List<String> pessoaSenha = new ArrayList<String>();	
        String [] bancoRoupas ={"Blusa", "Camisa", "Casaco", "Short", "Bermuda", "Calca", "Sapato"};
        
	public static List<Integer> bancoRoupas2 = new ArrayList<Integer>();
        
        public static List<Integer> dadas = new ArrayList<>();
        public static List<Integer> recebidas = new ArrayList<>();
        public static List<Integer> bonus = new ArrayList<>();
        
        
	String nome, senha;
 	public static int qtdeT, tipoT, cont=0,contbanco=0;
	boolean login;
	public static int posicao=0;
	public static int verificado=0;
        static int inicializar=0;
	
        //CONSTRUTOR
	public TrocaRoupa(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
        
        
        public static void bancoDeRoupasInicializar() {
            desserializaInicializar();
            if (inicializar == 1) {
            for(int i=0; i<7;i++){
               bancoRoupas2.add(i,0);
               dadas.add(i,0);
               recebidas.add(i,0);
               bonus.add(i,0);
                }
            }
            
        }
        //CADASTRO
	public void cadastro(String nome, String senha) {
		    verificado=1;
			desserializaContTroca();
                        desserializaLoginTroca();
                        
			for(int i=0;i<pessoaNome.size();i++) {
				
					if(nome.equals(pessoaNome.get(i))) {
						verificado=0;
                                                
						JOptionPane.showMessageDialog(null, "Login já existe", "Cadastro não efetivado", WIDTH);
				}
			}
			if(verificado==1) {
                                
				pessoaNome.add(cont, nome);
                                pessoaSenha.add(cont, senha);
                                serializaLoginTroca();
                                desserializaLoginTroca();
				cont++;
                                serializaContTroca();
                                desserializaContTroca();
				JOptionPane.showMessageDialog(null, "Cadastro Realizado! Faça o login", "Cadastro Efetivado", WIDTH);	
                        }

			}
			
	 //LOGIN
	public void login(String nome, String senha) {
		verificado=0;
                inicializar +=1;
                
                serializaInicializar();
                
                desserializaLoginTroca();

		for(int i=0;i<pessoaNome.size();i++) {
			
				if(nome.equals(pessoaNome.get(i)) && senha.equals(pessoaSenha.get(i))) {
					verificado=1;
			}
		
		}
	}
        //VERIFICAÇÃO DE LOGIN
        public void verificaLogin(String nome, String senha){
              desserializaLoginTroca();

		for(int i=0;i<pessoaNome.size();i++) {
			
				if(nome.equals(pessoaNome.get(i)) && senha.equals(pessoaSenha.get(i))) {
					posicao=i;
			}
		
		}
        }
	//AÇÕES
	public void trocaDeRoupas(int tipo, int qtde) {
		for (int j =0; j < bancoRoupas.length; j++) {
			if (bancoRoupas[j].equals(bancoRoupas[tipo])) {
				bancoRoupas2.set(j, bancoRoupas2.get(j)+qtde);
                        
                                dadas.set(posicao, (dadas.get(posicao)+qtde));
                                bonus.set(posicao, bonus.get(posicao)+qtde);
                               
                                 try{
					         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupaTroca.txt"));
					         oos.writeObject(bancoRoupas2);
					         oos.close();
					         //fos.close();
					       }catch(IOException ioe){
					            ioe.printStackTrace();
					        }
						try
				        {
				            //FileInputStream fis = new FileInputStream("myfile");
				            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupaTroca.txt"));
				            bancoRoupas2 = (ArrayList) ois.readObject();
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
				JOptionPane.showMessageDialog(null, "Peça inserida no banco com sucesso!", "Inserção efetivada", WIDTH);
			}
		}
	}
	
	public void recebimentoDeRoupas(int tipo, int qtde) {
		
		for (int j =0; j < bancoRoupas.length; j++) {
			if (bancoRoupas[j].equals(bancoRoupas[tipo])) {
				if (bancoRoupas2.get(j) == 0) {
                                    JOptionPane.showMessageDialog(null, "Infelizmente, não temos essa unidade disponível!", "Recebimento não Efetivado", WIDTH);
				}
				else if (qtde <= bancoRoupas2.get(j)){
                                    if(qtde<=bonus.get(posicao)){
				 
					bancoRoupas2.set(j, bancoRoupas2.get(j)-qtde);
                                        
                                        recebidas.set(posicao, (recebidas.get(posicao)+qtde));
                                        bonus.set(posicao, (dadas.get(posicao)-recebidas.get(posicao)));
                                        
					 JOptionPane.showMessageDialog(null, "Troca realizada com sucesso!", "Recebimento Efetivado", WIDTH);
				}
                                    else{
                                    JOptionPane.showMessageDialog(null, "Você não possue Bônus suficiente!", "Recebimento não Efetivado", WIDTH);
                                }
                                }
                                
				else  if(qtde>bancoRoupas2.get(j)){
                                    JOptionPane.showMessageDialog(null, "Limite atingido, digite novamente!", "Recebimento não Efetivado", WIDTH);
                                }
				}
				}
			}
	
        //SERIALIZAÇÕES E DESSERIALIZAÇÕES
	public void bancoRoupaSerializar() {

		 try{
		         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupaTroca.txt"));
		         oos.writeObject(TrocaRoupa.bancoRoupas2);
		         oos.close();
		       }catch(IOException ioe){
		            ioe.printStackTrace();
		        }
	}
	public void bancoRoupaDesserializar() {
		for(int i=0;i<bancoRoupas.length;i++) {
			try
	        {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("/C:/Projeto/bancoroupaTroca.txt"));
	            (TrocaRoupa.bancoRoupas2) = (ArrayList) ois.readObject();
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
	}
        
	public static void serializaLoginTroca() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/salvarpessoaTroca.txt"));
	         oos.writeObject(TrocaRoupa.pessoaNome);
	         oos.writeObject(TrocaRoupa.pessoaSenha);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public static void desserializaLoginTroca() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/salvarpessoaTroca.txt"));
		       (TrocaRoupa.pessoaNome) = (ArrayList<String>) ois.readObject();
		       (TrocaRoupa.pessoaSenha) = (ArrayList<String>) ois.readObject();

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
	public void serializaContTroca() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/contTroca.txt"));
	         oos.writeObject(cont);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaContTroca() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/contTroca.txt"));
		        (cont) = (int) ois.readObject();
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
        public static void serializaInicializar() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/inicializarTrocaRoupa.txt"));
	         oos.writeObject(inicializar);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
	public static void desserializaInicializar() {
		try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/inicializarTrocaRoupa.txt"));
	        inicializar = (int) ois.readObject();
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
         public void serializaDadas(){
            try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/roupasDadas.txt"));
	         oos.writeObject(dadas);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
        public void desserializaDadas(){
            try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/roupasDadas.txt"));
	        dadas = (ArrayList) ois.readObject();
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
         public void serializaBonus(){
            try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/roupasBonus.txt"));
	         oos.writeObject(bonus);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
        public void desserializaBonus(){
            try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/roupasBonus.txt"));
	        bonus = (ArrayList) ois.readObject();
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
        public void serializaContBancoTroca() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/contBancoTroca.txt"));
	         oos.writeObject(contbanco);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaContBancoTroca() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/contBancoTroca.txt"));
		        (contbanco) = (int) ois.readObject();
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
        
		}