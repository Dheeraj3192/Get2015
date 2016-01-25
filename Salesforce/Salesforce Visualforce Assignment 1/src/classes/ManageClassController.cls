/**
* Author: Dheeraj Kumar	
* Created Date: 21/01/2016
* Name: ManageClassController
* Desc:  Class Object cotroller to edit delete records
*/
public class ManageClassController {
   
   public Class__c recordsToDisplay { get; private set; }
   public Class__c saveRecords { get; private set; }
   public String idToUpdate {get;set;}
   public boolean displayPopup {get; set;} 
   
   
   public String thisClass {get; set;}
   String query = 'SELECT Id, Name, fee__c, board__c FROM Class__c ';
    /**
    *    @param  void 
    *    @return  
    *    @desc Constructor of this class
    */
   public ManageClassController(ApexPages.StandardController controller) {
   }
   
   /**
    *    @param  void 
    *    @return  void
    *    @desc saving record
    */
   public void saveDetails() {  
       displayPopup = false;
       update saveRecords;
       
   }  
   
    /**
    *    @param  void 
    *    @return  void
    *    @desc delete record
    */
   public void deleteDetails() { 
       saveRecords = [SELECT id,Name,fee__C FROM Class__c WHERE id = :idToUpdate];
       delete saveRecords;
   }  
  
    /**
    *    @param  void 
    *    @return  void
    *    @desc showing record which have to edit
    */
   public void ShowDataToEdit() { 
       saveRecords = [SELECT id, Name, fee__c,board__C FROM Class__c WHERE id = :idToUpdate];
       displayPopup = true;    
   }   
    
    /**
    *    @param  void 
    *    @return  List<Class__c>
    *    @desc getting  list of classes 
    */
   public List<Class__C> getRecords() 
   {
       return Database.query(query);
   }  
}