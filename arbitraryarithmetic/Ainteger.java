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
        if(num.charAt(0)=='-'&&a.get().charAt(0)=='-'){
            othernum.deleteCharAt(0);
            thisnum.deleteCharAt(0);
            Ainteger temp = new Ainteger(thisnum.toString());
            StringBuilder result  = new StringBuilder(temp.add(new Ainteger(othernum.toString())));
            result.insert(0, '-');
            return result;
        }
        else if(num.charAt(0)=='-'){
            thisnum = new StringBuilder(num);
            thisnum.deleteCharAt(0);
            StringBuilder result  = new StringBuilder(a.sub(new Ainteger(thisnum.toString())));
            return result;
        }
        else if(a.get().charAt(0)=='-'){
            othernum = new StringBuilder(a.get());
            othernum.deleteCharAt(0);
            StringBuilder result = new StringBuilder(this.sub(new Ainteger(othernum.toString())));
            return result;
        }
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
    public StringBuilder sub(Ainteger a){
        StringBuilder thisnum = new StringBuilder(num);
        StringBuilder othernum = new StringBuilder(a.get());
        if(num.charAt(0)=='-'&&a.get().charAt(0)=='-'){
            othernum.deleteCharAt(0);
            thisnum.deleteCharAt(0);
            a = new Ainteger(othernum.toString());
            StringBuilder result  = new StringBuilder(a.sub(new Ainteger(thisnum.toString())));
            return result;
        }
        else if(num.charAt(0)=='-'){
            thisnum.deleteCharAt(0);
            StringBuilder result  = new StringBuilder(a.add(new Ainteger(thisnum.toString())));
            result.insert(0, '-');
            return result;
        }
        else if(a.get().charAt(0)=='-'){
            othernum.deleteCharAt(0);
            StringBuilder result  = new StringBuilder(this.add(new Ainteger(othernum.toString())));
            return result;
        }
        String num1=thisnum.toString();
        String num2=othernum.toString();
        int check = 0;
        while(num2.length()<num1.length()){
            num2="0"+num2;
        }
        while(num1.length()<num2.length()){
            num1="0"+num1;
        }
        if(num1.compareTo(num2)<0){
            String temp = num1;
            num1=num2;
            num2=temp;
            check=1;
        }
        int size = num2.length();
        int current_dif=0;
        int carry=0;
        StringBuilder result = new StringBuilder(num1);
        for(int i =size-1;i>=0;i--){
            current_dif=result.charAt(i)-num2.charAt(i)-carry;
            if(current_dif<0){
                current_dif+=10;
                carry=1;
            }
            else carry=0;
            result.setCharAt(i,(char)(current_dif+48));
        }
        if(check==1) result.insert(0,'-');
        return result;
    }
    public String subtract(Ainteger a){
        String ans = this.sub(a).toString();
        return remove_zeroes(ans);
    }
    public String mult(Ainteger a){
        int check = 0;
        StringBuilder thisnum = new StringBuilder((num));
        StringBuilder othernum = new StringBuilder((a.get()));
        if((num.charAt(0)=='-'&&a.get().charAt(0)!='-')||(num.charAt(0)!='-'&&a.get().charAt(0)=='-')){
            check =1;
            if(num.charAt(0)=='-') thisnum.deleteCharAt(0);
            else othernum.deleteCharAt(0);
        }
        else if(num.charAt(0)=='-'&&a.get().charAt(0)=='-'){
            thisnum.deleteCharAt(0);
            othernum.deleteCharAt(0);
        }
        int n=thisnum.length();
        String result = "0";
        Ainteger output = new Ainteger(result);
        String num1 = thisnum.toString();
        String num2 = othernum.toString();
        int size2 = num2.length();
        if(n<size2){
            num1 = num2;
            num2 = thisnum.toString();
            size2 = num2.length();
        }
        int size1 = num1.length();
        Ainteger temp = new Ainteger();
        for(int i  = size2 -1;i>=0;i--){
            int carry =0;
            int curr = 0;
            String trailing_zeroes="0".repeat(size2-i-1);
            StringBuilder current_product = new StringBuilder(trailing_zeroes);
            for(int j = size1-1;j>=0;j--){
                curr = (num1.charAt(j) - 48)*(num2.charAt(i)-48)+carry;
                carry  = curr/10;
                curr = curr%10;
                current_product.insert(0, (char)(curr + '0'));
                if(j==0&&carry>0) current_product.insert(0, (char)(carry + '0'));
            }
            temp.update(current_product.toString());
            result = output.add(temp).toString();
            output.update(result);
        }
        if(check==1) return "-"+output.get();
        else return output.get();
    }
    public String multiply(Ainteger a){
        String ans = this.mult(a).toString();
        return remove_zeroes(ans);
    }
}