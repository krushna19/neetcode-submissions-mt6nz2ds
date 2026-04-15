class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotiont = values[i];
            if(!map.containsKey(dividend)){
                map.put(dividend,new HashMap<String,Double>());
            }
            if(!map.containsKey(divisor)){
                map.put(divisor,new HashMap<String,Double>());
            }
            map.get(dividend).put(divisor,quotiont);
            map.get(divisor).put(dividend,1/quotiont);
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> querie = queries.get(i);
            String dividend = querie.get(0);
            String divisor = querie.get(1);
            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                result[i] = -1.0;
            }else if(dividend == divisor){
                result[i] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                result[i] = dfs(dividend,divisor,1,visited,map);
            }
        }
        return result;
    }
    public double dfs(String src,String destination, double prod,HashSet<String> visited, HashMap<String,HashMap<String,Double>>map){
        double ret = -1;
        visited.add(src);
        if(map.get(src).containsKey(destination)){
           ret = map.get(src).get(destination)*prod;
        }else{
            for(String nei : map.get(src).keySet()){
                if(!visited.contains(nei)){
                    ret = dfs(nei,destination,map.get(src).get(nei)*prod,visited,map);
                    if(ret != -1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }
}