package com.github.leventarican;

import java.util.ArrayList;
import java.util.List;

/**
 * REMARK: 
 * garbage collection dramatically reduces the incidence of memory leaks.
 * but a memory leak can still occurs.
 * 
 * A memory leak occurs when memory is allocated and never reclaimed.
 * 
 * DEMO: how to force a memory leak.
 * limit your heap size. e.g. set maximum Java heap size to 1024 to force a memory exception
 * create objects, reference it but don't use it --> memory leak
 * use visualvm (visualvm.exe --jdkhome) for memory monitoring. also with a usual task memory manager you can see the memory rising
 */
public class MemoryLeak {
	public static void main(String args[]) {
		List<Integer> references = new ArrayList<>();
		int size = Integer.MAX_VALUE / 25;
		for (int i=0; i<size; i++) {
			references.add(new Integer(314));

			// force GC to clean up will eventually prevent rising memory
//			System.gc();
		}
	}
}
/*
$ java -Xmx1024m -cp ../../..  com.github.leventarican.MemoryLeak
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
at java.util.Arrays.copyOf(Arrays.java:3210)
at java.util.Arrays.copyOf(Arrays.java:3181)
at java.util.ArrayList.grow(ArrayList.java:265)
at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
at java.util.ArrayList.add(ArrayList.java:462)
at com.github.leventarican.MemoryLeak.main(MemoryLeak.java:28)
*/