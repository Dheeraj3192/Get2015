@isTest
private class TestManageClassCont {
    
    @isTest
    static void test() {
        ManageClassTestUtility.createClassess(10);
        Test.startTest();
        ManageClassController manageClass = new ManageClassController(); 
        List<Class__c> clsList = manageClass.getRecords();
		Test.stopTest();
        System.assertEquals(clsList , ManageClassTestUtility.clsList);
        
    }
    @isTest
    static void testShowDataToEdit() {
        ManageClassTestUtility.createClassess(10);
        Test.startTest();
        ManageClassController manageClass = new ManageClassController(); 
        Class__c tempClass =[SELECT id, Name, fee__c,board__C FROM Class__c WHERE name = 'Test 3'];
        manageClass.idToUpdate = tempClass.id;
        manageClass.ShowDataToEdit();
        Test.stopTest();
        System.assert(manageClass.displayPopup);
    }
    @isTest
    static void testSaveDetails() {
        ManageClassTestUtility.createClassess(10);
        Test.startTest() ;
        ManageClassController manageClass = new ManageClassController(); 
        Class__c tempClass =[SELECT id, Name, fee__c,board__C FROM Class__c WHERE name = 'Test 3'];
        manageClass.idToUpdate = tempClass.id;
        manageClass.ShowDataToEdit();
        Test.stopTest();
        System.assert(manageClass.displayPopup);
        manageclass.saveDetails();
        System.assert(!manageClass.displayPopup);
    }
    @isTest
    static void testDeleteDetails() {
        ManageClassTestUtility.createClassess(10);
        Test.startTest();
        ManageClassController manageClass = new ManageClassController(); 
        Class__c tempClass =[SELECT id, Name, fee__c,board__C FROM Class__c WHERE name = 'Test 3'];
        manageClass.idToUpdate = tempClass.id;
        manageClass.ShowDataToEdit();
        Test.stopTest();
        System.assert(manageClass.displayPopup);
        manageClass.deleteDetails();
        List<Class__c> clsList = manageClass.getRecords();
        System.assertEquals(clsList.size(), 9);
    }
    
    
}