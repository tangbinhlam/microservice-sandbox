package net.bakaar.sandbox.cas.domain.event;

import net.bakaar.sandbox.event.common.DomainEvent;
import net.bakaar.sandbox.shared.domain.vo.PNumber;

public class CaseCreated implements DomainEvent {
    private final String id;
    private final PNumber pNumber;

    public CaseCreated(String id, PNumber pNumber) {
        this.id = id;
        this.pNumber = pNumber;
    }

    public String getId() {
        return id;
    }

    public PNumber getPNumber() {
        return pNumber;
    }
}
