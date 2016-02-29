@isTest
private class TestClassTrigger {
    
    @isTest
    static void testNotAllowDeleteClass() {
        
        ClassUtility.createClass(10,2);
        List<Student__c> stdList = ClassUtility.sts;
        Class__c cls = ClassUtility.cls;
        insert  stdList;
        Test.startTest();
        System.debug(cls);
        Database.DeleteResult result =  Database.delete(cls , false);
        system.debug('result is clas '+result);
        System.assert(!result.isSuccess()) ;
        System.assertEquals(result.getErrors()[0].getMessage(),'Class has more than on female student');
        Test.stopTest();
    }
    @isTest
    static void testNotAllowDeleteClassPositive() {
        ClassUtility.createClass(10,1);
        List<Student__c> stdList = ClassUtility.sts;
        Class__c cls = ClassUtility.cls;
        insert stdList;
        Test.startTest();
        System.debug(cls);
        Database.DeleteResult result =  Database.delete(cls , false);
        system.debug('result is clas '+result);
        System.assert(result.isSuccess()) ;
        Test.stopTest();
    }
    
    
}