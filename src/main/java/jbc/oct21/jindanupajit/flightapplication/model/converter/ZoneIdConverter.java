package jbc.oct21.jindanupajit.flightapplication.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.ZoneId;

@Converter
public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {

    @Override
    public String convertToDatabaseColumn(ZoneId zoneId) {
        return zoneId.getId();
    }

    @Override
    public ZoneId convertToEntityAttribute(String s) {
        return ZoneId.of(s);
    }
}
