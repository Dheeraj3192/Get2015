/**
* Author: Dheeraj Kumar	
* Created Date: 19/01/2016
* Name: AccountListController
* Desc: Get Account List from the given set of parameter billingcountry ,  billingstate ,billingcity ;  
*/

public class AccountListController {
    public String BillingCty{get;set;} 
    public String BillingCntry{get;set;}
    public String BillingStat{get;set;}
   	
    public List<Account> results{get;set;}  // account list are store 
    
    /**
    *    @param  void 
    *    @return void 
    *    @desc get account list which have given parameter billingcountry,billingstate,billingcity are matched and limit 100 records 
    */
    public void  getAccounts() {	
         String query ='SELECT Id, Name, BillingCountry,BillingState, BillingCity FROM Account' ;
        String queryCondition ='';
        Integer count=0;
        if(!String.isBlank(BillingCntry)) {
             queryCondition+= 'BillingCountry LIKE \'%'+ BillingCntry + '%\''+' AND ';
            count++;
        }
           
        if(!String.isBlank(BillingStat)) {
            queryCondition+='BillingState LIKE \'%'+ BillingStat+'%\''+' AND ' ;
            count++;
        }
             
        if(!String.isBlank(BillingCty)) {
            queryCondition+='BillingCity LIKE \'%' +BillingCty + '%\''+ ' AND ';
            count++;
        }
        if(count > 0) {
             System.debug(queryCondition);
            queryCondition = queryCondition.trim().removeEnd('AND');
            System.debug(queryCondition);
            query += ' WHERE ' + queryCondition ;
            
        }  
       	query +=' LIMIT 100';
        System.debug(query);
       	
        results = Database.query(query) ;
        }
      

}