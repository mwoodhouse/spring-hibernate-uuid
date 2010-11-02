package domfarr.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "PET")
public class Pet
{
    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid") @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PET_TYPE") @Enumerated(EnumType.STRING)
    private PetType petType;

    @ManyToOne @JoinColumn(name = "USER_ID")
    private User owner;

    public Pet()
    {
    }

    public Pet(final String name, final PetType petType, final User owner)
    {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public PetType getType()
    {
        return petType;
    }

    public User getOwner()
    {
        return owner;
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
