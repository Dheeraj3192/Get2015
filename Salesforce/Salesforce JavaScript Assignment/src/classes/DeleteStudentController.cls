/**
* Author: Dheeraj Kumar	
* Created Date: 30/01/2016
* Name: DeleteStudentController
* Desc: Delete students of selected record
*/
public class DeleteStudentController {
    public  List<Student__c> selectedsts{get;set;}
    private ApexPages.StandardSetController standardController;
    
     /**
    *    @param  ApexPages.StandardSetController 	
    *    @return   
    *    @desc  Constructor
    */
    public DeleteStudentController(ApexPages.StandardSetController standardController)
    {
        this.standardController = standardController;
    }

    /**
    *    @param  void	
    *    @return   PageReference
    *    @desc  getting seleted item of student 
    */
    public PageReference getSelectedStudents()
    {       
        // Get the selected records (optional, you can use getSelected to obtain ID's and do your own SOQL)
        selectedsts = (List<Student__c>) standardController.getSelected();
        if(selectedsts == null|| selectedsts.size() == 0) 
           return standardController.cancel();               
        selectedsts =[select name,id,class__r.Name from student__c where id In : selectedsts];
        return null;         
    }
    /**
    *    @param  void	
    *    @return   PageReference
    *    @desc  delete student list
    */
    public PageReference deleteStudent() {
        delete selectedsts ;
        System.debug('executed');
        return standardController.cancel();
    }

   
}