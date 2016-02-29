@isTest
private class TestAccountWithPagination {
    @testSetUp
    static void testSetUp() {
        AccountSearchUtility.setUpData();
    }
    
    
    @isTest
    static void test() {
        
        AccountWithPagination acpagination = new AccountWithPagination();
		
        System.assertEquals(acpagination.getAccounts(),null);
        acpagination.BillingCntry ='Country';
        acpagination.BillingCty='City';
        acpagination.BillingStat='State';
        acpagination.Search();
        System.debug('no of records' +acpagination.noOfRecords);
        System.debug('Size is '+acpagination.size);
        System.assertEquals(acpagination.noOfRecords ,10);
        System.assertEquals(acpagination.size ,3);
        System.assertEquals(acpagination.getAccounts().size() ,3);
        acpagination.refresh();
        System.debug('get'+acpagination.getAccounts());
        System.assertEquals(acpagination.noOfRecords ,10);
        System.assertEquals(acpagination.size ,3);
        for(integer i=0;i<3;i++){
            System.assert(acpagination.hasNext);
            System.assertEquals(acpagination.pageNumber,i+1);
            acpagination.next();
        }
        System.debug('get'+acpagination.getAccounts());
        System.assertEquals(acpagination.getAccounts().size(),1);
        for(integer i=0;i<3;i++){
            System.assert(acpagination.hasPrevious);
            acpagination.previous();
        }
        System.debug('get'+acpagination.getAccounts());
        System.assertEquals(acpagination.getAccounts().size(),3);
        acpagination.last();
        System.assertEquals(acpagination.getAccounts().size(),1);
        acpagination.first();
        System.assertEquals(acpagination.getAccounts().size(),3);
    }
}