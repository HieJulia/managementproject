package com.hien.project.model.data;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement(name = "paymentmode")
@Entity
@Table(name = "payment_ap", catalog = "erp_receivable")
public class PaymentAp implements java.io.Serializable {

    private Integer id;
    private String term;


    private Set<Invoice> invoices = new HashSet<Invoice>(0);

    public PaymentAp() {
    }

    public PaymentAp(String term) {
        this.term = term;
    }

    public PaymentAp(String term, Set<Invoice> invoices) {
        this.term = term;
        this.invoices = invoices;
    }

    @XmlElement
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement
    @Column(name = "term", nullable = false, length = 45)
    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @XmlTransient
    @JsonBackReference("paymentAp")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentAp")
    public Set<Invoice> getInvoices() {
        return this.invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

}
