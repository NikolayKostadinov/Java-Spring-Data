package Common;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {
    private T id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
