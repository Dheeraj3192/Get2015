package model;

public class Mentor extends LeaveApprover {

	@Override
	public void processRequest(int numberOfLeaves) {

		if (numberOfLeaves <= 1) {
			System.out.println("Leave Approved By Mentor");
		} else if (successor != null) {
			successor.processRequest(numberOfLeaves);
		
		}
	}

}
