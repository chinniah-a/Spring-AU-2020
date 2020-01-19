package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface FullAnno {
	int Id() default 0;
	String Name() default "";
	int Salary() default 0;
	boolean isIntern() default false;

}


class FTE{
	@FullAnno(Name = "Rohan Pawar",Salary = 100000)
	public void stat() {
		System.out.println("Full Time Employee");
	}
}

@FullAnno(Id = 1, Name = "Rohit",isIntern = true)
class Intern{
	void stat() {
		System.out.println("This is Intern");
	}
}

