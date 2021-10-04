package AlgorithmsLessons.Lesson10.Test.myAlgo;

import AlgorithmsLessons.Lesson10.src.myAlgo.PowerSet;
import org.junit.Assert;
import org.junit.Test;

public class PowerSetTest {

    @Test
    public void testPut() {

        PowerSet mset = new PowerSet();
        Assert.assertEquals("Size wrong ", 0, mset.size());

        mset.put("1");
        Assert.assertEquals("Size wrong ", 1, mset.size());

        mset.put(null);

        mset.put("test");
        mset.put("Conor");
        mset.put("hello");
        mset.put("world");
        mset.put("Sarah");
        mset.put("Conor");
        mset.put("qopj");

        Assert.assertEquals("Size wrong ", 7, mset.size());

        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");

        Assert.assertEquals("Size wrong ", 7, mset.size());

        mset.put("System");
        mset.put("f");
        mset.put("wfa");
        mset.put("asfag");
        mset.put("ytr");
        mset.put("zxcvgh");
        mset.put("yui");
        mset.put("vusdbhv");

        mset.put(null);


        Assert.assertEquals("Size wrong ", 15, mset.size());

        PowerSet ps = new PowerSet();
        for(int i = 0; i < 10000; i++){
            ps.put(String.valueOf(i));
            ps.put(null);
        }
        Assert.assertEquals("Size wrong ", 10000, ps.size());


    }

    @Test
    public void testGet() {
        PowerSet mset = new PowerSet();

        mset.put(null);
        Assert.assertEquals("Wrong size", 0, mset.size());

        Assert.assertTrue("Wrong get() condition", mset.get(null));

        mset.put("test");
        mset.put("Conor");
        mset.put("hello");
        mset.put("world");
        mset.put("Sarah");
        mset.put("qopj");

        mset.put("Conor");

        Assert.assertEquals("Size wrong ", 6, mset.size());

        Assert.assertTrue("Set has not element", mset.get("test"));
        Assert.assertTrue("Set has not element", mset.get("Conor"));
        Assert.assertTrue("Set has not element", mset.get("hello"));
        Assert.assertTrue("Set has not element", mset.get("world"));
        Assert.assertTrue("Set has not element", mset.get("Sarah"));
        Assert.assertTrue("Set has not element", mset.get("qopj"));
        Assert.assertTrue("Set has not element", mset.get(null));

        mset.put(null);


        mset.put("test");
        mset.put("Conor");
        mset.put("hello");
        mset.put("world");
        mset.put("Sarah");
        mset.put("qopj");

        Assert.assertEquals("Size wrong ", 6, mset.size());
        Assert.assertTrue("Set should has empty slots", mset.get(null));

        mset.put("System");
        mset.put("f");
        mset.put("wfa");
        mset.put("asfag");


        Assert.assertTrue("Set has not element", mset.get("System"));
        Assert.assertTrue("Set has not element", mset.get("f"));
        Assert.assertTrue("Set has not element", mset.get("wfa"));
        Assert.assertTrue("Set has not element", mset.get("asfag"));

        Assert.assertFalse("Set has element", mset.get("ytr"));
        Assert.assertFalse("Set has element", mset.get("zxcvgh"));
        Assert.assertFalse("Set has element", mset.get("yui"));
        Assert.assertFalse("Set has element", mset.get("vusdbhv"));

        mset.put("ytr");
        mset.put("zxcvgh");
        mset.put("yui");
        mset.put("vusdbhv");

        Assert.assertEquals("Size wrong ", 14, mset.size());

    }

    @Test
    public void testRemove() {
        PowerSet mset = new PowerSet();

        Assert.assertEquals("Size wrong ", 0, mset.size());

        mset.put("1");

        Assert.assertEquals("Size wrong ", 1, mset.size());
        Assert.assertTrue("Wrong remove result", mset.remove("1"));
        Assert.assertFalse("Wrong remove result", mset.remove(null));
        Assert.assertEquals("Size wrong ", 0, mset.size());

        mset.put(null);

        mset.put("test");
        mset.put("Conor");
        mset.put("hello");
        mset.put("world");
        mset.put("Sarah");
        mset.put("qopj");
        Assert.assertEquals("Size wrong ", 6, mset.size());

        Assert.assertTrue("Wrong remove result", mset.remove("test"));

        Assert.assertFalse("Wrong remove result", mset.remove("test"));
        Assert.assertFalse("Wrong remove result", mset.remove("test"));
        Assert.assertEquals("Size wrong ", 5, mset.size());


        Assert.assertTrue("Wrong remove result", mset.remove("Conor"));
        Assert.assertTrue("Wrong remove result", mset.remove("hello"));
        Assert.assertTrue("Wrong remove result", mset.remove("world"));
        Assert.assertTrue("Wrong remove result", mset.remove("Sarah"));
        Assert.assertTrue("Wrong remove result", mset.remove("qopj"));


        Assert.assertEquals("Size wrong ", 0, mset.size());

        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");
        mset.put("hello");

        Assert.assertEquals("Size wrong ", 1, mset.size());

        mset.put("System");
        Assert.assertTrue(mset.remove("System"));

        mset.put("f");
        Assert.assertTrue(mset.remove("f"));

        mset.put("wfa");
        Assert.assertTrue(mset.remove("wfa"));

        mset.put("asfag");
        Assert.assertTrue(mset.remove("asfag"));

        Assert.assertEquals("Size wrong ", 1, mset.size());


    }

