import java.util.Scanner;

class Painter  {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        String p = "BOAOR";

        int[][] arr = {{0,0,1}, {1,1,0}, {1,1,1}, {1,1,0}, {1,0,0}};

        int c = 0;int j=0;
        for(int i=0;i<arr[0].length;i++) {
            

                int flag = 0;
                j=0;
                while(j<n) {
                    if(arr[j][i] == 1) {
                        if(flag==0) {
                            flag=1;
                            c++;
                        }
                        j++;
                    } else {
                        flag = 0;
                        j++;
                    }
                    
                }
                
        }
        System.out.print(c);


    }
    
}
