package com.banco.completo.finaly.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone")
    private String phone;

    public Client() {
    }

    public Client(Long id, String nome, String cpf, String phone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
            this.cpf = cpf;
        }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getNome(), client.getNome()) && Objects.equals(getCpf(), client.getCpf()) && Objects.equals(getPhone(), client.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getPhone());
    }
}
