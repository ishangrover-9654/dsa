package com.delivery.data.db.jpa.entities;

import com.delivery.core.domain.Customer;
import com.delivery.core.domain.Identity;
import lombok.*;

import javax.persistence.*;

import static com.delivery.data.db.jpa.entities.IdConverter.convertId;

@AllArgsConstructor
@Entity(name = "customer")
@EqualsAndHashCode(of = {"name", "email", "address", "password"})
@Getter
@NoArgsConstructor
@Setter
@Table(name = "customer")
@ToString(of = {"name", "email", "address"})
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    // TODO: test
    public static CustomerData from(Customer customer) {
        return new CustomerData(
                convertId(customer.getId()),
                customer.getName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPassword()
        );
    }

    // TODO: test
    public Customer fromThis() {
        return new Customer(
                new Identity(id),
                name,
                email,
                address,
                password
        );
    }
}
