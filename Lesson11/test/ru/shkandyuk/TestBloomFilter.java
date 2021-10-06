package ru.shkandyuk;

import org.junit.Assert;
import org.junit.Test;

public class TestBloomFilter {
    static final int SIZE = 10;
    String str1 = "0123456789";
    String str2 = "9012345678";
    String str3 = "8901234567";
    String str4 = "7890123456";
    String str5 = "6789012345";
    String str6 = "5678901234";
    String str7 = "4567890123";
    String str8 = "3456789012";
    String str9 = "2345678901";
    String str10 = "1234567890";

    @Test
    public void testHash1(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);
        int fhash1 = bloomFilter.hash1(str1);
        int fhash2 = bloomFilter.hash2(str1);
        System.out.println("First hash code is - " + fhash1 + " Second hash code is - " + fhash2);
        Assert.assertNotEquals("Hash codes are equals", fhash1, fhash2 );

        int fhash3 = bloomFilter.hash1(str2);
        int fhash4 = bloomFilter.hash2(str2);
        System.out.println("First hash code is - " + fhash3 + " Second hash code is - " + fhash4);
        Assert.assertNotEquals("Hash codes are equals", fhash3, fhash4 );

    }

    @Test
    public void testAdd(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);

        bloomFilter.add(str1);
        System.out.print( "[1] =  " );
        printBitMask(str1);
        bloomFilter.add(str2);
        System.out.print("[2] =  ");
        printBitMask(str2);
        bloomFilter.add(str3);
        System.out.print("[3] =  ");
        printBitMask(str3);
        bloomFilter.add(str4);
        System.out.print("[4] =  ");
        printBitMask(str4);
        bloomFilter.add(str5);
        System.out.print("[5] =  ");
        printBitMask(str5);
        bloomFilter.add(str6);
        System.out.print("[6] =  ");
        printBitMask(str6);
        bloomFilter.add(str7);
        System.out.print("[7] =  ");
        printBitMask(str7);
        bloomFilter.add(str8);
        System.out.print("[8] =  ");
        printBitMask(str8);
        bloomFilter.add(str9);
        System.out.print("[9] =  ");
        printBitMask(str9);
        bloomFilter.add(str10);
        System.out.print("[10] = ");
        printBitMask(str10);

//        Assert.assertArrayEquals("Wrong filter array", bloomFilter.filter, checkArr);
    }

    @Test
    public void testIsValue(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);

        Assert.assertFalse("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertFalse("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertFalse("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertFalse("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertFalse("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertFalse("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertFalse("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertFalse("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertFalse("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertFalse("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str1);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );


        Assert.assertFalse("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertFalse("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertFalse("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertFalse("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertFalse("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertFalse("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertFalse("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertFalse("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str2);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );

        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );

        Assert.assertFalse("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertFalse("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertFalse("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertFalse("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertFalse("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertFalse("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str3);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );

        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );

        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );

        Assert.assertFalse("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertFalse("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertFalse("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertFalse("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str4);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );

        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );

        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );

        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );


        bloomFilter.add(str5);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str6);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str7);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str8);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str9);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );

        bloomFilter.add(str10);
        Assert.assertTrue("Wrong result isValue() str1", bloomFilter.isValue(str1) );
        Assert.assertTrue("Wrong result isValue() str2", bloomFilter.isValue(str2) );
        Assert.assertTrue("Wrong result isValue() str3", bloomFilter.isValue(str3) );
        Assert.assertTrue("Wrong result isValue() str4", bloomFilter.isValue(str4) );
        Assert.assertTrue("Wrong result isValue() str5", bloomFilter.isValue(str5) );
        Assert.assertTrue("Wrong result isValue() str6", bloomFilter.isValue(str6) );
        Assert.assertTrue("Wrong result isValue() str7", bloomFilter.isValue(str7) );
        Assert.assertTrue("Wrong result isValue() str8", bloomFilter.isValue(str8) );
        Assert.assertTrue("Wrong result isValue() str9", bloomFilter.isValue(str9) );
        Assert.assertTrue("Wrong result isValue() str10", bloomFilter.isValue(str10) );


    }

    @Test
    public void testSetBit(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);
        bloomFilter.setBit(2);
    }

    public void printBitMask(String str){
        BloomFilter mf = new BloomFilter(SIZE);
        int[] bitMask = new int[32];
        mf.add(str);
        int filMask = mf.filter;
        int mask = 1;
        for(int i = 31; i != 0; i--){
            if( (mask & filMask)/mask == 1 ){
                bitMask[i] = 1;
            } else {
                bitMask[i] = 0;
            }
            mask = mask << 1;
        }
        for (int x :bitMask) {
            System.out.print(x);
        }
        System.out.println();
    }
}
