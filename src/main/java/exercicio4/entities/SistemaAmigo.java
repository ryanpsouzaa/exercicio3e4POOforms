package exercicio4.entities;

import exercicio4.exception.AmigoNaoEncontradoException;
import exercicio4.exception.ListaNulaException;

import java.util.HashMap;
import java.util.Map;

public class SistemaAmigo {
    private Map<Amigo, Mensagem> lista;

    public SistemaAmigo(){
        this.lista = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo amigoElemento = new Amigo(nomeAmigo,emailAmigo);
        this.lista.put(amigoElemento, null);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoNaoEncontradoException {
        for(Amigo key : this.lista.keySet()){
            if(key.getEmail().equalsIgnoreCase(emailAmigo)){
                return key;
            }
        }
        throw new AmigoNaoEncontradoException("Amigo não cadastrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) throws AmigoNaoEncontradoException {
        Mensagem mensagemElemento = new MensagemParaTodos(texto, emailRemetente, anonima);
        Amigo amigoElemento = pesquisaAmigo(emailRemetente);
        this.lista.put(amigoElemento, mensagemElemento);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRementente, String emailDestinatario, boolean anonima) throws AmigoNaoEncontradoException {
        Mensagem mensagemElemento = new MensagemParaAlguem(texto, emailRementente,anonima, emailDestinatario);
        Amigo amigoElemento = pesquisaAmigo(emailRementente);
        this.lista.put(amigoElemento, mensagemElemento);
    }

    public Map<Amigo, Mensagem> pesquisaMensagensAnonimas() throws ListaNulaException {

        Map<Amigo, Mensagem> mapMensagensAnonimas = new HashMap<>();
        for(Amigo key : this.lista.keySet()){
            if(this.lista.get(key).isAnonima()){
                mapMensagensAnonimas.put(key, this.lista.get(key));
            }

        }
        if(mapMensagensAnonimas.isEmpty()){
            throw new ListaNulaException("Não foram encontradas mensagens anônimas");
        }else{
            return mapMensagensAnonimas;
        }
    }

    public Map<Amigo, Mensagem> pesquisarTodasAsMensagens() throws ListaNulaException {

        Map<Amigo, Mensagem> mapTodasMensagens = new HashMap<>();
        for(Amigo key : this.lista.keySet()){
            if(this.lista.get(key).getTexto() != null){
                mapTodasMensagens.put(key, this.lista.get(key));
            }
        }
        if(mapTodasMensagens.isEmpty()){
            throw new ListaNulaException("Não foram encontradas mensagens");
        }else{
            return mapTodasMensagens;
        }
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoNaoEncontradoException{
        boolean confirmacao = false;
        for(Amigo key : this.lista.keySet()){
            if(key.getEmail().equalsIgnoreCase(emailDaPessoa)){
                key.setEmailAmigoSorteado(emailAmigoSorteado);
                confirmacao = true;
            }
        }
        if(!confirmacao){
            throw new AmigoNaoEncontradoException("Email informado não se encontra cadastrado");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoEncontradoException{
        for(Amigo key : this.lista.keySet()){
            if(key.getEmail().equalsIgnoreCase(emailDaPessoa)){
                return key.getEmailAmigoSorteado();
            }

        }
        throw new AmigoNaoEncontradoException("Email informado não se encontra cadastrado");
    }


}
