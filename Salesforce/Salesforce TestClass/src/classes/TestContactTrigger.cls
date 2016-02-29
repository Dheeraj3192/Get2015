@isTest
private class TestContactTrigger {
    
    
    @isTest
    static void testRestrictTeachingHindi() {
        Contact cnt = new Contact();
        cnt.LastName = 'Test teacher';
        cnt.Subjects__c='Hindi';
       Database.SaveResult result = Database.insert(cnt, false);
        System.debug('Resulst is '+result);
        System.assert(!result.isSuccess());
        System.assertEquals(result.getErrors()[0].getMessage(),'Teacher not allowed to teach hindi subject');
        
        
        
    }
     @isTest
    static void testRestrictNotTeachingHindi() {
        Contact cnt = new Contact();
        cnt.LastName = 'Test teacher';
        cnt.Subjects__c='English';
       Database.SaveResult result = Database.insert(cnt, false);
        System.debug('Resulst is '+result);
        System.assert(result.isSuccess());

     }
    
    
    

}