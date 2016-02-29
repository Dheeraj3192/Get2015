@isTest
private class TestContactSearch {
    
    @isTest(SeeAllData=true)
    static void test() {
        String lastName =null;
        String postalCode ='305801';
        Test.startTest();
        List<contact> expected = ContactSearch.searchForContacts(lastName, postalCode);
        List<contact> actual = new List<contact>();
        Test.stopTest();
        System.assertEquals(expected, actual);  
    }
    @isTest(SeeAllData=true)
    static void testPositive() {
        String lastName ='Kumar';
        String postalCode ='305801';
        Test.startTest();
        List<contact> expected = ContactSearch.searchForContacts(lastName, postalCode);
        List<contact> actual = [Select ID , Name from Contact Where MailingPostalCode=:postalCode and LastName =:lastName];
        Test.stopTest();
        System.assertEquals(expected, actual);  
    }
}