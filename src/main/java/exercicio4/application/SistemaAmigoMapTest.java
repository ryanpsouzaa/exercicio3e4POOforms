package exercicio4.application;

import exercicio4.entities.Amigo;
import exercicio4.entities.Mensagem;
import exercicio4.entities.SistemaAmigo;
import exercicio4.exception.AmigoNaoEncontradoException;
import exercicio4.exception.ListaNulaException;

import java.util.Map;

public class SistemaAmigoMapTest {
    public static void main(String[]args){
        /* testar:
+ cadastrarAmigo
+ pesquisaAmigo
+ enviarMensagemParaTodos
+ enviarMensagemParaAlguem
+ pesquisaMensagensAnonimas
+ pesquisarTodasAsMensagens
+ configuraAmigoSecretoDe
+ pesquisaAmigoSecretoDe
*/
        SistemaAmigo lista = new SistemaAmigo();
        String nomeAmigo1 = "Alex";
        String emailAmigo1 = "alex@gmail.com";

        String nomeAmigo2 = "Ana";
        String emailAmigo2 = "ana@gmail.com";

        String nomeAmigo3 = "Bob";
        String emailAmigo3 = "bob@gmail.com";

        String nomeAmigo4 = "Jorge";
        String emailAmigo4 = "jorge@gmail.com";
        try{
            System.out.println("Cadastrando os 4 Amigos: ");
            lista.cadastraAmigo(nomeAmigo1, emailAmigo1);
            lista.cadastraAmigo(nomeAmigo2, emailAmigo2);
            lista.cadastraAmigo(nomeAmigo3, emailAmigo3);
            lista.cadastraAmigo(nomeAmigo4, emailAmigo4);

            System.out.println("\n");
            System.out.println("Pesquisando Alex: ");
            Amigo amigoPesquisado1 = lista.pesquisaAmigo(emailAmigo1);
            System.out.println(amigoPesquisado1.getNome());

            System.out.println("\n");
            System.out.println("Enviando mensagem para todos: ");
            lista.enviarMensagemParaTodos("Olá, boa tarde","jorge@gmail.com",true);
            lista.enviarMensagemParaTodos("Olá, bom dia", "bob@gmail.com",false);

            System.out.println("\n");
            System.out.println("Enviando mensagem para alguém: ");
            lista.enviarMensagemParaAlguem("Trabalho é dia 1","alex@gmail.com","ana@gmail.com",false);
            lista.enviarMensagemParaAlguem("Na verdade, o trabalho é para o dia 2","ana@gmail.com","alex@gmail.com",true);

            System.out.println("\n");
            System.out.println("Pesquisando mensagens anônimas: ");
            Map<Amigo, Mensagem> mensagensAnonimas = lista.pesquisaMensagensAnonimas();
            for(Amigo key : mensagensAnonimas.keySet()){
                System.out.println(mensagensAnonimas.get(key).getTextoCompletoExibir());
            }

            System.out.println("\n");
            System.out.println("Pesquisando todas as mensagens: ");
            Map<Amigo, Mensagem> todasMensagens = lista.pesquisarTodasAsMensagens();
            for(Amigo key : todasMensagens.keySet()){
                System.out.println(todasMensagens.get(key).getTextoCompletoExibir());

            }

            System.out.println("\n");
            System.out.println("Configurando amigo secreto:");
            lista.configuraAmigoSecretoDe("bob@gmail.com","ana@gmail.com");
            lista.configuraAmigoSecretoDe("ana@gmail.com","alex@gmail.com");
            lista.configuraAmigoSecretoDe("alex@gmail.com", "jorge@gmail.com");
            lista.configuraAmigoSecretoDe("jorge@gmail.com", "bob@gmail.com");

            System.out.println("\n");
            System.out.println("Pesquisando amigo secreto:");
            System.out.println(lista.pesquisaAmigoSecretoDe("bob@gmail.com"));
            System.out.println(lista.pesquisaAmigoSecretoDe("alex@gmail.com"));
            System.out.println(lista.pesquisaAmigoSecretoDe("ana@gmail.com"));
            System.out.println(lista.pesquisaAmigoSecretoDe("jorge@gmail.com"));


        }catch(AmigoNaoEncontradoException | ListaNulaException e){
            System.out.println(e.getMessage());
        }
    }
}
