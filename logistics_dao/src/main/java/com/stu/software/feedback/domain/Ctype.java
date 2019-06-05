package com.stu.software.feedback.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;


@Entity
@Table(name="T_CTYPE")
@NamedQueries({ @NamedQuery(name = "Ctype.getRoot", query = "select g from Ctype g where g.parent is null") })
public class Ctype extends BaseTreeEntity<Ctype> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public String getCtypeName() {
        return CtypeName;
    }

    public void setCtypeName(String ctypeName) {
        CtypeName = ctypeName;
    }

    @Column(name = "CTYPE_NAME")///////
            String CtypeName;

    public String getCtypeID() {
        return CtypeID;
    }

    public void setCtypeID(String ctypeID) {
        CtypeID = ctypeID;
    }

    @Column(name = "CTYPE_ID")////////
            String CtypeID;


    public Set<Comment> getComment() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "ctype", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Comment> comments;



}