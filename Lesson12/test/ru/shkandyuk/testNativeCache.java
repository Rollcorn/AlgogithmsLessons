package ru.shkandyuk;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testNativeCache {
    NativeCache<Integer> mnc = new NativeCache<>(10, Integer.class);
    ArrayList<String> keys = new ArrayList<String>();

    public void fillArray(ArrayList<String> keys){
        keys.add("1");
        keys.add("2");
        keys.add("3");
        keys.add("4");
        keys.add("5");
        keys.add("6");
        keys.add("7");
        keys.add("8");
        keys.add("9");
        keys.add("10");
//        keys.add("one");
//        keys.add("two");
//        keys.add("three");
//        keys.add("four");
//        keys.add("five");
//        keys.add("six");
//        keys.add("seven");
//        keys.add("eight");
//        keys.add("nine");
//        keys.add("ten");
    }

    public void printElements(NativeCache<Integer> nc){
        System.out.print("ELEMENTS: {");
        for (int j = 0; j != nc.size; j++){
            System.out.print(" [" + nc.slots[j] + " : " + nc.values[j] + "] ");
        }
        System.out.println(" }");
    }

    public void ptintHits(NativeCache<Integer> nc){
        System.out.print("HITS: [");
        for (int j = 0; j != nc.size; j++){
            System.out.print(nc.hits[j] + " ");
        }
        System.out.println(" ]");
    }

    public void putInCache(NativeCache<Integer> nc, int min, int max){

        for(int i = min; i != max; i++){
            nc.put(keys.get(i), i);
        }
    }

    public void getElems(NativeCache<Integer> nc, int min, int max){
        for(int i = min; i != max; i++){
            nc.get(keys.get(i));
        }
    }

    @Test
    public void testPut(){
        fillArray(keys);

        mnc.put("one", 1);
        mnc.put("two", 2);
        mnc.put("three", 3);
        mnc.put("four", 4);
        mnc.put("five", 5);
        mnc.put("six", 6);
        mnc.put("seven", 7);
        mnc.put("eight", 8);
        mnc.put("nine", 9);
        mnc.put("ten", 10);

        Assert.assertEquals("Wrong cache SLOT size", 10, 10);
        Assert.assertEquals("Wrong cache VALUES size",10, 10);
        printElements(mnc);
        ptintHits(mnc);
        System.out.println();

        System.out.println("First input");
        mnc.get("one");
        mnc.get("two");
        mnc.get("three");
        mnc.get("four");
        mnc.get("five");
        mnc.get("six");
        mnc.get("seven");
        mnc.get("eight");
        mnc.get("nine");
        mnc.get("ten");
        mnc.get("ten");
        mnc.get("one");

        printElements(mnc);
        ptintHits(mnc);

        System.out.println("Input [5 : 5]");
        mnc.put(keys.get(4), 5);
        printElements(mnc);
        ptintHits(mnc);
        getElems(mnc,0, 10);
        getElems(mnc,0, 10);
        ptintHits(mnc);
        System.out.println();

        System.out.println("Second input");
        mnc.get("one");
        mnc.get("two");
        mnc.get("three");
        mnc.get("four");
        mnc.get("five");
        mnc.get("nine");
        printElements(mnc);
        ptintHits(mnc);
        System.out.println("Input [2 : 1]");
        mnc.put(keys.get(1), 1);
        ptintHits(mnc);
        getElems(mnc,0, 10);
        getElems(mnc,0, 10);

        printElements(mnc);
        ptintHits(mnc);
        System.out.println();

        System.out.println("Third input");
        mnc.get("eight");
        mnc.get("nine");
        mnc.get("ten");
        mnc.get("one");
        ptintHits(mnc);
        System.out.println("Input [eleven : 11]");
        mnc.put("eleven", 11);

        mnc.get("eleven");
        mnc.get("eleven");
        mnc.get("eleven");
        mnc.get("2");

        printElements(mnc);
        ptintHits(mnc);

        System.out.println("Input [3 : 2]");
        mnc.put(keys.get(2), 2);
        getElems(mnc,0, 10);
        getElems(mnc,0, 10);
        printElements(mnc);
        ptintHits(mnc);
        System.out.println();

        System.out.println("Fourth input");
        System.out.println("Input [4 : 3]");
        mnc.put(keys.get(3), 3);
        getElems(mnc,0, 10);
        getElems(mnc,0, 10);
        printElements(mnc);
        ptintHits(mnc);
        System.out.println();

        System.out.println("Fifth input");
        System.out.println("Input [5 : 4]");
        mnc.put(keys.get(4), 4);
        getElems(mnc,0, 10);
        getElems(mnc,0, 10);
        printElements(mnc);
        ptintHits(mnc);
        System.out.println();


//        int elemAmount = 50;
//        fillCache(mnc, 0, elemAmount/3);
//        getElems(mnc, 0, elemAmount/2);
//        printElements(mnc);
//        ptintHits(mnc);
//
//        fillCache(mnc, 0, elemAmount);
//        getElems(mnc, elemAmount/2, elemAmount);
//        printElements(mnc);
//        ptintHits(mnc);
//
//        fillCache(mnc, 0, elemAmount);
//        getElems(mnc, elemAmount/3, elemAmount*2/3);
//        printElements(mnc);
//        ptintHits(mnc);
    }

    @Test
    public void testGet(){

    }

    @Test
    public void testRemove(){

    }


}
