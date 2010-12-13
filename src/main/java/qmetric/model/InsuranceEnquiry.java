package qmetric.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: dfarr
 */
@Entity @Table(name = "INSURANCE_ENQUIRY")
public class InsuranceEnquiry extends BaseEntity implements Serializable
{

    

    @OneToMany(cascade = CascadeType.ALL) @JoinColumn(name = "INSURANCE_ENQUIRY_ID", referencedColumnName = "ID")
    private Set<InsuranceQuote> insuranceQuotes = new HashSet<InsuranceQuote>();

    @Column
    private String description;

    protected InsuranceEnquiry()
    {
    }

    public InsuranceEnquiry(final String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public Set<InsuranceQuote> getInsuranceQuotes()
    {
        return insuranceQuotes;
    }

    public boolean addInsuranceQuote(final InsuranceQuote insuranceQuote)
    {
        return insuranceQuotes.add(insuranceQuote);
    }

    public boolean deleteInsuranceQuote(final InsuranceQuote insuranceQuote)
    {
        return insuranceQuotes.remove(insuranceQuote);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
