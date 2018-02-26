/*import java.util.Scanner;

public class Solution {
	static int map[][] = new int[9][9]; // map size 9*9
	static int t; // TestCase 수
	static boolean c, w, e, c1, w1, e1;
	static int result;
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	t = sc.nextInt();
	for(int i = 1; i < t+1; i++){
		for(int  j = 0; j < 9; j++){
			for(int k = 0; k < 9; k++){
				map[j][k] = sc.nextInt();
			}
		}
//		w = wcheck();
//		c = ccheck();
//		e = echeck();
		if(wcheck() && ccheck() && echeck())
			result = 1;
		else result = 0;
		System.out.println("#"+ i+" " +result);
		}
	}
	
	static boolean wcheck(){
		for(int i = 0; i < 9;i++){ // 행 고정
			for(int j =0; j < 8; j++){ // 열 이동 
				for(int q=j+1; q<9; q++){
				if(map[i][j] == map[i][q]){
					return false;
				}
				
			}
			}
		}return true;
	
	}
	static boolean ccheck(){
		for(int i =0; i < 9; i++){
			for(int j = 0; j < 8; j ++ ){
				for(int q = j+1; q < 9; q++){
					if(map[j][i] == map[q][i]){
						return false;
					}
					
				}
			}
		}
		return true;
	}
	static boolean echeck(){
		for(int i = 0; i < 2; i++){
			for(int j =0; j <2; j++){
//				if(map[i][j] == map[i][j+1] || map[i][j] == map[i+1][j] || map [i+3][j+3] == map[i+3][j+4] || map[i+3][j+3] == map[i+4][j+3] || map[i+6][j+6] ==map[i+6][j+7] || map[i+6][j+6] == map[i+7][j+6]       ){			
					if(map[i][j] == map[i][j+1] || map[i][j] == map[i+1][j+1]|| map[i][j] == map[i+1][j] || map [i+3][j+3] == map[i+3][j+4] || map [i+3][j+3] == map[i+4][j+4]|| map[i+3][j+3] == map[i+4][j+3] || map[i+6][j+6] ==map[i+6][j+7] || map[i+6][j+6] ==map[i+7][j+7]|| map[i+6][j+6] == map[i+7][j+6]       ){			
					return  false;
				}
				
			}
		}
		return true;
	}
}
*/

import java.util.Arrays;
import java.util.Scanner;

class Sudoku {
   static int answer;
   static int[] prime = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

   public static void main(String args[]) throws Exception {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int test_case = 0; test_case < T; test_case++) {
         answer = 1;
         int[][] arr = new int[10][10];
         for (int i = 1; i < 10; i++)
            for (int j = 1; j < 10; j++)
               arr[i][j] = sc.nextInt();
         // 네모 9개 체크
         for (int i = 1; i < 10; i = i + 3) {
            for (int j = 1; j < 10; j = j + 3) {
               if (check(arr, i, j))
                  continue;
               else {
                  answer = 0;
                  break;
               }
            }
         }
         int k = 0;
         int[] tmp = new int[9];
         // 행열로 체크
         if (answer == 1) {
            for (int i = 1; i < 10; i++) {
               for (int j = 1; j < 10; j++) {
                  tmp[k] = arr[i][j];
                  k++;
               }
               Arrays.sort(tmp);
               if (Arrays.equals(tmp, prime)) {
                  k = 0;
                  continue;
               } else {
                  answer = 0;
                  break;
               }
            }
         }
         if (answer == 1) {
            for (int j = 1; j < 10; j++) {
               for (int i = 1; i < 10; i++) {
                  tmp[k] = arr[i][j];
                  k++;
               }
               Arrays.sort(tmp);
               if (Arrays.equals(tmp, prime)) {
                  k = 0;
                  continue;
               } else {
                  answer = 0;
                  break;
               }
            }
         }

         System.out.println("#" + (test_case + 1) + " " + answer);

      }
   }

   private static boolean check(int[][] arr, int i, int j) {

      int[] nine = new int[9];
      int k = 0;
      for (int a = i; a < i + 3; a++) {
         for (int b = j; b < j + 3; b++) {
            nine[k] = arr[a][b];
            k++;
         }
      }
      Arrays.sort(nine);
      return Arrays.equals(prime, nine);
   }

}

