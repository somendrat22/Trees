import java.util.*;
public class Queen{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for(int i = 1; i<=n; i++){
            tree.put(i, new ArrayList<>());
        }
        int [] resp = new int[n+1];
        for(int i = 1; i<=n; i++){
            int pi = scn.nextInt();
            int ci = scn.nextInt();
            if(pi != -1){
                tree.get(pi).add(i);
            }
            resp[i] = ci;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int node : tree.keySet()){
            if(resp[node] == 1){
                ArrayList<Integer> children = tree.get(node);
                boolean flag = false;
                for(int child : children){
                    if(resp[child] != 1){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    ans.add(node);
                }
            }
        }
        if(ans.size() == 0){
            System.out.println(-1);
            return;
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}