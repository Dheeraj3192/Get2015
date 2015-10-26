package model;

public class SeniorMentor extends LeaveApprover {

	@Override
	public void processRequest(int numberOfLeaves) {

		if (numberOfLeaves <= 2) {
			System.out.println("Leave Approved By Senior Mentor");
		} else if (successor != null) {
			successor.processRequest(numberOfLeaves);
		}
	}

}
