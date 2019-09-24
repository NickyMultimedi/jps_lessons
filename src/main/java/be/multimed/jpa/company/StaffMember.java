package be.multimed.jpa.company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class StaffMember implements Serializable {
    @Id @Column(name = "StaffId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "StafMemberName") String name;
    @Enumerated(EnumType.STRING) @Column(name = "Role") StaffRole role;

    public StaffMember() {
    }

    public StaffMember(String name, StaffRole role) {
        this.name = name;
        this.role = role;
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

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMember that = (StaffMember) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole());
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
