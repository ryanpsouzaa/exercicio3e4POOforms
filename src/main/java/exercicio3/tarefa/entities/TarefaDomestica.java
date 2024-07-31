package exercicio3.tarefa.entities;

import java.time.LocalDate;

public class TarefaDomestica extends Tarefa{
    private String comodo;
    private String funcao;

    public TarefaDomestica(String nome, LocalDate dataInicio, boolean status, LocalDate dataFim, String comodo, String funcao) {
        super(nome, dataInicio, status, dataFim);
        setIdentificador("DOMESTICA");
        this.comodo = comodo;
        this.funcao = funcao;

    }

    public String getComodo() {
        return comodo;
    }

    public void setComodo(String comodo) {
        this.comodo = comodo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
