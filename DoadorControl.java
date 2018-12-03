
package controller;

import Exceptions.LoginOuSenhaIncorreto;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import model.Doador;
import model.Pessoa;

public class DoadorControl {
    
    private static Doador doador;
    public static int aux=0;
    
    //Cadastro e login
    public static void cadastroDoador(String nome, String senha, int tipoPessoa){
        try {
        doador = new Doador(nome, senha, tipoPessoa, "Doador");
        doador.cadastro("Doador", nome, senha);
        if(Pessoa.verificado==1){
            aux=1;
        }
        else{
            aux=0;
        }
        }catch(Exceptions.LoginJaCadastrado e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro não efetivado", WIDTH);
        }
    }
    
    public static void loginDoador(String nome, String senha) throws LoginOuSenhaIncorreto{
       doador = new Doador();
       doador.login(nome,senha,"Doador");
       if(Pessoa.verificado==1){
           JOptionPane.showMessageDialog(null, "Login Realizado Com sucesso!", "Login Efetivado", WIDTH);
            aux=1;
        }
       else if(Pessoa.verificado==0){
          
            aux=0;
            throw new Exceptions.LoginOuSenhaIncorreto("Login e/ou senha incorretos");
       }
    }
    
    //Ações
    public static void doarDinheiro(double dinheiro){
        
       if(dinheiro>0) {
        doador.doacaoDinheiro(dinheiro);
       
       }
       else{
           JOptionPane.showMessageDialog(null, "Valor inserido inválido!","Doação não efetivada", WIDTH);
       }
        salvarBancoDinheiro();
    }
    
    public static void doarRoupas(int tipoRoupa,int quantRoupa){
        
        doador.doarRoupa(tipoRoupa, quantRoupa); 
        salvarBancoRoupas();
       
        
    }
    
    //Salvamentos
     public static void salvarBancoDinheiro(){
         doador.bancoDinheiroSave();
    }
     
     public static void salvarBancoRoupas(){
         doador.bancoRoupaSave();
    }
    
     //Visualizações
    public static void verBancoDinheiro(){
       doador.getBancoDinheiro();
    }
    
    public static void verBancoRoupas(int i){
      doador.getBancoRoupas2(i);
    }
    
      //Notificações ao usuario
        public static void novaInstNaLista(){
    }
        public static void agradecimentos(){
            
        }

     
    
    
    
    
    
    
    
    
    
    
    
}
