public class Ainteger {
    private String num;
    public Ainteger(){
        num="0";
    }
    public Ainteger(String s){
        num = s;
    }
    public String get(){
        return num;
    }
    public void update(String s){
        num=s;
    }
    public Ainteger copy(){
        Ainteger newo = new Ainteger(num);
        return newo;
    }
    private int compareTo(Ainteger a){
        StringBuilder thisnum = new StringBuilder(remove_zeroes(this.num));
        StringBuilder othernum = new StringBuilder(remove_zeroes(a.get()));
        int length1 = thisnum.length();
        int length2 = othernum.length();
        if(length1>length2){
            return 1;
        }
        if(length1==length2) return thisnum.compareTo(othernum);
        else{
            return -1;
        }
    }
    private String remove_zeroes(String s){
        String ans = s;
        if(ans.charAt(0)!='-')
            ans = ans.replaceFirst("^0+(?!$)", "");
        else{
            StringBuilder result = new StringBuilder(ans);
            result.deleteCharAt(0);
            String okay = result.toString();
            okay = okay.replaceFirst("^0+(?!$)", "");
            ans = '-'+okay;
        }
        return ans;
    }
    public StringBuilder add(Ainteger a){
        StringBuilder thisnum = new StringBuilder(num);
        StringBuilder othernum = new StringBuilder(a.get());
        String num1=thisnum.toString();
        String num2=othernum.toString();
        while(num1.length()<num2.length()){
            num1="0"+num1;
        }
        while(num2.length()<num1.length()){
            num2="0"+num2;
        }
        int size = num2.length();
        int current_sum=0;
        int carry=0;
        StringBuilder result = new StringBuilder(num1);
        for(int i =size-1;i>=0;i--){
            current_sum =result.charAt(i)+num2.charAt(i)-2*'0'+carry;
            carry = current_sum/10;
            char e  = (char)(current_sum%10+48);
            result.setCharAt(i,e);
            if(i==0 && carry>0) result.insert(0,(char)(carry+48));
        }
        return result;
    }
    public String addition(Ainteger a){
        String ans = this.add(a).toString();
        return remove_zeroes(ans);
    }
}