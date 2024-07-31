package exercicio4.entities;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }
    @Override
    public String getTextoCompletoExibir(){
        if(isAnonima()){
            return "Mensagem para todos. Texto: " + getTexto();
        }else{
            return"Mensagem de " + getEmailRemetente() + " para todos. Texto: " + getTexto();
        }
    }
}
