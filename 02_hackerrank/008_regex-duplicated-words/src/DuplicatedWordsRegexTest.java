import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.*;


public class DuplicatedWordsRegexTest {

	@Test
	public void testReturnWordsWithoutDuplication() {
		DuplicatedWordsRegex myReg = new DuplicatedWordsRegex();
		String input = "hi hi higher";
		
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		myReg.setRegex(regex);
		assertThat(myReg.returnWordswithoutDuplication(input), is("hi higher"));
		
		regex = "\\b([a-z]|[A-Z]+)(\\s+\\1\\b)+";
		myReg.setRegex(regex);		
		assertThat(myReg.returnWordswithoutDuplication(input), is("hi higher"));
	}

}
