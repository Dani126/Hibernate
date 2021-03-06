package org.example.converter;

import org.example.enumerators.Pohlavie;

import javax.persistence.AttributeConverter;

public class PohlavieConverter implements AttributeConverter<Pohlavie,Character> {
    @Override
    public Character convertToDatabaseColumn(Pohlavie pohlavie) {
        if(pohlavie ==null){
            return null;
        }
        return pohlavie.getKod();
    }

    @Override
    public Pohlavie convertToEntityAttribute(Character character) {
        if(character == null){
            return null;
        }
        return Pohlavie.getEnumFromKod(character);
    }
}
