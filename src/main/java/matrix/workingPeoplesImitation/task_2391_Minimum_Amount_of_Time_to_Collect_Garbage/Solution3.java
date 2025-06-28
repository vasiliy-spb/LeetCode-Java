package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

// from leetcode code sample (1)
public class Solution3 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalGarbage = 0;
        int travelTime = 0;

        for(int i = 0; i < travel.length; i++){
            travelTime += travel[i];
        }

        for(String s: garbage){
            totalGarbage += s.length();
        }

        //totalGarbage += garbage[garbage.length - 1].length();
        travelTime *= 3;

        for(int i = garbage.length - 1; i > 0; i--){
            if(garbage[i].indexOf('M') != -1) break;
            else travelTime -= travel[i-1];
        }

        for(int i = garbage.length - 1; i > 0; i--){
            if(garbage[i].indexOf('P') != -1) break;
            else travelTime -= travel[i-1];
        }

        for(int i = garbage.length - 1; i > 0; i--){
            if(garbage[i].indexOf('G') != -1) break;
            else travelTime -= travel[i-1];
        }

        return totalGarbage + travelTime;
    }
}




// class Solution {
//     public int garbageCollection(String[] garbage, int[] travel) {
//         int totalMetal = 0;
//         int totalPaper = 0;
//         int totalGlass = 0;

//         // HashMap<Character, Integer>() = new HashMap<Character, Integer>();
//         int lastMetal = 0;
//         int lastPaper = 0;
//         int lastGlass = 0;


//         int index = 0;
//         for(String s: garbage){
//             for(char c: s.toCharArray()){
//                 if(c == 'P'){
//                     totalPaper++;
//                     lastPaper = index;
//                 }else if(c == 'M'){
//                     totalMetal++;
//                     lastMetal = index;
//                 }else{
//                     totalGlass++;
//                     lastGlass = index;
//                 }
//             }
//             index++;
//         }
//         int totalGarbage = totalMetal + totalGlass + totalPaper;
//         int travelTime = 0;

//         int tempSum = 0;
//         for(int i = 0; i < travel.length; i++){
//             tempSum += travel[i];
//             if(lastGlass == i+1) travelTime += tempSum;
//             if(lastPaper == i+1) travelTime += tempSum;
//             if(lastMetal == i+1) travelTime += tempSum;
//         }

//         return totalGarbage + travelTime;
//     }
// }



// class Solution {
//     public int garbageCollection(String[] garbage, int[] travel) {
//         int minutes =0;
//         boolean paper = false;
//         for(int i=0; i< garbage.length; i++){
//             if(garbage[i].contains("P")){
//                 paper = true;
//                 break;
//             }
//         }
//         boolean metal = false;
//         for(int i=0; i< garbage.length; i++){
//             if(garbage[i].contains("M")){
//                 metal = true;
//                 break;
//             }
//         }
//         boolean glass = false;
//         for(int i=0; i< garbage.length; i++){
//             if(garbage[i].contains("G")){
//                 glass = true;
//                 break;
//             }
//         }
//         //The paper garbage truck
//         if(paper){
//             for(int i =0; i< garbage.length; i++){
//                 // loop here for each char
//                 boolean flag = false;
//                 for(int y=0; y<garbage[i].length(); y++ ){
//                 if(garbage[i].charAt(y) == 'P'){
//                     minutes++;
//                 }
//                 }
//                 for(int  x = i+1; x< garbage.length; x++){

//                     if(garbage[x].contains("P")){
//                         break;
//                     }
//                     if(x == garbage.length-1){
//                         flag =true;
//                         break;
//                     }
//                 }
//                 if(i>0){
//                         minutes += travel[i-1];
//                     }
//                     if(flag){
//                     break;
//                 }
//             }
//             // System.out.println(minutes);
//         }


//         //The glass garbage truck
//         if(glass){
//             for(int i =0; i< garbage.length; i++){
//                 // loop here for each char
//                 boolean flag = false;
//                 for(int y=0; y<garbage[i].length(); y++ ){

//                 if(garbage[i].charAt(y) =='G'){
//                     minutes++;
//                 }
//                 }
//                 for(int  x = i+1; x< garbage.length; x++){

//                     if(garbage[x].contains("G")){
//                         break;
//                     }
//                     if(x == garbage.length-1){
//                         flag =true;
//                         break;
//                     }
//                 }
//                 if(i>0){
//                         minutes += travel[i-1];
//                     }
//                 if(flag){
//                     break;
//                 }
//             }
//             // System.out.println(minutes);
//         }

//         //The metal garbage truck
//         if(metal){
//             for(int i =0; i< garbage.length; i++){
//                 // loop here for each char
//                 boolean flag = false;
//                 for(int y=0; y<garbage[i].length(); y++ ){
//                 if(garbage[i].charAt(y) =='M'){
//                     minutes++;
//                 }
//                 }
//                 for(int  x = i+1; x< garbage.length; x++){

//                     if(garbage[x].contains("M")){
//                         break;
//                     }
//                     if(x == garbage.length-1){
//                         flag =true;
//                         break;
//                     }
//                 }
//                 if(i>0){
//                         minutes += travel[i-1];
//                     }
//                 if(flag){
//                     break;
//                 }
//             }
//             // System.out.println(minutes);
//         }


//         return minutes;
//     }
// }
