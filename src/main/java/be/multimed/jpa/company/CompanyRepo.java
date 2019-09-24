package be.multimed.jpa.company;

import be.multimed.jpa.handlers.MainRepo;
import be.multimed.jpa.handlers.MainRepoImpl;

public interface CompanyRepo extends MainRepo {
    Company find(long id);
}
