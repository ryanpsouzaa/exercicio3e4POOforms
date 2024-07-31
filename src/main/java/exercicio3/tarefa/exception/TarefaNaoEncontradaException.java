package exercicio3.tarefa.exception;

public class TarefaNaoEncontradaException extends RuntimeException{
    public TarefaNaoEncontradaException(String msg){
        super(msg);
    }
}