    @Test
    public void testIntersection() {

        PowerSet pwset1 = new PowerSet();
        pwset1.put("test");
        pwset1.put("Conor");
        pwset1.put("hello");
        pwset1.put("world");
        pwset1.put("Sarah");
        pwset1.put("qopj");

        PowerSet pwset2 = new PowerSet();
        pwset2.put("world");
        pwset2.put("Sarah");
        pwset2.put("qopj");

        // [1] Intersection set1 - set2
        PowerSet pwset3 = pwset1.intersection(pwset2);
        Assert.assertTrue("Difference wrong result set1 - set2", pwset3.get("world")
                && pwset3.get("Sarah") && pwset3.get("qopj"));
        Assert.assertEquals("Size wrong set1 - set2", 3, pwset3.size());

        // [2] Intersection set1 - empty
        PowerSet pwsetEmpty = new PowerSet();
        PowerSet pwset4 = pwset1.intersection(pwsetEmpty);
        Assert.assertEquals("Size wrong set1 - empty", 0, pwset4.size());

        // [3] Intersection empty  - set1
        PowerSet pwset5 = pwsetEmpty.intersection(pwset1);
        Assert.assertEquals("Size wrong empty - set1", 0, pwset5.size());

        // [4] Intersection set1 - set1
        PowerSet pwset6 = pwset1.intersection(pwset1);
        Assert.assertEquals("Size wrong empty - set1", 6, pwset6.size());
        Assert.assertTrue("Difference wrong result pwset2 - pwsetEmpty", pwset6.get("test")
                && pwset6.get("Conor") && pwset6.get("hello") && pwset6.get("world") && pwset6.get("Sarah")
                && pwset6.get("qopj"));
    }

    @Test
    public void testDeference() {
        PowerSet pwset1 = new PowerSet();
        pwset1.put("test");
        pwset1.put("Conor");
        pwset1.put("hello");
        pwset1.put("world");
        pwset1.put("Sarah");
        pwset1.put("qopj");

        PowerSet pwset2 = new PowerSet();
        pwset2.put("world");
        pwset2.put("Sarah");
        pwset2.put("qopj");

        // [1] Difference set1 - set2
        PowerSet pwset3 = pwset1.difference(pwset2);
        Assert.assertTrue("Difference wrong result pwset1 - pwset2", pwset3.get("test") && pwset3.get("Conor")
                && pwset3.get("hello"));
        Assert.assertEquals("Size wrong ", 3, pwset3.size());

        // [2] difference set1 and empty set
        PowerSet pwsetEmpty = new PowerSet();
        PowerSet pwset4 = pwset1.difference(pwsetEmpty);
        Assert.assertTrue("Difference wrong result pwset2 - pwsetEmpty", pwset4.get("test")
                && pwset4.get("Conor") && pwset4.get("hello") && pwset4.get("world") && pwset4.get("Sarah")
                && pwset4.get("qopj"));
        Assert.assertEquals("Size wrong ", 6, pwset4.size());

        // [3] Difference set2 - set1
        PowerSet pwset5 = pwset2.difference(pwset1);
        Assert.assertFalse("Difference wrong result pwset2 - pwset1", pwset5.get("test") && pwset5.get("Conor")
                && pwset5.get("hello"));
        Assert.assertEquals("Size wrong ", 0, pwset5.size());

        // [4] Difference set1 - set1
        System.out.println("Difference set1 - set1");
        PowerSet pwset6 = pwset1.difference(pwset1);
        Assert.assertEquals("Size wrong ", 0, pwset6.size());
    }

