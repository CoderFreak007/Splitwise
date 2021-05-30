package org.interview.model;

import java.util.Objects;

public class UsersShareOutput {

    private String userName1;

    private String userName2;

    private double amount;


    public UsersShareOutput(String userName1, String userName2, double amount) {
        this.userName1 = userName1;
        this.userName2 = userName2;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UsersShareOutput{" +
                "user='" + userName1 + '\'' +
                "owes user='" + userName2 + '\'' +
                "-> amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersShareOutput that = (UsersShareOutput) o;
        return userName1.equals(that.userName1) && userName2.equals(that.userName2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName1, userName2);
    }
}
