@isTest
private class TestDeleteStudentController {
 
    @isTest
    static void test() {
        StudentClassTestUtility.setUpData();
       	Apexpages.StandardSetController setcontroller = new  ApexPages.StandardSetController(StudentClassTestUtility.stdList);
       
        DeleteStudentController dsc = new DeleteStudentController(setcontroller);
        dsc.getSelectedStudents();

        
        
        
    }
}