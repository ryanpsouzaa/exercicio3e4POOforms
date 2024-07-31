package exercicio3.tarefa.entities;

import java.time.LocalDate;

public class TarefaFaculdade extends Tarefa{
    private String disciplina;
    private LocalDate dataProva;
    private int unidade;

    public TarefaFaculdade(String nome, LocalDate dataInicio, boolean status, LocalDate dataFim, String disciplina, LocalDate dataProva, int unidade) {
        super(nome,dataInicio, status, dataFim);
        setIdentificador("FACULDADE");
        this.disciplina = disciplina;
        this.dataProva = dataProva;
        this.unidade = unidade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDate getDataProva() {
        return dataProva;
    }

    public void setDataProva(LocalDate dataProva) {
        this.dataProva = dataProva;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

}
