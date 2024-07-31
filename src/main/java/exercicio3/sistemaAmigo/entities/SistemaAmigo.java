package exercicio3.sistemaAmigo.entities;

import exercicio3.sistemaAmigo.exception.AmigoNaoEncontradoException;
import exercicio3.sistemaAmigo.exception.ListaNulaException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo amigoElemento = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.add(amigoElemento);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoEncontradoException {
        for (Amigo a : this.amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                return a;
            }
        }
        throw new AmigoNaoEncontradoException("Amigo não encontrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        Mensagem mensagemElemento = new MensagemParaTodos(texto, emailRemetente, anonima);
        this.mensagens.add(mensagemElemento);
    }

    public void enviarMensagemParaalguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        Mensagem mensagemElemento = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        this.mensagens.add(mensagemElemento);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() throws ListaNulaException {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        if (mensagensAnonimas.isEmpty()) {
            throw new ListaNulaException("Não foi registrada nenhuma mensagem anônima");
        } else {
            return mensagensAnonimas;
        }
    }

    public List<Mensagem> pesquisarTodasAsMensagens() throws ListaNulaException {
        List<Mensagem> todasMensagens = new ArrayList();
        for (Mensagem m : this.mensagens) {
            todasMensagens.add(m);
        }
        if (todasMensagens.isEmpty()) {
            throw new ListaNulaException("Nenhuma mensagem foi registrada");
        } else {
            return todasMensagens;
        }
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoNaoEncontradoException {
        boolean confirmacao = false;
        for (Amigo a : this.amigos) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                confirmacao = true;
            }
        }
        if (!confirmacao) {
            throw new AmigoNaoEncontradoException("A pessoa mencionada não se encontra cadastrada");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoEncontradoException {
        for (Amigo a : this.amigos) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                return a.getEmailAmigoSorteado();
            }
        }
        throw new AmigoNaoEncontradoException("Pessoa mencionada não encontrada");
    }

    public List<Amigo> listarSemAmigosSemSecreto() throws ListaNulaException {
        List<Amigo> semSecreto = new ArrayList<>();
        for (Amigo a : this.amigos) {
            if (a.getEmailAmigoSorteado() == null) {
                semSecreto.add(a);
            }
        }
        if (semSecreto.isEmpty()) {
            if (this.amigos.isEmpty()) {
                throw new ListaNulaException("Não há participantes registrados");
            } else {
                throw new ListaNulaException("Todos os participantes já possuem seus AMIGOS SECRETOS");
            }
        } else {
            return semSecreto;
        }
    }

    //QUESTÃO 5)
    public void sortear() {
        List<Amigo> amigosNaoSorteados = new ArrayList<>(this.amigos);
        Collections.shuffle(amigosNaoSorteados);

        for (Amigo amigo : this.amigos) {
            int posicaoDaListaSorteada = (int) (Math.random() * amigosNaoSorteados.size());
            while (amigo.getEmail().equals(amigosNaoSorteados.get(posicaoDaListaSorteada).getEmail())) {
                posicaoDaListaSorteada = (int) (Math.random() * amigosNaoSorteados.size());
            }
            Amigo amigoSorteado = amigosNaoSorteados.get(posicaoDaListaSorteada);
            amigo.setEmailAmigoSorteado(amigoSorteado.getEmail());
            amigosNaoSorteados.remove(posicaoDaListaSorteada);
        }
    }
    public List<Amigo> getListaAmigos(){
        return this.amigos;
    }


}
