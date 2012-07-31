
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;


class CreateDirectory 
{
 
public static void main(String args[]) throws IOException 
  {
	 // Create 2 tables in MS access Table 1: GBP and Table 2: EURO in location .......... "C:\\JagsTables\\GBP_EURO.accdb"; 
	
	CreateDirectory cd = new CreateDirectory();
    
	ArrayList<Object> G = new ArrayList<Object>(); // G = GBP TABLE
	 ArrayList<Object> E = new ArrayList<Object>(); // E = EURO TABLE
	 
	 String cols[] = {"P1","P2","P3","P4","Total"} ;
	 
	 for(int i = 0; i <cols.length ; i ++)
	 {
	 System.out.println("Column:    " + cols[i]);
	 getColumns(cols[i],G,E);
	 cd.compareVal(G,E);
	 }
 }
 
  static void compareVal (ArrayList<Object> G, ArrayList<Object> E){
	for(int i = 0; i < G.size() ; i ++){
		 		
		int Eval =Integer.parseInt( E.get(i).toString() );
		
		if ( G.get(i).equals(Eval*1.5))
		 		{
		 		System.out.println("GBP Table:" + G.get(i) + "............Equals........EURO........" + E.get(i) );
		 				 		
		 		}
		
		else {  System.out.println("Error"); }
	
	}}
 
 static void getColumns(String col, ArrayList<Object> G, ArrayList<Object> E ) throws IOException{
	 String path = "C:\\JagsTables\\GBP_EURO.accdb";
	 Table GBP = Database.open(new File(path)).getTable("GBP");
	 Table EURO = Database.open(new File(path)).getTable("EURO");
	 for(Map<String, Object> row : GBP) {
		  G.add(row.get(col)); }
	 for(Map<String, Object> row : EURO) {
		 E.add(row.get(col));}
 }

}
 