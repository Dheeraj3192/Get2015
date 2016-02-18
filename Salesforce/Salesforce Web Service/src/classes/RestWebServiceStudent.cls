/**
* Author: Dheeraj Kumar	
* Created Date: 16/02/2016
* Name: RestWebServiceStudent
* Desc: Rest API for Studnet Object Insert
*/
@RestResource(urlMapping='/insertstudent')	
global class RestWebServiceStudent {
     /**
*    @param String , String, String, String
*    @return void 
*    @desc insert Student Rest Web Service
*/
    @httpPost
    global static void CreateStudentWithRequiredField(String name ,String firstName,String lastName,String className) {
        System.debug('hi insert student');
        Class__c newClass = null;
        Student__c newStudent = null;
        String returnMessage = '';
        try {
            newClass = new Class__c(name=className);
            insert newClass;
            newStudent =new student__c(Name=name ,First_Name__c=firstName,Last_Name__c=lastName,Class__c=newclass.id);
            insert newStudent;
            returnMessage = json.serialize(newStudent);
        } catch (Exception  e) {
            returnMessage = 'Exception Occured '+e.getMessage();
        }
        System.debug('Return Data is'+returnMessage);
        RestContext.response.responseBody = Blob.valueOf(returnMessage);
    }
    
}