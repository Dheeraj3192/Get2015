/**
* Author: Dheeraj Kumar	
* Created Date: 22/01/2016
* Name: PDFAttachStudent
* Desc:  Student record to pdf Attachment
*/
public class PDFAttachStudent {
    Student__c student ;
    private Id studentID ;
    private String alreadySet;
    LIST<Attachment> attatchment=new LIST<Attachment>();
    
    /**
    *    @param ApexPages.StandardController
    *    @return 
    *    @desc Constructor
    */
    public PDFAttachStudent(ApexPages.StandardController controller) {
        studentId= System.currentPageReference().getParameters().get('id');
        student = [SELECT First_Name__c,Last_Name__c,Age__c,Email__c,Married__c,Wife_Name__c,Sex__c FROM Student__c where Student__c.Id =:studentID];
    }
    
    /**
    *    @param void
    *    @return PageReference
    *    @desc save details into pdf
    */
    public PageReference savePdf() {
        PageReference pdf = Page.StudentDetailPage;
        pdf.getParameters().put('Id', student.Id);
   		Attachment attach = new Attachment();   
        //Delete of Attach if there already Attachment Exists
        attatchment = [SELECT Id,Name FROM Attachment  where ParentId=:studentID];
        if(attatchment.size() > 0) {
            delete attatchment;
        }
        Blob body;
        // the contents of the attachment from the pdf
        try {
             // returns the output of the page as a PDF
            body = pdf.getContent(); 
            System.debug(body);
            // need to pass unit test -- current bug    
        } catch (VisualforceException e) {
            system.assert(false, e.getMessage());
            body = Blob.valueOf('there is error ');
        }
        attach.Body = body;
        // add the user entered name
        attach.Name = student.First_Name__c;

        // attach the pdf to the account
        attach.ParentId= student.Id;
        insert attach;

        // send the user to the account to view results
        return new PageReference('/'+student.Id);

    }
    
}