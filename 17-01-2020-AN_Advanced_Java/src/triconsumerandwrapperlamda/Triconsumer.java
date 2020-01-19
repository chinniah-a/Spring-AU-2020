package triconsumerandwrapperlamda;
@FunctionalInterface
public interface Triconsumer<A,B,C> {
	
	public void accept(A a,B b,C c);

}