    @Test
    public void testUnion() {
        PowerSet pwset1 = new PowerSet();
        pwset1.put("test");
        pwset1.put("Conor");
        pwset1.put("hello");
        pwset1.put("world");
        pwset1.put("Sarah");
        pwset1.put("qopj");

        PowerSet pwset2 = new PowerSet();
        pwset2.put("cool");
        pwset2.put("story");
        pwset2.put("bro");

        // [1] Union set1 - set2
        PowerSet pwset3 = pwset1.union(pwset2);
        Assert.assertTrue("Wrong Union result set1 - set2", pwset3.get("test")
                && pwset3.get("Conor") && pwset3.get("hello") && pwset3.get("world") && pwset3.get("Sarah")
                && pwset3.get("qopj") && pwset3.get("cool") && pwset3.get("story") && pwset3.get("bro") );
        Assert.assertEquals("Wrong Size  result set1 - set2", 9, pwset3.size());

        // [2] Union set1 - empty
        PowerSet pwsetEmpty = new PowerSet();
        PowerSet pwset4 = pwset1.union(pwsetEmpty);
        Assert.assertTrue("Wrong Union result set1 - empty", pwset4.get("test")
                && pwset4.get("Conor") && pwset4.get("hello") && pwset4.get("world") && pwset4.get("Sarah")
                && pwset4.get("qopj") );
        Assert.assertEquals("Wrong Union Size empty", 0, pwsetEmpty.size());
        Assert.assertEquals("Wrong Size result set1 - empty", 6, pwset4.size());

        // [23 Union empty - set1
        PowerSet pwset5 = pwsetEmpty.union(pwset1);
        Assert.assertTrue("Wrong Union result empty - set1", pwset5.get("test")
                && pwset5.get("Conor") && pwset5.get("hello") && pwset5.get("world") && pwset5.get("Sarah")
                && pwset5.get("qopj") );
        Assert.assertEquals("Wrong Union Size empty", 0, pwsetEmpty.size());
        Assert.assertEquals("Wrong Union Size result empty - set2", 6, pwset5.size());

        // [3] Union set1 - set1
        System.out.println("Union set1 with set1");
        PowerSet pwset6 = pwset1.union(pwset1);
        Assert.assertTrue("Wrong Union result empty - set1", pwset5.get("test")
                && pwset5.get("Conor") && pwset5.get("hello") && pwset5.get("world") && pwset5.get("Sarah")
                && pwset5.get("qopj") );
        Assert.assertEquals("Wrong Union Size result empty - set2", 6, pwset5.size());
    }

    @Test
    public void testSubset() {
        PowerSet pwset1 = new PowerSet();
        pwset1.put("test");
        pwset1.put("Conor");
        pwset1.put("hello");
        pwset1.put("world");
        pwset1.put("Sarah");
        pwset1.put("qopj");

        PowerSet pwset2 = new PowerSet();
        pwset2.put("cool");
        pwset2.put("story");
        pwset2.put("bro");

        PowerSet pwset3 = new PowerSet();
        pwset3.put("test");
        pwset3.put("Conor");
        pwset3.put("hello");

        // [1] Subset set1 - set2
        Assert.assertFalse("Wrong Subset result set1 - set2", pwset1.isSubset(pwset2) );
        Assert.assertFalse("Wrong Subset result set2 - set1", pwset2.isSubset(pwset1) );
        Assert.assertTrue("Wrong Subset result set1 - set2", pwset1.isSubset(pwset3) );
        Assert.assertFalse("Wrong Subset result set2 - set1", pwset3.isSubset(pwset1));

        // [2] Union set1 - empty
        PowerSet pwsetEmpty = new PowerSet();
        Assert.assertTrue("Wrong Subset result set1 - empty", pwset1.isSubset(pwsetEmpty) );
        Assert.assertFalse("Wrong Subset result empty - set1", pwsetEmpty.isSubset(pwset1) );
        pwsetEmpty = null;
        Assert.assertTrue("Wrong Subset result set1 - empty", pwset1.isSubset(pwsetEmpty) );

        // [3] Union empty - set1
        Assert.assertTrue("Wrong Subset result set1 - set1", pwset1.isSubset(pwset1) );
        Assert.assertTrue("Wrong Subset result set2 - set2", pwset2.isSubset(pwset2) );
    }

    @Test
    public void testHighload() {
        PowerSet pwset1 = new PowerSet();

        System.out.println("Start");
        int i;
        for (i = 0; i != 20000; i++){
            pwset1.put( Character.toString((i)) );
            Assert.assertTrue("Wrong put result", pwset1.get( Character.toString((i)) ) );
        }
        Assert.assertFalse("Set should not has empty slots", pwset1.get(null));

        for (; i != 21000; i++){
            pwset1.put( Character.toString((i)) );
            Assert.assertFalse("Wrong put result", pwset1.get( Character.toString((i)) ) );
        }
        System.out.println("Stop");

        System.out.println("Start");
        int j;
        for ( j = 0; j != 20000 && pwset1.size() != 0; j++){
            Assert.assertTrue("Wrong remove result", pwset1.remove( Character.toString(j) ) );
        }
        for ( ; j != 21000 && pwset1.size() != 0; j++){
            Assert.assertFalse("Wrong remove result", pwset1.remove( Character.toString(j) ) );
        }
        System.out.println("Stop");

    }

}
