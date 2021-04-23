package com.banco.completo.finaly.entity;

import com.banco.completo.finaly.entity.enums.OperationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "extract")
public class Extract implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExtract")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT3")
    @Column(name = "moveDate",nullable=false)
    private Instant dateTimeMovement;

    @Column(name="operation",nullable=false)
    private Integer operationStatus;

    @Column(name="value")
    private Double operationValue;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "current_account_id")
    private CurrentAccount currentAccount;

    public Extract(){
    }

    public Extract(Long id, Instant dateTimeMovement, Integer operationStatus, Double operationValue, CurrentAccount currentAccount) {
        this.id = id;
        this.dateTimeMovement = dateTimeMovement;
        this.operationStatus = operationStatus;
        this.operationValue = operationValue;
        this.currentAccount = currentAccount;
    }

    public Extract(Object o, OperationStatus withdraw, Double withdraw1, CurrentAccount entity) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateTimeMovement() {
        return Instant.now();
    }

    public OperationStatus operationStatus() {
        return OperationStatus.valueOf(operationStatus);
    }
    public void setDateTimeMovement(Instant dateTimeMovement) {
        this.dateTimeMovement = dateTimeMovement;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        if (operationStatus != null)
        this.operationStatus = operationStatus.getCode();
    }

    public Double getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(Double operationValue) {
        this.operationValue = operationValue;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Extract)) return false;
        Extract extract = (Extract) o;
        return getId().equals(extract.getId()) && Objects.equals(getDateTimeMovement(), extract.getDateTimeMovement()) && Objects.equals(getOperationStatus(), extract.getOperationStatus()) && Objects.equals(getOperationValue(), extract.getOperationValue()) && Objects.equals(getCurrentAccount(), extract.getCurrentAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateTimeMovement(), getOperationStatus(), getOperationValue(), getCurrentAccount());
    }

    @Override
    public String toString() {
        return "Extract{" +
                "id=" + id +
                ", dateTimeMovement=" + dateTimeMovement +
                ", operationStatus=" + operationStatus +
                ", operationValue=" + operationValue +
                ", currentAccount=" + currentAccount +
                '}';
    }
}
