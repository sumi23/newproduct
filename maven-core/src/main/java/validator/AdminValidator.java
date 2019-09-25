package validator;
import exception.ValidatorException;
import model.UserDetails;

public class AdminValidator {
UserDetails user = new UserDetails();
	public void availableCans(String cans) throws ValidatorException {
		String upperCaseChars = "(.*[A-Z].*)";
		
	     if (cans.matches(upperCaseChars ))
	     {
	             throw new ValidatorException("phone_number should not contain alphabet");
	     }
	     String lowerCaseChars = "(.*[a-z].*)";
	     if (cans.matches(lowerCaseChars ))
	     {
	             throw new ValidatorException("phone_number should not contain alphabet");
	     }
	     String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
	     if (cans.matches(specialChars ))
	     {
	             throw new ValidatorException("phone_number should notcontain special character");
	     }
	}
	}
	

