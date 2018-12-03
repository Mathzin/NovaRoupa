package model;

import Exceptions.LoginJaCadastrado;
import controller.DonatarioControl;
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

public class Pessoa implements Serializable {
	
     //tranformar tudo em privado ;-;
	public String nome, senha; //privado
	public int tipoPessoa; //privado
	public static int verificado; //statico
	public static int posicao=0; //estatico
	public static int contDoa=0, contDona=0;
        public static int limite, limiteDinheiro;
        public static int inicializar = 0;
        
	static String [] bancoRoupas ={"Blusa", "Camisa", "Casaco", "Short", "Bermuda", "Calca", "Sapato"};
	public static List<Integer> bancoRoupas2 = new ArrayList<Integer>();
	public static double dinheiroDoado;
	
	private List<String> loginDoaNome = new ArrayList<>();
        private List<String> loginDoaSenha = new ArrayList<>();
        private List<Integer> loginDoaPessoa = new ArrayList<>();
        public List<String> loginDonaNome = new ArrayList<>();
        private List<String> loginDonaSenha = new ArrayList<>();
        List<Integer> loginDonaPessoa = new ArrayList<>();
        
        
	
        //CONSTRUTORES
	Pessoa(String nome, String senha, int tipoPessoa, String funcao){
		this.nome=nome;
		this.senha=senha;
		this.tipoPessoa=tipoPessoa;
        }
        public Pessoa(){
            
        }
 
        
        public static void Inicializar() {
            desserializaInicializar();
            if (inicializar == 1) {
            for(int i=0; i<7;i++){
                bancoRoupas2.add(i, 0);
                Donatario.recebidas.add(i,0);
                Donatario.recebidasDin.add(i,0.0);
        }
            }
        }
	
	//CADASTRO
	public void cadastro(String funcao, String nome, String senha) throws LoginJaCadastrado {
		
	verificado=1; 
		if(funcao.equals("Doador")) {
                    desserializaContDoa();
                    desserializaLoginDoa();
                    
                    for(int i=0;i<loginDoaNome.size();i++) {
			
				if(nome.equals(loginDoaNome.get(i))) {
					verificado=0;
                                        
			}
		}
		if(verificado==1) {
                    loginDoaNome.add(contDoa, nome);
                    loginDoaSenha.add(contDoa, senha);
                    loginDoaPessoa.add(contDoa, tipoPessoa);
                    serializaLoginDoa();
                    desserializaLoginDoa();
			contDoa++;
                        serializaContDoa();
                        desserializaContDoa();
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado! Faça o login", "Cadastro Efetivado", WIDTH);	
		}
                else {
                    throw new Exceptions.LoginJaCadastrado("Login já existe");
                }
                }
		
		if(funcao.equals("Donatario")) {
                    desserializaContDona();
			 desserializaLoginDona();
                    
			for(int i=0;i<loginDonaNome.size();i++) {
				
					if(nome.equals(loginDonaNome.get(i))) {
						verificado=0;
						
					
				}
			}
			if(verificado==1) {
                            
                    loginDonaNome.add(contDona, nome);
                    loginDonaSenha.add(contDona, senha);
                    loginDonaPessoa.add(contDona, tipoPessoa);
                    serializaLoginDona();
                    desserializaLoginDona();
				contDona++;
                                serializaContDona();
                                desserializaContDona();
				JOptionPane.showMessageDialog(null, "Cadastro Realizado! Faça o login", "Cadastro Efetivado", WIDTH);
			}
                        else {
                    throw new Exceptions.LoginJaCadastrado("Login já existe");
                }
			}
	}
        
