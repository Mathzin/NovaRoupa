/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doarTempo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class Relatorio {
    List<String> nomes = new ArrayList<String>();

   private String nome;

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public List<String> listagem(int selecao)
   {  
      if(selecao == 1)
      {
         nomes.add(getNome());
      }

      return nomes;
   }
}
