/**
* Author: Dheeraj Kumar	
* Created Date: 20/01/2016
* Name: AccountListController
* Desc: Get Account List from the given set of parameter billingcountry ,  billingstate ,billingcity ;  
*/

public class JSONString {
    public List<Account> accList {get;set;}
    public String jsonData{get; set;}
    
    /**
    *    @param  void 
    *    @return String  
    *    @desc Preparing data to string format 
    */
    public String preparedData() {
        accList = Database.query('select Id,Name from Account');
        return JSON.serialize(accList);
    }
    
    /**
    *    @param  void 
    *    @return   
    *    @desc Constructor
    */
    public JSONString() {
        jsonData = preparedData();
    }
}