package soft.pegas.vocabularychieftain.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditTrailListener.class)
public class BaseModel {

    @Id
    @GeneratedValue
    protected UUID id;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
