package ProjectCompany.Factory;

import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;



public interface EngineerFactory {
	
	public Engineer createEngineer(String name ,EngineerType type);
	
	
}
