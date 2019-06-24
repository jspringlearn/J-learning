package com.stu.software.Employee.domain;

import com.stu.software.domain.BaseEntity;

import javax.persistence.*;

@Table(name="T_ADMIN_STAFF")
@Entity
public class Staff extends BaseEntity {
    private static final long serialVersionUID = 5541402222324784680L;
    @Id
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name="STAFF_NUM")
    String staff_num;
    @Column(name="STAFF_NAME")
    String staff_name;
    @Column(name="STAFF_SEX")
    String staff_sex;
    @Column(name="STAFF_AGE")
    String staff_age;
    @Column(name="STAFF_TEL")
    String staff_tel;
    @ManyToOne
    @JoinColumn(name="BOSS_ID")
    Boss boss;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getStaff_num() {
        return staff_num;
    }
    public void setStaff_num(String staff_num) {
        this.staff_num = staff_num;
    }
    public String getStaff_name() {
        return staff_name;
    }
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }
    public String getStaff_sex() {
        return staff_sex;
    }
    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }
    public String getStaff_age() {
        return staff_age;
    }
    public void setStaff_age(String staff_age) {
        this.staff_age = staff_age;
    }
    public String getStaff_tel() {
        return staff_tel;
    }
    public void setStaff_tel(String staff_tel) {
        this.staff_tel = staff_tel;
    }
    public Boss getBoss() {
        return boss;
    }
    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
