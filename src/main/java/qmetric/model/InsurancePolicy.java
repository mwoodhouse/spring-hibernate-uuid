package qmetric.model;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Author: Dom Farr
 */
@Entity
@Table(name = "INSURANCE_POLICY")
public class InsurancePolicy extends BaseEntity
{
    @Column(name = "START_DATE") @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime startDate;

    @Column(name = "DOCUMENT_PATH")
    private String documentPath;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "QUOTE_ID")
    private InsuranceQuote quote;
}
