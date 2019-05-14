package com.delivery.data.db.jpa.entities;

import com.delivery.core.domain.Identity;
import com.delivery.core.domain.Product;
import lombok.*;

import javax.persistence.*;

import static com.delivery.data.db.jpa.entities.IdConverter.convertId;

@AllArgsConstructor
@Entity(name = "product")
@EqualsAndHashCode(of = {"name", "description", "price"})
@Getter
@NoArgsConstructor
@Setter
@Table(name = "product")
@ToString(of = {"name", "description", "price"})
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreData store;

    // TODO: test
    public static ProductData from(Product product) {
        return new ProductData(
                convertId(product.getId()),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                StoreData.from(product.getStore())
        );
    }

    // TODO: test
    public Product fromThis() {
        return new Product(
                new Identity(id),
                name,
                description,
                price,
                store.fromThis()
        );
    }
}
