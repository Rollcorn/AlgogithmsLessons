package ru.shkandyuk;

import org.junit.Assert;
import org.junit.Test;

public class TestBloomFilter {
    static final int SIZE = 10;
    String str1 = "key";
    String str2 = "hello";

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
        int[] checkArr = new int[SIZE];
        for(int i = 0; i != SIZE; i++) checkArr[i] = 0;

        bloomFilter.add(str1);
        checkArr[bloomFilter.hash1(str1)] = 1;
        checkArr[bloomFilter.hash2(str1)] = 1;

        bloomFilter.add(str2);
        checkArr[bloomFilter.hash1(str2)] = 1;
        checkArr[bloomFilter.hash2(str2)] = 1;

        System.out.println("Bloom filter elemets:");
        for(int i = 0; i != SIZE; i++) {
//            System.out.println(i + " = [" + bloomFilter.filter[i] + "]");
        }

//        Assert.assertArrayEquals("Wrong filter array", bloomFilter.filter, checkArr);
    }

    @Test
    public void testIsValue(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);

    }
    @Test
    public void testSetBit(){
        BloomFilter bloomFilter = new BloomFilter(SIZE);

        bloomFilter.setBit(2);

    }
}
