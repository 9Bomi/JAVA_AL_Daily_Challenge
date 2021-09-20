class Solution {
    public String solution(String new_id) {
        
       //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuilder answer = new StringBuilder(new_id);
        for(int i=answer.length()-1;i>=0;i--){
            char c = answer.charAt(i);
            if(!Character.isLetter(c) && !Character.isDigit(c) && c!='-' && c !='_' && c!='.')
                answer.delete(i,i+1);
        }
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i=answer.length()-2;i>=0;i--)
            if(answer.charAt(i)=='.' && answer.charAt(i+1)=='.')
                answer.delete(i+1,i+2);
        
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(answer.charAt(answer.length()-1) == '.')
            answer.delete(answer.length()-1,answer.length());
        if(answer.length()>0 && answer.charAt(0) == '.')
            answer.delete(0,1);
        
        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer.length() == 0)
            answer = new StringBuilder("a");
        
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(answer.length()>=16)
            answer = new StringBuilder(answer.toString().substring(0,15));
        
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.charAt(answer.length()-1) == '.')
        	answer.delete(answer.length()-1,answer.length());
        
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(answer.length()<3){
            answer.append(answer.charAt(answer.length()-1));
        }
        
        return answer.toString();
    }
}