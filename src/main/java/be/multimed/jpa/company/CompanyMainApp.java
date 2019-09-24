package be.multimed.jpa.company;

public class CompanyMainApp {
    public static void main(String[] args) {
        CompanyRepo repo = new CompanyRepoImpl();

        StaffMember member = new StaffMember();
        member.setName("Nick");
        member.setRole(StaffRole.CEO);
        StaffMember member2 = new StaffMember();
        member2.setRole(StaffRole.CFO);
        member2.setName("Karel");

        Company comp = new Company();
        comp.setName("MM");
        comp.addStaffMember(member);
        comp.addStaffMember(member2);

        repo.save(comp);
        System.out.println(repo.find(3L));
    }
}
