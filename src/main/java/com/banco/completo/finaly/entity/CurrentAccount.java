package com.banco.completo.finaly.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@RequestMapping(name = "current_account")

public class CurrentAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Integer currentAccountNumber;

    @Column(name = "balance")
    private Double balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "Extract_id")
    private Extract extract;

    @OneToMany(mappedBy = "currentAccount")
    private final List<Extract> extracts = new ArrayList<>();

    public CurrentAccount(){
    }

    public CurrentAccount(Long id, Integer currentAccountNumber, Double balance, Agency agency) {
        this.id = id;
        this.currentAccountNumber = currentAccountNumber;
        this.balance = balance;
        this.agency = agency;
    }

    public Long getId() {
        return id;
    }

    public Integer getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(Integer currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double value) {
        this.balance += value;
    }

    public void setDeposit(Double deposit) {
        this.balance += deposit;
    }

    public void setWithdraw(Double withdraw){
        this.balance -= withdraw;
    }

    public void setTransfer(Double transfer) {
        this.balance -= transfer;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentAccount)) return false;
        CurrentAccount that = (CurrentAccount) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCurrentAccountNumber(), that.getCurrentAccountNumber()) && Objects.equals(getBalance(), that.getBalance()) && Objects.equals(getAgency(), that.getAgency()) && Objects.equals(extract, that.extract) && Objects.equals(extracts, that.extracts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCurrentAccountNumber(), getBalance(), getAgency(), extract, extracts);
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + id +
                ", currentAccountNumber=" + currentAccountNumber +
                ", balance=" + balance +
                ", agency=" + agency +
                ", extract=" + extract +
                ", extracts=" + extracts +
                '}';
    }
}

