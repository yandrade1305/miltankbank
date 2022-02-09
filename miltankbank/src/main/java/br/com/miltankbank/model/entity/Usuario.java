package br.com.miltankbank.model.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USUARIO", schema = "MILTANKBANK")
public class Usuario implements UserDetails{
    @Id
    @SequenceGenerator(name = "MILTANKBANK.ID_USUARIO_SEQ", sequenceName = "MILTANKBANK.ID_USUARIO_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "MILTANKBANK.ID_USUARIO_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USUARIO")
    private Long id;
    @Column(name = "NOME_COMPLETO_USUARIO")
    private String nomeCompleto;
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "SENHA")
    private String senha;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    name = "USUARIO_PERFIS", schema = "MILTANKBANK",
    joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"), 
    inverseJoinColumns = @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL"))
    private List<Perfil> perfis;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nomeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
    
}
