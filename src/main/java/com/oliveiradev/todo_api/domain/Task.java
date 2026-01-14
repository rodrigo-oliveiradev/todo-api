package com.oliveiradev.todo_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private String status; // PENDENTE, CONCLUIDA

    @Column(nullable = false)
    private String prioridade; // BAIXA, MEDIA, ALTA

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
