package com.banco.completo.finaly.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agency")
public class Agency implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "agency")
    private final List<CurrentAccount> accountList = new ArrayList<>();


    public Agency() {
    }

    public Agency(Long id, String nome, String address, String phone, Client client) {
        this.id = id;
        this.nome = nome;
        this.address = address;
        this.phone = phone;
        this.client = client;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CurrentAccount> getAccountList() {
        return accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agency)) return false;
        Agency agency = (Agency) o;
        return Objects.equals(getId(), agency.getId()) && Objects.equals(getNome(), agency.getNome()) && Objects.equals(getAddress(), agency.getAddress()) && Objects.equals(getPhone(), agency.getPhone()) && Objects.equals(getClient(), agency.getClient()) && Objects.equals(getAccountList(), agency.getAccountList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getAddress(), getPhone(), getClient(), getAccountList());
    }
}

