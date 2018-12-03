
package controller;

import Exceptions.LoginOuSenhaIncorreto;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import model.TrocaRoupa;

public class TrocaRoupaControl {
    
    private static TrocaRoupa troca; 
    public static int aux=0; 
    
    //CADASTRO
     public static void cadastroTrocaRoupa(String nome, String senha){
        troca = new TrocaRoupa(nome, senha);
        troca.cadastro(nome, senha);
       
         if(TrocaRoupa.verificado==1){
             
        troca.desserializaContBancoTroca();
        
        troca.dadas.add(TrocaRoupa.contbanco, 0);
        troca.recebidas.add(TrocaRoupa.contbanco,0);
        troca.bonus.add(TrocaRoupa.contbanco, 0);
        
        TrocaRoupa.contbanco++;
        troca.serializaContBancoTroca();
        troca.desserializaContBancoTroca();
        
            aux=1;
        }
        else{
            aux=0;
        }
    }
    //LOGIN
    public static void loginTrocaRoupa(String nome, String senha) throws LoginOuSenhaIncorreto{
       troca = new TrocaRoupa(nome,senha);
       troca.login(nome, senha);
 
       if(TrocaRoupa.verificado==1){
           JOptionPane.showMessageDialog(null, "Login Realizado Com sucesso!", "Login Efetivado", WIDTH);
            aux=1;
        }
       else if(TrocaRoupa.verificado==0){
            aux=0;
            throw new Exceptions.LoginOuSenhaIncorreto("Login e/ou senha incorretos");
       }
    }
    
    //Ações
    public static void trocaDeRoupas(String nome,String senha,int tipo, int qtde){
        
       
        troca.bancoRoupaDesserializar();
        troca.desserializaBonus();
        troca.desserializaDadas();
        troca.desserializaRecebidas();
        
        troca.verificaLogin(nome, senha);
        troca.trocaDeRoupas(tipo, qtde);
        
        troca.serializaBonus();
        troca.serializaDadas();
        troca.serializaRecebidas();
        troca.bancoRoupaSerializar();
       
        
    }
    
    public static void recebimentoDeRoupas(String nome,String senha,int tipo, int qtde){
        troca.bancoRoupaDesserializar();
        troca.desserializaBonus();
        troca.desserializaDadas();
        troca.desserializaRecebidas();
        
        troca.verificaLogin(nome, senha);
        troca.recebimentoDeRoupas(tipo, qtde);
      
        troca.serializaBonus();
        troca.serializaDadas();
        troca.serializaRecebidas();
        troca.bancoRoupaSerializar();
    }
    
    //SALVAMENTO
    public static void serializaBancoRoupas(){
       troca.bancoRoupaSerializar();
    }
     
    //VISUALIZAÇÕES
    public static void desserializaBancoRoupas(){
       troca.bancoRoupaDesserializar();
    }
    public static int verDadas(String nome, String senha){
        troca.desserializaDadas();
        troca.verificaLogin(nome, senha);
        return TrocaRoupa.dadas.get(TrocaRoupa.posicao);
    }
     public static int verRecebidas(String nome, String senha){
        troca.desserializaRecebidas();
         troca.verificaLogin(nome, senha);
        return TrocaRoupa.recebidas.get(TrocaRoupa.posicao);
    }
      public static int verBonus(String nome, String senha){
          troca.desserializaBonus();
        troca.verificaLogin(nome, senha);
        return TrocaRoupa.bonus.get(TrocaRoupa.posicao);
    }
    
    
}
