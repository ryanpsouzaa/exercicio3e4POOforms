package exercicio3.tarefa.entities;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public abstract class Tarefa implements Comparable<Tarefa> {
    private String nome;
    private LocalDate dataInicio;
    private boolean status;
    private LocalDate dataFim;
    private String identificador;

    public Tarefa(String nome, LocalDate dataInicio, boolean status, LocalDate dataFim){
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.status = status;
        this.dataFim = dataFim;
    }
    public Tarefa(){
        this("",null,false,null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public String getIdentificador(){
        return this.identificador;
    }
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(nome, tarefa.nome) && Objects.equals(dataInicio, tarefa.dataInicio) && Objects.equals(dataFim, tarefa.dataFim) && Objects.equals(identificador, tarefa.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicio, dataFim, identificador);
    }

    @Override
    public int compareTo(Tarefa o){
        return this.nome.compareTo(o.getNome());
    }
}
