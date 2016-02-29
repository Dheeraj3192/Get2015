@isTest
private class TestStudentMapClass {
    
    @TestSetup
    static void testSetup() {
        StudentClassTestUtility.setUpData();
        
    }
    @isTest
    static  void testGetClassStudents() {
        
        Test.startTest();
        List<Class__C> cls = [Select id ,(Select Name from students__r ) from Class__C where name='5thClass'];
        Map<Id,Set<Student__c>> expected=new Map<Id,Set<Student__c>>();
        for ( Class__c class1 : cls)  
            expected.put(class1.id, new Set<Student__c>(class1.Students__r));
        Map<Id,Set<Student__c>> actual = ClassStudentsMap.getAllClassByStudent();
        Test.stopTest();
        System.debug(expected.size()+'actual size is'+actual.size()); 
        System.debug('expected '+ expected);
        System.debug('Actual '+ actual);
        System.assertEquals(expected, actual);      
    }
    
    
}