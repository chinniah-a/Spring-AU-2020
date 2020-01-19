package triconsumerandwrapperlamda;

public class TriConsumerTest {
	
	
	static <A,B,C,E extends Exception> Triconsumer<A, B, C> lamdaWrapper(Triconsumer<A, B, C> triConsumer, Class<E> exception){ //Wrapper Lambda For Exception Handling
		
		return (a,b,c) -> {
			try {
				triConsumer.accept(a,b,c);
			}
			catch(Exception e) {
				try {
	                E exCast = exception.cast(e);
	                System.err.println(
	                  "Exception occured : " + exCast.getMessage());
	            } catch (ClassCastException ccEx) {
	                throw e;
	            }
			}
		};
		
	}
		
	public static void main(String[] args) {
		Triconsumer<Integer, Integer, Integer> triconsumer = (a,b,c) -> {	//Largest of 3 numbers
			if(a > b)
			{
				if (a > c) {
					System.out.println(a + " Is largest");
				}
				else {
					System.out.println(c + " Is largest");
				}
			}
			else {
				if (b > c) {
					System.out.println(b + " Is largest");
				}
				else {
					System.out.println(c + " Is largest");
				}
			}
		};
		
		triconsumer.accept(1, 2, 3);
		
		Triconsumer<String, String, String> triconsumerStr = (a,b,c) -> System.out.println(a+b+c); // Triconsumer to concatenate Strings
				
	
		
		triconsumerStr.accept("Hello ", "I\'m ", "Rohit.");
		
		
		//// Wrapper Lambda Test
		
		//= (a,b,c) -> System.out.println((a)/(b - c));
		
		Triconsumer< Integer, Integer, Integer> wrapperTest = lamdaWrapper((a,b,c) -> System.out.println((a)/(b - c)),ArithmeticException.class); //Lambda wrapped inside the wrapper function
		
		wrapperTest.accept(5, 1, 1);
	}
	
	
	
	
}
