package qmetric.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: dfarr
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity implements Serializable {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Set<InsuranceEnquiry> insuranceEnquiries = new HashSet<InsuranceEnquiry>();

    protected Customer() {
    }

    public Customer(final String firstName, final String lastName, final String email, final String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    public void prePersist() {
        super.prePersist();
        System.out.println("Pre Persist in Customer");
        // this is the place to generate a custom CID
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public Set<InsuranceEnquiry> getInsuranceEnquiries() {
        return insuranceEnquiries;
    }

    public boolean addInsuranceEnquiry(final InsuranceEnquiry insuranceEnquiry) {
        return insuranceEnquiries.add(insuranceEnquiry);
    }

    public boolean deleteInsuranceEnquiry(final InsuranceEnquiry insuranceEnquiry) {
        return insuranceEnquiries.remove(insuranceEnquiry);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
