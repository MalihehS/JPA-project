package jpaproject;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maliheh
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustomerNumber", query = "SELECT c FROM Customers c WHERE c.customerNumber = :customerNumber")
    , @NamedQuery(name = "Customers.findByCustomerName", query = "SELECT c FROM Customers c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "Customers.findByContactLastName", query = "SELECT c FROM Customers c WHERE c.contactLastName = :contactLastName")
    , @NamedQuery(name = "Customers.findByContactFirstName", query = "SELECT c FROM Customers c WHERE c.contactFirstName = :contactFirstName")
    , @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customers.findByAddressLine1", query = "SELECT c FROM Customers c WHERE c.addressLine1 = :addressLine1")
    , @NamedQuery(name = "Customers.findByAddressLine2", query = "SELECT c FROM Customers c WHERE c.addressLine2 = :addressLine2")
    , @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city")
    , @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state")
    , @NamedQuery(name = "Customers.findByPostalCode", query = "SELECT c FROM Customers c WHERE c.postalCode = :postalCode")
    , @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country")
    , @NamedQuery(name = "Customers.findByCreditLimit", query = "SELECT c FROM Customers c WHERE c.creditLimit = :creditLimit")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @Column(name = "customerNumber")
    private Integer customerNumber;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "contactLastName")
    private String contactLastName;

    @Column(name = "contactFirstName")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressLine1")
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;
    @Column(name = "creditLimit")
    private BigDecimal creditLimit;
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    @ManyToOne
    private Employees salesRepEmployeeNumber;

    public Customers() {
    }

    public Customers(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Customers(Integer customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String city, String country) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.country = country;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employees getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Employees salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerNumber != null ? customerNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerNumber == null && other.customerNumber != null) || (this.customerNumber != null && !this.customerNumber.equals(other.customerNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ customerNumber=" + customerNumber + " / customerName: " + customerName + " / Phone nummber: " + phone + " / Country name:" + country + " ]";
    }

}
