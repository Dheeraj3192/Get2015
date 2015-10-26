package Helper;

import model.LeaveApprover;

public class Chaining {

	public static void setChaining(LeaveApprover mentor,
			LeaveApprover srMentor, LeaveApprover hrManager) {
		mentor.setSuccessor(srMentor);
		srMentor.setSuccessor(hrManager);
	}
}
