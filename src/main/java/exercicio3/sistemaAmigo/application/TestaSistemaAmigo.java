package exercicio3.sistemaAmigo.application;

import exercicio3.sistemaAmigo.entities.Mensagem;
import exercicio3.sistemaAmigo.entities.SistemaAmigo;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[]args){
        SistemaAmigo sistemaAmigo = new SistemaAmigo();
        //QUESTÃO 3a)
        String nome1 = "José";
        String nome2 = "Maria";

        String emailJose = "joseconta@gmail.com";
        String emailMaria = "mariaconta@gmail.com";

        sistemaAmigo.cadastraAmigo(nome1, emailJose);
        sistemaAmigo.cadastraAmigo(nome2, emailMaria);

        //QUESTÃO 3b)
        sistemaAmigo.configuraAmigoSecretoDe(emailJose, emailMaria);
        sistemaAmigo.configuraAmigoSecretoDe(emailMaria, emailJose);

        //QUESTÃO 3c)
        String mesagemAnonimaParaJose = "Não se esqueça do trabalho";
        sistemaAmigo.enviarMensagemParaalguem(mesagemAnonimaParaJose, emailMaria, emailJose, true);

        //QUESTÃO 3d)
        String mensagemAnonimaParaTodos = "Trabalho é para o dia 7 desse mês";
        sistemaAmigo.enviarMensagemParaTodos(mensagemAnonimaParaTodos, emailMaria, true);

        //QUESTÃO 3e)
        List<Mensagem> mensagensAnonimas = sistemaAmigo.pesquisaMensagensAnonimas();
        for(Mensagem m : mensagensAnonimas){
            System.out.println(m.getTextoCompletoAExibir());
        }

        //QUESTÃO 3d)
        String emailSecreto = sistemaAmigo.pesquisaAmigoSecretoDe(emailJose);
        if(emailSecreto.equals(emailMaria)){
            System.out.println("OK");
        }else{
            System.out.println("ERRO");
        }
    }
}
