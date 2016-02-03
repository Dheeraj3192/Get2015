trigger OpportunityTrigger on Opportunity (before insert, before update , after update) {
    
    
     // Assign values of trigger new list to helper class variable
    OpportunityTriggerHelper.newList = trigger.new;
    
    // Assign values of trigger old list to helper class variable
    OpportunityTriggerHelper.oldList = Trigger.old;
    
    // Assign values of trigger new map to helper class variable 
    OpportunityTriggerHelper.newMap = Trigger.newMap;
    
    // Assign values of trigger old map to helper class variable
    OpportunityTriggerHelper.oldMap = Trigger.oldMap;
    
    
     if(trigger.isBefore){
        if(trigger.isUpdate){
                OpportunityTriggerHelper.populateClosedDateField();
               
            	OpportunityTriggerHelper.sendMailWhenStatusChange();
        }
        if(trigger.isInsert) {
        
        OpportunityTriggerHelper.updateManagerField();

        }
       
    }
    if(trigger.isAfter) {
        if(trigger.isUpdate) {
             OpportunityTriggerHelper.deleteAssociatedProduct();
        }
    }
        
  
    

}