package domfarr.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.ALL;

@Entity @Table(name = "USER")
public class Customer
{
    private static final String[] EXCLUDED_FIELDS = {"pets"};

    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid") @Column(name = "ID")
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    public Customer()
    {
    }

    public Customer(final String firstName, final String lastName, final String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this, EXCLUDED_FIELDS);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj, EXCLUDED_FIELDS);
    }

    @Override
    public String toString()
    {
        final ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this);
        builder.setExcludeFieldNames(EXCLUDED_FIELDS);
        return builder.toString();
    }
}
