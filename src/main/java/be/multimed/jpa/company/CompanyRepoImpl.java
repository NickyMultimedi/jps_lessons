package be.multimed.jpa.company;

import be.multimed.jpa.handlers.MainRepoImpl;

public class CompanyRepoImpl extends MainRepoImpl implements CompanyRepo {
    public Company find(long id) {
        return super.find(Company.class, id);
    }
}
