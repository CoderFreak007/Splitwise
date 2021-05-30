package org.interview.service;

import org.interview.model.Expense;
import org.interview.model.Group;

public interface ShareCalculationService {

    public void calculateUsersShareAndUpdateGroupBalance(Group group, Expense expense);
}
