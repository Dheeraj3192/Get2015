@isTest
private class TestTemplateController {
    @testSetup
    static void testSetup () {
        AccountUtility.createAccounts();
    }
    
    @isTest
    static void test() {
        String sObjectVar ='Account'; 
        TemplateController tcontrol = new TemplateController() ;
        tcontrol.myfieldsapex ='Id,Name';
        tcontrol.myobjectapex='Account';
        List<Sobject> expected = tcontrol.getsobjects();
        System.debug('expected size '+expected.size());
        System.assertEquals(expected.size(), 10);      // assert
        System.assertEquals(tcontrol.totalRecs, 26);  // assert
        tcontrol.sortField = 'Name' ;
        tcontrol.sortType = 'DESC' ;
        tcontrol.sortData();
        expected = tcontrol.sobjectList ;
        System.debug('expected is '+expected);
        
        List<Account> actual = [ SELECT Id,Name FROM Account ORDER BY Name DESC LIMIT 10 OFFSET 0] ;
        System.debug('actual is '+actual);
        System.assertEquals(expected, actual); // assert
        System.assertEquals(tcontrol.totalpage, 3);
        tcontrol.sortType = 'ASC' ;
        tcontrol.pageNumber = 5;
        tcontrol.redirectToPage();
        tcontrol.setPages();
        System.assertEquals(tcontrol.pagedetails,'invalid page number');
        tcontrol.pageNumber = 2 ;
        tcontrol.redirectToPage();
        expected = tcontrol.sobjectList ;  
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 10];
        System.assertEquals(expected , actual);
        tcontrol.pageNumber = 3 ;
        
        tcontrol.redirectToPage();
        tcontrol.setPages();
        expected = tcontrol.sobjectList ;  
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 20];
        System.assertEquals(expected , actual);
        
        tcontrol.FirstPage();
        System.assertEquals(tcontrol.pageNumber ,1);
        expected = tcontrol.sobjectList ;       
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 0];
        System.debug('expected'+expected);
        System.debug('actual'+actual);
        System.assertEquals(expected , actual);
        System.assert(tcontrol.getprev());
        System.assert(!tcontrol.getnxt());
        tcontrol.next();
        expected = tcontrol.sobjectList ;   
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 10];
        System.assertEquals(expected, actual);
        
        System.assert(!tcontrol.getprev());
        tcontrol.previous();
        expected = tcontrol.sobjectList ;   
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 0];
        System.assertEquals(expected, actual);
        
        
        tcontrol.LastPage();
        tcontrol.pageNumber = 3;
        tcontrol.redirectToPage();
        System.assertEquals(tcontrol.pageNumber, 3);
        
        expected = tcontrol.sobjectList ;   
        actual =[ SELECT Id,Name FROM Account ORDER BY Name ASC LIMIT 10 OFFSET 20];
        System.debug('expected'+expected);
        System.debug('actual'+actual);
        System.assertEquals(expected, actual);
        System.assert(tcontrol.getnxt());
    }
}