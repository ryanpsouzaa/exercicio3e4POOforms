package exercicio3.tarefa.entities;

import exercicio3.tarefa.exception.ListaTarefaNulaException;
import exercicio3.tarefa.exception.TarefaNaoEncontradaException;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> listaTarefas;

    public ListaTarefa(){
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefaElemento){
        this.listaTarefas.add(tarefaElemento);
    }
    public void removerTarefa(Tarefa tarefaElemento){
        this.listaTarefas.remove(tarefaElemento);
    }

    public List<Tarefa> tarefasPendentes() throws ListaTarefaNulaException {
        List<Tarefa> tarefasPendentes = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(t.isStatus()){
                tarefasPendentes.add(t);
            }
        }
        if(tarefasPendentes.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas pendentes registradas.");
        }else{
            return tarefasPendentes;
        }
    }
    public List<Tarefa> tarefasConcluidas() throws ListaTarefaNulaException{
        List<Tarefa> tarefasConcluidas = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(!t.isStatus()){
                tarefasConcluidas.add(t);
            }
        }
        if(tarefasConcluidas.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas concluídas registradas.");
        }else{
            return tarefasConcluidas;
        }
    }
    public List<Tarefa> filtrarTarefasDomesticas() throws ListaTarefaNulaException{
        List<Tarefa> listaDomestica = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(t.getIdentificador().equals("DOMESTICA")){
                listaDomestica.add(t);
            }
        }
        if(listaDomestica.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas domésticas registradas.");
        }else{
            return listaDomestica;
        }
    }
    public List<Tarefa> filtrarTarefasTrabalho() throws ListaTarefaNulaException{
        List<Tarefa> listaTrabalho = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(t.getIdentificador().equals("TRABALHO")){
                listaTrabalho.add(t);
            }
        }
        if(listaTrabalho.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas de trabalho registradas.");
        }else{
            return listaTrabalho;
        }

    }
    public List<Tarefa> filtrarTarefasFaculdade() throws ListaTarefaNulaException{
        List<Tarefa> listaFaculdade = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(t.getIdentificador().equals("FACULDADE")){
                listaFaculdade.add(t);
            }
        }
        if(listaFaculdade.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas da faculdade registradas.");
        }else{
            return listaFaculdade;
        }
    }
    public List<Tarefa> filtrarTarefasData(LocalDate data)throws ListaTarefaNulaException{
        List<Tarefa> listaTarefasData = new ArrayList<>();
        for(Tarefa t : this.listaTarefas){
            if(t.getDataInicio().equals(data)){
                listaTarefasData.add(t);
            }
        }
        if(listaTarefasData.isEmpty()){
            throw new ListaTarefaNulaException("Não há tarefas registradas com essa data de início");
        }else{
            return listaTarefasData;
        }
    }

    public Tarefa consultarTarefa(String nome)throws TarefaNaoEncontradaException {
        for(Tarefa t : this.listaTarefas){
            if(t.getNome().equals(nome)){
                return t;
            }
        }
        throw new TarefaNaoEncontradaException("Tarefa não encontrada");
    }

}
