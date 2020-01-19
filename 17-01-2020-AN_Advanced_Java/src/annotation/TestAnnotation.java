package annotation;

import java.lang.reflect.Method;

public class TestAnnotation {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Intern intern = new Intern();
		FTE f = new FTE();
		
		Method statFTE = f.getClass().getMethod("stat");
		
		FullAnno fullAnnoFTE = statFTE.getAnnotation(FullAnno.class);
		
		if(!fullAnnoFTE.isIntern()) {
			System.out.println("Not an intern. \nSalary :" + fullAnnoFTE.Salary());
		}
		
		
		FullAnno fullAnnoIntern = intern.getClass().getAnnotation(FullAnno.class);
		
		if(fullAnnoIntern.isIntern()) {
			System.out.print("Not an intern. \nSalary :" + fullAnnoIntern.Salary());
		}
	}
	
}

