import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static boolean validateEmail(String emailAddress) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		Matcher m = p.matcher(emailAddress);

		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(emailAddress, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
		}

		if (matchFound && lastToken.length() >= 2 && emailAddress.length() - 1 != lastToken.length()) {
			return true;
		} else
			return false;
	}

	public static void main(String args[]) {
		// Input the string for validation
		String email = "xyz@hotmail.com";

		System.out.println(validateEmail(email));
	}
}
