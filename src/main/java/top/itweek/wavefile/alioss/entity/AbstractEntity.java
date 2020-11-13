package top.itweek.wavefile.alioss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractEntity {
    private String bucketName;

    public AbstractEntity() {
    }

    public AbstractEntity(String bucketName) {
        this.bucketName = bucketName;
    }
}
