package Lab.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

/**
 * Spring uses Object Relational Mapping to provide an easy way to interact with the database.
 */
@Entity // ✅ Mark the class as an entity
public class Product {

    @Id // ✅ Mark productID as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Auto-generate productID (optional)
    private long productID;

    private String name;
    private String description;

    public Product(long productID, String name, String description) {
        this.productID = productID;
        this.name = name;
        this.description = description;
    }

    public Product() {
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
