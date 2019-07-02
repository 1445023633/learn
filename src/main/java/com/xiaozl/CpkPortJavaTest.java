package src.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class CpkPortJavaTest {
	
	static List<int[]> list = new ArrayList();
	
	public static void init() {
		list.add(a2019063);
		list.add(a2019064);
		list.add(a2019065);
		list.add(a2019066);
		list.add(a2019067);
		list.add(a2019068);
		list.add(a2019069);
		list.add(a2019070);
		list.add(a2019071);
		list.add(a2019072);
		list.add(a2019073);
		list.add(a2019074);
		list.add(a2019075);
	}
	
	
	public static int[] a2019075=  new int[] {5,8,20,22,31,33};
	public static int[] a2019074=  new int[] {12,21,27,29,31,33};
	public static int[] a2019073=  new int[] {1,2,6,12,16,18};
	public static int[] a2019072 = new int[] {2,9,13,15,22,30};
	public static int[] a2019071 = new int[] {1,8,19,24,29,30};
	public static int[] a2019070 = new int[] {6,15,18,19,24,32};
	public static int[] a2019069 = new int[] {6,11,16,19,21,25};
	public static int[] a2019068 = new int[] {3,14,20, 24, 26, 33};
	public static int[] a2019067 = new int[] {4 ,6 ,8, 11 ,30 ,33};
	public static int[] a2019066 = new int[] {1 ,14 ,17, 20 ,22 ,32 };
	public static int[] a2019065 = new int[] {6 ,9 ,11 ,15 ,20, 26 };
	public static int[] a2019064 = new int[] {12 ,20, 24, 25, 30 ,33};
	public static int[] a2019063 = new int[] {1,14,19,22,29,31};

	
	//统计全部没有匹配到的值
	public static int count(int sum,int gotTime) {
		int got = 0;
		int notGot = 0;
		
		for(int j= 0 ;j<list.size()-1;j++) {
			int[] is = list.get(j); 
			int[] up = list.get(j+1); 
			
			for(int i = 0;i<is.length;i++) {
				int he = is[i]+sum+i;
				int jian = is[i]-(sum+i);
				for(int k = 0;k<up.length;k++) {
					if(he == up[k] || jian == up[k] ) {
						got++;
					}else {
						notGot++;
					}
				}
			}
		}
//		int bijiaocishu = (list.size()-1)*36;
//		System.out.println("比较次数"+bijiaocishu);
		if(got<=gotTime) {
			return sum;
		}
		return 0;
	}
	
	//算出来的 不会要的值
	public static List<Integer>  getNotNeedNum(int sum) {
		List<Integer> result = new ArrayList();
		int[] is = list.get(list.size()-1); 
		for(int i = 0;i<is.length;i++) {
			int he = is[i]+sum+i;
			int jian = is[i]-(sum+i);
			for(int k = 1;k<=33;k++) {
				Integer object = k; 
				if(he == object || jian == object) {
					result.add(object);
				}
			}
		}
		return result;
	}
	
	//算出来需要的值
	public static List<Integer>  getNeedNum(int gotTime) {
		List<Integer> result = new ArrayList();
		for(int k = 1;k<=33;k++) {
			result.add(k);
		}
		//统计得到需要的sum值
		for(int k = 1;k<=33;k++) {
			int sum = count(k,gotTime);	 
			if(sum >0 ) {
//				System.out.print("sum"+sum+",");
				//根据sum值筛选出相应的结果
				List<Integer> num = new ArrayList<>();
				num=getNotNeedNum(sum); 
				for(Integer object: num ) {
					if(result.indexOf(object)>-1) {
						result.remove(result.indexOf(object));
					}
				}
			}
		}
//		if(result.size()<33) {
//			System.out.println();
//		}
		return result;
	}
	
	
	public static void main(String[] args) {
		CpkPortJavaTest.init();
//		List result = new ArrayList();
		// 匹配为0 则筛选度最高，一个都没匹配上。
		for(int i =0;i<=list.size()*6;i++) {
			List<Integer> num = getNeedNum(i);
//			System.out.print("num d size" + num.size());
			if(num.size()<=25) {
				for(Object object: num ) {
					System.out.print(object+",");
				}
				System.out.println();
			}
//				result.addAll(num);
		}
		
//		String str = ",5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,31,";
//		for(int i = list.size()-1 ;i>=0;i--){
//			int[] js = list.get(i);
//			for(int j=0;j<js.length;j++) {
//				if(str.indexOf(","+js[j]+",")>-1) {
//					str=str.replace(","+js[j]+",", ",");
//					System.out.println(str);
//				}
//			}
//		}
	}
	
}
