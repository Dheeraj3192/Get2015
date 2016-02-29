@isTest
private class TestCreateStudent {
    
    @isTest
    static void testcreateStudent () {
        Class__c cls  = new Class__c(Name ='TestClass');
        insert cls;
        String firstName ='Test' ;
        String lastName = 'Student';
        String className =cls.name;
        Test.startTest() ;
        String StudentId = CreateStudent.CreateStudentWithRequiredField(firstName, lastName, className);
        Test.stopTest();
        System.assert(studentId !=null);
    }
    @isTest
    static void testcreateStudentClassNull () {
        String firstName ='Test' ;
        String lastName = 'Student';
        String className =null;
        Test.startTest();
        String StudentId = CreateStudent.CreateStudentWithRequiredField(firstName, lastName, className);
        Test.stopTest() ;
        System.assert(studentId ==null);
    }
    @isTest
    static void testcreateStudentClassId () {
        Class__c cls  = new Class__c(Name ='TestClass');
        insert cls;
        String firstName ='Test' ;
        String lastName = 'Student';
        String classid =cls.id;
        Test.startTest() ;
        String StudentId = CreateStudent.CreateStudentWithClassid(firstName, lastName, ClassId);
        Test.stopTest() ;
        System.assert(StudentId != null);
    }
    @isTest
    static void testcreateStudentClassIdNull() {
        String firstName ='Test' ;
        String lastName = 'Student';
        String classid =null;
        Test.startTest() ;
        String StudentId = CreateStudent.CreateStudentWithClassid(firstName, lastName, ClassId);
        Test.stopTest();
        System.assert(StudentId == null);
    }
}