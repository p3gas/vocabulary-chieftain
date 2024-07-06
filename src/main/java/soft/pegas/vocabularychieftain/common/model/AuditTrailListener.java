package soft.pegas.vocabularychieftain.common.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.OffsetDateTime;
import java.util.UUID;

public class AuditTrailListener {

    @PrePersist
    public void beforeAnyPersistence(BaseModel model) {
        model.setId(UUID.randomUUID());
        model.setCreatedAt(OffsetDateTime.now());
    }

    @PreUpdate
    public void beforeAnyUpdate(BaseModel model) {
        model.setUpdatedAt(OffsetDateTime.now());
    }
}
