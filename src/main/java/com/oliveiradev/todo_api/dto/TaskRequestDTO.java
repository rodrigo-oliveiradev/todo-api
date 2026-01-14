package com.oliveiradev.todo_api.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskRequestDTO {
    @NotBlank
    private String titulo;

    private String descricao;

    @NotBlank
    private String status;

    @NotBlank
    private String prioridade;

    private Long userId;

    // getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}