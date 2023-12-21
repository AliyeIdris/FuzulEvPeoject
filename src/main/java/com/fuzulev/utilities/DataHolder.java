package com.fuzulev.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author : user
 * @created : 21.12.2023,14:09
 * @Email :aliyeidiris@gmail.com
 **/
public class DataHolder {
    public static int minimumPrice=(int)(Math.random()*10000+1);
    public static int maximumPrice=(int)(Math.random()*500000+50000);
    public static String propertyName(){
        List<String> names= Arrays.asList("Bahçeli Villa","Kiralık Daire","Geniş Ev","Otoparklı Villa");
        return names.get(new Random().nextInt(names.size()));
    }
}
