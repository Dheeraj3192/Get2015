@isTest
Private class TestClassStudents {
    @TestSetup
    static void testSetup() {
        StudentClassTestUtility.setUpData();
        
    }
    
    @isTest
    static  void testGetClassStudents() {
        Test.startTest();
        Class__C cls = [Select id ,(Select Id , Name from students__r ) from Class__C where name='5thClass'];
        List<Student__C>  stdLIst = ClassStudents.getAllStudent(cls.Id);
        System.debug(cls.Students__r.size()+'dfsd'+stdList.size());
        Test.stopTest();
        System.assertEquals(cls.Students__r, stdList);        
    }
    @isTest
    static  void testGetClassStudentsClassNull() {
        Test.startTest();
        List<Student__C>  stdLIst = ClassStudents.getAllStudent(null);
        Test.stopTest();
        System.assertEquals(0, stdList.size());        
    }
    
}