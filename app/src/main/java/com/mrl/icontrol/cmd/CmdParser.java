package com.mrl.icontrol.cmd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmdParser {

    public static final Integer OFF = 0x00;
    public static final Integer ON = 0x01;
    public static final Integer PAUSE = 0x02;
    public static final Integer RESUME = 0x03;
    public static final Integer FAST = 0x04;
    public static final Integer SLOW = 0x05;

    public static final String PATTERN_OFF = ".*(关闭|关机|off|shutdown).*";
    public static final String PATTERN_ON = ".*(打开|启动|on|boot).*";
    public static final String PATTERN_PAUSE = ".*(暂停|停下|pause|stop).*";
    public static final String PATTERN_RESUME = ".*(恢复|继续|resume|start).*";
    public static final String PATTERN_FAST = ".*(加快|加速|快点|fast|quick).*";
    public static final String PATTERN_SLOW = ".*(变慢|减速|慢点|slow).*";

    public static boolean matches(String regex, String input) {
//        Pattern test_ = Pattern.compile("",Pattern.CASE_INSENSITIVE);
        boolean res = Pattern.matches(regex, input);
        return res;
    }

    public static Integer parse(String input){
        Integer cmd = 0x00;
        if (matches(PATTERN_OFF, input)){
            cmd = OFF;
        }else if(matches(PATTERN_ON, input)){
            cmd = ON;
        }else if(matches(PATTERN_PAUSE, input)){
            cmd = PAUSE;
        }else if(matches(PATTERN_RESUME, input)){
            cmd = RESUME;
        }else if(matches(PATTERN_FAST, input)){
            cmd = FAST;
        }else if(matches(PATTERN_SLOW, input)){
            cmd = SLOW;
        }
        return cmd;
    }

}
