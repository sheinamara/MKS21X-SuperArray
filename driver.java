public class driver{
	public static void main(String[] args){
		SuperArray a = new SuperArray();
		/*Phase 1 testing*/
		System.out.println("-----Testing Phase 1-----");

		//Testing SuperArray initializing
		System.out.println("\n---Initializing SuperArray---");
		System.out.println("Testing toString(): should return []");
		System.out.println(a);
		System.out.println("\nTesting toStringDebug(): should return [null (x10)]");
		System.out.println(a.toStringDebug());

		//testing size()
		System.out.println("\n\n---Testing size()---");
		System.out.println("Testing size(): should return 0");
		System.out.println(a.size());

		//testing add()
		System.out.println("\n\n---Testing add()---");
		System.out.println("Testing add() while empty: should return true");
		System.out.println(a.add("apple"));
		System.out.println("\nChecking add() and toString(): should return [apple]");
		System.out.println(a);
		a.add("banana");
		System.out.println("\nChecking add() and toString(): should return [apple, banana]");
		System.out.println(a);
		for (int x = 0; x < 9; x++){
			a.add("blank");
		}
		System.out.println("\n---Testing toStringDebug() again: should print [apple, banana, blank (x8)]---");
		System.out.println(a.toStringDebug());
		System.out.println("\n\n---Testing add() while full: should return false---");
		System.out.println(a.add("full"));

		//testing clear()
		System.out.println("\n\n---Testing clear()---");
		System.out.println("Testing clear(): should return []");
		a.clear();
		System.out.println(a);
		System.out.println("\n\n---Testing clear(): Should print [apple, banana, null (x8)]---");
		System.out.println(a.toStringDebug());
		System.out.println("\n---Testing clear() and size(): should return 0---");
		System.out.println(a.size());
		System.out.println("\n---Testing add(\"boop\") after clear(): should return true---");
		System.out.println(a.add("boop"));
		System.out.println("\n---Should print [boop]---");
		System.out.println(a);
		a.clear();

		//testing get()
		System.out.println("\n\n-----Testing get()-----");
		System.out.println("---Testing get() while empty: should return null---");
		System.out.println(a.get(0));
		a.add("burp");
		a.add("ahem");
		a.add("coughdrop");
		System.out.println("\n---Testing get() with indices 0-2 filled: should return values burp, ahem, coughdrop---");
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		System.out.println(a.get(2));
		System.out.println("\n---Testing get() for out of bounds: should return null---");
		System.out.println(a.get(-1));
		System.out.println(a.get(10));

		//testing set()
		System.out.println("\n\n-----Testing set()-----");
		System.out.println("---Using SuperArray from testing get()---");
		System.out.println(a);
		System.out.println("\n---Testing set(0, \"blue\"): should return burp---");
		System.out.println(a.set(0, "blue"));
		System.out.println("-Should print [blue, ahem, coughdrop]-");
		System.out.println(a);
		System.out.println("\n---Testing set(1, \"fish\"): should return ahem---");
		System.out.println(a.set(1, "fish"));
		System.out.println("-Should print [blue, fish, coughdrop]-");
		System.out.println(a);
		System.out.println("\n---Testing set(2, \"syrup\"): should return syrup---");
		System.out.println(a.set(2, "syrup"));
		System.out.println("-Should print [blue, fish, syrup]-");
		System.out.println(a);
		System.out.println("\n\n---Testing the error: using indices that are outside of the domain. Both should return null and print an error message---");
		System.out.println(a.set(-2, "I'm not to be seen"));
		System.out.println(a.set(100, "I'm not supposed to be here..."));
		System.out.println("\n---Using cleared SuperArray---");
		a.clear();
		System.out.println("\n---Testing set(2, \"rock\"): should return null and an error message---");
		System.out.println(a.set(2, "rock"));
		System.out.println("-Should print []-");
		System.out.println(a);
	}
}
