/** 
* Author: Dheeraj Kumar
* Created Date: 12/01/2016
* Name:  CreateStudent 
* Desc: Soap Web Service Student Object
*/
global class CreateStudent {
   
    /**
*    @param String, String,String
*    @return String
*    @desc Create Student By Class Name 
*/
   webservice static String CreateStudentWithRequiredField(String firstName,String lastName,String className) {
       Class__c newClass = new Class__c(name=className);
       insert newClass;
       student__c newStudent =new student__c(First_Name__c=firstName,Last_Name__c=lastName,Class__c=newclass.id);
       insert newStudent;
       return newStudent.id;
    }
    /**
*    @param String, String,String
*    @return String
*    @desc Create Student By Class Id
*/
     webservice static String CreateStudentWithClassid(String firstName,String lastName,String ClassId) {
       student__c newStudent =new student__c(First_Name__c=firstName,Last_Name__c=lastName,Class__c=ClassId);
       insert newStudent;
       return newStudent.id;
    }
}