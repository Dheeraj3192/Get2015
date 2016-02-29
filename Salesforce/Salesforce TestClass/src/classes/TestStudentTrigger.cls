@isTest
private class TestStudentTrigger {
    
    
    @isTest 
    static void testNotAllowInsertStudent() {
        ClassUtility.createClass(1 ,2);
        List<Student__C> stdList = ClassUtility.sts ;
        Test.startTest();
        Database.SaveResult[] result=Database.insert(stdList  ,false) ;
        Test.stopTest();
        System.debug('result is '+result);
        System.assert(!result.get(0).isSuccess());
        System.assert(!result.get(1).isSuccess());
        System.assert(result.get(1).getErrors().size()>0);
        System.assertEquals('No more seat in selected class', result.get(1).getErrors()[0].getMessage());
    }
    
    
    @isTest
    static void testUpdateMyCountOnDelete() {
        ClassUtility.createClass(2,2);
        List<Student__C> stdList = ClassUtility.sts ;
        Test.startTest();
        insert stdList; 
        delete stdList.get(1);
        Class__C cls1 = [Select My_count__C from  Class__C where Name ='TenthClass'];
        Decimal expected = cls1.My_Count__c;
       	Decimal actual = 1;
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
}