@isTest(SeeAllData=true)
private class TestOpportunityTrigger {
    @isTest
    static void testupdateManagerField() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Contact cnt = OpportunityUtility.cnt;
        Account acc = OpportunityUtility.acc;
        opp.BillToContact__c = cnt.id;
        Test.startTest();
        update opp;
        Opportunity expected = [Select Name , BillToContact__c , Manager__c from Opportunity where Name='testOpportunity' LIMIt 1];
        Test.stopTest();
        System.debug('expected is '+expected);
        System.debug('actual is '+acc.id);
        System.assertEquals(expected.Manager__c, acc.id);
    }
    
    @isTest
    static void testPopulateCloseDateField () {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        Contact cnt = OpportunityUtility.cnt;
        Account acc = OpportunityUtility.acc;   
        opp.StageName ='Closed Won';
        Test.startTest();
        update opp;
        Opportunity expected = [Select Name,StageName , CloseDate from Opportunity where name='testOpportunity'];
        System.debug('expected close'+expected);
        System.assertEquals(expected.CloseDate, System.today());
        opp.CloseDate  = OpportunityUtility.closDay ;
        opp.StageName = 'Close Lost';
        update opp;
        expected = [Select Name,StageName , CloseDate from Opportunity where name='testOpportunity'];
        System.debug('expected close date'+expected);
        System.assertEquals(expected.CloseDate, OpportunityUtility.closDay);
        opp.CloseDate  =OpportunityUtility.closDay ;
        opp.StageName = 'Close Won';
        update opp;
        expected = [Select Name,StageName , CloseDate from Opportunity where name='testOpportunity'];
        Test.stopTest();
        System.debug('expected close date'+expected);
        System.assertEquals(expected.CloseDate, OpportunityUtility.closDay);
    }
    @isTest
    static void testDeleteAssociatedProduct() {
        OpportunityUtility.createOpportunity();
        Opportunity opp = OpportunityUtility.opp;
        //create product 
        Product2 prod  = new Product2(Name='TestProduct' , ProductCode ='Pro-test', isActive =true ,Price__c =100);
        insert prod;
        //get price book from org
        Pricebook2  standardPb = [select id, name, isActive from Pricebook2 where IsStandard = true limit 1];
        System.debug('Standard price book is '+standardPb);
        PriceBookEntry pbEntry = new PricebookEntry(Pricebook2id = standardPb.id , Product2id = prod.id  ,UnitPrice = 100 , isActive = true );
        insert pbEntry;
        List<OpportunityLineItem> oppProducts = new List<OpportunityLineItem>();
        for(integer i=0;i< 3;i++) {
            OpportunityLineItem item = new OpportunityLineItem(OpportunityId = opp.id ,Quantity=2 ,PriceBookEntryId =pbEntry.id );
            item.TotalPrice = (item.Quantity)*(pbEntry.UnitPrice);
            oppProducts.add(item);
        }
        insert oppProducts;
        opp.Custom_Status__c='Reset';
        Test.startTest();
        update opp;
        List<OpportunityLineItem> expected = [Select id from OpportunityLineItem where OpportunityId =:opp.id];
        Test.stopTest();
        System.assertEquals(expected.size() , 0 ) ;
    }
    
    
}