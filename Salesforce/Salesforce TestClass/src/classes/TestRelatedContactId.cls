@isTest
private class TestRelatedContactId {
    
    @testSetup
    static void testSetup() {
        AccountClassTestUtility.setUpData();
    }
    
    
    @isTest 
    static void setContactId() {
        Test.startTest();
        Contact cnt = [Select id  , AccountId from contact where LastName ='TestContact2'];
        Account acc = new Account();
        acc.id =cnt.AccountId;
        
        Account expected = [Select ContactIds__c , (Select id from Contacts) from Account where id= :cnt.accountId];
        String contactcsv ='';
        System.debug('Contact ids '+expected.ContactIDs__c);
        for(Contact cnt1 : expected.Contacts) 
            contactcsv+=cnt1.id +',' ;
        contactcsv= contactcsv.removeEnd(',');
        expected.ContactIDs__c=contactcsv;  
        RelatedContactId.setContactId(cnt.id);
        
        Account actual = [Select ContactIds__c , (Select id from Contacts) from Account where id= :cnt.accountId];
        System.debug('Expected :'+expected);
        System.debug('Actual:'+actual);
        
        System.assertEquals(expected, actual);
        Contact cnt1 = new Contact(LastName ='other test', AccountId = acc.id);
        insert cnt1;
        
        expected.ContactIDs__c+=','+cnt1.id;
        RelatedContactId.setContactId(cnt1.id);
        
        actual = [Select ContactIds__c , (Select id from Contacts) from Account where id= :cnt1.accountId];
        String exp =expected.ContactIDs__c;
        String act = actual.ContactIDs__c;
        String[] expp = exp.split(',');
        String[] actt = act.split(',');
        System.debug('Expected :'+expected);
        System.debug('Actual:'+actual);
        
        System.assertEquals(expp.size() ,actt.size());
        Test.stopTest();
        
    }
    
    @isTest 
    static void setContactIdIsNull() {
        boolean expected = false;
        Test.startTest();
        boolean actual = RelatedContactId.setContactId(null);
        Test.stopTest();
        System.debug('Expected :'+expected);
        System.debug('Actual:'+actual);
        System.assertEquals(expected, actual);
    }
    
    
    
}