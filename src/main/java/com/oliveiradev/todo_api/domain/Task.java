package com.oliveiradev.todo_api.domain;

import com.oliveiradev.todo_api.domain.enums.PrioridadeTask;
import com.oliveiradev.todo_api.domain.enums.StatusTask;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTask status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadeTask prioridade;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
