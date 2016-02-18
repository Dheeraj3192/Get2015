/** 
* Author: Dheeraj Kumar
* Created Date: 11/01/2016
* Name:  GetContactDetail 
* Desc: Soap Web Service Contact Object
*/
global class GetContactDetail {
    /**
*    @param String
*    @return String
*    @desc Search Contact By Id
*/
    webservice static String SearchContactById(String contactId) {
       List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone from contact where id=:contactId];
       String str = JSON.serialize(cntList);
       return str;
    } 
        /**
*    @param String
*    @return String
*    @desc Search Contact By Name 
*/
    webservice static String SearchContactByName(String ContactName) {
       List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone from contact where name=:ContactName limit 1000];
       String str = JSON.serialize(cntList);
       return str;
    } 
        /**
*    @param String
*    @return String
*    @desc Search Contact By email id
*/
     webservice static String SearchContactByEmail(String ContactEmail) {
      List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone from contact where Email=:ContactEmail limit 1000];
       String str = JSON.serialize(cntList);
       return str;
     } 
         /**
*    @param void
*    @return String
*    @desc get All Contacts
*/
      webservice static String getAllContact() {
       List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone from contact limit 1000];
       String str = JSON.serialize(cntList);
       return str;
     } 
}