import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        Map<Integer,Integer> dl = new TreeMap<>();
        Map<Character,Integer> bukva = new TreeMap<>();

        String data = readAllBytesJava7("Война и мир.txt");
        if(data!=null){
            String[] ss = data.split("[, ?.@\"\n()!?*1-90=+@#$%<>+{};:^\t-]+");
            for(int i = 0;i<ss.length;i++){
                if(map.containsKey(ss[i])){
                    map.put(ss[i],map.get(ss[i])+1);
                }
                else
                    map.put(ss[i],new Integer(1));
            }
            for(Map.Entry<String,Integer> sl : map.entrySet()){
                Integer cc = sl.getKey().length();

                if(dl.containsKey(cc)){
                    dl.put(cc,dl.get(cc)+1);
                }
                else
                    dl.put(cc,new Integer(1));
                String slovo = sl.getKey();
                for(int i = 0;i<slovo.length();i++){
                    if(slovo.charAt(i) != '\'' && slovo.charAt(i) != '\\')
                    if(bukva.containsKey(slovo.charAt(i))){
                        bukva.put(slovo.charAt(i),bukva.get(slovo.charAt(i))+1);
                    }
                    else
                        bukva.put(slovo.charAt(i),new Integer(1));
                }
                System.out.println("Слово \"" + sl.getKey()+ "\" встречается " + sl.getValue() + " раз(а)");
            }
            System.out.println("\n\nДлинна слов :");
            for(Map.Entry<Integer,Integer> len: dl.entrySet()){
                System.out.println(len.getKey() + "=" + len.getValue());
            }
            System.out.println("\n\nБуквы :");
            for(Map.Entry<Character,Integer> ch: bukva.entrySet()){
                System.out.println(ch.getKey() + "=" + ch.getValue());
            }
            System.out.println("\n\nЧаще всего используемые буквы(первые 10) :");
            bukva.entrySet().stream()
                    .sorted(Map.Entry.<Character,Integer>comparingByValue().reversed())
                    .forEach(new Consumer<Map.Entry<Character,Integer>>(){
                        private int a = 0;
                        @Override
                        public void accept(Map.Entry<Character,Integer> a){
                            if(this.a<10)
                                System.out.println(a.getKey() + " = " + a.getValue());
                            this.a++;
                        }
            });
            System.out.println("\n\nЧаще всего используемые слова(первые 10)");
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(new Consumer<Map.Entry<String,Integer>>(){
                        private int a = 0;
                        @Override
                        public void accept(Map.Entry<String,Integer> a){
                            if(this.a<10)
                                System.out.println(a.getKey() + " = " + a.getValue());
                            this.a++;
                        }
            });

        }



    }

    private static String readAllBytesJava7(String filePath)
    {
        String content;
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
            return content;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
