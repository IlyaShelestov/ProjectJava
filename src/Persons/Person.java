package Persons;

abstract class Person {
    private final String firstName;
    private final String secondName;
    private final String login;
    private final String password;

    public Person(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
