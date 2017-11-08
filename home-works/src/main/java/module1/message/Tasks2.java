package module1.message;


import module1.message.model.Message;
import module1.message.model.MessageGenerator;
import module1.message.model.User;
import module1.message.model.UserGenerator;
import module1.utils.ListUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {

    public static void main(String[] args) {
        MessageGenerator messageGenerator = new MessageGenerator();
        List<Message> messages = messageGenerator.generate(10);

        System.out.println("Messages before sort: \n" + messages + "\n");
        sortByPriority(messages);
        System.out.println("Messages after sort: \n" + messages + "\n");

        List<User> users = UserGenerator.generate(10);
        System.out.println("Generated users: \n" + users + "\n");
        NavigableSet<User> sortedUsers = sortedByCompanyAndName(users);
        System.out.println("Users sorted by Company and Name: \n" + sortedUsers + "\n");

        sortedUsers = sortedBySalaryAndName(users);
        System.out.println("Users sorted by Salary and Name: \n" + sortedUsers + "\n");

        sortedUsers = sortedBySalaryAgeCompanyAndName(users);
        System.out.println("Users sorted by Salary, Age, Company and Name: \n" + sortedUsers + "\n");
    }

    private static void sortByPriority(List<Message> messages) {
        messages.sort(Comparator.comparingInt(o -> o.getPriority().ordinal()));
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {
        NavigableSet<User> sortedUsers = new TreeSet<>((o1, o2) -> {
            if (o1.getCompany().equals(o2.getCompany())) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getCompany().compareTo(o2.getCompany());
        });

        sortedUsers.addAll(users);
        return sortedUsers;
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {
        NavigableSet<User> sortedUsers = new TreeSet<>((o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getSalary() - o2.getSalary();
        });

        sortedUsers.addAll(users);
        return sortedUsers;
}

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {
        NavigableSet<User> sortedUsers = new TreeSet<>((o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) {
                if (o1.getAge() == o2.getAge()) {
                    if (o1.getCompany().equals(o2.getCompany())) {
                        return o1.getName().compareTo(o2.getName());
                    }
                    return o1.getCompany().compareTo(o2.getCompany());
                }
                return o1.getAge() - o2.getAge();
            }
            return o1.getSalary() - o2.getSalary();
        });

        sortedUsers.addAll(users);
        return sortedUsers;
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {
        return ListUtils.view(it1, it2).iterator();
    }


}
