package net.emailwebclient.bl;

import net.emailwebclient.model.User;

public class NullChecker {

	public static boolean isSet(User user) {
		if (user == null) {
			return false;
		}
		if (isSet(user.getUserName()) || isSet(user.getPassword())
				|| isSet(user.getFirstName()) || isSet(user.getLastName())
				|| isSet(user.getSex()) || isSet(user.getCity())
				|| isSet(user.getAge())) {
			return true;
		} else {
			return false;
		}
	}

	// public static boolean isSet(UserAndFile userAndFile) {
	// if (userAndFile == null) {
	// return false;
	// }
	// if (isSet(userAndFile.getUser()) || isSet(userAndFile.getFile())
	// || isSet(userAndFile.getMaxFileDimension())
	// || isSet(userAndFile.getMinFileDimension())) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	public static boolean isSet(String string) {
		if (string == null || string.trim().length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isSet(Integer integer) {
		if (integer == null) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isSet(Long long_) {
		if (long_ == null) {
			return false;
		} else {
			return true;
		}
	}

}