package vansh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sourceforge.plantuml.SourceStringReader;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class main {
		static String default1 = "";
		static String location = "/Users/Vansh/Desktop/PersonalProject/test 3";
		static String outdetail = "outputimage.png";
	    public static void main(String[] args) throws Exception {
	        
	    	// creating input stream

	    	if(args.length == 2) {
	    			location =args[0];
	    			outdetail = args[1];
	    	} else {
	    		System.out.println("You Entered wrong Format. Please correct it..");
	    		System.out.println("Correct path is");
	    		System.out.println("jar file | <path of java files> | <path for output image with extension>");
	    	}

	    	// An abstract representation of file and directory pathnames. 

	    	File location1 = new File(location);
	    	for(File FileDetails: location1.listFiles()) 

	    		//Array of file File objects will be returned for all files in the location specified. 

	    		// Now checking that whether its directory or not 
	    		// Also checking 


	    	if(!FileDetails.isDirectory() && isJava(FileDetails)){
	    		//FileInputStream will now obtain input bytes from a file in a location mentioned.

		        FileInputStream fileinput = new FileInputStream(FileDetails);
		        CompilationUnit cu;
		        try {
		        	//Parse the file

		            cu = JavaParser.parse(fileinput);
		        } finally {
		            fileinput.close();
		        }
		        VisitMethod visitmethod = new VisitMethod();
		        visitmethod.visit(cu, null);
		        visitmethod.getUml();
	    	}
	    	for(PairDeclare s: modTypes)
	    		default1 += s.toString(allClass);
	    	OutputStream png = new FileOutputStream(outdetail);
	    	//System.out.println(UML);
	    	SourceStringReader reader = new SourceStringReader("@startuml\n" + default1 + "@enduml\n");
	    	String desc = reader.generateImage(png);
	    }


	    //   	 SourceFileReader(file);
			// List<methods> list = .getGeneratedImages();
			// File f1 = list.get(0).outdetails();


		static Set<PairDeclare> modTypes = new HashSet<PairDeclare>();
		static List<String> allClass = new ArrayList<String>();
//		String methodName = method.getName();
//        String methodClass = "";

	    private static class VisitMethod extends VoidVisitorAdapter<Object> {
			@Override
			public void visit(ConstructorDeclaration arg0, Object arg1) {
				// TODO Auto-generated method stub
				if((arg0.getModifiers() & Modifier.PUBLIC) > 0)

					// Check the modifier type	

					allVariables.add("+" + arg0.getDeclarationAsString(false, false));
				super.visit(arg0, arg1);
			}

			
			
			//variable tempVal
			
			
			
			
			private String tempVal(String str) {
				int a = str.indexOf('<');
				int b = str.indexOf('>');
				
				if(a >= 0 && a < b)  {
					return str.substring(a+1, b);
				}
				return "";
			}

			

			// Now getting an ordered collections of all methods in the list
			// Also getting an ordered collection of all fields in the list
			// Generating an empty arrayList with default size of 10

			List<String> allMethods = new ArrayList<String>();
    		List<String> allVariables = new ArrayList<String>();
//    		private HashMap<String, ArrayList>
    		
    		//Everything to check inheritance, for class, for interface
    		
    		
    		String forInheritance = "";
    		String classN;
    		// Checking whether the class is abstract or not also methods.
    		private boolean checkInterface = false;
    			
			private boolean checkAbstract;
			
			@Override
			public void visit(MethodDeclaration arg0, Object arg1) {
				// TODO Auto-generated method stub
				if((arg0.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
						if(arg0.getName().substring(0, 3) == "get" ||
								/*arg1.name()*/arg0.getName().substring(0, 3) == "set")
							open.add(new PairDeclare(arg0.getName()/*arg1.name()*/ + "( "+planeL12(arg0.getParameters()) +") :" + arg0.getType().toString(),
									Character.toLowerCase(arg0.getName().substring(3).charAt(0)) + (arg0.getName().substring(3).length() > 1 ? arg0.getName().substring(3).substring(1) : "")));
						else

							//publicAcces.add(new PairDeclare("+planeLan(arg0.getParameters()) +") :" Character.toLowerCase(arg0.getName().substring(3).charAt(0)) + (arg0.getName().substring(3).length() > 1 ? arg0.getName().substring(3).substring(1) :+ arg0.getType().toString(),  "")));
							//uses(arg1.getParameters());
	
							open.add(new PairDeclare(arg0.getName() + "( "+planeL12(arg0.getParameters()) +") :" + arg0.getType().toString(), Character.toLowerCase(arg0.getName().substring(3).charAt(0)) + (arg0.getName().substring(3).length() > 1 ? arg0.getName().substring(3).substring(1) : "")));
						uses(arg0.getParameters());
				}
				super.visit(arg0, arg1);
			}

			
			
			@Override
			public void visit(FieldDeclaration arg0, Object arg1) {
				// TODO Auto-generated method stub
				char modType = ' ';
				if((arg0.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
					// Giving symbol for modifier type
					modType = '+';
					for(Iterator<?>  it = arg0.getVariables().iterator(); it.hasNext(); ) {
						if(tempVal(arg0.getType().toString()) != "")
							modTypes.add(new PairDeclare(classN, tempVal(arg0.getType().toString()), true));
						else {
							allVariables.add(modType + " " + it.next() + ":" + arg0.getType());
							modTypes.add(new PairDeclare(classN, arg0.getType().toString()));
						}
					}
				}
				else if((arg0.getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE) {
					
					//using getVariable from javaparser
					for(Iterator<?>  it = arg0.getVariables().iterator(); it.hasNext(); ) {
						//Using inbuilt VariableDeclarator
						VariableDeclarator v = (VariableDeclarator) it.next();
						if(tempVal(arg0.getType().toString()) != "")
							modTypes.add(new PairDeclare(classN, tempVal(arg0.getType().toString()), true));
						else {
							notOpen.add(new VariableDeclare(v.toString(),
									arg0.getType().toString(), Modifier.PRIVATE));
							modTypes.add(new PairDeclare(classN, arg0.getType().toString()));
						}
					}
				}
				if(modType != ' ')
				super.visit(arg0, arg1);
			}

			

				//			public void writeDependancy(String key, String string) {
				//				if(classList.contains(string) || interfaceList.contains(string)){
				//				//	System.out.println(key+ " depends on "+ string);
				//					dependancySet.add(key+" "+string);
				//				}
				//		}
			
			//Using github Javaparser Methods 
			//Visit method | MethodDeclaration ClassOrInterface
			@Override

	        public void visit(ClassOrInterfaceDeclaration arg0, Object arg1) {
				// TODO Auto-generated method stub
				
	        	//classN = arg0.getName();
	        	//checkInterface = arg0.toString();
	        	//isAbstract = arg0.toString();
	        	classN = arg0.getName(); //Class name
	        	checkInterface = arg0.toString().indexOf("interface")!=-1; //Inteface
	        	checkAbstract = arg0.toString().indexOf("abstract")!=-1; //Abstract
	        	allClass.add(classN);
	        	for(Iterator<?> it = arg0.getImplements().iterator(); it.hasNext();)
	        		forInheritance += classN + " ..|> " + it.next() + "\n";
	        	for(Iterator<?> it = arg0.getExtends().iterator(); it.hasNext();)
	        		forInheritance += classN + " ---|> " +it.next() + "\n";
				super.visit(arg0, arg1);
			}
	    	
    		

			private boolean search(String name) {
				boolean searchresult = false;
	    		for(int i = 0; i < open.size(); i++ ) {
	    			PairDeclare p = open.get(i);
	    			if(p.action.compareTo(name) == 0) {
	    				open.remove(i);
		    				i--;
	    				searchresult = true;
	    			}
	    		}
				return searchresult;
			}

			public void getUml() {
	    		for(Iterator<VariableDeclare> it = notOpen.iterator(); it.hasNext(); ) {
	    			VariableDeclare v = (VariableDeclare) it.next();
	    			if(search(v.name)) {
	    				//By default it will show green circle
	    				// Adding skinparam classAttributeIconSize 0 we can show the exact sign
	    				allVariables.add("+ " + v.name + ":" + v.type + "\n");
	    			} else {
	    				allVariables.add(((v.modifier & Modifier.PUBLIC) > 0? "+" : "- ") + v.name + ":" + v.type + "\n");
	    			}
	    		}
	    		for(Iterator<PairDeclare> it = open.iterator(); it.hasNext(); )
	    			allVariables.add("+ " + it.next().user);
	    		default1 += (checkInterface? "interface " : (checkAbstract ? "abstract ":"class  ")) + classN + " {\n";
				for(Iterator<String> it = allVariables.iterator(); it.hasNext(); )
					default1 += "\t" + it.next() + "\n";
				default1 += "}\n";
				default1 += forInheritance +"\n";
	    	}
			
			
			private void uses(List<Parameter> list) {
	    		for(Iterator<Parameter> it = list.iterator(); it.hasNext();) {
	    			Parameter p = (Parameter) it.next();
	    			modTypes.add(new PairDeclare(classN, p.getType().toString(), 1));
	    		}
	    	}
			//checking the file
		    
			//ArrayList for both the class
			private List<PairDeclare> open = new ArrayList<PairDeclare>();
			private List<VariableDeclare> notOpen = new ArrayList<VariableDeclare>();
	    	private String planeL12(List<?> l) {
    			String res = "";
    			for(Iterator<?> it = l.iterator(); it.hasNext(); ) {
    				res += it.next();
    			}
    			return res;
    		}
			
			
			  
			
			
	    }

	  private static boolean isJava(File f) {
	  	//true if the file type in defined location is java
		  //only java files will be selected

	    	String n = f.getName();
			return n.substring(n.length() - 4).equals("java");
	    }
}
