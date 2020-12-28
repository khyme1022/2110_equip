import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken()); // 집 개수
    int C = Integer.parseInt(st.nextToken()); // 공유기 개수
    int[] arr = new int[N]; // 집 좌표
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    
    int left =1;
    int right = arr[N-1] - arr[0];
    int d =0;
    int result = 0;

    while(left<= right){
      int mid= (left + right) / 2 ;
      int start = arr[0];
      int cnt = 1;

      for(int i=1;i<N;i++){
        d= arr[i] - start;
        if( mid <= d ){
          ++cnt;
          start = arr[i];
        }
      }
      if(cnt >= C){
        result = mid;
        left = mid +1;
      }else{
        right = mid -1;
      }
    }
    System.out.println(result);
  }
}