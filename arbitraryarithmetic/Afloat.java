package arbitraryarithmetic;
import java.util.List;
public class Afloat{
    private String num;
    private String intpart;
    private String decimalpart;
    private String no_decimal_num;
    public Afloat(String inp){
        num = inp;
        char find = '.';
        if(num.indexOf(find)==-1){
            intpart = num;
            decimalpart = "0";
            num = num +".0";
        }
        else{
            String[] parts = num.split("\\.");
            intpart = parts[0];
            decimalpart = parts[1];
        }
        no_decimal_num  = intpart + decimalpart;
    }
    public List<String> get(){
        return List.of(num,intpart,decimalpart,no_decimal_num);
    }
    public Afloat copy(){
        Afloat newo = new Afloat(num);
        return newo;
    }
    public String remove_zeroes(String s){
        String[] parts = s.split("\\.");
        String ans = parts[0];
        if(ans.charAt(0)!='-')
            ans = ans.replaceFirst("^0+(?!$)", "");
        else{
            StringBuilder result = new StringBuilder(ans);
            result.deleteCharAt(0);
            String okay = result.toString();
            okay = okay.replaceFirst("^0+(?!$)", "");
            ans = '-'+okay;
        }
        StringBuilder decimal = new StringBuilder(parts[1]);
        int k = decimal.length() - 1;
        while (k >= 0) {
            if (decimal.charAt(k) == '0') {
                decimal.deleteCharAt(k);
                k--;
            } else {
                break;
            }
        }
        if (decimal.length() == 0) decimal = new StringBuilder("0");
        return ans+'.'+decimal.toString();
    }
    public String add(Afloat a){
        List<String> input = a.get();
        int size2 = input.get(2).length();
        StringBuilder othernum = new StringBuilder(input.get(0));
        StringBuilder thisnum = new StringBuilder(this.num);
        int size1 = decimalpart.length();
        while(size2<size1){
            othernum.append('0');
            size2++;
        }
        while(size1<size2){
            thisnum.append('0');
            size1++;
        }
        a = new Afloat(othernum.toString());
        input = a.get();
        String temp = thisnum.toString();
        String[] parts = temp.split("\\.");
        temp = parts[0]+parts[1];
        StringBuilder temp1 = new StringBuilder(input.get(3));
        temp1 = new Ainteger(temp).add(new Ainteger(temp1.toString()));
        temp1.insert(temp1.length()-size2,".");
        return temp1.toString();
    }
    public String addition(Afloat a){
        String ans = this.add(a);
        return remove_zeroes(ans);
    }
    public String sub(Afloat a){
        List<String> input = a.get();
        int size2 = input.get(2).length();
        StringBuilder othernum = new StringBuilder(input.get(0));
        StringBuilder thisnum = new StringBuilder(this.num);
        int size1 = decimalpart.length();
        while(size2<size1){
            othernum.append('0');
            size2++;
        }
        while(size1<size2){
            thisnum.append('0');
            size1++;
        }
        a = new Afloat(othernum.toString());
        input = a.get();
        String temp = thisnum.toString();
        String[] parts = temp.split("\\.");
        temp = parts[0]+parts[1];
        StringBuilder temp1 = new StringBuilder(input.get(3));
        temp1 = new Ainteger(temp).sub(new Ainteger(temp1.toString()));
        temp1.insert(temp1.length()-size2,".");
        return temp1.toString();
    }
    public String subtract(Afloat a){
        String ans = this.sub(a);
        return remove_zeroes(ans);
    }
    public String mult(Afloat a){
        List<String> input = a.get();
        int total_decimal = input.get(2).length()+decimalpart.length();
        StringBuilder temp = new StringBuilder(input.get(3));
        temp = new StringBuilder(new Ainteger(no_decimal_num).mult(new Ainteger(temp.toString())));
        temp.insert(temp.length()-total_decimal,".");
        return temp.toString();
    }
    public String multiply(Afloat a){
        String ans = this.mult(a);
        return remove_zeroes(ans);
    }
    public String division(Afloat a){
        int check = 0;
        Afloat curr = new Afloat(remove_zeroes(num));
        StringBuilder thisnum = new StringBuilder(curr.get().get(0));
        a = new Afloat(remove_zeroes(a.get().get(0)));
        if(a.get().get(0).equals("0.0")) throw new ArithmeticException("Division by zero");
        StringBuilder othernum = new StringBuilder(a.get().get(0));
        if((thisnum.charAt(0)=='-'&&othernum.charAt(0)!='-')||(thisnum.charAt(0)!='-'&&othernum.charAt(0)=='-')){
            check =1;
            if(thisnum.charAt(0)=='-'){
                thisnum.deleteCharAt(0);
                curr = new Afloat(thisnum.toString());
            }
            else{
                othernum.deleteCharAt(0);
                a = new Afloat(othernum.toString());
            }
        }
        else if(num.charAt(0)=='-'&&a.get().get(0).charAt(0)=='-'){
            thisnum.deleteCharAt(0);
            curr = new Afloat(thisnum.toString());
            othernum.deleteCharAt(0);
            a = new Afloat(othernum.toString());
        }
        int size1 = curr.get().get(2).length();
        int size2 = a.get().get(2).length();
        StringBuilder result = new StringBuilder("");
        StringBuilder num1 = new StringBuilder(curr.get().get(3));
        StringBuilder num2 = new StringBuilder(a.get().get(3));
        while(size1<size2){
            num1.append('0');
            size1++;}
        while(size2<size1){
            num2.append('0');
            size2++;}
        Ainteger num2_obj = new Ainteger(num2.toString());
        Ainteger num1_obj = new Ainteger(num1.toString());
        List<String> parts = num1_obj.division(num2_obj);
        result.append(parts.get(0));
        result.append(".");
        int decimal_couter = 0;
        StringBuilder remainder = new StringBuilder(parts.get(1));
        remainder = new StringBuilder(remainder.toString().replaceFirst("^0+", ""));
        if(remainder.isEmpty()) remainder = new StringBuilder("0");
        Ainteger rem_obj = new Ainteger(remainder.toString());
        if(remainder.toString().equals("0")){
            result.append('0');
            if(check==1) return "-"+result.toString();
            return result.toString();
        }
        while(decimal_couter<=30){
            int count = 0;
            while(remainder.length()<num2.length()){
                remainder.append('0');
                count++;
            }
            if(remainder.compareTo(num2)<0){
                remainder.append('0');
                count++;
            }
            for(int i =1;i<count;i++){
                result.append('0');
                decimal_couter++;
            }
            remainder = new StringBuilder(remainder.toString().replaceFirst("^0+", ""));
            if(remainder.isEmpty()) remainder = new StringBuilder("0");
            rem_obj.update(remainder.toString());
            parts = rem_obj.division(num2_obj);
            result.append(parts.get(0));
            decimal_couter+=parts.get(0).length();
            remainder = new StringBuilder(parts.get(1));
            if (remainder.chars().allMatch(c -> c == '0')) {
                break;
            }
        }
        if(check==1) return "-"+result.toString();
        return result.toString();
    }
    public String divide(Afloat a){
        String ans = this.division(a);
        return remove_zeroes(ans);
    }
}

