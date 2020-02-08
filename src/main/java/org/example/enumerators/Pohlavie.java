package org.example.enumerators;

public enum Pohlavie {
    MUZ('M'),
    ZENA('Z');

    private char kod;

    Pohlavie(char kod){
        this.kod = kod;
    }

    public char getKod() {
        return kod;
    }

    public static Pohlavie getEnumFromKod(Character kod){
        if(kod.equals('M')||kod.equals('m'))
        {
            return MUZ;
        }
        if(kod.equals('Z')||kod.equals('z')){
            return ZENA;
        }

        throw new UnsupportedOperationException("Kod enumeratora : " + kod +" neexistuje");

    }


}
