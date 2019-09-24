package be.multimed.jpa.company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class Company implements Serializable {
    @Id @Column(name = "CompanyId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "CompanyName") String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @MapKey(name = "role") Map<StaffRole, StaffMember> staff = new HashMap<>();

    public Company() {
    }

    public Company(String name, Map<StaffRole, StaffMember> staff) {
        this.name = name;
        this.staff = staff;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<StaffRole, StaffMember> getStaff() {
        return staff;
    }

    public void setStaff(Map<StaffRole, StaffMember> staff) {
        this.staff = staff;
    }

    public void addStaffMember(StaffMember member) {
        this.staff.put(member.getRole(), member);
    }

    public void removeStaffMember(StaffMember member) {
        this.staff.remove(member.getRole(), member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return getId() == company.getId() &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getStaff(), company.getStaff());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStaff());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", staff=" + staff +
                '}';
    }
}
