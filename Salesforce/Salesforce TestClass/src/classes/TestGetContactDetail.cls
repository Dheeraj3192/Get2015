@isTest
private class TestGetContactDetail {
    
    @isTest
    static void testGetAllContact() {
        ContactAndLeadUtility.createContacts(10);
        Test.startTest();
        String expected =GetContactDetail.getAllContact();
        List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone,Email from contact limit 1000];
        String actual = JSON.serialize(cntList);
        Test.stopTest();
        System.assertEquals(expected, actual);
        
    }
    
    @isTest
    static void testSearchContactByName() {
        ContactAndLeadUtility.createContacts(10);
        Test.startTest();
        String contactName = 'Contact Test3';
        String expected =GetContactDetail.SearchContactByName(contactName);
        List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone,Email from contact where name=:contactName limit 1];
        String actual = JSON.serialize(cntList);
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void testSearchContactByEmail() {
        ContactAndLeadUtility.createContacts(10);
        String contactEmail = 'test3@metacube.com';
        Test.startTest();
        String expected =GetContactDetail.SearchContactByEmail(contactEmail);
        List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone,Email from contact where Email=:contactEmail limit 1];
        String actual = JSON.serialize(cntList);
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void testSearchContactById() {
        ContactAndLeadUtility.createContacts(10);
        Contact cnt = [Select id from Contact where name = 'Contact Test3' limit 1];
        String contactId = cnt.id;
        String expected =GetContactDetail.SearchContactById(contactId);
        List<Contact> cntList = [select id,FirstName,LastName,Account.name,phone,Email from contact where Id=:contactId limit 1];
        String actual = JSON.serialize(cntList);
        System.assertEquals(expected, actual);
    }
    
}