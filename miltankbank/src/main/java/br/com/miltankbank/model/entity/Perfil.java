package br.com.miltankbank.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "PERFIL", schema = "MILTANKBANK")
public class Perfil implements GrantedAuthority{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL")
    private Long id;
    @Column(name = "NOME_PERFIL")
    private String nome;


    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}
