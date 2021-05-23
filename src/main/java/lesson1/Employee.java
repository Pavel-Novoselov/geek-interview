package lesson1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

@Getter
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Employee(
            final String firstName,
            final String lastName,
            final String middleName,
            final String country,
            final String address,
            final String phone,
            final int age,
            final String gender
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    static class Builder{
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;


        public Builder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMiddleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withCountry(final String country) {
            this.country = country;
            return this;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withAge(final int age) {
            this.age = age;
            return this;
        }

        public Builder withGender(final String gender) {
            this.gender = gender;
            return this;
        }

        public Employee build(){
            return new Employee(this.firstName,
                    this.middleName,
                    this.lastName,
                    this.country,
                    this.address,
                    this.phone,
                    this.age,
                    this.gender);
        }
    }

    public static void main(final String[] args) {
        final Employee employee = new Employee
                .Builder()
                .withFirstName("Igor")
                .withMiddleName("Igorevich")
                .withLastName("Ivanov")
                .withCountry("Russia")
//                .withGender("M")
                .withPhone("1234566789")
                .withAddress("address")
                .withAge(20)
                .build();

        System.out.println(employee);
    }
}


