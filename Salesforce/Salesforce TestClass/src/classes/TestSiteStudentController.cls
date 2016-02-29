@isTest
private class TestSiteStudentController {
    
    @isTest
    static void testGetStudentNames() {
        StudentClassTestUtility.setUpData();
        Test.startTest();
        SiteStudentController siteController = new SiteStudentController();
        List<SelectOption> expected = siteController.getStudentNames();
		Test.stopTest();
        System.assertEquals(expected.size(), 6);        
    }
    @isTest
    static void testStudentDetail() {
        StudentClassTestUtility.setUpData();
        Test.startTest();
        SiteStudentController siteController = new SiteStudentController();
        Student__c st = [Select id from Student__c where name ='Test Student3' Limit 1];
        sitecontroller.selectedStdId = st.id ;
        siteController.studentDetail();
        Student__c expected = siteController.student;
        Student__c actual = [SELECT Name,Email__c,Sex__c ,Age__c,Class__r.Name ,First_Name__c,Last_Name__c, DOB__C FROM Student__c WHERE Id = :st.id LIMIT 1] ;
        Test.stopTest();
        System.assertEquals(expected, actual);
        System.assert(siteController.show);
    }
    
}