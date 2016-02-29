@isTest
private class TestShoppingController {
    
    @isTest
    static void testCategory()  {
        ShoppingController scontroller = PurchaseOrderUtility.createOrder();
        Test.startTest();
        Integer expected = scontroller.Category.size();
        Schema.DescribeFieldResult fieldResult = product2.category__c.getDescribe();
        List<Schema.PicklistEntry> ple = fieldResult.getPicklistValues();
        Integer actual = ple.size() ;
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void testPopulateProduct()  {
        ShoppingController scontroller = PurchaseOrderUtility.createOrder();
        Test.startTest();
        scontroller.SelectedCategory ='Tablets';
        scontroller.populateProducts();
        List<Product2> expected =  scontroller.products ;
        List<Product2> actual = [select ID,ProductCode,Name,Price__c,category__c from product2 where category__c ='Tablets'];
        Test.stopTest();
        System.assertEquals(expected, actual);	
    }
    
    @isTest
    static void testAddToCart()  {
        ShoppingController scontroller = PurchaseOrderUtility.createOrder();
        Test.startTest();
        scontroller.SelectedCategory ='Mobiles';
        Product2 pr =  [Select id , Name , Price__c from Product2 where Name= 'Product 1' Limit 1] ;
        scontroller.idOfProductToAdd = pr.id;
        System.debug('idofproduct'+scontroller.idOfProductToAdd);
        scontroller.AddToCart();
        List<PurchaseOrderLineItem__c> items =  scontroller.items;
        System.assertEquals(items.size(), 1) ;
        System.debug('item of cart'+items[0]);
        System.assertEquals(items[0].Name , pr.Name);
        System.assertEquals(items[0].Quantity__c ,1);
        System.assertEquals(items[0].Price__c, pr.Price__c);
        PurchaseOrder__c porder = PurchaseOrderUtility.porder ;
        Decimal expectedTotal = [Select Grand_Total__c from PurchaseOrder__c where id =:porder.id].Grand_Total__C;
        Decimal actualTotal =items[0].Quantity__c * items[0].Price__c;
        system.assertEquals(expectedTotal , actualTotal);
        
        scontroller.AddToCart();
        items =  scontroller.items;
        System.assertEquals(items.size(), 1) ;
        System.assertEquals(items[0].Quantity__c ,2);
        porder = PurchaseOrderUtility.porder ;
        expectedTotal = [Select Grand_Total__c from PurchaseOrder__c where id =:porder.id].Grand_Total__C;
        actualTotal =items[0].Quantity__c * items[0].Price__c ;
        Test.stopTest();
        system.assertEquals(expectedTotal , actualTotal);
    }
    
    
    @isTest
    static void testRemoveFromCart() {
        ShoppingController scontroller = PurchaseOrderUtility.createOrder();
        Test.startTest();
        scontroller.SelectedCategory ='Mobiles';
        Product2 pr =  [Select id , Name , Price__c from Product2 where Name= 'Product 1' Limit 1] ;
        scontroller.idOfProductToAdd = pr.id;
        scontroller.AddToCart();
        System.debug('item  before cart'+ scontroller.items);
        scontroller.idOfProductToAdd = scontroller.items[0].id;
        scontroller.RemoveFromCart();
        System.debug('item after cart'+scontroller.items);
        Test.stopTest();
        System.assertEquals(scontroller.items.size() , 0);
        
        
        
    }
    
}