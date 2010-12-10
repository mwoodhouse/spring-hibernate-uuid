package qmetric.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * Author: dfarr
 */
@Entity @Table(name = "CLASS_DETAIL")
public class ClassDetail extends BaseEntity implements Serializable
{
    @Column(name = "TYPE_DESCRIPTION")
    private String typeDescription;

    private double cost;

    ClassDetail()
    {
    }

    public ClassDetail(final String typeDescription, final double cost) {

        this.typeDescription = typeDescription;
        this.cost = cost;
    }

    public String getTypeDescription()
    {
        return typeDescription;
    }

    public double getCost()
    {
        return cost;
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
