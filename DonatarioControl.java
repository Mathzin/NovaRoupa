
package controller;

import Exceptions.LoginOuSenhaIncorreto;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import model.Donatario;
import model.Pessoa;

public class DonatarioControl {
   
    public static int aux =0;
    private static Donatario donatario;
    public static boolean verificacao;
    
    
    
    //CADASTRO
    public static void cadastroDonatario(String nome, String senha, int tipoPessoa){
          try {
        donatario = new Donatario(nome, senha,tipoPessoa,"Donatario");
        donatario.cadastro("Donatario", nome, senha);
      
        if(Pessoa.verificado==1){
            aux=1;
            donatario.serializaContRecebidos();
            donatario.desserializaContRecebidos();
            
            donatario.recebidas.add(donatario.contRecebidos, 0);
            donatario.recebidasDin.add(donatario.contRecebidos, 0.0);
            donatario.contRecebidos++;
            donatario.serializaContRecebidos();
            
        }
        else if(Pessoa.verificado==0){
            aux=0;
        }
        }catch(Exceptions.LoginJaCadastrado e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro não efetivado", WIDTH);
        } 
        
    }
    
    //LOGIN
    public static void loginDonatario(String nome, String senha) throws LoginOuSenhaIncorreto{
       donatario = new Donatario();
       donatario.login(nome, senha, "Donatario");
  
       if(Pessoa.verificado==1){
           donatario.verificaLogin(nome, senha);
            aux=1;
        }
        else if(Pessoa.verificado==0){
            aux=0;
             throw new Exceptions.LoginOuSenhaIncorreto("Login e/ou senha incorretos");
        }
    }
    
    //AÇÕES
    public static void receberDinheiro(String nome, String senha,double dinheiro){
        donatario.serializaRecebidasDin();
        donatario.desserializaRecebidasDin();
        salvarBancoDinheiro();
        donatario.verificaLogin(nome, senha);
        donatario.receberDinheiro(dinheiro);
        salvarBancoDinheiro();
        donatario.serializaRecebidasDin();
        
    }
    
    public static void receberRoupas(String nome, String senha, int tipoRoupa,int quantRoupa){
        donatario.serializaRecebidas();
        salvarBancoRoupas();
        donatario.verificaLogin(nome, senha);
        donatario.receberRoupas(tipoRoupa, quantRoupa);
        salvarBancoRoupas();
        donatario.serializaRecebidas();
    }
    
    public static int limiteRoupas(){
        return Pessoa.limite;
    }
     public static int limiteDinheiro(){
        return Pessoa.limiteDinheiro;
    }
    
    //VISUALIZAÇÕES
     
    public static int verRoupasRecebidas(String nome, String senha){
        donatario.desserializaRecebidas();
        donatario.verificaLogin(nome,senha);
         return donatario.verTotalRoupasRecebidas(Pessoa.posicao);
     }
     
       public static double verDinheiroRecebido(String nome, String senha){
           donatario.desserializaRecebidasDin();
        donatario.verificaLogin(nome,senha);
           return donatario.verDinheiroRecebido(Pessoa.posicao);
    }
    
    public static void verBancoDinheiro(){
       donatario.getBancoDinheiro();
    }
    
    public static void verBancoRoupas(){
       donatario.getBancoRoupas2();
    }
    
    //SALVAMENTOS
     public static void salvarBancoDinheiro(){
       donatario.bancoDinheiroSave();
    }
     
     public static void salvarBancoRoupas(){
       donatario.bancoRoupaSave();
    }
      
      
}
