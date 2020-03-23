/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenerator;

import java.util.Random;

class Generator extends Random {
    private final Random rand;

    Generator() {
        this.rand = new Random();
    }
    public char nextAlphabet(boolean upper) {
        return (char)(rand.nextInt(26)+(int)((upper) ? 'A' : 'a'));
    }
    
    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) a[i] = rand.nextInt(Integer.MAX_VALUE);
        return a;
    }
    
    public long[] nextLongArray(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; ++i) a[i] = rand.nextLong();
        return a;
    }
    
    public int[] nextPermutationArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) a[i] = i+1;
        int co = Math.max((int)(Math.log10(n)/Math.log10(2)), 5);
        while (co-- > 0) {
            for (int i = 1; i < n; ++i) {
                int j = rand.nextInt(i);
                a[i] += a[j];
                a[j] = a[i]-a[j];
                a[i] -= a[j];
            }   
        }
        return a;
    }
}
