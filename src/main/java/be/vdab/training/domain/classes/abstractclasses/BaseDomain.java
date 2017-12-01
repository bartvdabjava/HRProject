package be.vdab.training.domain.classes.abstractclasses;

import java.util.UUID;

public abstract class BaseDomain {
    protected UUID identifier=UUID.randomUUID();

    public UUID getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDomain)) return false;

        BaseDomain that = (BaseDomain) o;

        return getIdentifier() != null ? getIdentifier().equals(that.getIdentifier()) : that.getIdentifier() == null;
    }

    @Override
    public int hashCode() {
        return getIdentifier() != null ? getIdentifier().hashCode() : 0;
    }
}
