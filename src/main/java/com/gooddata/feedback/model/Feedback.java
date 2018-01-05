package com.gooddata.feedback.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Feedback implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String summary;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date created;

    public Feedback() {
        super();
        this.created = new Date();
    }

    public Feedback(String name, String summary) {
        super();
        this.name = name;
        this.summary = summary;
        this.created = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
