package qmetric.model;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
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
@Entity @Table(name = "INSURANCE_QUOTE")
public class InsuranceQuote extends BaseEntity implements Serializable
{
    @OneToMany(cascade = CascadeType.ALL) @JoinColumn(name = "INSURANCE_QUOTE_ID", referencedColumnName = "ID")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<ClassDetail> classDetails = new HashSet<ClassDetail>();

    InsuranceQuote()
    {
    }

    public InsuranceQuote(final Set<ClassDetail> classDetails) {
        Validate.notNull(classDetails);
        this.classDetails = classDetails;
    }

    public Set<ClassDetail> getClassDetails()
    {
        return classDetails;
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
