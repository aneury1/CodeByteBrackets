package org.example;

import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public String BracketMatcher(String str) {
        Stack<Character> chars = new Stack<>();
        Boolean ret = false;

        Stream<Character> strStream = str.chars().mapToObj(c-> (char)c);

        ///Boolean contains = strStream.allMatch(c-> (c=='['||c=='('||c=='{'||c==']'||c==')'||c=='}'));

        var k= ((strStream.filter(c-> (c=='['||c=='('||c=='{'||c==']'||c==')'||c=='}')).map(String::valueOf).collect(Collectors.joining())));

        String filteredText = k.toString();
        //// System.out.println(filteredText);
        if(filteredText.length()==0)
            return "1";

        for (var j : filteredText.toCharArray())
        {
            if(j=='('||j=='{'||j == '[')
                chars.push(j);
            else{
                if(chars.isEmpty())
                    return "0";
                else
                {
                    char pop = chars.pop();
                    if(j ==')' && pop != '(')return "0";
                    else if(j =='}' && pop != '{')return "0";
                    else if(j ==']' && pop != '[')return "0";
                    else{
                        //System.out.println("SKipped");
                        continue;
                    }
                }
            }
        }
        if(chars.isEmpty())
        {
            return "1";
        }
        else
            return "0";
    }


    public static void main(String[] args) {

        Main main =new Main();
         System.out.println("[] => "+main.BracketMatcher("[]") );
         System.out.println("(] => "+main.BracketMatcher("(]"));
         System.out.println("[({})] => "+main.BracketMatcher("[({})]"));
         System.out.println("[({[}})] => "+main.BracketMatcher("[({[}})]"));
         System.out.println("(hello (world)) => "+main.BracketMatcher("(hello (world))"));
         System.out.println("((hello (world)) => "+main.BracketMatcher("((hello (world))"));
         System.out.println("Hello world => "+main.BracketMatcher("((hello (world))"));
    }
}