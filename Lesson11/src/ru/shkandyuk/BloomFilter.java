package ru.shkandyuk;

public class BloomFilter {
    public int filter_len;

    public int filter = 0;

    public BloomFilter(int f_len) {
        filter_len = f_len;

        // создаём битовый массив длиной f_len ..   .
    }

    // 1st hash function
    public int hash1(String str1) {
        final int SIMPLNUM = 17;
        int hashCode = 0;
        int code;

        for (int i = 0; ( str1 != null ) &&  ( i < str1.length() ); i++) {
            code = str1.charAt(i);
            hashCode = ( hashCode * SIMPLNUM + code ) % filter_len;
        }
        return hashCode;
    }

    // 2nd hash function
    public int hash2(String str1) {
        final int SIMPLNUM = 223;
        int hashCode = 0;
        int code;

        for (int i = 0; ( str1 != null ) && (i < str1.length()); i++) {
            code = str1.charAt(i);
            hashCode = ( hashCode * SIMPLNUM + code ) % filter_len;
        }
        return hashCode;
    }

    public void add(String str1) {
        int hcode1 = hash1(str1);
        int hcode2 = hash2(str1);

    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        int hcode1 = hash1(str1);
        int hcode2 = hash2(str1);

        return ( (hcode1 == 1) && (hcode2 == 1) );
    }

    public void setBit(int pos){
        int codePose = 1;
        codePose = codePose << pos;
        System.out.println(codePose);
    }
}