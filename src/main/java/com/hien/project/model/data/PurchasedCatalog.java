package com.hien.project.model.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchased_catalog", catalog = "erp_purchasing")
public class PurchasedCatalog implements java.io.Serializable {

    // Purchase Catalog : id, purchaseOrder, catId, qty
    private Integer id;
    private PurchaseOrder purchaseOrder;
    private int catId;
    private int qty;

    public PurchasedCatalog() {
    }

    public PurchasedCatalog(PurchaseOrder purchaseOrder, int catId, int qty) {
        this.purchaseOrder = purchaseOrder;
        this.catId = catId;
        this.qty = qty;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poId", nullable = false)
    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Column(name = "catId", nullable = false)
    public int getCatId() {
        return this.catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Column(name = "qty", nullable = false)
    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
