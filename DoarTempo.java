/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doarTempo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author karol
 */
public class DoarTempo {
    public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      List<UsuarioDoador> usuariosDoadores = new ArrayList<UsuarioDoador>();
      DecimalFormat df = new DecimalFormat("000");
      Relatorio relatorio = new Relatorio();

      int opcao;

      while(true)
      {
         System.out.println("\n Escolha uma das seguintes opções:\n\n"
                           +" 1 - Inserir Dados Doador Tempo\n"
                           +" 2 - Consultar dados\n"
                           +" 3 - Sair\n");

         System.out.print(" Opção escolhida: ");
         opcao = scan.nextInt();

         switch(opcao)
         {
            case 1:
	UsuarioDoador usuarioDoador = new UsuarioDoador();

	System.out.print("\n\t\t\t\t\t Nome: ");
	String nomeUsuarioDoador = scan.nextLine();
	usuarioDoador.setNome(nomeUsuarioDoador);
	
	System.out.print("\n\t\t\t\t\t Idade: ");
	int idadeUsuarioDoador = Integer.parseInt(scan.nextLine());
	usuarioDoador.setIdade(idadeUsuarioDoador);

	System.out.print("\n\t\t\t\t\t Número: ");
	String numeroUsuarioDoador = scan.nextLine();
	usuarioDoador.setNumero(numeroUsuarioDoador);

	//               relatorio.setNome(scan.nextLine());
	//             relatorio.listagem(opcao);
            break;
            case 2:
                //teste.addAll(relatorio.listagem(opcao));
               System.out.println("_____________________________________________");
               System.out.println("\t\tRELATÓRIO");
               System.out.println("_____________________________________________");

               /*for(int i = 0; i < usuariosDoadores.size(); i++) {
                  System.out.println("" + df.format((i+1)) + " " + teste.get(i));
               }*/

               System.out.println(" _____________________________________________\n\n");
               System.exit(0);
            break;
            case 3:
               System.exit(0);
            break;
            default:
               System.out.println("\t\t\t\t\t Opção inexistente! Tente novamente.\n\n");
         }
      }
   }
}
