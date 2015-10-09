public class GeneralizedList<T> {

	private boolean tag;  //used for either contain it integer(if false) or itself list(if true)
	private T data ;  //contain data either integer or itself list
	private GeneralizedList<?> nextDataLink; //point to the next node of list
	private static char[] charInput;    //input array 
	private static int  charIndex;		//input array index

	public boolean isTag() {
		return tag;
	}
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public GeneralizedList<?> getNextDataLink() {
		return nextDataLink;
	}
	public void setNextDataLink(GeneralizedList<?> nextDataLink) {
		this.nextDataLink = nextDataLink;
	}
	public static char[] getInputString() {
		return charInput;
	}
	public static void setInputString(char[] charInput) {
		GeneralizedList.charInput = charInput;
	}

	public GeneralizedList() {
	}

	/*create node of list according to boolean value*/
	private static GeneralizedList<?> createListNode(boolean isList){
		if(isList)
			return new GeneralizedList<GeneralizedList<?>>();
		return new GeneralizedList<Integer>();
	}
	/*Parameterized constructor for creating list according to given string */
	@SuppressWarnings("unchecked")
	public GeneralizedList(String inputString) {
		charIndex=0;
		if(inputString==null||inputString.length()==0) {
			System.out.println("Input is not correct");
			return ;
		}
		inputString = inputString.substring(1, inputString.length()-1);
		charInput= inputString.toCharArray();
		GeneralizedList<?> start=null;

		start =createList(start);
		this.data= (T) start.getData();
		this.tag=start.tag;
		this.nextDataLink=start.nextDataLink;

	}


	@SuppressWarnings("unchecked")
	private static GeneralizedList<?> createList(GeneralizedList<?> start) {
		boolean isList = false;
		String digitString="";
		if(charIndex >=charInput.length)
			return start;
		if(charInput[ charIndex]==')') {
			charIndex++;
			return start;
		}
		if(charInput[ charIndex ] == '(') {
			isList = true;
			charIndex++;
		}
		if(isList==false) {
			digitString=hasDigit(); 
		}
		if(!digitString.equals("")||isList==true) {
			start = createListNode(isList); //create node of list
			if(!isList)
				((GeneralizedList<Integer>)start).setData(Integer.parseInt(digitString));
			else {	
				start.setTag(isList);
				((GeneralizedList<GeneralizedList<?>>)start).setData(createList((GeneralizedList<?>) start.getData()));
			}
			start.setNextDataLink(createList(start.getNextDataLink()));
			return start;
		}
		if(charInput[charIndex]== ',') {
			charIndex++;
			start =createList(start);
		}
		return start;
	}

	public static String hasDigit() {
		char ch=0;
		if(charIndex<charInput.length) {
			ch=charInput[charIndex];
			if(ch >= 48 && ch <= 57) {
				charIndex++;
				return ch+hasDigit();
			}
			return "";
		}
		return "";
	}

	public static void  traverse (GeneralizedList<?> startNode) {
		if(startNode!=null) {
			if(!startNode.isTag())
				System.out.print(startNode.getData() +" ");
			else {
				System.out.print("(");
				traverse((GeneralizedList<?>)startNode.getData());
				System.out.print(")");
			}
			traverse(startNode.getNextDataLink());
		}
	}
	
	public static String  toString (GeneralizedList<?> startNode) {
		String expression="";
		if(startNode!=null) {
			if(!startNode.isTag())
				expression += startNode.getData();
			else {
				System.out.print("(");
				expression="("+toString((GeneralizedList<?>)startNode.getData())+")";
				System.out.print(")");
			}
			return expression +","+ toString(startNode.getNextDataLink());
		}
		return "";
	}

	public static Integer sum (GeneralizedList<?> startNode) {
		Integer data=0;
		if(startNode!=null){
			if(!startNode.isTag())
				data=(Integer)startNode.getData();
			else 
				data=sum((GeneralizedList<?>)startNode.getData());

			return data+sum(startNode.getNextDataLink());
		}
		return 0;
	}

	public static Integer max (GeneralizedList<?> startNode) {
		Integer data=0;
		if(startNode!=null){
			if(!startNode.isTag())
				data=(Integer)startNode.getData();
			else 
				data = max((GeneralizedList<?>)startNode.getData());
			return data>max(startNode.getNextDataLink())?data:max(startNode.getNextDataLink());
		}
		return 0;
	}

	public static boolean find (GeneralizedList<?> startNode ,Integer dataSearch) {
		Integer data=0;
		boolean isFound=false;
		if(startNode!=null){
			if(!startNode.isTag())
				data=(Integer)startNode.getData();
			else {
				isFound	=  find((GeneralizedList<?>)startNode.getData(),dataSearch);
				if( isFound )
					return isFound;
			}
			isFound=(data.equals(dataSearch)) ? true : find(startNode.getNextDataLink(),dataSearch);
			if(isFound)
				return isFound;
		}
		return false;
	}
}
