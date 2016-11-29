package sdomain.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Receipt {

    private int id;
    private String productName;
    private String currency;
    private BigDecimal price;
    private Date purchaseDate;
    private Date warrantyDate;
    private String category;
    private String shopName;
    private String shopInvoice;
    private String shopAddress;
    private String shopPhone;
    private String remarks;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopInvoice() {
        return shopInvoice;
    }

    public void setShopInvoice(String shopInvoice) {
        this.shopInvoice = shopInvoice;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", warrantyDate=" + warrantyDate +
                ", category='" + category + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopInvoice='" + shopInvoice + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopPhone='" + shopPhone + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
