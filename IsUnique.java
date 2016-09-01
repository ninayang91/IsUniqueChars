
public class IsUnique {
	//Implement an algorithm to determine if a string has all unique characters.
	//What if you cannot use additional data structures?
	
	public static boolean isUniqueChars(String s){//no additional data structures
		int n=s.length();
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(s.charAt(j)==s.charAt(i))return false;
			}
		}
		return true;
	}//time O(n^2) space O(1)
	
	
	//if ASCII 256, If Unicode (17*65536) 1114112
	//suppose the String contains ASCII 
		public static boolean isUniqueChars2(String str){
			if(str.length()>256)return false;
			boolean[] checker=new boolean[256];
			for(int i=0;i<str.length();i++){
				char ch=str.charAt(i);
				if(checker[(int)ch]){
					return false;
				}
				checker[(int)ch]=true;
			}
			return true;
		}//time O(n) space O(1)
	
	//space will reduce by 8 with a bit vector
	public static boolean isUniqueChars3(String str){
		int checker=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			int val=ch-'a';
			if((checker & (1<< val))>0){
				return false;
			}
			checker= checker | (1<<val);
		}
		return true;
	}

}
