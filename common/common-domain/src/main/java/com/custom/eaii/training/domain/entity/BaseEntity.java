
package com.custom.eaii.training.domain.entity;



import java.util.Objects;

public abstract class BaseEntity<ID> {
    private ID id;

    public BaseEntity() {
    }

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            BaseEntity<?> that = (BaseEntity)o;
            return Objects.equals(this.id, that.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }
}
