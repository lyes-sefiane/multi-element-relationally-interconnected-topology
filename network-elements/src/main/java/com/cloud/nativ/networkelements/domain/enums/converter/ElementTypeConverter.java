package com.cloud.nativ.networkelements.domain.enums.converter;

import com.cloud.nativ.networkelements.domain.enums.ElementType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-24 11:05 a.m.
 */
@Converter
public class ElementTypeConverter implements AttributeConverter<ElementType, String>  {

    @Override
    public String convertToDatabaseColumn(ElementType elementType) {
        return elementType.getValue();
    }

    @Override
    public ElementType convertToEntityAttribute(String value) {
        return ElementType.getEnumByValue(value);
    }
}
