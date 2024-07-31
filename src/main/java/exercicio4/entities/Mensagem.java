package exercicio4.entities;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(){
        this("","",false);
    }
    public Mensagem(String texto, String emailRemetente, boolean anonima){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean isAnonima() {
        return anonima;
    }

    public void setAnonima(boolean anonima) {
        this.anonima = anonima;
    }
    public abstract String getTextoCompletoExibir();
}
