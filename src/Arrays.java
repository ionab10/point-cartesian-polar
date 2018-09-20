import java.util.*;
import java.time.*;

public class Arrays {

	public static void main(String[] args) {
		ArrayList<Integer> arrL = new ArrayList<Integer>();

		
		long startTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() - startTime<10000) {
			arrL.add((int)Math.random()*10);
		}
		int size = arrL.size();
		System.out.println(size);
		
		Vector<Integer> vect = new Vector<Integer>();
		int[] intArr = new int[size];
		
		for(int q=0;q<size;q++) {
			vect.add((int)Math.random()*10);
			intArr[q]=(int)Math.random()*10;
		}
		
		int sum1=0, sum2=0, sum3=0;
		
		startTime = System.currentTimeMillis();
		for(Iterator<Integer> iter = arrL.iterator();iter.hasNext();) {
			sum1+=iter.next();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Summing the ArrayList took: " + (endTime-startTime)/1000.0 + " seconds");
		
		startTime = System.currentTimeMillis();
		for(Iterator<Integer> iter = vect.iterator();iter.hasNext();) {
			sum2+=iter.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Summing the Vector took: " + (endTime-startTime)/1000.0 + " seconds");
		
		startTime = System.currentTimeMillis();
		for(int x=0;x<size;x++) {
			sum3+=intArr[x];
		}
		endTime = System.currentTimeMillis();
		System.out.println("Summing the array took: " + (endTime-startTime)/1000.0 + " seconds");
	}

}
