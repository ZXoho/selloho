package com.cn.demo.Utils;

import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class IpUtil {

    public static String getIP(HttpServletRequest request){
            String ip = request.getHeader("x-forwarded-for");
            System.out.println("x-forwarded-for ip: " + ip);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                // 多次反向代理后会有多个ip值，第一个ip才是真实ip
                if(ip.contains(",")){
                    ip = ip.split(",")[0];
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                log.error("【获取IP】获取IP失败 Proxy-Client-IP ip={}", ip);
                throw new SellException(ResultEnum.FAIL_TO_GET_IP);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                log.error("【获取IP】获取IP失败 WL-Proxy-Client-IP  ip={}", ip);
                throw new SellException(ResultEnum.FAIL_TO_GET_IP);

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                log.error("【获取IP】获取IP失败 HTTP_CLIENT_IP  ip={}", ip);
                throw new SellException(ResultEnum.FAIL_TO_GET_IP);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                log.error("【获取IP】获取IP失败 HTTP_X_FORWARDED_FOR  ip={}", ip);
                throw new SellException(ResultEnum.FAIL_TO_GET_IP);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                log.error("【获取IP】获取IP失败 X-Real-IP  ip={}", ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                System.out.println("getRemoteAddr ip: " + ip);
            }
            return ip;
        }
    }

