package project.service;


import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Конвертор datetime сущностей
 *
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
public class LocalDateTimeConverter implements AttributeConverter <LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute != null ? Timestamp.valueOf(attribute) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return dbData != null ? dbData.toLocalDateTime() : null;
    }

}
