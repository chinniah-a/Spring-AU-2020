package triconsumerandwrapperlamda;
@FunctionalInterface
public interface Triconsumer<A,B,C> { //Decleration and signature of the Triconsumer
	
	public void accept(A a,B b,C c);

}
