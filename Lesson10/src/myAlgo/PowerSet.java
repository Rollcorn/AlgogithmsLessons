// package AlgorithmsLessons.Lesson10.src.myAlgo;

public class PowerSet {
    private static final int CAPACITY = 20000;
    private static final int STEP = 3;
    private int mSize;
    private String[] mSlots;

    public PowerSet() {
        mSlots = new String[CAPACITY];
        mSize = 0;

        for (int i = 0; i < CAPACITY; i++) {
            mSlots[i] = null;
        }
    }

    public int size() {
        return mSize;
    }

    // If aKey = null return 0
    public int hashFun(String aValue) {
        int hash = 0;
        final int SIMPLENUM = 31;
        for (int i = 0; (aValue != null) && (i != aValue.length()); i++) {
            hash = (hash * SIMPLENUM + aValue.charAt(i)) % CAPACITY;
        }
        return hash;
    }

    public boolean get(String aKey) {

        int hashKey = hashFun(aKey);
        boolean equals = false;

        for (int count = 0;
             (mSlots[hashKey] != null) && (aKey != null) && (count < CAPACITY);
             count++, hashKey = (hashKey + STEP) % CAPACITY) {

            // Equals keys must have equals hashes and equals lengths
            if ((hashFun(mSlots[hashKey]) != hashFun(aKey)) && (mSlots[hashKey].length() != aKey.length())) {
                continue;
            }

            if (mSlots[hashKey].equals(aKey)) {
                return true;
            }
        }

        if (aKey == null) {
            equals = mSize < CAPACITY;
        }
        return equals;
    }

    public void put(String aValue) {

        int hashKey = hashFun(aValue);
        //Check this value in the set
        boolean checkKey = get(aValue);
        // While not found empty slot or number of attempts not equal sets capacity keep looking
        for (int count = 0; (mSlots[hashKey] != null) && (count < CAPACITY); count++) {
            //if set already has this value don't put it again
            if (checkKey) {
                break;
            }
            hashKey = (hashKey + STEP) % CAPACITY;
        }

        // if this slot is empty, and we don't have this value in the set put value in set
        if ((mSlots[hashKey] == null) && (aValue != null) && !checkKey) {
            mSlots[hashKey] = aValue;
            mSize += 1;
        }
    }

    public boolean remove(String aValue) {
        if (aValue == null) {
            return false;
        }

        boolean checkKey = get(aValue);

        if (!checkKey) {
            return false;
        }

        int hashKey = hashFun(aValue);
        // Looking for slot which has key = a_value 
        while (!mSlots[hashKey].equals(aValue)) {
            hashKey = (hashKey + STEP) % CAPACITY;
        }

        // Remove this key
        mSlots[hashKey] = null;
        mSize--;
        hashKey = (hashKey + STEP) % CAPACITY;

        // Fix sequence following for the removed key
        while (mSlots[hashKey] != null) {
            String keyToRedo = mSlots[hashKey];
            mSlots[hashKey] = null;
            mSize--;
            put(keyToRedo);
            hashKey = (hashKey + STEP) % CAPACITY;
        }
        return true;

    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet intersectSet = new PowerSet();

        for (int i = 0; i < CAPACITY; i++) {
            if (this.mSlots[i] != null && set2.get(this.mSlots[i])) {
                intersectSet.put(this.mSlots[i]);
            }
        }

        return intersectSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet unionSet = new PowerSet();

        for (int i = 0; (i < CAPACITY) && (unionSet.size() < (this.size() + set2.size())); i++) {
            if (this.mSlots[i] != null) {
                unionSet.put(this.mSlots[i]);
            }
            if (set2.mSlots[i] != null) {
                unionSet.put(set2.mSlots[i]);
            }
        }
        return unionSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet diffSet = new PowerSet();

        for (int i = 0; i < CAPACITY; i++) {
            if (this.mSlots[i] != null && !set2.get(mSlots[i])) {
                diffSet.put(mSlots[i]);
            }
        }

        return diffSet;
    }

    public boolean isSubset(PowerSet set2) {

        boolean equalCheck = true;
        String checkingSlot;

        if ( set2 != null && this.size() < set2.size()) {
            equalCheck = false;
        }

        for (var i = 0;  set2 != null && ( i < CAPACITY ) && equalCheck; i++) {
            checkingSlot = set2.mSlots[i];

            if (checkingSlot == null) {
                continue;
            }
            equalCheck = this.get(checkingSlot);
        }

        return equalCheck;

    }

}
