import java.util.ArrayList;

class Solution {

    private Character[][] priorities = {
        {'*', '+', '-'}, {'*', '-', '+'},
        {'+', '*', '-'}, {'+', '-', '*'},
        {'-', '*', '+'}, {'-', '+', '*'}
    };
    
    public long solution(String expression) {
        long answer = 0;
        
        ArrayList<Character> operatorList = new ArrayList<>();
        StringBuilder builder = new StringBuilder(expression);
        for(int index = 0; index < builder.length(); index++) {
            char c = builder.charAt(index);
            if(c  == '*' || c  == '+' || c == '-') {
                operatorList.add(c);
                builder.setCharAt(index, ' ');
            }
        }
        
        String[] numArray = builder.toString().split(" ");
        
        long first, second, value, result;
        Character operator;
        for(int p = 0; p < priorities.length; p++) {
            ArrayList<Long> numList = new ArrayList<>();
            for(String num : numArray) {
                numList.add(Long.parseLong(num));
            }
            ArrayList<Character> opList = new ArrayList<>(operatorList);
            
            for(int o = 0; o < priorities[p].length; o++) {
                for(int index = 0; index < opList.size(); ) {
                    operator = opList.get(index);
                    if(operator.equals(priorities[p][o])) {
                        first = numList.get(index);
                        second = numList.get(index+1);
                        value = calculate(first, second, operator);   
                        
                        numList.add(index, value);
                        numList.remove(index+2);
                        numList.remove(index+1);
                        
                        opList.remove(index);
                    } else {
                        index++;
                    }
            	}
            }

            result = Math.abs(numList.get(0));
            if(answer < result)
                answer = result;
        }
        
        return answer;
    }
    
    private long calculate(long a, long b, Character operator) {
        if(operator.equals('*')) return a * b;
        else if(operator.equals('+')) return a + b;
        else if(operator.equals('-')) return a - b;
        else return 0;
    }
}