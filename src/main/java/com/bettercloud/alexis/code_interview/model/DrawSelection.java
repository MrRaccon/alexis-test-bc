package com.bettercloud.alexis.code_interview.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "draw_selection")
public class DrawSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "draw_selection_id")
    private int drawSelectionId;

    @ManyToOne
    @JoinColumn(name = "person_id_receive", nullable = false)
    private Person personReceive;

    @ManyToOne
    @JoinColumn(name = "person_id_give", nullable = false)
    private Person personGive;

    @Column(name = "year_draw")
    private int yearDraw;
    
    
	
}
