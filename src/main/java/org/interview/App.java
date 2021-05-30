package org.interview;

import org.interview.model.Expense;
import org.interview.model.UsersShareOutput;
import org.interview.service.GroupService;
import org.interview.service.UserService;
import org.interview.serviceImpl.GroupServiceImpl;
import org.interview.serviceImpl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        UserService userService = UserServiceImpl.getInstance();
        GroupService groupService = new GroupServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String line1 = scanner.next();
            if ("adduser".equals(line1)) {
                userService.addNewUser(scanner.next());
                continue;
            }
            if ("addgroup".equals(line1)) {
                groupService.addGroup(scanner.next(), scanner.next());
                continue;
            }
            if ("addusertogroup".equals(line1)) {
                try {
                    groupService.addUserToGroup(scanner.next(), scanner.next());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                continue;
            }
            if ("addexpensetogroup".equals(line1)) {
                Expense expense = new Expense(scanner.next(), scanner.next(), scanner.nextDouble());
                try {
                    groupService.addExpenseAndCalculateUserShare(expense);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                continue;
            }

            if ("getresult".equals(line1)) {
                Set<UsersShareOutput> result = null;
                try {
                    result = groupService.getGroupBalancesForUsers(scanner.next());
                    for (UsersShareOutput outpout : result)
                        System.out.println(outpout.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                continue;

            }

        }
    }
}
