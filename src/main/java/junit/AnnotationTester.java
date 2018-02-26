package junit;

import java.lang.reflect.AnnotatedElement;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class AnnotationTester {

	@Transactional
	@Test
	public void testAnnotaion() throws NoSuchMethodException, SecurityException{
		AnnotatedElement element = AnnotationTester.class.getMethod("testAnnotaion", null);
		Transactional ann = element.getAnnotation(Transactional.class);
		System.out.println(ann);
	}

}
