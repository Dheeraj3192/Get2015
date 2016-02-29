@isTest
private class TestCustomLookScreen {
    
    
    @isTest
    static void testCheckValidity() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Test.startTest();
        Apexpages.StandardController controller = new ApexPages.StandardController(opp);
        CustomLookupScreen cls = new CustomLookupScreen(controller);
        Test.stopTest();
        System.assert(!cls.setb);
        cls.checkValidity();
        System.assert(cls.setb);
    }
    @isTest
    static void testGetItems() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Test.startTest();
        Apexpages.StandardController controller = new ApexPages.StandardController(opp);
        CustomLookupScreen cls = new CustomLookupScreen(controller);
        cls.checkValidity();
        Test.stopTest();
        System.assertEquals(cls.contactList.size() ,1);
        List<SelectOption> so =cls.getItems();
        System.assertEquals(so.size() ,1);
        
    }
    @isTest
    static void testSetBuildToContact() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Test.startTest();
        Apexpages.StandardController controller = new ApexPages.StandardController(opp);
        CustomLookupScreen cls = new CustomLookupScreen(controller);
        cls.checkValidity();
        cls.contactId = OpportunityUtility.cnt.id ;
        cls.setBuildToContact();
        Test.stopTest();
        System.assertEquals(opp.BillToContact__c, OpportunityUtility.cnt.id  );
    }
    @isTest
    static void testClearBuildToContact() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Test.startTest();
        Apexpages.StandardController controller = new ApexPages.StandardController(opp);
        CustomLookupScreen cls = new CustomLookupScreen(controller);
        cls.checkValidity();
        cls.clearBuildToContact();
        Test.stopTest();
        System.assertEquals(opp.BillToContact__c,NULL );
    }
    @isTest
    static void testManagerNull() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Test.startTest();
        Apexpages.StandardController controller = new ApexPages.StandardController(opp);
        CustomLookupScreen cls = new CustomLookupScreen(controller);
        opp.Manager__c = null;
        update opp;
        cls.checkValidity();
        List<ApexPages.Message> messages = Apexpages.getMessages();
        Test.stopTest();
        System.assertEquals(messages.size() ,1);
        System.assertEquals(messages[0].getSummary(), 'Manager Field is Blank');
        
        
    }
}