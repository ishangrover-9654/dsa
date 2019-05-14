package com.delivery.data.db.jpa.entities;

import com.delivery.core.domain.Identity;
import com.delivery.core.domain.Store;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.delivery.data.db.jpa.entities.IdConverter.convertId;

@AllArgsConstructor
@Entity(name = "store")
@EqualsAndHashCode(of = {"name", "address"})
@Getter
@NoArgsConstructor
@Setter
@Table(name = "store")
@ToString(of = {"name", "address"})
public class StoreData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "cousine_id", nullable = false)
    private CousineData cousine;

    @OneToMany(mappedBy = "store")
    private Set<ProductData> products;

    // TODO: test
    public static StoreData from(Store store) {
        return new StoreData(
                convertId(store.getId()),
                store.getName(),
                store.getAddress(),
                CousineData.from(store.getCousine()),
                new HashSet<>());
    }

    // TODO: test
    public Store fromThis() {
        return new Store(
                new Identity(id),
                name,
                address,
                cousine.fromThis()
        );
    }
}
