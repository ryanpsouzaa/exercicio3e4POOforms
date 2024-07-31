package exercicio3.sistemaAmigo.application;

import exercicio3.sistemaAmigo.entities.Amigo;
import exercicio3.sistemaAmigo.entities.Mensagem;
import exercicio3.sistemaAmigo.entities.SistemaAmigo;

import java.util.List;
import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[]args){
        Scanner resp = new Scanner(System.in);
        //QUESTÃO 4a)
        SistemaAmigo sistemaAmigo = new SistemaAmigo();

        //QUESTÃO 4b)
        System.out.print("Digite a quantidade de pessoas que irão participar do AMIGO SECRETO: ");
        int quantidade = Integer.parseInt(resp.nextLine());

        //QUESTÃO 4c)
        for(int k = 1; k <= quantidade; k++){
            System.out.println("\nParticipante #" + k);
            System.out.print("Digite o nome: ");
            String nome = resp.nextLine();

            System.out.print("Digite o email: ");
            String email = resp.nextLine();

            sistemaAmigo.cadastraAmigo(nome, email);
        }

        //QUESTÃO 4d)
        sistemaAmigo.sortear();
        for (Amigo a : sistemaAmigo.getListaAmigos()){
            String emailAmigoSorteado = sistemaAmigo.pesquisaAmigoSecretoDe(a.getEmail());
            System.out.println(a.getNome() + " tirou " + emailAmigoSorteado);
        }

        //QUESTÃO 4e)
        System.out.print("Deseja enviar alguma mensagem para todos? (s ou n): ");
        String resposta = resp.nextLine();

        if(resposta.equalsIgnoreCase("s")){
            System.out.print("Digite o nome do remetente: ");
            String remetente = resp.nextLine();

            System.out.print("Digite a mensagem: ");
            String mensagem = resp.nextLine();

            System.out.print("A mensagem deve ser passada de forma anônima? (s ou n)");
            String respostaAnonima = resp.nextLine();

            if(respostaAnonima.equalsIgnoreCase("s")){
                sistemaAmigo.enviarMensagemParaTodos(mensagem, remetente, true);
            }else{
                sistemaAmigo.enviarMensagemParaTodos(mensagem, remetente, false);
            }
            List<Mensagem> mensagens = (sistemaAmigo.pesquisarTodasAsMensagens());
            for(Mensagem m : mensagens){
                System.out.println(m.getTextoCompletoAExibir());
            }

            System.out.println("\n Programa finalizado");
        }else{
            System.out.println("Programa finalizado");
            resp.close();
        }

    }
}
