import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int minIndex = 0, maxIndex = people.length-1;
        for(; maxIndex >= minIndex; maxIndex--) {
            if(minIndex == maxIndex) {
                answer++;
                break;
            }
            
            if(people[minIndex] + people[maxIndex] <= limit) {
                minIndex++;
            }
            answer++;
        }
        
        return answer;
    }
}