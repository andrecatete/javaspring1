package tasks.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

public class Task {
	private Long Id;
	
	@Size(min = 3, message="A descrição deve ter pelo menos 3 caracteres") // o "messagem" inclui uma mensagem de erro na execução do programa
	private String descricao;
	private boolean finalizada;
	private Calendar dataFinalizacao; 				//utilizar o Calendar do java.util
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
}
