package com.hien.project.model.data;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PurchaseOrder generated by hbm2java
 */
@Entity
@Table(name = "purchase_order", catalog = "erp_purchasing")
public class PurchaseOrder implements java.io.Serializable {

    // Purchase order : id, payment, sid, cid, date
    private int id;
    private PaymentPo paymentPo;
    private int sid;
    private int cid;
    private Date date;
    private Set<PurchasedCatalog> purchasedCatalogs = new HashSet<PurchasedCatalog>(
            0);

    public PurchaseOrder() {
    }

    public PurchaseOrder(int id, PaymentPo paymentPo, int sid, int cid,
                         Date date) {
        this.id = id;
        this.paymentPo = paymentPo;
        this.sid = sid;
        this.cid = cid;
        this.date = date;
    }

    public PurchaseOrder(int id, PaymentPo paymentPo, int sid, int cid,
                         Date date, Set<PurchasedCatalog> purchasedCatalogs) {
        this.id = id;
        this.paymentPo = paymentPo;
        this.sid = sid;
        this.cid = cid;
        this.date = date;
        this.purchasedCatalogs = purchasedCatalogs;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid", nullable = false)
    public PaymentPo getPaymentPo() {
        return this.paymentPo;
    }

    public void setPaymentPo(PaymentPo paymentPo) {
        this.paymentPo = paymentPo;
    }

    @Column(name = "sid", nullable = false)
    public int getSid() {
        return this.sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Column(name = "cid", nullable = false)
    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseOrder")
    public Set<PurchasedCatalog> getPurchasedCatalogs() {
        return this.purchasedCatalogs;
    }

    public void setPurchasedCatalogs(Set<PurchasedCatalog> purchasedCatalogs) {
        this.purchasedCatalogs = purchasedCatalogs;
    }

}
