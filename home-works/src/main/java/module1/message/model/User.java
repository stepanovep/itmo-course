package module1.message.model;

/**
 * Created by xmitya on 20.10.16.
 */
public class User {
    private String name;
    private int age;
    private int salary;
    private String company;

    public User() {
    }

    public User(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return  age == user.age &&
                salary == user.salary &&
                (name != null ? name.equals(user.name) : user.name == null) &&
                (company != null ? company.equals(user.company) : user.company == null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
