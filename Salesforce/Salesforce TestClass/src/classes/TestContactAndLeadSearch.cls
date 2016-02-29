@isTest
private class TestContactAndLeadSearch {
    
    @testSetup
    static void setup() {
        ContactAndLeadUtility.createContacts(10);
        ContactAndLeadUtility.createLeads(10);
    }
    
    @isTest
    static void testSearchNull() {
        String find = null;
        Test.startTest();
        List<List<Sobject>> expected = ContactAndLeadSearch.searchContactsAndLeads(find);
        List<List<Sobject>> actual = new  List<List<Sobject>>();
        System.assertEquals(expected, actual);
        Test.stopTest();
        
    }
    @isTest
    static void testSearch() {
        String find = 'Test';
        Test.startTest();
        List<List<Sobject>> expected = ContactAndLeadSearch.searchContactsAndLeads(find);
        List<List<Sobject>> actual = [ FIND :find IN ALL FIELDS RETURNING Contact(FirstName, LastName),Lead(FirstName , LastName)];
        Test.stopTest();
        System.assertEquals(expected, actual);
        
    }
    @isTest
    static void testSearchNotFound() {
        String find = 'Dh';
        Test.startTest();
        List<List<Sobject>> expected = ContactAndLeadSearch.searchContactsAndLeads(find);
        List<List<Sobject>> actual = [ FIND :find IN ALL FIELDS RETURNING Contact(FirstName, LastName),Lead(FirstName , LastName)];
        System.debug('expected'+expected+' actual '+actual);
        Test.stopTest();
        System.assertEquals(expected, actual);
        
    }
    
    
    
}