	//LOGIN
	public void login(String nome, String senha, String funcao) {
		verificado=0;
                inicializar +=1;
		if(funcao.equals("Doador")) {
                  
                        desserializaLoginDoa();
                        desserializaContDoa(); 
                    
                                
		for(int i=0;i<contDoa;i++) {
			
				if(nome.equals(loginDoaNome.get(i)) && senha.equals(loginDoaSenha.get(i))) {
					verificado=1;
                                        
			}
		}
		}
		if(funcao.equals("Donatario")) {
                 
                        desserializaContDona();
			 desserializaLoginDona();
                    
			for(int i=0;i<contDona;i++) {
				
					if(nome.equals(loginDonaNome.get(i)) && senha.equals(loginDonaSenha.get(i))) {
						verificado=1;
                                                posicao=i;
				}
                        }
			}
		
	}
        //VERIFICAÇÃO DE LOGIN
        public void verificaLogin(String nome, String senha){
            desserializaContDona();
            desserializaLoginDona();
          for(int i=0;i<contDona;i++) {			
	if(nome.equals(loginDonaNome.get(i)) && senha.equals(loginDonaSenha.get(i))) {
            posicao=i;
            if (loginDonaPessoa.get(posicao) == 1) {
                 limiteDinheiro = 500;
                   limite = 5;
                    }
                 if (loginDonaPessoa.get(posicao) == 2) {
                   limite = 5000;
                   limiteDinheiro = 10000;
                 }
            }
          }
        }
        
	//SERIALIZAÇÕES - DESSERIALIZAÇÕES
	public void bancoRoupaSave() {
		for(int i=0;i<7;i++) {
			try
	        {
	            //FileInputStream fis = new FileInputStream("myfile");
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupa.txt"));
	            bancoRoupas2 = (ArrayList) ois.readObject();
	            ois.close();
	           // fis.close();
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
	public void bancoDinheiroSave() {
		try
        {
            FileInputStream fis = new FileInputStream("C:/Projeto/bancodinheiro.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dinheiroDoado = (double) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
            // ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
        
         public void serializaRoupa() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/bancoroupa.txt"));
	         oos.writeObject(bancoRoupas2);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
	public void desserializaRoupa() {
		try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/bancoroupa.txt"));
	        bancoRoupas2 = (ArrayList) ois.readObject();
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
	
	public void serializaLoginDoa() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/salvarpessoaDoa.txt"));
	         oos.writeObject(loginDoaNome);
	         oos.writeObject(loginDoaSenha);
	         oos.writeObject(loginDoaPessoa);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaLoginDoa() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/salvarpessoaDoa.txt"));
		       loginDoaNome = (ArrayList<String>) ois.readObject();
		       loginDoaSenha = (ArrayList<String>) ois.readObject();
                       loginDoaPessoa = (ArrayList<Integer>) ois.readObject();

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
	public void serializaLoginDona() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/salvarpessoaDona.txt"));
	         oos.writeObject(loginDonaNome);
	         oos.writeObject(loginDonaSenha);
	         oos.writeObject(loginDonaPessoa);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaLoginDona() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/salvarpessoaDona.txt"));
		       loginDonaNome = (ArrayList<String>) ois.readObject();
		       loginDonaSenha = (ArrayList<String>) ois.readObject();
		       loginDonaPessoa = (ArrayList<Integer>) ois.readObject();

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
	
	public void serializaContDoa() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/contDoa.txt"));
	         oos.writeObject(contDoa);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaContDoa() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/contDoa.txt"));
		        contDoa = (int) ois.readObject();
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
	public void serializaContDona() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/contDona.txt"));
	         oos.writeObject(contDona);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
	public void desserializaContDona() {
		 try
		    {
		        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/contDona.txt"));
		        contDona =  (int) ois.readObject();
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
        public void serializaInicializar() {
		 try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream ("C:/Projeto/inicializarRoupa.txt"));
	         oos.writeObject(inicializar);
	         oos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		 
	}
	public static void desserializaInicializar() {
		try
	    {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream ("C:/Projeto/inicializarRoupa.txt"));
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
        
	//GETS
        public List<Integer> getBancoRoupas2() {
		return bancoRoupas2;
	}
        public double getBancoDinheiro(){
            return dinheiroDoado;
        }
        public int getBancoRoupas2(int i){
            return bancoRoupas2.get(i);
        }
        
        //SETS
	public void setBancoRoupas2(List<Integer> bancoRoupas2) {
		Pessoa.bancoRoupas2 = bancoRoupas2;
	}
	public void setDinheiroDoado(double dinheiroDoado) throws IOException {
		Pessoa.dinheiroDoado = dinheiroDoado;
	}
        
        public String getNome(int i){
            return loginDonaNome.get(i);
        }
        public int verTamanho(){
            return loginDoaNome.size();
        }
        
    
}
