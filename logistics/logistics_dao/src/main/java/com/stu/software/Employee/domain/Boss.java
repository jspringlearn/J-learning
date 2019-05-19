package com.stu.software.Employee.domain;

import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Table(name="T_ADMIN_BOSS")
@Entity
@NamedQueries({ @NamedQuery(name = "Boss.getRoot", query="select g from Boss g where g.parent is null") })
public class Boss extends BaseTreeEntity<Boss> {
    private static final long serialVersionUID = 2512557695858759144L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="BOSS_NUM")
    String boss_num;
    @Column(name="BOSS_NAME")
    String boss_name;
    @Column(name="BOSS_SEX")
    String boss_sex;
    @Column(name="BOSS_AGE")
    String boss_age;
    @Column(name="BOSS_TEL")
    String boss_tel;
    @OneToMany(mappedBy="boss",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
    Set<Staff>staffs;
    public Long getId() {
        return id;
    }
    public String getBoss_num() {
        return boss_num;
    }
    public void setBoss_num(String boss_num) {
        this.boss_num = boss_num;
    }
    public String getBoss_name() {
        return boss_name;
    }
    public void setBoss_name(String boss_name) {
        this.boss_name = boss_name;
    }
    public String getBoss_sex() {
        return boss_sex;
    }
    public void setBoss_sex(String boss_sex) {
        this.boss_sex = boss_sex;
    }
    public String getBoss_age() {
        return boss_age;
    }
    public void setBoss_age(String boss_age) {
        this.boss_age = boss_age;
    }
    public String getBoss_tel() {
        return boss_tel;
    }
    public void setBoss_tel(String boss_tel) {
        this.boss_tel = boss_tel;
    }
    public Set<Staff> getStaffs() {
        return staffs;
    }
    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
