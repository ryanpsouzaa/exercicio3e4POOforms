package exercicio3.tarefa.entities;

import java.time.LocalDate;

public class TarefaTrabalho extends Tarefa{
    private String empresa;
    private String cargo;
    private String encargo;

    public TarefaTrabalho(String nome, LocalDate dataInicio, boolean status, LocalDate dataFim, String empresa, String cargo, String encargo) {
        super(nome, dataInicio, status, dataFim);
        setIdentificador("TRABALHO");
        this.empresa = empresa;
        this.cargo = cargo;
        this.encargo = encargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEncargo() {
        return encargo;
    }

    public void setEncargo(String encargo) {
        this.encargo = encargo;
    }

}
