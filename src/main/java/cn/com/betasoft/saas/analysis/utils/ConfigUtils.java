package cn.com.betasoft.saas.analysis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileSystemUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by lichenzhe on 2017/12/21
 */
public class ConfigUtils {
    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);
    /**
     * 读取TXT
     */
    public static Map<String,String> readTxtForMap(String name){
//        File file=new File("classpath:config/"+name+".txt");
        Map<String,String> map=new HashMap<>();
//        if(file.exists()&&file.isFile()){
            BufferedReader br=null;
            try{
                Resource resource = new ClassPathResource("config/"+name+".txt");
                File file = resource.getFile();
                br=new BufferedReader(new BufferedReader(new InputStreamReader(new FileInputStream(file))));
                String s;
                while((s=br.readLine())!=null){
                    map.put(s.split(";;")[0],s.split(";;")[1]);
                }
            }catch (Exception e){
                log.info("读取配置文件错误",e);
            }finally {
                try {
                    br.close();
                } catch (IOException e) {
                    log.info("读取配置文件错误",e);
                }
            }
//        }
        return map;
    }
}
