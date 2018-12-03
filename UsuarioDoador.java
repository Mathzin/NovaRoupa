/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doarTempo;

/**
 *
 * @author karol
 */
public class UsuarioDoador {
    private String nome;
	private String numero;
	private int idade;

	public void setNome(String nome) { 
            this.nome = nome; }
	public String getNome() { 
            return this.nome; }

        public String getNumero(){
            return numero;
        }
       public int getIdade(){
            return idade;
        }
       
       public void setNumero(String numero){
           this.numero=numero;
       }
       public void setIdade(int idade){
           this.idade=idade;
       }
        
        

}
