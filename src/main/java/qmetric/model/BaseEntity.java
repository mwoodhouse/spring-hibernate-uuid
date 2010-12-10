package qmetric.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;

/**
 * Author: dfarr
 */
@MappedSuperclass
public class BaseEntity implements Serializable
{
    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid") @Column(name = "ID")
    private String id;

    @Column(nullable = false) @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime created = new DateTime();

    @Column(nullable = false, name = "LAST_MODIFIED") @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime lastModified = new DateTime();

    public String getId()
    {
        return id;
    }
    public DateTime getCreated()
    {
        return created;
    }
    public DateTime getLastModified()
    {
        return lastModified;
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
        return ToStringBuilder.reflectionToString(this);
    }
}